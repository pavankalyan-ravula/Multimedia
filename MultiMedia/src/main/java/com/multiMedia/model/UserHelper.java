package com.multiMedia.model;

import java.util.List;

public class UserHelper {

	
	private Long id;
	
	private String name;
	
	private String city;
	
	private String status;
	
	private int age;
	
	private String image;
	
//	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//	private List<Address> address;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
//	public List<Address> getAddress() {
//		return address;
//	}
//	public void setAddress(List<Address> address) {
//		this.address = address;
//	}
	
	public UserHelper() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserHelper(Long id, String name, String city, String status, int age, String image)//, List<Address> address 
	{
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.status = status;
		this.age = age;
		this.image = image;
	//	this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", city=" + city + ", status=" + status + "]";
	}
	
}
