package com.Flapkap.VendingMachine.product.exception;

import com.Flapkap.VendingMachine.config.exception.NotFoundException;

public class ProductNotFoundException extends NotFoundException {
    public ProductNotFoundException() {
        super("Product not found ");
    }

}
