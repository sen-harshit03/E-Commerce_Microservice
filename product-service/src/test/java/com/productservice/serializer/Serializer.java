package com.productservice.serializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

public class Serializer {

    @Autowired
    private ObjectMapper objectMapper;

    public String getObjectAsString(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }
}
