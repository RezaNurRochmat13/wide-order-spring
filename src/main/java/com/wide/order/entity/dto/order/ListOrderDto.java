package com.wide.order.entity.dto.order;

import com.wide.order.entity.dto.customer.SingleCustomerDto;
import com.wide.order.entity.dto.product.SingleProductDto;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ListOrderDto implements Serializable {
    private Long id;
    private SingleCustomerDto customer;
    private SingleProductDto product;
    private Double total;
    private String orderStatus;
    private LocalDateTime orderDate;
}
