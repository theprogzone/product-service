package com.ecom.product_service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InventoryDTO {

    private String skuCode;

    private Integer quantity;
}
