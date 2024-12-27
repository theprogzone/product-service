package com.ecom.product_service.repository;

import com.ecom.product_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface helps to deal with the database.
 * All the database queries keeping inside this repository.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
