package com.bill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bill.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
	 Payment findByUserId(Long id);
}
