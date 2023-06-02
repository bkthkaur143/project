package com.tns.cg.smms.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetails")

public class OrderDetails implements Serializable {
	
	

	public OrderDetails() {
		super();
	}
	

	public OrderDetails(int id, LocalDate dateOfPurchase, float total, String paymentMode, Customer customer) {
		super();
		this.id = id;
		this.dateOfPurchase = dateOfPurchase;
		this.total = total;
		this.paymentMode = paymentMode;
		this.customer = customer;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "dateOfPurchase")
	private LocalDate dateOfPurchase;
	@Column(name = "total")
	private float total;
	@Column(name = "paymentMode")
	private String paymentMode;

//Mapping
	@ManyToOne(cascade = CascadeType.ALL)
//@JoinColumn(name="id")
	private Customer customer;

//GETTER & SETTER

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(LocalDate dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer_id(Customer customer) {
		this.customer = customer;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}


	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", dateOfPurchase=" + dateOfPurchase + ", total=" + total + ", paymentMode="
				+ paymentMode + ", customer=" + customer + "]";
	}

}
