package com.yash.ota.service;

import java.util.List;

import com.yash.ota.exception.AlreadyExistsException;
import com.yash.ota.exception.DoesNotExistException;
import com.yash.ota.exception.FieldEmptyException;
import com.yash.ota.exception.InvalidContactException;
import com.yash.ota.exception.InvalidEmailException;
import com.yash.ota.exception.InvalidPasswordException;
import com.yash.ota.exception.NonAlphabeticNameException;
import com.yash.ota.exception.UserAuthenticationException;
import com.yash.ota.model.User;

public interface UserService {
	boolean registerUser(User user) throws InvalidPasswordException, FieldEmptyException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException;
	User authenticateUser(String loginName, String password) throws UserAuthenticationException;
	List<User> listUsers();
	boolean removeUser(User user) throws DoesNotExistException;
	boolean updateUser(User user) throws DoesNotExistException;
	User findUserByProperty(String property, Object value) throws DoesNotExistException;
}
