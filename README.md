# spring Boot & JPA(Java Persistence API) study sample  

## JDBC와 ORM

### JDBC
    JDBC에 자세한 내용은 생략하고 JDBC 사용을 지양하고 JPA를 사용하는 이유에 대해서...

### JDBC의 문제점
    1. SQL을 실행하는 비용이 크다.
    2. SQL이 데이터베이스 마다 다르다.(유지보스 및 추가개발 대한 문제)
    3. 스키마를 바꾸면 코드가 바뀌는 경우가 많다.
    4. try 리소스와 같은 반복적인 코드가 상당량 늘어난다.
    5. 필요하지 않은 데이터도 모두 읽어 오는 경우가 있기 때문에 비효율 적이다. 

* * *

### ORM(Object-Relation Mapping)
    ORM은 애플리케이션의 클래스와 SQL 데이터베이스의 테이블 사이의 맵핑 정보를 기술한 메타데이터를
    사용하여, 자바 애플리케이션의 객체를 SQL 데이터베이스 테이블에 자동으로(깨끗하게) 영속화 해주는 기술이다.

    장점:
    1. 생산성(맵핑 정보만 입력해주면 데이터를 넣고 빼는게 가능)
    2. 유지보수성(코드가 매우 간결하여 유지보수에 용이 로직에 집중할 수 있음)
    3. 성능 (논란의 여지가 있을 수 있지만 하이버네이트의 트랜젝션 내의 캐시(객체와 데이터베이스사이)를 관리해주는 역할 등 성능 최적화를 해주는 기능이 기본으로 있음)
    4. 벤더 독립성(DBMS 마다 데이터 베이스의 문법이 약간 상이한 부분이 있지만 그런 부분을 알아서 수정해준다.)

    단점:
    학습비용(배우는 학습 비용이 크다. 하이버네이트 문법 뿐만아니라 DBMS의 깊은 이해가 필요하다.)


도메인 모델 사용예)
```
   @Autowired
   BoardRepository boardRepo; 

    
    @Test
    public void insertDummy() {

        IntStream.range(0,10).forEach(i -> {
            boardRepo.save(Board.builder().content("content"+i).writer("writer"+i).title("title"+i).build());
        });   
        // 의존 주입된 board 도메인 객체를 간단한 코드로 등록할 수 있음
        // JDBC의 커넥션 객체를 이용한 코드와 확연한 차이가 있음 
    }
```

### ORM 패러다임 불일치
    객체를 릴레이션에 맵핑하는데 발생되는 문제 그리고 해결책

#### 밀도(granularity) 문제

|객체|릴레이션|
|------|---|
|다양한 크기의 객체를 만들수 있음| 테이블|
|커스텀한 타입 만들기 쉬움(객체형) |기본 데이터 타입(INTEGER, VARCHAR...)|

#### 서브타입(subtype)의 문제

|객체|릴레이션|
|------|---|
|상속 구조 만들기 쉬움| 테이블에 상속이라는 개념이 없음|
|다형성 |상속기능을 구현했다 하더라도 표준이 아님, 다형성의 관계를 표현할 방법 없음|

#### 식별성(Identity)의 문제

|객체|릴레이션|
|------|---|
|레퍼런스의 동일성 == , 인스턴스의 동일성 (equals() 메소드)|주키(primary key)|

#### 관계(Association)의 문제

|객체|릴레이션|
|------|---|
|객체 레퍼런스로 관계 표현.| 외래키(foreign key) 관계로 표현, 방향이라는 개념이 없고 Join으로 아무거나 묶을 수 있음|
|근본적으로 방향이 존재, 다대다 관계를 가질 수 있음| 애초에 다대다 관계를 형성할 수 없고 조인 테이블 또는 링크 테이블을 사용해서 두개의 1대다 관계를 풀어야함 |


#### 데이터 네이비게이션(Navigation)의 문제

|객체|릴레이션|
|------|---|
|레퍼런스를 이용해서 다른객체로 이동 가능| 릴레이션에서 객체를 이용한 이동은 데이터를 조회하는데 있어서 매우 비효율 적임|
|컬렉션을 순회 할 수 있음| 데이터베이스 요청을 적게 할 수록 성능이 좋음 따라서 Join을 사용함 |
|#| Join을 통해 한번에 너무 많이 가지고오면 그것도 문제임. 그렇다고 lazy loading을 해도 문제가됨|


* * *

## JPA 프로그래밍 : 엔티티 맵핑

* @Entity
  * "엔티티"는 객체를 부르는 이름
  * 보통 클래스와 같은 이름을 사용하기 때문에 값을 변경하지 않는다.
  * 엔티티의 이름은 JQL에서 쓰임

* @Table
  * "릴레이션"에서 부르는 이름
  * @Entity의 이름이 기본값
  * 테이블의 이름은 SQL에서 사용

* @Id
  * 엔티티의 주키를 맵핑할 때 사용
  * 자바의 모든 primitive 타입과 그 랩퍼 타입을 사용할 수 있음 (Date, BigDecimal, BigInteger도 사용 가능)
  * 복합키를 만들때 맵핑하는 방법도 있음

* @GeneratedValue
  * 주키의 생성 방법을 맵핑할때 사용함
  * @Entity의 이름이 기본값.
  * 생성전략과 생성기를 설정할 수 있음.
    * 기본 전략은 AUTO, 사용하는 DB에 따라 적절한 전략 선택
    * TABLE, SEQUENCE, IDENTITY 중 하나.

* @Column
  * unique
  * nullable
  * length
  * columnDefinition

* @Temporal
  * Date Calendar 지원

* @Transient
  * 컬럼으로 맵핑 하고 싶지 않은 멤버

* application.properties 
  * spring.jpa.show-sql=true  // 쿼리 보여줌
  * spring.jpa.properties.hibernate.format_sql=true





