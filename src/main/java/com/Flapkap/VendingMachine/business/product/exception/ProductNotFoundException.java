package com.Flapkap.VendingMachine.business.product.exception;

import com.Flapkap.VendingMachine.exception.NotFoundException;

public class ProductNotFoundException extends NotFoundException {
    public ProductNotFoundException() {
        super("Product not found ");
    }

}
