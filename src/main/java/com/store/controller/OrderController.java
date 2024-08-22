package com.store.controller;

import com.store.dto.OrderDTO;
import com.store.dto.OrderItemDTO;
import com.store.dto.OrderRequestDTO;
import com.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public OrderDTO placeOrder(@RequestBody OrderRequestDTO orderRequest) {
        OrderDTO orderDTO = orderRequest.getOrderDTO();

        // deliveryIdx가 null이거나 유효하지 않은 경우 기본 값으로 설정
        if (orderDTO.getDeliveryIdx() == 0 || !isValidDeliveryIdx(orderDTO.getDeliveryIdx())) {
            orderDTO.setDeliveryIdx(getDefaultDeliveryIdx()); // 기본 deliveryIdx 설정
        }

        List<OrderItemDTO> orderItems = orderRequest.getOrderItems();
        return orderService.placeOrder(orderDTO, orderItems);
    }

    private boolean isValidDeliveryIdx(int deliveryIdx) {
        // DeliveryRepository 등을 통해 deliveryIdx가 유효한지 확인하는 로직 추가
        return true; // 이 부분을 실제 유효성 검사 로직으로 변경
    }

    private int getDefaultDeliveryIdx() {
        // 기본 deliveryIdx를 반환하는 로직 추가
        return 1; // 예시로, 기본 배송 정보를 가진 delivery_idx
    }


    @GetMapping("/{orderIdx}")
    public OrderDTO getOrderById(@PathVariable int orderIdx) {
        return orderService.getOrderById(orderIdx);
    }

    @GetMapping("/{orderIdx}/items")
    public List<OrderItemDTO> getOrderItemsByOrderId(@PathVariable int orderIdx) {
        return orderService.getOrderItemsByOrderId(orderIdx);
    }
}
