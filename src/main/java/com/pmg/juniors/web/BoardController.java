package com.pmg.juniors.web;

import java.util.List;

import com.pmg.juniors.Repository.BoardRepository;
import com.pmg.juniors.domain.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class BoardController {
    
    @Autowired
    private BoardRepository boardRepository;

    @RequestMapping("/list")
    public List<Board> list() {
        List<Board> boardList = boardRepository.findAll(); 
        return boardList;
    }
}