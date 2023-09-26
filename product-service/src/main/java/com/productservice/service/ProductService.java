package com.productservice.service;

import com.productservice.dto.ProductRequestDto;
import com.productservice.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    void addProduct(ProductRequestDto productRequestDto);

    List<ProductResponseDto> getAllProducts();

    ProductResponseDto getProductByName(String name);

    List<ProductResponseDto> getProductByCategory(String category);
}
