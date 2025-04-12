package com.bill.entity;

import java.time.LocalDate;
import java.util.List;

import com.bill.Enums.PaymentMethod;
import com.bill.Enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "bill_id", nullable = false)
    private Bill bill;  // Corrected field name

    @Column(nullable = false)
    private double amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod paymentMethod;

    @Column(nullable = false)
    private LocalDate paymentDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status;  // Renamed from "Status" to "status"

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@JsonBackReference
	private User user;

	public Long getId() {
		return id;
	}

	public Bill getBill() {
		return bill;
	}

	public double getAmount() {
		return amount;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public User getUser() {
		return user;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", bill=" + bill + ", amount=" + amount + ", paymentMethod=" + paymentMethod
				+ ", paymentDate=" + paymentDate + ", status=" + status + ", user=" + user + "]";
	}

	public Payment(Long id, Bill bill, double amount, PaymentMethod paymentMethod, LocalDate paymentDate,
			PaymentStatus status, User user) {
		super();
		this.id = id;
		this.bill = bill;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.paymentDate = paymentDate;
		this.status = status;
		this.user = user;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

   
    
}
