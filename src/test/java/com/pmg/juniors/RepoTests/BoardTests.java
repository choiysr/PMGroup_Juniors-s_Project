package com.pmg.juniors.RepoTests;

import java.util.stream.IntStream;

import com.pmg.juniors.Repository.BoardRepository;
import com.pmg.juniors.domain.Board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardTests {

   @Autowired
   BoardRepository boardRepo;

    
    @Test
    public void insertDummy() {

        IntStream.range(0,10).forEach(i -> {
            boardRepo.save(Board.builder().content("content"+i).writer("writer"+i).title("title"+i).build());
        });

                               
    }
    
}