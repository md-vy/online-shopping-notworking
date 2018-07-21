package com.StudentBack.BShopDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {

	
	/*
	 * private fields for user
	 * */

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//-----------------------------------------
	@ManyToOne
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user=user;
	}
	//-----------------------------------------
	
	@Column(name = "address_line_one")
	private String addressLineOne;
	@Column(name = "address_line_two")
	private String addressLineTwo;
	private String city;
	private String state;
	private String country;
	@Column(name = "postal_code")
	private String postalCode;
	private boolean shipping;
	private boolean billing;
	
	
	/*
	 * getters and setters
	 * */ 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getAdressLineOne() {
		return addressLineOne;
	}
	public void setAdressLineOne(String adressLineOne) {
		this.addressLineOne = adressLineOne;
	}
	public String getAdressLineTwo() {
		return addressLineTwo;
	}
	public void setAdressLineTwo(String adressLineTwo) {
		this.addressLineTwo = adressLineTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		postalCode = postalCode;
	}
	public boolean isShipping() {
		return shipping;
	}
	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}
	public boolean isBilling() {
		return billing;
	}
	public void setBilling(boolean billing) {
		this.billing = billing;
	}
	@Override
	public String toString() {
		return "Address [id=" + id +  ", addressLineOne=" + addressLineOne + ", addressLineTwo="
				+ addressLineTwo + ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode="
				+ postalCode + ", shipping=" + shipping + ", billing=" + billing + "]";
	}
	
	
	
	
	

	
	
	
	
}
