package com.tns.cg.smms.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {
	
	public User() {
		super();
	}

	public User(int id, String name, String type, String password, Customer customer_id, MallAdmin malladmin_id,
			ShopOwner shopowner_id) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.password = password;
		this.customer_id = customer_id;
		this.malladmin_id = malladmin_id;
		this.shopowner_id = shopowner_id;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "type")
	private String type;
	@Column(name = "password")
	private String password;

//Mapping
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer_id;

	@OneToOne(cascade = CascadeType.ALL)
	private MallAdmin malladmin_id;

	@OneToOne(cascade = CascadeType.ALL)
	private ShopOwner shopowner_id;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Customer customer_id) {
		this.customer_id = customer_id;
	}

	public MallAdmin getMalladmin_id() {
		return malladmin_id;
	}

	public void setMalladmin_id(MallAdmin malladmin_id) {
		this.malladmin_id = malladmin_id;
	}

	public ShopOwner getShopowner_id() {
		return shopowner_id;
	}

	public void setShopowner_id(ShopOwner shopowner_id) {
		this.shopowner_id = shopowner_id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", type=" + type + ", password=" + password + ", customer_id="
				+ customer_id + ", malladmin_id=" + malladmin_id + ", shopowner_id=" + shopowner_id + "]";
	}

}
