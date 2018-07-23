package user_registry;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.yash.user_registry.dao.UserDAO;
import com.yash.user_registry.daoimpl.UserDAOImpl;
import com.yash.user_registry.model.User;

public class UserDAOImplTest {

	private UserDAO userDAO;
	private User user;
	
	
	@Before
	public void Setup() {
		userDAO = new UserDAOImpl();
		user = new User();
		user.setName("Karl");
		user.setLoginName("karoth");
		user.setPassword("GoodP@ss");
	}
	
	@Test
	public void testGetRegistry_NothingGiven_ShouldReturnEmptyList() {
		assertEquals(Arrays.asList(), userDAO.getUserRegistry());
	}
	
	@Test
	public void testInsert_UserGiven_ShouldReturnListOfUsers() {
		userDAO.insert(user);
		assertEquals(Arrays.asList(user),userDAO.getUserRegistry());	
	}
	
	@Test
	public void testContainsUser_SameUserInsertedAndGiven_ShouldReturnTrue() {
		userDAO.insert(user);
		assertEquals(true,userDAO.containsUser(user.getLoginName()));	
	}
	
	@Test
	public void testContainsUser_DifferentUserGiven_shouldReturnFalse() {
		
		User differentUser = new User();
		differentUser.setName("Shane");
		differentUser.setLoginName("skfielder");
		differentUser.setPassword("GoodP@ss");
		
		userDAO.insert(differentUser);
		assertEquals(false, userDAO.containsUser(user.getLoginName()));
	}
	
	@Test
	public void testUserAuthentication_CorrectPasswordGiven_ShouldReturnTrue() {
		userDAO.insert(user);
		assertEquals(true, userDAO.userAuthentication("karoth", "GoodP@ss"));
	}
	
	@Test 
	public void testUserAuthentication_IncorrectPasswordGiven_ShouldReturnFalse() {
		userDAO.insert(user);
		assertEquals(false, userDAO.userAuthentication("karoth", "WrongP@ss"));
	}
	
	@Test
	public void testGetName_UserAdded_shouldReturnName() {
		userDAO.insert(user);
		assertEquals("Karl", userDAO.getName("karoth"));
	}
	
	
	

}
