package com.bill.payload;

public class PaymentRequest {
	private Long userId;
	private Long billId;
	private Double amount;
	private String paymentMethod;
	private String status;

	public Long getUserId() {
		return userId;
	}

	public Long getBillId() {
		return billId;
	}

	public Double getAmount() {
		return amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public String getStatus() {
		return status;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PaymentRequest [userId=" + userId + ", billId=" + billId + ", amount=" + amount + ", paymentMethod="
				+ paymentMethod + ", status=" + status + "]";
	}

	public PaymentRequest(Long userId, Long billId, Double amount, String paymentMethod, String status) {
		super();
		this.userId = userId;
		this.billId = billId;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.status = status;
	}

	public PaymentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

}
