package com.bill.dto;

import java.time.LocalDate;

public class PaymentDTO {

	    private Long id;
	    private double amount;
	    private LocalDate paymentDate;
	    private String status;
	    
		
		public PaymentDTO(Long id, double amount, LocalDate paymentDate, String status) {
			super();
			this.id = id;
			this.amount = amount;
			this.paymentDate = paymentDate;
			this.status = status;
		}
		public Long getId() {
			return id;
		}
		public double getAmount() {
			return amount;
		}
		public LocalDate getPaymentDate() {
			return paymentDate;
		}
		public String getStatus() {
			return status;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public void setPaymentDate(LocalDate paymentDate) {
			this.paymentDate = paymentDate;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return "PaymentDTO [id=" + id + ", amount=" + amount + ", paymentDate=" + paymentDate + ", status=" + status
					+ "]";
		}
	    
	    
}
