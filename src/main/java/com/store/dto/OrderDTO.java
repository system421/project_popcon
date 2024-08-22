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
public class OrderDTO {

    private int orderIdx;
    private int deliveryIdx;
    private int customerIdx;
    private int orderStatusIdx;
    private int cartIdx;
    private LocalDateTime orderTime;
    private Integer orderPrice;
    private String paymentId;
}
