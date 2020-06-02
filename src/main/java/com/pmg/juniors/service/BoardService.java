package com.pmg.juniors.service;

import com.pmg.juniors.domain.Board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {

    Page<Board> findByList(Pageable pageInfo);

    



}