package com.store.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.store.dto.CheckOutDTO;
import com.store.mapper.CheckOutMapper;

@Service
public class CheckOutServiceImpl implements CheckOutService {

    private final CheckOutMapper checkOutMapper;

    @Autowired
    public CheckOutServiceImpl(CheckOutMapper checkOutMapper) {
        this.checkOutMapper = checkOutMapper;
    }

    // 유저정보 불러오기
    @Override
    public List<CheckOutDTO> findCustomer(int customerIdx) {
        return checkOutMapper.findCustomer(customerIdx);
    }

    // 장바구니 불러오기
    @Override
    public List<CheckOutDTO> findCart(int customerIdx) {
        return checkOutMapper.findCart(customerIdx);
    }
}
