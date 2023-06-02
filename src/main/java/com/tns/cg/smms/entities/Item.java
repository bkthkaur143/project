package com.tns.cg.smms.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item")

public class Item implements Serializable {
	
	

	public Item() {
		super();
	}
	

	public Item(int id, String itemName, double price, LocalDate manufacturingDate, LocalDate expiry, String category,
			Shop shopID) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.price = price;
		this.manufacturingDate = manufacturingDate;
		this.expiry = expiry;
		this.category = category;
		this.shopID = shopID;
	}



	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "itemName")
	private String itemName;
	@Column(name = "price")
	private double price;
	@Column(name = "manufacturingDate")
	private LocalDate manufacturingDate;
	@Column(name = "expiry")
	private LocalDate expiry;
	@Column(name = "category")
	private String category;

	//Mapping
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shopId")
	private Shop shopID;

	// GETTERs & SETTERs

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public LocalDate getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(LocalDate manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public LocalDate getExpiry() {
		return expiry;
	}

	public void setExpiry(LocalDate expiry) {
		this.expiry = expiry;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Shop getShopID() {
		return shopID;
	}

	public void setShopID(Shop shopID) {
		this.shopID = shopID;
	}


	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", price=" + price + ", manufacturingDate="
				+ manufacturingDate + ", expiry=" + expiry + ", category=" + category + ", shopID=" + shopID + "]";
	}

}
