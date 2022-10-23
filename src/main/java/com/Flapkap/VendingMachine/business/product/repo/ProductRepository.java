package com.Flapkap.VendingMachine.business.product.repo;

import com.Flapkap.VendingMachine.business.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
