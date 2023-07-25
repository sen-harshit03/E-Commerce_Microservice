package com.productservice.constants;

import com.productservice.dto.ProductRequestDto;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;



@Component
public class TestConstants {

    public static ProductRequestDto getProductRequest() {
        return ProductRequestDto.builder()
                .name("Iphone 13")
                .description("Apple Iphone 13")
                .category("Smartphone")
                .price(BigDecimal.valueOf(59000))
                .build();
    }
}
