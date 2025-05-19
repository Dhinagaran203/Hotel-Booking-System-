package com.project.hotelbookingapp.service;

import java.util.Optional;

import com.project.hotelbookingapp.model.Customer;

public interface CustomerService {

    Optional<Customer> findByUserId(Long userId);

    Optional<Customer> findByUsername(String username);
}
