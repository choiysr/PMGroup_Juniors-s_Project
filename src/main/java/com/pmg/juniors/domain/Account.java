package com.pmg.juniors.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // 이 클래스가  Account 테이블에 맵핑이 되겠다고 선언
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id @GeneratedValue // @Id 데이터베이스 주키 맵핑 , @GeneratedValue 자동으로 생성되는 값 설정
    private Long id;

    @Column // 명시적으로 작성하지 않아도 컬럼으로 자동인식
    private String username;

    private String password;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
}