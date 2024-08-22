package com.store.service;

import com.store.dto.OrderDTO;
import com.store.dto.OrderItemDTO;

import java.util.List;

public interface OrderService {

    OrderDTO placeOrder(OrderDTO orderDTO, List<OrderItemDTO> orderItems);

    OrderDTO getOrderById(int orderIdx);

    List<OrderItemDTO> getOrderItemsByOrderId(int orderIdx);
}
