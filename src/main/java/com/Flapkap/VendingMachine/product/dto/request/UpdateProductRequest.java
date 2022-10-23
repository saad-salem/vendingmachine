package com.Flapkap.VendingMachine.product.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
@Data
@NoArgsConstructor
public class UpdateProductRequest {
    @NotNull
    @Min(0)
    private Integer amountAvailable;
    @NotNull
    @Min(0)
    private Double cost;
    @NotNull
    private String productName;
}
