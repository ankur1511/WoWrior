package com.ankur.Entity;

public class User {

	private String name;
	private int age;
	private String gender;
	private String[] address;

	public String[] getAddress() {
		return address;
	}

	public void setAddress(String[] address) {
		System.out.println();
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public User(String Name, int age, String gender, String[] address) {
		this.name = Name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	public User() {

	}

}
