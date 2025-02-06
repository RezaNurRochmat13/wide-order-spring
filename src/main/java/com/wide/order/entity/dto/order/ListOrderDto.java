package com.wide.order.entity.dto.order;

import com.wide.order.entity.Customer;
import com.wide.order.entity.Product;
import com.wide.order.entity.dto.customer.ListCustomerDto;
import com.wide.order.entity.dto.product.ListProductDto;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class ListOrderDto implements Serializable {
    private Long id;
    private ListCustomerDto customer;
    private ListProductDto product;
    private Double total;
    private String orderStatus;
    private LocalDateTime orderDate;
}
