package com.example.service;

public class Pet {

	String name;
	String color;
	Integer age;
	
	Pet(String name, String color, int age){
		this.name = name;
		this.color = color;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
