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

@Entity   // This specifies the class as a entity class
@Table(name = "employee") // specifies name of table in database
public class Employee implements Serializable {
	
	
	public Employee() {
		super();
	}

	
	
	public Employee(int id, String name, LocalDate dob, float salary, String address, String designation, Shop shop) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.salary = salary;
		this.address = address;
		this.designation = designation;
		this.shop = shop;
	}

	private static final long serialVersionUID = 1L;
	
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "dob")
	private LocalDate dob;
	@Column(name = "salary")
	private float salary;
	@Column(name = "address")
	private String address;
	@Column(name = "designation")
	private String designation;

	//Mapping
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shopId")
	private Shop shop;

	//Generating GETTERs & SETTERs

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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + ", salary=" + salary + ", address=" + address
				+ ", designation=" + designation + ", shop=" + shop + "]";
	}

}