
package com.yash.ota.serviceimpl;

import java.util.List;

import com.yash.ota.dao.UserDAO;
import com.yash.ota.daoimpl.UserDAOImpl;
import com.yash.ota.exception.AlreadyExistsException;
import com.yash.ota.exception.DoesNotExistException;
import com.yash.ota.exception.FieldEmptyException;
import com.yash.ota.exception.InvalidContactException;
import com.yash.ota.exception.InvalidEmailException;
import com.yash.ota.exception.InvalidPasswordException;
import com.yash.ota.exception.NonAlphabeticNameException;
import com.yash.ota.exception.UserAuthenticationException;
import com.yash.ota.model.User;
import com.yash.ota.service.UserService;
import com.yash.ota.util.PasswordUtil;
import com.yash.ota.util.RegisterUtil;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	public UserServiceImpl() {
		userDAO = new UserDAOImpl();
	}
	
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public boolean registerUser(User user) throws InvalidPasswordException, FieldEmptyException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		long contact = user.getContact();
		String email = user.getEmail();
		String loginName = user.getLoginName();
		String password = user.getPassword();
		
		RegisterUtil.checkForNullOrEmptyFields(user);
		
		RegisterUtil.checkOnlyContainsAlpha(firstName);
		RegisterUtil.checkOnlyContainsAlpha(lastName);
		
		RegisterUtil.checkContactContainsExactlyTenDigits(contact);
		
		RegisterUtil.checkOnlyContainsAlpha(loginName);
		checkIfLoginNameIsAvailable(loginName);
		
		RegisterUtil.checkEmailFormat(email);
		
		
		PasswordUtil.checkPasswordMeetsCriterion(password);
		
		return userDAO.insert(user);
	}

	private void checkIfLoginNameIsAvailable(String loginName) throws AlreadyExistsException {
		for(User user : userDAO.list()) {
			if(user.getLoginName().equals(loginName)) {
				throw new AlreadyExistsException("The login name "+loginName+" already exists.");
			}
		}
		
	}

	public User authenticateUser(String loginName, String password) throws UserAuthenticationException {
		checkIfloginNameExists(loginName);
		
		for(User user : userDAO.list()) {
			if(user.getLoginName().equals(loginName) && user.getPassword().equals(password)) {
				return user;
			}
		}
		
		throw new UserAuthenticationException("Login name or password is incorrect");
	}

	private void checkIfloginNameExists(String loginName) throws UserAuthenticationException {
		for(User user : userDAO.list()) {
			if(user.getLoginName().equals(loginName)) {
				return; 
			}
		}
		throw new UserAuthenticationException("Login name does not exist");
	}


	public List<User> listUsers() {
		return userDAO.list();
	}

	public boolean removeUser(User user) throws DoesNotExistException  {
		
		for(User elem : userDAO.list()) {
			if(elem.getId() == user.getId()) {
				return userDAO.delete(user.getId());
			}
		}
		throw new DoesNotExistException("The ID "+user.getId()+" does not exist.");
	}
		
	

	public boolean updateUser(User user) throws DoesNotExistException {
		for(User elem : userDAO.list()) {
			if(elem.getId() == user.getId()) {
				return userDAO.update(user);
			}
		}
		throw new DoesNotExistException("The user with ID "+user.getId()+" does not exist.");
	}

	public User findUserByProperty(String property, Object value) throws DoesNotExistException {
		property = property.toLowerCase();
		if(property.equals("id") || property.equals("batchid") || property.equals("firstname") || property.equals("lastname") || property.equals("email") ||property.equals("contact") || property.equals("loginname")) {
			return userDAO.findByProperty(property, value);
		}
		throw new DoesNotExistException("The property "+property+" does not exist.");
	}

}
