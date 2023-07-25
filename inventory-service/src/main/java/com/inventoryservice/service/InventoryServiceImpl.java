package com.inventoryservice.service;


import com.inventoryservice.dto.InventoryResponseDto;
import com.inventoryservice.model.Inventory;
import com.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Override
    @Transactional(readOnly = true)
    public List<InventoryResponseDto> isInStock(List<String> skuCodes) {

       return inventoryRepository.findBySkuCodeIn(skuCodes)
               .stream()
               .map(this::mapToDto)
               .toList();
    }


    private InventoryResponseDto mapToDto(Inventory inventory) {
        return InventoryResponseDto.builder()
                .skuCode(inventory.getSkuCode())
                .isInStock(inventory.getQuantity() > 0)
                .build();
    }
}
