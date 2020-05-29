package com.pmg.juniors.Repository;

import com.pmg.juniors.domain.Board;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long>{
    
}