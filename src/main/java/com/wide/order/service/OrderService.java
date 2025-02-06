package com.wide.order.service;

import com.wide.order.entity.Order;
import com.wide.order.entity.dto.order.CreateOrderDto;
import com.wide.order.entity.dto.order.ListOrderDto;
import com.wide.order.entity.dto.order.SingleOrderDto;
import com.wide.order.entity.dto.order.UpdateOrderDto;

import java.util.List;

public interface OrderService {
    List<ListOrderDto> findAllActiveOrders();
    SingleOrderDto findOrderById(Long id);
    Order createOrder(CreateOrderDto order) throws Exception;
    Order updateOrder(Long id, UpdateOrderDto payload);
    void destroyOrder(Long id);
}
