package com.Flapkap.VendingMachine.business.product.controller;

import com.Flapkap.VendingMachine.business.product.dto.ProductDto;
import com.Flapkap.VendingMachine.business.product.dto.ResponseWithLongId;
import com.Flapkap.VendingMachine.business.product.dto.request.StoreProductRequest;
import com.Flapkap.VendingMachine.business.product.dto.request.UpdateProductRequest;
import com.Flapkap.VendingMachine.business.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@Validated
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping()
    ResponseEntity<?> ListAll() {
        return new ResponseEntity<>(productService.listAllProducts(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyAuthority('SELLER')")
    public ResponseWithLongId addProduct(@Validated @RequestBody StoreProductRequest request) {
        return productService.addProduct(request);
    }
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto getProduct(@PathVariable Long id) {
        return productService.getProductDto(id);
    }

    @PreAuthorize("hasAnyAuthority('SELLER')")
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@PathVariable Long id,
                              @Validated @RequestBody UpdateProductRequest request) {
        productService.updateProduct(id, request);
    }

    @PreAuthorize("hasAnyAuthority('SELLER')")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }


}
