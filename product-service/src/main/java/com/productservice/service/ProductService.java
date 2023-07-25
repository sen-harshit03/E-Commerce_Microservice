package com.productservice.service;

import com.productservice.dto.ProductRequestDto;
import com.productservice.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    public void addProduct(ProductRequestDto productRequestDto);

    public List<ProductResponseDto> getAllProducts();

    public ProductResponseDto getProductByName(String name);

    public List<ProductResponseDto> getProductByCategory(String category);
}
