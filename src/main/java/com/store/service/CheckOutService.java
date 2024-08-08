package com.store.service;

import java.util.List;
import com.store.dto.CheckOutDTO;

public interface CheckOutService {
	
	List<CheckOutDTO> findCustomer(int customerIdx);  //유저 정보불러오기
	List<CheckOutDTO> findCart(int customerIdx);	  //장바구니 불러오기
	
}
