package com.abhishekanand.productservice.repository;

import com.abhishekanand.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
