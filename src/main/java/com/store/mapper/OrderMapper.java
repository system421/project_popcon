package com.store.mapper;

import com.store.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    void insertOrder(OrderDTO orderDTO);

    OrderDTO selectOrderById(@Param("orderIdx") int orderIdx);
}
