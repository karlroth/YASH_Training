package com.yash.ota.daoimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.yash.ota.dao.UserDAO;
import com.yash.ota.exception.DoesNotExistException;
import com.yash.ota.model.Batch;
import com.yash.ota.model.User;

public class UserDAOImpl implements UserDAO {

	private List<User> userList;
	private File userFile;

	public UserDAOImpl() {
		userFile = new File("userStorage.txt");
		userList = getUserListFromFile();
	}

	public boolean insert(User user) {
		if (userList.isEmpty()) {
			user.setId(100);
		} else {
			User lastUser = userList.get(userList.size() - 1);
			int nextId = lastUser.getId() + 1;
			user.setId(nextId);
		}
		userList.add(user);
		saveUserListToFile();
		return true;

	}

	public boolean delete(int id) {
		boolean deleted = false;
		User userToBeDeleted = new User();
		for (User user : userList) {
			if (user.getId() == id) {
				userToBeDeleted = user;
				deleted = true;
			}
		}
		userList.remove(userToBeDeleted);

		saveUserListToFile();
		return deleted;
	}

	public boolean update(User user) {
		boolean updated = false;

		for (User elem : userList) {
			if (elem.getId() == user.getId()) {
				elem.setFirstName(user.getFirstName());
				elem.setLastName(user.getLastName());
				elem.setContact(user.getContact());
				elem.setEmail(user.getEmail());
				elem.setLoginName(user.getLoginName());
				elem.setPassword(user.getPassword());
				elem.setBatchId(user.getBatchId());

				updated = true;
			}
		}
		saveUserListToFile();
		return updated;
	}

	public List<User> list() {
		return userList;
	}

	public User findById(int id) {
		for (User user : userList) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User findByProperty(String property, Object value) throws DoesNotExistException {
		for (User elem : userList) {
			if (property.equals("firstname")) {
				String firstName = (String) value;
				if(elem.getFirstName().equals(firstName)) {
					return elem;
				}	
			} else if (property.equals("lastname")) {
				String lastName = (String) value;
				if(elem.getLastName().equals(lastName)) {
					return elem;
				}
			} else if (property.equals("contact")) {
				long contact = Long.parseLong((String)value);
				if(elem.getContact() == contact) {
					return elem;
				}

			} else if (property.equals("email")) {
				String email = (String) value;
				if(elem.getEmail().equals(email)) {
					return elem;
				}

			} else if (property.equals("loginname")) {
				String loginName = (String) value;
				if(elem.getLoginName().equals(loginName)) {
					return elem;
				}

			} else if (property.equals("password")) {
				String password = (String) value;
				if(elem.getPassword().equals(password)) {
					return elem;
				}

			} else if (property.equals("id")) {
				int id = (Integer) value;
				if(elem.getId() == id) {
					return elem;
				}

			} else if (property.equals("batchid")) {
				int batchId = (Integer) value;
				if(elem.getBatchId() == batchId) {
					return elem;
				}
			} 
		
		}
		throw new DoesNotExistException("The value \""+value+"\" does not exist for the property \""+property+"\"");
	}

	private void saveUserListToFile() {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(userFile));
			oos.writeObject(userList);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private List<User> getUserListFromFile() {
		List<User> users = new ArrayList<User>();
		try {
			if (userFile.exists()) {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(userFile));
				users = (List<User>) ois.readObject();
				ois.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return users;
	}

}
