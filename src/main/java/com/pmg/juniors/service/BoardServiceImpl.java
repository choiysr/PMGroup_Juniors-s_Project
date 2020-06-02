package com.pmg.juniors.service;

import com.pmg.juniors.Repository.BoardRepository;
import com.pmg.juniors.domain.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Override
    public Page<Board> findByList(Pageable pageInfo) {
        return boardRepository.findAll(pageInfo);
    }
    
}