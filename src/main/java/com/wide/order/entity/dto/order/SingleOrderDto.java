package com.wide.order.entity.dto.order;

import com.wide.order.entity.Auditing;
import com.wide.order.entity.dto.customer.ListCustomerDto;
import com.wide.order.entity.dto.product.ListProductDto;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SingleOrderDto extends Auditing implements Serializable {
    private Long id;
    private ListCustomerDto customer;
    private ListProductDto product;
    private Double total;
    private String orderStatus;
    private LocalDateTime orderDate;
}
