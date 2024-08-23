package com.store.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class OrderDetailDTO {

    private int orderIdx;
    private LocalDateTime orderTime;
    private Integer orderPrice;
    private String paymentId;
    private String deliveryStatus;
    private String orderStatus;
    private int orderItemIdx;
    private String orderItemQty;
    private String orderItemPrice;
    private String productName;
}
