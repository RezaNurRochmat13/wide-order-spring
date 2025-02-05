package com.wide.order.presenter;

import com.wide.order.entity.dto.order.CreateOrderDto;
import com.wide.order.entity.dto.order.UpdateOrderDto;
import com.wide.order.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class OrderPresenter {
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("orders")
    @ResponseStatus(value = HttpStatus.OK)
    public Map<String, Object> findAllOrders() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", orderService.findAllActiveOrders());
        return response;
    }

    @GetMapping("orders/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Map<String, Object> findOrderById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", orderService.findOrderById(id));
        return response;
    }

    @PostMapping("orders")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Map<String, Object> createOrder(@RequestBody CreateOrderDto payload) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", orderService.createOrder(payload));
        return response;
    }

    @PutMapping("orders/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Map<String, Object> updateOrder(@PathVariable Long id, @RequestBody UpdateOrderDto payload) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", orderService.updateOrder(id, payload));
        return response;
    }

    @DeleteMapping("orders/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Map<String, Object> destroyOrder(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        orderService.destroyOrder(id);
        return response;
    }
}
