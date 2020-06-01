package com.pmg.juniors;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.pmg.juniors.domain.Account;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner { // ApplicationRunner 스프링 구동시점에 실행되는 코드 설정

    @PersistenceContext
    EntityManager entityManager; // JPA의 핵심 , 스프링  applicationContext와 유사

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // 위 entityManager를 통해 Account 엔티티를 영속화 하는 과정을 해보겠음
        // Account account = new Account();
        // account.setUsername("HYUNHO");
        // account.setPassword("juniors");

        Account sessionAccount = new Account();
        sessionAccount.setUsername("sessionTest");
        sessionAccount.setPassword("session");
        sessionAccount.setCreated(new Date());
        
        // session을 꺼내서 저장을 할 수도 있음
        Session session = entityManager.unwrap(Session.class); // jpa가 하이버네이트 API도 사용가능하기 때문에 하이버네이트 Session도 사용가능
        session.save(sessionAccount);

        // entityManager.persist(account);

    }
    
}