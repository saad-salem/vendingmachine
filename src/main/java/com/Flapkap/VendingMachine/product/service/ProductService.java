package com.Flapkap.VendingMachine.product.service;

import com.Flapkap.VendingMachine.product.dto.ProductDto;
import com.Flapkap.VendingMachine.product.dto.ResponseWithLongId;
import com.Flapkap.VendingMachine.product.dto.request.StoreProductRequest;
import com.Flapkap.VendingMachine.product.dto.request.UpdateProductRequest;
import com.Flapkap.VendingMachine.product.entity.Product;

import java.util.List;

public interface ProductService {

    ResponseWithLongId addProduct(StoreProductRequest request);

    List<ProductDto> listAllProducts();

    ProductDto getProductDto(Long id);

    Product getProduct(Long id);

    void deductProductAmount(Long id, Integer amount);

    void updateProduct(Long id, UpdateProductRequest request);

    void deleteProduct(Long id);
}
