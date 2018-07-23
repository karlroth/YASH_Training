package com.yash.user_registry.serviceimpl;

import com.yash.user_registration.exceptions.FieldEmptyException;
import com.yash.user_registration.exceptions.InvalidPasswordException;
import com.yash.user_registration.exceptions.NonAlphabeticNameException;
import com.yash.user_registration.exceptions.UserAlreadyExistsException;
import com.yash.user_registration.exceptions.UserAuthenticationException;
import com.yash.user_registry.dao.UserDAO;
import com.yash.user_registry.model.User;
import com.yash.user_registry.service.UserService;
import com.yash.user_registry.util.PasswordUtil;
import com.yash.user_registry.util.RegisterUtil;

public class UserServiceImpl implements UserService {

	UserDAO userDAO;

	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void registerUser(User user)
			throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException,
			UserAlreadyExistsException {

		String name = user.getName();
		String login_name = user.getLoginName();
		String password = user.getPassword();
		
		RegisterUtil.checkIfNullOrEmpty(name, login_name, password);

		RegisterUtil.checkOnlyContainsAlpha(name);
		RegisterUtil.checkOnlyContainsAlpha(login_name);
		checkIfLoginNameIsAvailable(login_name);

		PasswordUtil.checkPasswordMeetsCriterion(password);

		register(name, login_name, password);
	}

	public void login(String login_name, String password) throws UserAuthenticationException {

		checkIfUserExists(login_name);
		authenticate(login_name, password);

		printWelcomeMessage(login_name);
	}

	private void printWelcomeMessage(String login_name) {
		String name = userDAO.getName(login_name);
		System.out.println("Welcome, " + name + "!");
		System.out.println();
	}

	private void authenticate(String login_name, String password) throws UserAuthenticationException {
		if (!userDAO.userAuthentication(login_name, password)) {
			throw new UserAuthenticationException("Incorrect password.");
		}
	}

	private void checkIfUserExists(String login_name) throws UserAuthenticationException {
		if (!userDAO.containsUser(login_name)) {
			throw new UserAuthenticationException("The login name " + login_name + " does not exist");
		}
	}

	private void register(String name, String login_name, String password) {
		User user = new User();
		user.setName(name);
		user.setLoginName(login_name);
		user.setPassword(password);
		userDAO.insert(user);
	}

	private void checkIfLoginNameIsAvailable(String login_name) throws UserAlreadyExistsException {
		boolean userAlreadyExists = userDAO.containsUser(login_name);
		if (userAlreadyExists) {
			throw new UserAlreadyExistsException(
					"The user name " + login_name + " already exists. Please choose another.");
		}
	}


}
