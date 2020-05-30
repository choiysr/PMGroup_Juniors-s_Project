# spring Boot & JPA(Java Persistence API) study sample  

### JDBC와 ORM

#### JDBC
    JDBC에 자세한 내용은 생략하고 JDBC 사용을 지양하고 JPA를 사용하는 이유에 대해서...

#### JDBC의 문제점
    1. SQL을 실행하는 비용이 크다.
    2. SQL이 데이터베이스 마다 다르다.(유지보스 및 추가개발 대한 문제)
    3. 스키마를 바꾸면 코드가 바뀌는 경우가 많다.
    4. try 리소스와 같은 반복적인 코드가 상당량 늘어난다.
    5. 필요하지 않은 데이터도 모두 읽어 오는 경우가 있기 때문에 비효율 적이다. 


#### ORM(Object-Relation Mapping)
    ORM은 애플리케이션의 클래스와 SQL 데이터베이스의 테이블 사이의 맵핑 정보를 기술한 메타데이터를
    사용하여, 자바 애플리케이션의 객체를 SQL 데이터베이스의 테이블에 자동으로(깨끗하게) 영속화 해주는 기술이다.

도메인 모델 사용예)
```
   @Autowired
   BoardRepository boardRepo; 

    
    @Test
    public void insertDummy() {

        IntStream.range(0,10).forEach(i -> {
            boardRepo.save(Board.builder().content("content"+i).writer("writer"+i).title("title"+i).build());
        });   // 의존 주입된 board 도메인 객체를 간단한 코드로 등록할 수 있음.                   
    }
```




