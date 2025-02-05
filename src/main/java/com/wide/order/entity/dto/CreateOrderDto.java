package com.wide.order.entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CreateOrderDto implements Serializable {
    private Long customerId;
    private Long productId;
    private Double total;
    private String orderStatus;
}
