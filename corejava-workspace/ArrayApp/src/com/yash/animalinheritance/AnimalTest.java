package com.yash.animalinheritance;

import java.util.Scanner; 
import com.yash.animalinheritance.Animal;

public class AnimalTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter object type :");
		String objectType = sc.nextLine();
		
		Object object = Class.forName("com.yash.animalinheritance."+objectType).newInstance();
		
		if(object instanceof Dog) {
			Dog dog = (Dog)object;
			
			dog.eat();
			dog.run();
			dog.bark();
			
			
		} else if (object instanceof Cat) {
			Cat cat = (Cat)object;
			
			cat.eat();
			cat.run();
			cat.bite();
			
		} else {
			System.out.println("Don't try to be oversmart");
		}
		
		
	}
}
