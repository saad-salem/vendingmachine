package com.Flapkap.VendingMachine.business.product.service.impl;

import com.Flapkap.VendingMachine.exception.ForbiddenException;
import com.Flapkap.VendingMachine.util.SecurityUtils;
import com.Flapkap.VendingMachine.business.product.dto.ProductDto;
import com.Flapkap.VendingMachine.business.product.dto.ResponseWithLongId;
import com.Flapkap.VendingMachine.business.product.dto.request.StoreProductRequest;
import com.Flapkap.VendingMachine.business.product.dto.request.UpdateProductRequest;
import com.Flapkap.VendingMachine.business.product.entity.Product;
import com.Flapkap.VendingMachine.business.product.exception.ProductNotFoundException;
import com.Flapkap.VendingMachine.business.product.repo.ProductRepository;
import com.Flapkap.VendingMachine.business.product.service.ProductMapper;
import com.Flapkap.VendingMachine.business.product.service.ProductService;
import com.Flapkap.VendingMachine.business.user.dto.TokenUser;
import com.Flapkap.VendingMachine.business.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductMapper productMapper;
    @Autowired
    ProductRepository productRepo;

    @Override
    @Transactional
    public ResponseWithLongId addProduct(StoreProductRequest request) {
        List<Product> entities = productRepo.findAll();
        if (entities.stream().anyMatch(p -> p.getProductName().equals(request.getProductName()))) {
            throw new IllegalArgumentException(String.format("Product with name %s already exists", request.getProductName()));
        }
        TokenUser tokenUser = SecurityUtils.getTokenUser();
        User seller=new User(tokenUser.getId());
        Product product = productMapper.map(request);
        product.setSeller(seller);
        return new ResponseWithLongId(productRepo.save(product).getId());
    }

    @Override
    public List<ProductDto> listAllProducts() {
        List<Product> entities = productRepo.findAll();
        return productMapper.map(entities);
    }


    @Override
    public Product getProduct(Long id) {
        return productRepo.findById(id).orElseThrow(ProductNotFoundException::new);
    }
    @Override
    public ProductDto getProductDto(Long id) {
        Product entity = productRepo.findById(id).orElseThrow(ProductNotFoundException::new);
        return productMapper.map(entity);
    }

    @Override
    public void deductProductAmount(Long id, Integer amount) {
        Product entity = productRepo.findById(id).orElseThrow(ProductNotFoundException::new);
        entity.setAmountAvailable(entity.getAmountAvailable() - amount);
        productRepo.save(entity);
    }

    @Override
    public void updateProduct(Long id, UpdateProductRequest request) {
        Product entity = productRepo.findById(id).orElseThrow(ProductNotFoundException::new);
        TokenUser tokenUser = SecurityUtils.getTokenUser();
        if (tokenUser.getId()!= entity.getId()){
            throw new ForbiddenException();
        }
        entity.setProductName(request.getProductName());
        entity.setAmountAvailable(request.getAmountAvailable());
        entity.setCost(request.getCost());
        productRepo.save(entity);
    }


    @Override
    @Transactional
    public void deleteProduct(Long id) {
        Product entity=productRepo.findById(id).orElseThrow(ProductNotFoundException::new);
        TokenUser tokenUser = SecurityUtils.getTokenUser();
        if (tokenUser.getId()!= entity.getId()){
            throw new ForbiddenException();
        }
        productRepo.deleteById(id);
    }
}
