package com.ecom.product_service.service;

import com.ecom.product_service.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    void createProduct(ProductDTO productDTO);

    List<ProductDTO> getAllProducts();

    ProductDTO getProduct(Long id);
}
