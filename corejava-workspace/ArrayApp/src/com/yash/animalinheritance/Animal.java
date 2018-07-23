package com.yash.animalinheritance;

public class Animal {

	private String name;
	
	public Animal() {
		this.name = "Unknown";
	}
	
	public Animal(String name) {
		this.name = name;
	}
	
	public void eat() {
		System.out.println(name+" is eating...");
	}
	
	public void run() {
		System.out.println(name+" is running...");
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
