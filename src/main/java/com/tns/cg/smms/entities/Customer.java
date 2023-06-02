package com.tns.cg.smms.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity    // This annotation used to define class as a entity class.
@Table(name = "customer")   // this annotation specifies table name in database

public class Customer implements Serializable {
	
	public Customer() {
		super();
	}

	public Customer(int id, String name, String phone, String email, List<OrderDetails> order, List<User> user) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.order = order;
		this.user = user;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "phone")
	private String phone;
	@Column(name = "email")
	private String email;

	//Mapping
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderDetails> order;
	@OneToMany(cascade = CascadeType.ALL)
	private List<User> user;

	//Generating GETTERs & SETTERs

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<OrderDetails> getOrder() {
		return order;
	}

	public void setOrder_id(List<OrderDetails> order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", order=" + order
				+ ", user=" + user + "]";
	}

}
