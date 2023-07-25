package com.orderservice.service;

import com.orderservice.dto.OrderRequest;
import com.orderservice.dto.OrderResponseDto;

import java.util.List;

public interface OrderService {
    public void placeOrder(OrderRequest orderRequest);

    public List<OrderResponseDto> getOrderList();
}
