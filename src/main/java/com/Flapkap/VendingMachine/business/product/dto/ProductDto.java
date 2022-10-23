package com.Flapkap.VendingMachine.business.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private Integer amountAvailable;
    private Double cost;
    private String productName;
    private Long sellerId;
}
