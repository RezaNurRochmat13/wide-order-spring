package com.wide.order.service;

import com.wide.order.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllActiveCustomers();
    Customer findCustomerById(Long id);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Long id, Customer payload);
    void destroyCustomer(Long id);
}
