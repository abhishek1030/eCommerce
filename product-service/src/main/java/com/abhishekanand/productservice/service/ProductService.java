package com.abhishekanand.productservice.service;

import com.abhishekanand.productservice.dto.ProductRequest;
import com.abhishekanand.productservice.dto.ProductResponse;
import com.abhishekanand.productservice.model.Product;
import com.abhishekanand.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .id(productRequest.getId())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is being saved",product.getId());
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
        //List<ProductResponse> productResponses = products.stream().map(product->mapToProductResponse(product)).collect(Collectors.toList());
        List<ProductResponse> productResponses = products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
        return productResponses;
    }

    private ProductResponse mapToProductResponse(Product product) {
        ProductResponse productResponse = ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
        return productResponse;
    }
}
