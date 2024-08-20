package com.store.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
public class CustomerQna {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="qna_idx")
	int qnaIdx;
	
	@Column(name="faqtype_idx")
	int faqtypeIdx;
	
	@Column(name="customer_idx")
	int customerIdx;
	
	@Column(nullable=false, name="qna_title")
	String qnaTitle;
																																																																																																																																																																																																																																																																																																																																																																																																																																										
	@Column(nullable=false, name="qna_text")
	String qnaText;
	
	@Column(name="qna_picture")
	String qnaPicture;
	
	@Column(name="qna_image")
	String qnaImage;
	
	@Column(name="qna_del")
	Boolean qnaDel;

//	타임스탬프는 SQL로 저장
	@Column(name="qna_picture")
	String qnaPicture;
	
	@Column(name="qna_image")
	String qnaImage;
	
//	타임스탬프는 SQL로 저장
	@Column(name="qna_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")	
	LocalDateTime qnaDate;
	
	@Column(name="qna_ans")
	String qnaAns;
	
////	타임스탬프는 SQL로 저장
//	@Column(name="qna_date")
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")	
//	LocalDateTime qnaDate;
//	
//	@PrePersist // 엔티티가 저장되기 전에 호출
//	private void updateTime() {
//        this.qnaDate = LocalDateTime.now(); // qnaDate에도 현재 시간 설정
//        System.out.println("qnaDate:" + qnaDate);
//    }
	
	
}
