package com.wide.order.entity.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CreateProductDto implements Serializable {
    private String name;
    private String description;
    private Integer stock;
    private Double price;
    private Long categoryId;
}
