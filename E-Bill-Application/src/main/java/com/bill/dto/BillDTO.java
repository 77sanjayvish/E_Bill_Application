package com.bill.dto;

import java.time.LocalDate;

public class BillDTO {

	private Long id;
	private Integer unitsConsumed;
	private double amountDue;
	private LocalDate dueDate;
	private String billStatus;
	public Long getId() {
		return id;
	}
	public Integer getUnitsConsumed() {
		return unitsConsumed;
	}
	public double getAmountDue() {
		return amountDue;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public String getBillStatus() {
		return billStatus;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUnitsConsumed(Integer unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}
	public void setAmountDue(double amountDue) {
		this.amountDue = amountDue;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}
	@Override
	public String toString() {
		return "BillDTO [id=" + id + ", unitsConsumed=" + unitsConsumed + ", amountDue=" + amountDue + ", dueDate="
				+ dueDate + ", billStatus=" + billStatus + "]";
	}
	public BillDTO(Long id, Integer unitsConsumed, double amountDue, LocalDate dueDate, String billStatus) {
		super();
		this.id = id;
		this.unitsConsumed = unitsConsumed;
		this.amountDue = amountDue;
		this.dueDate = dueDate;
		this.billStatus = billStatus;
	}
	
	
}
