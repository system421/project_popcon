package com.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.store.dto.QnaDTO;
import com.store.entity.CustomerQna;
import com.store.mapper.QnaMapper;
import com.store.repository.QnaRepository;

@Service
public class QnaServiceImpl implements QnaService {

	private QnaRepository qnaRepository;
	QnaMapper qnaMapper;
	
	public QnaServiceImpl(QnaRepository qnaRepository, QnaMapper qnaMapper) {
		this.qnaRepository = qnaRepository;
		this.qnaMapper = qnaMapper;
	}
	
	// 문의 등록 Post
	@Override
	public CustomerQna PostMyQna(CustomerQna qna) {
		return qnaRepository.save(qna);
	}

    // 문의내용 Update
	@Override
    public CustomerQna EditMyQna(int CustomerIdx, CustomerQna qna) {
        qna.setCustomerIdx(CustomerIdx);
        return qnaRepository.save(qna);
    }
    
    // 문의내용 Delete
	@Override
    public CustomerQna DeleteMyQna(int CustomerIdx, CustomerQna qna) {
        qna.setQnaDel(true);
        return qnaRepository.save(qna);
    }
	
	// 문의내역 조회
	@Override
	public List<QnaDTO> findMyQna(int CustomerIdx) {
		return qnaMapper.findMyQna(CustomerIdx);
	}

}
