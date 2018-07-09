package com.StudentBack.BShopDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", Name=" + Name + ", description=" + description + ", imageURL=" + imageURL
				+ ", active=" + active + "]";
	}



	/*
	 * Private fields
	 * */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String Name;
	private String description;
	
	@Column(name="image_url")
	private String imageURL;
	
	@Column(name="is_active")
	private boolean active=true;
}
