package com.orderservice.service;

import com.orderservice.dto.InventoryResponseDto;
import com.orderservice.dto.OrderLineItemDto;
import com.orderservice.dto.OrderRequest;
import com.orderservice.dto.OrderResponseDto;
import com.orderservice.model.Order;
import com.orderservice.model.OrderLineItem;
import com.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private WebClient webClient;

    @Override
    public void placeOrder(OrderRequest orderRequest) {

        List<OrderLineItem> orderLineItemList = orderRequest.getOrderLineItemDtoList().stream()
                .map(this::dtoToEntity).toList();
        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .orderLineItemList(orderLineItemList)
                .build();

        List<String> skuCodeRequests = batchSkuCodes(order);

        InventoryResponseDto[] response = webClient.get()
                .uri("http://localhost:8084/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCodes", skuCodeRequests).build())
                        .retrieve()
                                .bodyToMono(InventoryResponseDto[].class)
                                        .block();             // makes it sync call


        boolean areAllProductsInStock = Arrays.stream(response).allMatch(InventoryResponseDto::isInStock);

        if(areAllProductsInStock) {
            orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Given Product is not in stock. Please try later.");
        }
    }



    @Override
    public List<OrderResponseDto> getOrderList() {
        List<Order> orderList = orderRepository.findAll();

        List<OrderResponseDto> orderResponseDtoList = orderList
                .stream()
                .map(this::orderToDto)
                .toList();

        return orderResponseDtoList;
    }


    private OrderResponseDto orderToDto(Order order) {
        return OrderResponseDto.builder()
                .orderNumber(order.getOrderNumber())
                .id(order.getId())
                .orderLineItemList(order.getOrderLineItemList())
                .build();
    }


    private OrderLineItem dtoToEntity(OrderLineItemDto orderLineItemDto) {
        return OrderLineItem.builder()
                .skuCode(orderLineItemDto.getSkuCode())
                .price(orderLineItemDto.getPrice())
                .quantity(orderLineItemDto.getQuantity())
                .build();
    }


    private List<String> batchSkuCodes(Order order) {
        return order.getOrderLineItemList()
                .stream()
                .map(OrderLineItem::getSkuCode)
                .toList();
    }
}
