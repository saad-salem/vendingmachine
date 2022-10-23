package com.Flapkap.VendingMachine.product.service;


import com.Flapkap.VendingMachine.product.dto.ProductDto;
import com.Flapkap.VendingMachine.product.dto.request.StoreProductRequest;
import com.Flapkap.VendingMachine.product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product map(StoreProductRequest request);

    List<ProductDto> map(List<Product> products);

    ProductDto map(Product product);
}
