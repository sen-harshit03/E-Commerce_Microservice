package com.productservice;

import com.productservice.constants.TestConstants;
import com.productservice.controller.ProductController;
import com.productservice.dto.ProductRequestDto;
import com.productservice.dto.ProductResponseDto;
import com.productservice.repository.ProductRepository;
import com.productservice.serializer.Serializer;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.utility.DockerImageName;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
//@Testcontainers
//@AutoConfigureMockMvc
class ProductServiceApplicationTests {

//	@Autowired
//	private TestConstants testConstants;
//
//	@Autowired
//	private Serializer serializer;
//
//	@Autowired
//	ProductController controller;
////	@Container
////	final static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:4.0.10"));
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Autowired
//	ProductRepository repository;
//
//
////	@DynamicPropertySource
////	public static void setProperties(DynamicPropertyRegistry propertyRegistry) {
////		propertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
////	}
//
//
//	@Test
//	public void shouldCreateProduct() throws Exception {
//
//		ProductRequestDto productRequest = testConstants.getProductRequest();
//
////		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
////				.contentType(MediaType.APPLICATION_JSON)
////				.content(serializer.getObjectAsString(productRequest)))
////				.andExpect(status().isCreated());
//		ResponseEntity<ProductRequestDto> responseEntity = controller.addProduct(productRequest);
//		repository.deleteByName(responseEntity.getBody().getName());
//		Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
//	}




	@Test
	void contextLoads() {
	}

}
