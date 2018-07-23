package com.yash.user_registry.dao;

import java.util.List;

import com.yash.user_registry.model.User;

public interface UserDAO {

	void insert(User user);

	boolean containsUser(String login_name);

	boolean userAuthentication(String login_name, String password);

	String getName(String login_name);

	List<User> getUserRegistry();
	

}
