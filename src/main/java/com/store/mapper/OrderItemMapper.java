package com.store.mapper;

import com.store.dto.OrderItemDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderItemMapper {

    void insertOrderItem(OrderItemDTO orderItemDTO);

    List<OrderItemDTO> selectOrderItemsByOrderId(@Param("orderIdx") int orderIdx);
}
