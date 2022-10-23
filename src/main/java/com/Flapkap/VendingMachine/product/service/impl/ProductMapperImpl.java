package com.Flapkap.VendingMachine.product.service.impl;

import com.Flapkap.VendingMachine.product.dto.ProductDto;
import com.Flapkap.VendingMachine.product.dto.request.StoreProductRequest;
import com.Flapkap.VendingMachine.product.entity.Product;
import com.Flapkap.VendingMachine.product.service.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductMapperImpl implements ProductMapper {
    @Override
    public Product map(StoreProductRequest request) {
        if ( request == null ) {
            return null;
        }
        Product product = new Product();
        product.setAmountAvailable( request.getAmountAvailable() );
        product.setCost( request.getCost() );
        product.setProductName( request.getProductName() );
        return product;
    }

    @Override
    public List<ProductDto> map(List<Product> products) {
        if ( products == null ) {
            return null;
        }
        List<ProductDto> list = new ArrayList<>( products.size() );
        for ( Product product : products ) {
            list.add( map( product ) );
        }
        return list;
    }

    @Override
    public ProductDto map(Product product) {
        if ( product == null ) {
            return null;
        }
        ProductDto productResponse = new ProductDto();
        productResponse.setId( product.getId() );
        productResponse.setAmountAvailable( product.getAmountAvailable() );
        productResponse.setCost( product.getCost() );
        productResponse.setProductName( product.getProductName() );
        productResponse.setSellerId( product.getSeller().getId() );
        return productResponse;
    }
}
