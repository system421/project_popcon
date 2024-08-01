package com.store.mapper;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.store.dto.KeepDTO;
import com.store.dto.SkuDTO;

@Mapper
public interface KeepMapper {

    List<KeepDTO> findAll();
}

