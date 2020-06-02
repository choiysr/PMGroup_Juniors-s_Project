package com.pmg.juniors.Repository;

import com.pmg.juniors.domain.Board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface BoardRepository extends JpaRepository<Board,Long>{
    
}