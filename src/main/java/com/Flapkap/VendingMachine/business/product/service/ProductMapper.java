package com.Flapkap.VendingMachine.business.product.service;


import com.Flapkap.VendingMachine.business.product.dto.ProductDto;
import com.Flapkap.VendingMachine.business.product.dto.request.StoreProductRequest;
import com.Flapkap.VendingMachine.business.product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product map(StoreProductRequest request);

    List<ProductDto> map(List<Product> products);

    ProductDto map(Product product);
}
