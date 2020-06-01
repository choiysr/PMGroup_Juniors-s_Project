package com.pmg.juniors.Controller;

import com.pmg.juniors.Repository.BoardRepository;
import com.pmg.juniors.domain.Board;

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

    private final BoardRepository boardRepo;

    // 게시글 리스트 불러오기
    @GetMapping(value = "/list")
    public ResponseEntity<Page<Board>> getAllList() {
        Pageable pageInfo = PageRequest.of(0, 10, Sort.Direction.DESC, "bno");
        Page<Board> result = boardRepo.findAll(pageInfo);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
}