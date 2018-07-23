package com.yash.animalinheritance;

public class Cat extends Animal {
	public Cat() {
		this("Unkown");
	}
	
	public Cat(String name) {
		super(name);
	}
	
	public void bite() {
		System.out.println(getName()+" is biting...");
	}
}
