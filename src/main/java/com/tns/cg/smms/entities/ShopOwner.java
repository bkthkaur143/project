package com.tns.cg.smms.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shopowner")

public class ShopOwner implements Serializable {
	
	

	public ShopOwner() {
		super();
	}
	
	public ShopOwner(int id, String name, String address, LocalDate dob, User user_ID, MallAdmin malladmin_ID) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.user_ID = user_ID;
		this.malladmin_ID = malladmin_ID;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "dob")
	private LocalDate dob;

//Mapping
	@OneToOne(cascade = CascadeType.ALL)
	private User user_ID;
	@OneToOne(cascade = CascadeType.ALL)
	private MallAdmin malladmin_ID;

//GETTER & SETTER

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public User getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(User user_ID) {
		this.user_ID = user_ID;
	}

	public MallAdmin getMalladmin_ID() {
		return malladmin_ID;
	}

	public void setMalladmin_ID(MallAdmin malladmin_ID) {
		this.malladmin_ID = malladmin_ID;
	}

	@Override
	public String toString() {
		return "ShopOwner [id=" + id + ", name=" + name + ", address=" + address + ", dob=" + dob + ", user_ID="
				+ user_ID + ", malladmin_ID=" + malladmin_ID + "]";
	}
	
}
