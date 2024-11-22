package com.ecom.product_service.controller;

import com.ecom.product_service.dto.ProductDTO;
import com.ecom.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductDTO productDTO) {
        productService.createProduct(productDTO);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<ProductDTO> readAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ProductDTO getProduct(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }
}
