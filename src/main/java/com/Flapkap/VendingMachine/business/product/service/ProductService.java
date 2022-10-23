package com.Flapkap.VendingMachine.business.product.service;

import com.Flapkap.VendingMachine.business.product.dto.ProductDto;
import com.Flapkap.VendingMachine.business.product.dto.ResponseWithLongId;
import com.Flapkap.VendingMachine.business.product.dto.request.StoreProductRequest;
import com.Flapkap.VendingMachine.business.product.dto.request.UpdateProductRequest;
import com.Flapkap.VendingMachine.business.product.entity.Product;

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
