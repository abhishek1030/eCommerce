package com.abhishekanand.orderservice.service;

import com.abhishekanand.orderservice.dto.OrderLineItemsDto;
import com.abhishekanand.orderservice.dto.OrderRequest;
import com.abhishekanand.orderservice.model.Order;
import com.abhishekanand.orderservice.model.OrderLineItems;
import com.abhishekanand.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){
        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .build();
        List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsDtoList().stream().map(orderLineItemsDto -> mapToDto(orderLineItemsDto)).toList();
        order.setOrderLineItemsList(orderLineItemsList);
        orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        return OrderLineItems.builder()
                .id(orderLineItemsDto.getId())
                .skuCode(orderLineItemsDto.getSkuCode())
                .price(orderLineItemsDto.getPrice())
                .quantity(orderLineItemsDto.getQuantity())
                .build();
    }
}
