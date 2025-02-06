package com.wide.order.entity.dto.product;

import com.wide.order.entity.Auditing;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateProductDto extends Auditing implements Serializable {
    private String name;
    private String description;
    private Integer stock;
    private Double price;
    private Long categoryId;
}
