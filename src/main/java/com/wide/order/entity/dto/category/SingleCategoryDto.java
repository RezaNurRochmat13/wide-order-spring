package com.wide.order.entity.dto.category;

import com.wide.order.entity.Auditing;
import lombok.Data;

import java.io.Serializable;

@Data
public class SingleCategoryDto extends Auditing implements Serializable {
    private Long id;
    private String name;
    private String description;
}
