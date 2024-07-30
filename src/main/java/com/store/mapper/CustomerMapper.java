package com.store.mapper;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.store.dto.CustomerDTO;
import com.store.dto.Member;
import com.store.entity.Customer;

@Mapper
public interface CustomerMapper {

    CustomerDTO findById(String customer_id);
    public CustomerDTO authenticate(Map<String, String> map);
}

