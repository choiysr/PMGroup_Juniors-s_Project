package com.pmg.juniors.RepoTests;

import java.util.stream.IntStream;

import com.pmg.juniors.Repository.BoardRepository;
import com.pmg.juniors.domain.Board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class BoardTests {

   @Setter(onMethod_ ={@Autowired})
   BoardRepository boardRepo;

    
    @Test
    public void insertDummy() {
        IntStream.range(11,70).forEach(i -> {
            boardRepo.save(Board.builder().content("content"+i).writer("writer"+i).title("title"+i).build());
        });   
    }

    @Test
    public void pagingTest() {     

        Pageable page = PageRequest.of(0, 10, Sort.Direction.DESC, "bno");
        Page<Board> result = boardRepo.findAll(page);

        result.forEach(board -> {
            log.info("BNO : " + board.getBno());
            log.info("TITLE : " + board.getTitle());
            log.info("WRITER : " + board.getWriter());
            log.info("CONTENT : " + board.getContent());
        });
      
    }

    
    
}