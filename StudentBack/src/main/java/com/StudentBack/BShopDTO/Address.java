package com.StudentBack.BShopDTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Address implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	@NotBlank(message = "Please enter address line one!")
	private String addressLineOne;
	
	@Column(name = "address_line_two")
	@NotBlank(message = "Please enter address line two!")
	private String addressLineTwo;
	
	@NotBlank(message = "Please enter city name!")
	private String city;
	
	@NotBlank(message = "Please enter state name!")
	private String state;
	
	@NotBlank(message = "Please enter country!")
	private String country;
	
	@Column(name = "postal_code")
	@NotBlank(message = "Please enter postal code!")	
	private String postalCode;
	
	@Column(name = "is_shipping")
	private boolean shipping;
	
	@Column(name = "is_billing")
	private boolean billing;
	
	@Column(name = "user_id")
	private int userId;
	
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
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Address [id=" + id +  ", addressLineOne=" + addressLineOne + ", addressLineTwo="
				+ addressLineTwo + ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode="
				+ postalCode + ", shipping=" + shipping + ", billing=" + billing + "]";
	}
	
	
	
	
	

	
	
	
	
}
