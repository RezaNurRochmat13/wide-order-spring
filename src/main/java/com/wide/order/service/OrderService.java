package com.wide.order.service;

import com.wide.order.entity.Order;
import com.wide.order.entity.dto.CreateOrderDto;
import com.wide.order.entity.dto.UpdateOrderDto;

import java.util.List;

public interface OrderService {
    List<Order> findAllActiveOrders();
    Order findOrderById(Long id);
    Order createOrder(CreateOrderDto order) throws Exception;
    Order updateOrder(Long id, UpdateOrderDto payload);
    void destroyOrder(Long id);
}
