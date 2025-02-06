package com.wide.order.entity.dto.customer;

import com.wide.order.entity.Auditing;
import lombok.Data;

import java.io.Serializable;

@Data
public class SingleCustomerDto extends Auditing implements Serializable {
    private Long id;
    private String name;
    private String address;
    private String postalCode;
}
