package com.bill.service;

import java.util.List;

import com.bill.entity.Payment;
import com.bill.payload.PaymentRequest;

public interface PaymentService {

	Payment processPayment(PaymentRequest request);

	Payment getPaymentById(Long id);

	List<Payment> getPaymentsByUser(Long userId);
}
