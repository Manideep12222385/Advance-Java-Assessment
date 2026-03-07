package com.springrest.demo.model;

import java.util.*;
import jakarta.persistence.*;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private Long phoneNumber;
	private String address;
	
	@OneToMany(mappedBy = "customer",cascade=CascadeType.ALL)
	private List<Policy> policies;
	
	public Customer() {

	}

	public Customer(String name, String email, Long phoneNumber, String address, List<Policy> policies) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.policies = policies;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<Policy> getPolicies(){
		return policies;
	}
	
	public void setPolicies(List<Policy> policies) {
		this.policies=policies;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", policies=" + policies + "]";
	}

}