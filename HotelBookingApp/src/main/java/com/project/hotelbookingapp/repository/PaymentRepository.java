package com.project.hotelbookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hotelbookingapp.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
