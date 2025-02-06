package com.wide.order.entity.dto.product;

import com.wide.order.entity.Auditing;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ListProductDto extends Auditing implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Integer stock;
    private Double price;
}
