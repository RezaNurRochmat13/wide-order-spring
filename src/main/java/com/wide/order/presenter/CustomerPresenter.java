package com.wide.order.presenter;

import com.wide.order.entity.Customer;
import com.wide.order.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class CustomerPresenter {
    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping("customers")
    @ResponseStatus(value = HttpStatus.OK)
    public Map<String, Object> findAllCustomers() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", customerService.findAllActiveCustomers());
        return response;
    }

    @GetMapping("customers/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Map<String, Object> findCustomerById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", customerService.findCustomerById(id));
        return response;
    }

    @PostMapping("customers")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Map<String, Object> createCustomer(@RequestBody Customer payload) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", customerService.createCustomer(payload));
        return response;
    }

    @PutMapping("customers/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Map<String, Object> updateCustomer(@PathVariable Long id, @RequestBody Customer payload) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", customerService.updateCustomer(id, payload));
        return response;
    }

    @DeleteMapping("customers/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Map<String, Object> destroyCustomer(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        customerService.destroyCustomer(id);
        return response;
    }
}
