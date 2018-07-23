import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yash.ota.dao.UserDAO;
import com.yash.ota.daoimpl.UserDAOImpl;
import com.yash.ota.exception.DoesNotExistException;
import com.yash.ota.model.User;

public class UserDAOImplTest {


	UserDAO userDAO;
	User user;
	User secondUser;
	
	@Before
	public void SetUp() {
		userDAO = new UserDAOImpl();
		
		user = new User();
		user.setBatchId(101);
		user.setFirstName("Karl");
		user.setLastName("Roth");
		user.setContact(123456789);
		user.setEmail("karl.roth@yash.com");
		user.setLoginName("karlroth");
		user.setPassword("GoodP@ss");
		
		secondUser = new User();
		secondUser.setBatchId(101);
		secondUser.setFirstName("Karl");
		secondUser.setLastName("Roth");
		secondUser.setContact(123456789);
		secondUser.setEmail("karl.roth@yash.com");
		secondUser.setLoginName("karlroth");
		secondUser.setPassword("GoodP@ss");
	}
	
	@After
	public void CleanUp() {
		File file = new File("userStorage.txt");
		if(file.exists()) {
			file.delete();
		}
	}
	
	public void testList_NoInputGiven_ShouldReturnEmptyList() {
		assertEquals(Arrays.asList(), userDAO.list());
	}
	
	@Test
	public void testInsert_UserGiven_ShouldReturnTrue() {
		assertEquals(true,userDAO.insert(user));
	}
	
	@Test
	public void testInsert_OneUserGiven_ShouldReturnListOfSizeOne() {
		userDAO.insert(user);
		assertEquals(1,userDAO.list().size());
	}
	
	@Test
	public void testInsert_OneUserGiven_ShouldReturnIdZeroOneOne() {
		userDAO.insert(user);
		assertEquals(100,userDAO.list().get(0).getId());
	}
	
	@Test
	public void testInsert_TwoUserGiven_ShouldReturnListOfSizeTwo() {
		userDAO.insert(user);
		userDAO.insert(secondUser);
		assertEquals(2,userDAO.list().size());
	}
	
	@Test
	public void testInsert_TwoUserGiven_ShouldReturnIdOneZeroOne() {
		userDAO.insert(user);
		userDAO.insert(secondUser);
		assertEquals(2,userDAO.list().size());
	}
	
	@Test
	public void testList_NoInputGiven_ShouledReturnBatchList() {
		userDAO.insert(user);
		userDAO.insert(secondUser);
		assertEquals(101, userDAO.list().get(1).getId());
	}
	
	@Test
	public void testDelete_IdGiven_ShouldReturnTrue() {
		userDAO.insert(user);
		userDAO.insert(secondUser);
		userDAO.delete(100);
		
		assertEquals(101, userDAO.list().get(0).getId() );
	}

	@Test
	public void testUpdate_BatchGiven_ShouldReturnTrue() {
		userDAO.insert(user);
		assertEquals(true, userDAO.update(user));
	}
	
	
	@Test
	public void testUpdate_UpdatedBatchIdGiven_ShouldReturnListWithUpdate() {
		user.setId(100);
		secondUser.setId(100);
		userDAO.insert(user);
		secondUser.setBatchId(201);
		userDAO.update(secondUser);
		assertEquals(201,  userDAO.list().get(0).getBatchId());
	}
	
	@Test
	public void testUpdate_UpdatedFirstNameGiven_ShouldReturnListWithUpdate() {
		user.setId(100);
		secondUser.setId(100);
		userDAO.insert(user);
		secondUser.setFirstName("Kyle");
		userDAO.update(secondUser);
		assertEquals("Kyle",  userDAO.list().get(0).getFirstName());
	}
	
	@Test
	public void testUpdate_UpdatedLastNameGiven_ShouldReturnListWithUpdate() {
		user.setId(100);
		secondUser.setId(100);
		userDAO.insert(user);
		secondUser.setLastName("Lewis");
		userDAO.update(secondUser);
		assertEquals("Lewis",  userDAO.list().get(0).getLastName());
	}
	
	@Test
	public void testUpdate_UpdatedContactGiven_ShouldReturnListWithUpdate() {
		user.setId(100);
		secondUser.setId(100);
		userDAO.insert(user);
		secondUser.setContact(1111111111);
		userDAO.update(secondUser);
		assertEquals(1111111111,  userDAO.list().get(0).getContact());
	}
	
	@Test
	public void testUpdate_UpdatedEmailGiven_ShouldReturnListWithUpdate() {
		user.setId(100);
		secondUser.setId(100);
		userDAO.insert(user);
		secondUser.setEmail("karoth@yash.com");
		userDAO.update(secondUser);
		assertEquals("karoth@yash.com",  userDAO.list().get(0).getEmail());
	}
	
	@Test
	public void testUpdate_UpdatedLoginNameGiven_ShouldReturnListWithUpdate() {
		user.setId(100);
		secondUser.setId(100);
		userDAO.insert(user);
		secondUser.setLoginName("karoth");
		userDAO.update(secondUser);
		assertEquals("karoth",  userDAO.list().get(0).getLoginName());
	}
	
	@Test
	public void testUpdate_UpdatedPasswordGiven_ShouldReturnListWithUpdate() {
		user.setId(100);
		secondUser.setId(100);
		userDAO.insert(user);
		secondUser.setLoginName("NewP@ssword");
		userDAO.update(secondUser);
		assertEquals("NewP@ssword",  userDAO.list().get(0).getLoginName());
	}

	@Test
	public void testFindByProperty_IdGiven_ShouldReturnUser() throws DoesNotExistException {
		user.setId(100);
		userDAO.insert(user);
		assertEquals(100, userDAO.findByProperty("id", 100).getId());
	}
	
	@Test
	public void testFindByProperty_BatchIdGiven_ShouldReturnUser() throws DoesNotExistException {
		userDAO.insert(user);
		assertEquals(101, userDAO.findByProperty("batchid", 101).getBatchId());
	}
	
	@Test
	public void testFindByProperty_FirstNameGiven_ShouldReturnUser() throws DoesNotExistException {
		userDAO.insert(user);
		assertEquals("Karl", userDAO.findByProperty("firstname", "Karl").getFirstName());
	}
	
	@Test
	public void testFindByProperty_LastNameGiven_ShouldReturnUser() throws DoesNotExistException {
		userDAO.insert(user);
		assertEquals("Roth", userDAO.findByProperty("lastname", "Roth").getLastName());
	}
	
	@Test
	public void testFindByProperty_ContactGiven_ShouldReturnUser() throws DoesNotExistException {
		userDAO.insert(user);
		assertEquals(123456789, userDAO.findByProperty("contact", "123456789").getContact());
	}
	
	@Test
	public void testFindByProperty_EmailGiven_ShouldReturnUser() throws DoesNotExistException {
		userDAO.insert(user);
		assertEquals("karl.roth@yash.com", userDAO.findByProperty("email", "karl.roth@yash.com").getEmail());
	}
	
	@Test
	public void testFindByProperty_LoginNameGiven_ShouldReturnUser() throws DoesNotExistException {
		userDAO.insert(user);
		assertEquals("karlroth", userDAO.findByProperty("loginname", "karlroth").getLoginName());
	}
	
	@Test(expected = DoesNotExistException.class)
	public void testFindByProperty_NonExistentValueGiven_ShouldReturnException() throws DoesNotExistException {
		userDAO.insert(user);
		userDAO.findByProperty("name", "Kelsey");
	}
	
	
}
