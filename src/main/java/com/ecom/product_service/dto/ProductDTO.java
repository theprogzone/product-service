package com.ecom.product_service.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductDTO {

    private String skuCode;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer quantity;

    public ProductDTO(String skuCode, String name, String description, BigDecimal price) {
        this.skuCode = skuCode;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
