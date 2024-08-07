package com.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.dto.QnaRequestDTO;
import com.store.entity.CustomerQna;

public interface QnaRepository extends JpaRepository<CustomerQna, Integer>  {

	CustomerQna save(QnaRequestDTO qna);}
