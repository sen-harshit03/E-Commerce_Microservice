package com.inventoryservice.service;

import com.inventoryservice.dto.InventoryResponseDto;

import java.util.List;

public interface InventoryService {
    public List<InventoryResponseDto> isInStock(List<String> skuCode);
}
