package com.productservice.repository;

import com.productservice.dto.ProductRequestDto;
import com.productservice.dto.ProductResponseDto;
import com.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository <Product, String> {
    public Product findByNameIgnoreCase(String name);

    public List<Product> findByCategoryIgnoreCase(String category);

    public void deleteByName(String name);
//    public void save(Product product);
//
//    public List<Product> findAll();
}
