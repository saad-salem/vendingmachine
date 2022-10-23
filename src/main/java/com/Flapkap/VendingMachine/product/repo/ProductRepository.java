package com.Flapkap.VendingMachine.product.repo;

import com.Flapkap.VendingMachine.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
