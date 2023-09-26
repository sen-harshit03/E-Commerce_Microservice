package com.productservice.controller;

import com.productservice.dto.ProductRequestDto;
import com.productservice.dto.ProductResponseDto;
import com.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductRequestDto> addProduct(@RequestBody ProductRequestDto productRequestDto) {
        productService.addProduct(productRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRequestDto);

    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(value = "/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDto getProductByName(@PathVariable("name") @RequestBody String name) {
        return productService.getProductByName(name);
    }

    @GetMapping(value = "/category/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDto> getProductByCategory(@PathVariable("category") @RequestBody String category) {
        return productService.getProductByCategory(category);
    }
}
