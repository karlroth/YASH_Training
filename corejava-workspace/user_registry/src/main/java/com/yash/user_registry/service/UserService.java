package com.yash.user_registry.service;

import com.yash.user_registration.exceptions.FieldEmptyException;
import com.yash.user_registration.exceptions.InvalidPasswordException;
import com.yash.user_registration.exceptions.NonAlphabeticNameException;
import com.yash.user_registration.exceptions.UserAlreadyExistsException;
import com.yash.user_registration.exceptions.UserAuthenticationException;
import com.yash.user_registry.model.User;

public interface UserService {

	void registerUser(User user) throws InvalidPasswordException, FieldEmptyException, NonAlphabeticNameException, UserAlreadyExistsException;

	void login(String login_name, String password) throws UserAuthenticationException;

}
