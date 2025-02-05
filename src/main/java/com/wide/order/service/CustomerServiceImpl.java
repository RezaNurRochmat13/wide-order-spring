package com.wide.order.service;

import com.wide.order.entity.Customer;
import com.wide.order.exception.ResourceNotFound;
import com.wide.order.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllActiveCustomers() {
        return customerRepository.findAllActiveCustomers();
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Customer not found for this id :" + id));
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer payload) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Customer not found for this id :" + id));

        customer.setName(payload.getName());
        customer.setAddress(payload.getAddress());
        customer.setPostalCode(payload.getPostalCode());

        return customerRepository.save(customer);
    }

    @Override
    public void destroyCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Customer not found for this id :" + id));

        customer.setDeletedAt(LocalDateTime.now());

        customerRepository.save(customer);
    }
}
