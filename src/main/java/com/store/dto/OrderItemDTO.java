package com.store.dto;

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
public class OrderItemDTO {

    private int orderItemIdx;
    private int orderIdx;
    private int skuIdx;
    private int orderItemQty;
    private int orderItemPrice;
}
