package com.yash.strassignment.controller;

import com.yash.strassignment.model.*;
import java.util.ArrayList;


public class UserController {

	private static ArrayList<User> users;
	private static boolean isInitialized = false;
	
	
	public UserController() {
		users = new ArrayList<User>();
		isInitialized = true;
	}
	
	public void addUser(User user) {
		if(isInitialized) {
			users.add(user);
		}
	}
	
	public void editUser(User user) {
		if(isInitialized) {
			
		}
	}
	
	public void deleteUser(User user) {
		if(isInitialized) {
			users.remove(user);
		}
	}
	
	public void listUsers() {
		if(isInitialized) {
			int length = users.size();
			for(int i = 0; i < length; i++) {
				System.out.println(users.get(i));
			}
		}
	}
}
