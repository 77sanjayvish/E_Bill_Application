package com.bill.entity;

import com.bill.Enums.BillStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bills")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Integer unitsConsumed;

	@Column(nullable = false)
	private double amountDue;

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "M/d/yyyy")
	private LocalDate dueDate;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private BillStatus billStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@JsonBackReference
	private User user;

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

	public BillStatus getBillStatus() {
		return billStatus;
	}

	public User getUser() {
		return user;
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

	public void setBillStatus(BillStatus billStatus) {
		this.billStatus = billStatus;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", unitsConsumed=" + unitsConsumed + ", amountDue=" + amountDue + ", dueDate="
				+ dueDate + ", billStatus=" + billStatus + ", user=" + user + "]";
	}

	public Bill(Long id, Integer unitsConsumed, double amountDue, LocalDate dueDate, BillStatus billStatus, User user) {
		super();
		this.id = id;
		this.unitsConsumed = unitsConsumed;
		this.amountDue = amountDue;
		this.dueDate = dueDate;
		this.billStatus = billStatus;
		this.user = user;
	}

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

}
