package com.wide.order.service;

import com.wide.order.entity.Customer;
import com.wide.order.entity.Order;
import com.wide.order.entity.Product;
import com.wide.order.entity.dto.order.CreateOrderDto;
import com.wide.order.entity.dto.order.UpdateOrderDto;
import com.wide.order.exception.ResourceNotFound;
import com.wide.order.repository.CustomerRepository;
import com.wide.order.repository.OrderRepository;
import com.wide.order.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Order> findAllActiveOrders() {
        return orderRepository.findAllActiveOrders();
    }

    @Override
    public Order findOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Order not found for this id :" + id));
    }

    @Override
    public Order createOrder(CreateOrderDto payload) throws Exception {
        Order order = new Order();
        Customer customer = customerRepository.findById(payload.getCustomerId())
                .orElseThrow(() -> new ResourceNotFound("Customer not found for this id :" + payload.getCustomerId()));
        Product product = productRepository.findById(payload.getProductId())
                .orElseThrow(() -> new ResourceNotFound("Product not found for this id :" + payload.getProductId()));

        if (product.getStock() < 0) {
            throw new Exception("Product out of stock");
        }

        product.setStock(product.getStock() - 1);

        order.setCustomer(customer);
        order.setProduct(product);
        order.setTotal(payload.getTotal());
        order.setOrderStatus(payload.getOrderStatus());

        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long id, UpdateOrderDto payload) {
        Customer customer = customerRepository.findById(payload.getCustomerId())
                .orElseThrow(() -> new ResourceNotFound("Customer not found for this id :" + payload.getCustomerId()));
        Product product = productRepository.findById(payload.getProductId())
                .orElseThrow(() -> new ResourceNotFound("Product not found for this id :" + payload.getProductId()));
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Order not found for this id :" + id));

        order.setCustomer(customer);
        order.setProduct(product);
        order.setTotal(payload.getTotal());
        order.setOrderStatus(payload.getOrderStatus());

        return orderRepository.save(order);
    }

    @Override
    public void destroyOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Order not found for this id :" + id));

        order.setDeletedAt(LocalDateTime.now());

        orderRepository.save(order);
    }
}
