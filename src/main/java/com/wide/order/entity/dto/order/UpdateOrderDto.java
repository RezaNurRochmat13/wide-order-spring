package com.wide.order.entity.dto.order;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateOrderDto implements Serializable {
    private Long customerId;
    private Long productId;
    private Double total;
    private String orderStatus;
}
