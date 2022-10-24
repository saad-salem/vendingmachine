package com.Flapkap.VendingMachine.business.product.service;


import com.Flapkap.VendingMachine.business.product.dto.ProductDto;
import com.Flapkap.VendingMachine.business.product.dto.request.StoreProductRequest;
import com.Flapkap.VendingMachine.business.product.entity.Product;


import java.util.List;

public interface ProductMapper {

    Product map(StoreProductRequest request);

    List<ProductDto> map(List<Product> products);

    ProductDto map(Product product);
}
