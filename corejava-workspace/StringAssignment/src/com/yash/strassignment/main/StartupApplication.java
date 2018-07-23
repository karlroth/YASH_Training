package com.yash.strassignment.main;

import com.yash.strassignment.model.*;
import com.yash.strassignment.controller.UserController;
import java.util.Scanner;


public class StartupApplication {
	public static void main(String[] args) {
		
		UserController control = new UserController();
		
		printMenu();
		
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		
		switch(sc ) {
			case 1:
				
		}
		
		control.addUser(1234);
		
		control.listUsers();
		
	}
	
	public static void printMenu() {
		System.out.println("----Main Menu----");
		System.out.println("What would you like to do?");
		System.out.println("1. Add user");
		System.out.println("2. Delete user");
		System.out.println("0. Exit");
	}
	
}
