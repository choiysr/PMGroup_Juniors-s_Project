package com.pmg.juniors.controller;

import com.pmg.juniors.Repository.BoardRepository;
import com.pmg.juniors.domain.Board;
import com.pmg.juniors.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/*")
@RequiredArgsConstructor
public class BoardController {

    @Autowired
    private BoardService boardService;

    private BoardRepository boardRepository;

    // 게시글 리스트 불러오기
    @GetMapping(value = "/list")
    public ResponseEntity<Page<Board>> getAllList() {
        Pageable pageInfo = PageRequest.of(0, 10, Sort.Direction.DESC, "bno");
        Page<Board> result = boardService.findByList(pageInfo);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    
    
    
}