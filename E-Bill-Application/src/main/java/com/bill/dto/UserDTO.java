package com.bill.dto;

import java.util.List;


public class UserDTO {
	
	private Long id;
	
	private String username;
	
	private String email;
	
	private List<BillDTO> bills;
	
	private List<PaymentDTO> payments;

	public UserDTO(Long id, String username, String email, List<BillDTO> bills, List<PaymentDTO> payments) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.bills = bills;
		this.payments = payments;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", email=" + email + ", bills=" + bills + ", payments="
				+ payments + "]";
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public List<BillDTO> getBills() {
		return bills;
	}

	public List<PaymentDTO> getPayments() {
		return payments;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBills(List<BillDTO> bills) {
		this.bills = bills;
	}

	public void setPayments(List<PaymentDTO> payments) {
		this.payments = payments;
	}
	
	

}
