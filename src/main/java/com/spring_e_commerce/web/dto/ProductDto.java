package com.spring_e_commerce.web.dto;

import com.spring_e_commerce.web.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private double costPrice;
    private double salePrice;
    private int currentQuantity;
    private String image;
    private Category category;
    private boolean deleted;
    private boolean activated;
}
