package com.wide.order.entity.dto.product;

import com.wide.order.entity.Auditing;
import com.wide.order.entity.dto.category.SingleCategoryDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class ListProductDto extends Auditing implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Integer stock;
    private Double price;
    private SingleCategoryDto category;
}
