package com.ecom.product_service.service;

import com.ecom.product_service.dto.InventoryDTO;
import com.ecom.product_service.dto.ProductDTO;
import com.ecom.product_service.model.Product;
import com.ecom.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

/**
 * Keeping all the business logics
 * Used web client to communicate between services
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final WebClient.Builder webClientBuilder;

    @Override
    public void createProduct(ProductDTO productDTO) {
        log.info("Creating product: {}", productDTO);
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        productRepository.save(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = productList.stream().map(p -> new ProductDTO(p.getSkuCode(), p.getName(), p.getDescription(), p.getPrice())).toList();
        return productDTOList;
    }

    @Override
    public ProductDTO getProduct(Long id) {
        log.info("Product id: {}", id);
        Optional<Product> productOptional = productRepository.findById(id);
        ProductDTO productDTO = new ProductDTO();
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            InventoryDTO inventoryDTO = webClientBuilder.build().get().uri("http://inventory-service/v1/api/inventory/"+product.getSkuCode()).retrieve().bodyToMono(InventoryDTO.class).block();
            log.info("Inventory DTO: {}", inventoryDTO);
            BeanUtils.copyProperties(product, productDTO);
            productDTO.setQuantity(inventoryDTO.getQuantity());
        }
        return productDTO;
    }
}
