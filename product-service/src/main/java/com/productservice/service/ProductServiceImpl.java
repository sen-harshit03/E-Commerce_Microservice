package com.productservice.service;

import com.productservice.dto.ProductRequestDto;
import com.productservice.dto.ProductResponseDto;
import com.productservice.model.Product;
import com.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void addProduct(ProductRequestDto productRequestDto) {

        Product product = Product.builder()
                .name(productRequestDto.getName())
                .description(productRequestDto.getDescription())
                .category(productRequestDto.getCategory())
                .price(productRequestDto.getPrice())
                .build();

        productRepository.save(product);

        log.info("Product {} added successfully", product.getId());



    }

    @Override
    public List<ProductResponseDto> getAllProducts() {

        log.info("Fetching products from the database...");
        List<Product> productList = productRepository.findAll();

        log.info("Fetched the productList from the database");

        List<ProductResponseDto> productResponseList = productList.stream()
                .map(this::mapToDto).toList();

        return productResponseList;

    }

    @Override
    public ProductResponseDto getProductByName(String name) {
        log.info("Fetching the product {} from the database...", name);
        Product product = productRepository.findByNameIgnoreCase(name);

        log.info("Fetched the product {} from the database", product.getName());

        return mapToDto(product);
    }

    @Override
    public List<ProductResponseDto> getProductByCategory(String category) {
        log.info("Fetching the products of category {} from the database...", category);

        List<Product> productList = productRepository.findByCategoryIgnoreCase(category);

        log.info("Fetched the products of category {} from the database", category);

        List<ProductResponseDto> productResponseList = productList.stream()
                .map(this::mapToDto).toList();

        return productResponseList;
    }


    private ProductResponseDto mapToDto(Product product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .category(product.getCategory())
                .price(product.getPrice())
                .build();
    }
}
