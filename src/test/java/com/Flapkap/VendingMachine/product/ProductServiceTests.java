package com.Flapkap.VendingMachine.product;

import com.Flapkap.VendingMachine.business.product.dto.ProductDto;
import com.Flapkap.VendingMachine.business.product.entity.Product;
import com.Flapkap.VendingMachine.business.product.repo.ProductRepository;
import com.Flapkap.VendingMachine.business.product.service.ProductMapper;
import com.Flapkap.VendingMachine.business.product.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTests {
    @Mock
    private ProductMapper productMapper;
    @Mock
    private ProductRepository productRepo;

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getProducts() {
        List<Product> entities = List.of(
                new Product()
        );
        List<ProductDto> Dtos = List.of(
                new ProductDto()
        );

        Mockito.when(productRepo.findAll()).thenReturn(entities);
        Mockito.when(productMapper.map(entities)).thenReturn(Dtos);

        List<ProductDto> res=productServiceImpl.listAllProducts();
        assertNotNull(res);
    }
}
