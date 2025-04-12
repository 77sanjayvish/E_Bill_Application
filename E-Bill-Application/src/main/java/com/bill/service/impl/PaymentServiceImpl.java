package com.bill.service.impl;

import com.bill.Enums.BillStatus;
import com.bill.Enums.PaymentMethod;
import com.bill.Enums.PaymentStatus;
import com.bill.entity.Bill;
import com.bill.entity.Payment;
import com.bill.entity.User;
import com.bill.exception.ResourceNotFoundException;
import com.bill.payload.PaymentRequest;
import com.bill.repository.BillRepository;
import com.bill.repository.PaymentRepository;
import com.bill.repository.UserRepository;
import com.bill.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BillRepository billRepository;

	@Override
	public Payment processPayment(PaymentRequest request) {
		User user = userRepository.findById(request.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));

		Bill bill = billRepository.findById(request.getBillId())
				.orElseThrow(() -> new ResourceNotFoundException("Bill not found"));

		if (bill.getBillStatus() == BillStatus.PAID) {
			throw new IllegalStateException("Bill is already paid");
		}

		Payment payment = new Payment();
		payment.setBill(bill); // Set the actual Bill entity
		payment.setAmount(request.getAmount());
		payment.setPaymentMethod(PaymentMethod.valueOf(request.getPaymentMethod()));
		payment.setPaymentDate(LocalDate.from(LocalDateTime.now()));
		payment.setStatus((PaymentStatus.SUCCESS));
		payment.setUser(user);

		// Update bill status after successful payment
		bill.setBillStatus(BillStatus.PAID);
		billRepository.save(bill);

		return paymentRepository.save(payment);
	}

	@Override
	public Payment getPaymentById(Long id) {
		return paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Payment not found"));
	}

	@Override
	public List<Payment> getPaymentsByUser(Long userId) {
		return (List<Payment>) paymentRepository.findByUserId(userId);
	}
}
