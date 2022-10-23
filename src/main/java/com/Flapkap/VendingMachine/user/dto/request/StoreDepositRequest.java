package com.Flapkap.VendingMachine.user.dto.request;

import lombok.Data;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Validated
@Data
@Getter
public class StoreDepositRequest {
    @NotNull
    @Positive
    @Min(5)
    @Max(100)
    private BigDecimal deposit;
}
