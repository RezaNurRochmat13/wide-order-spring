package com.wide.order.entity.dto.customer;

import com.wide.order.entity.Auditing;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ListCustomerDto extends Auditing implements Serializable {
    private Long id;
    private String name;
    private String address;
    private String postalCode;
}
