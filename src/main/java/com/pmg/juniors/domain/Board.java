package com.pmg.juniors.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Board
 */
@Entity
@Table(name = "tbl_board")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    
    private String title;
    
    private String writer;
    
    private String content;

    @CreationTimestamp
    private LocalDateTime regdate;

    @UpdateTimestamp
    private LocalDateTime updateddate;

    
}