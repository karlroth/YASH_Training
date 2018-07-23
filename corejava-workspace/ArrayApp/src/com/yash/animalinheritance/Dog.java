package com.yash.animalinheritance;

class Dog extends Animal {

	public Dog() {
		this("Unkown");
	}
	
	public Dog(String name) {
		super(name);
	}
	
	public void bark() {
		System.out.println(getName()+" is barking...");
	}
	
}