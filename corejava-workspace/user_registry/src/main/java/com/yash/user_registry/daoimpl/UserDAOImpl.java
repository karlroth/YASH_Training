package com.yash.user_registry.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.yash.user_registry.dao.UserDAO;
import com.yash.user_registry.model.User;

public class UserDAOImpl implements UserDAO {

	private List<User> userRegistry;
	
	public UserDAOImpl() {
		userRegistry = new ArrayList<User>();
	}
	
	public void insert(User user) {
		userRegistry.add(user);
		
	}

	public boolean containsUser(String login_name) {
		boolean inRegistry = false;
		for(User user : userRegistry) {
			if(user.getLoginName().equals(login_name)) {
				inRegistry = true;
				break;
			}
		}
		return inRegistry;
	}

	public boolean userAuthentication(String login_name, String password) {
		boolean authenticated = false; 
		
		for(User user : userRegistry) {
			if(user.getLoginName().equals(login_name) && user.getPassword().equals(password)) {
				authenticated = true;
			}
		}
		return authenticated;
	}

	public String getName(String login_name) {
		String name = "";
		for(User user : userRegistry) {
			if(user.getLoginName().equals(login_name)) {
				name = user.getName();
			}
		}
		return name;
	}
	
	public List<User> getUserRegistry() {
		return userRegistry;
	}

}
