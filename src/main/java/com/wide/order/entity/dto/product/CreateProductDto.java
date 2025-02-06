package com.wide.order.entity.dto.product;

import lombok.Data;

import java.io.Serializable;

@Data
public class CreateProductDto implements Serializable {
    private String name;
    private String description;
    private Integer stock;
    private Double price;
    private Long categoryId;
}
