package com.yash.ota.dao;

import java.util.List;

import com.yash.ota.exception.DoesNotExistException;
import com.yash.ota.model.User;

public interface UserDAO {
	
	boolean insert(User user);
	boolean delete(int id);
	boolean update(User user);
	List<User> list();
	User findById(int id);
	User findByProperty(String property, Object value) throws DoesNotExistException;
}
