import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.yash.ota.dao.UserDAO;
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
import com.yash.ota.serviceimpl.UserServiceImpl;

public class UserServiceImplTest {

	private UserService userService;
	private UserDAO mockedDAO;
	private User user;
	
	@Before
	public void SetUp() {
		mockedDAO = mock(UserDAO.class);
		userService = new UserServiceImpl(mockedDAO);
		user = new User();
		
		user.setFirstName("Karl");
		user.setLastName("Roth");
		user.setContact(8152365555L);
		user.setEmail("karoth@gmail.com");
		user.setLoginName("karoth");
		user.setPassword("GoodP@ss");
	}
	

	@Test(expected = FieldEmptyException.class)
	public void testRegisterUser_NoFirstNameGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		user.setFirstName("");
		userService.registerUser(user);
	}
	
	@Test(expected = FieldEmptyException.class)
	public void testRegisterUser_NoLastNameGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		user.setLastName("");
		userService.registerUser(user);
	}
	
	@Test(expected = FieldEmptyException.class)
	public void testRegisterUser_NoContactGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		user.setContact(0);
		userService.registerUser(user);
	}
	
	@Test(expected = FieldEmptyException.class)
	public void testRegisterUser_NoEmailGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		user.setEmail("");
		userService.registerUser(user);
	}
	
	@Test(expected = FieldEmptyException.class)
	public void testRegisterUser_NoLoginNameGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		user.setLoginName("");
		userService.registerUser(user);
	}
	
	@Test(expected = FieldEmptyException.class)
	public void testRegisterUser_NoPasswordGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		user.setPassword("");
		userService.registerUser(user);
	}
	
	@Test(expected = FieldEmptyException.class)
	public void testRegisterUser_NullFirstNameGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		user.setFirstName(null);
		userService.registerUser(user);
	}
	
	@Test(expected = FieldEmptyException.class)
	public void testRegisterUser_NullLastNameGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		user.setLastName(null);
		userService.registerUser(user);
	}
	
	@Test(expected = FieldEmptyException.class)
	public void testRegisterUser_NullEmailGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		user.setEmail(null);
		userService.registerUser(user);
	}
	
	@Test(expected = FieldEmptyException.class)
	public void testRegisterUser_NullLoginNameGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		user.setLoginName(null);
		userService.registerUser(user);
	}
	
	@Test(expected = FieldEmptyException.class)
	public void testRegisterUser_NullPasswordGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		user.setPassword(null);
		userService.registerUser(user);
	}

	@Test(expected = NonAlphabeticNameException.class)
	public void testRegisterUser_NonAlphabeticFirstNameGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		user.setFirstName("K@rl2");
		userService.registerUser(user);
	}
	
	@Test(expected = NonAlphabeticNameException.class)
	public void testRegisterUser_NonAlphabeticLastNameGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		user.setLastName("R0th#");
		userService.registerUser(user);
	}
	
	@Test(expected = Exception.class)
	public void testRegisterUser_LessThanTenDigitContactGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException, InvalidContactException {
		user.setContact(123456789);
		userService.registerUser(user);
	}
	
	@Test(expected = NonAlphabeticNameException.class)
	public void testRegisterUser_NonAlphabeticLoginNameGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		user.setLoginName("k@roth4");
		userService.registerUser(user);
	}
	
	@Test(expected = AlreadyExistsException.class)
	public void testRegisterUser_ReservedLoginNameGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		User mockedUser = new User();
		mockedUser.setLoginName("karoth");

		Mockito.when(mockedDAO.list()).thenReturn(Arrays.asList(mockedUser));

		userService.registerUser(user);
	}
	
	@Test(expected = InvalidPasswordException.class)
	public void testRegisterUser_LessThanEightCharacterPasswordGiven_ShouldReturnException() throws InvalidPasswordException, FieldEmptyException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		user.setPassword("1234567");
		userService.registerUser(user);
	}
	
	@Test(expected = InvalidPasswordException.class)
	public void testRegisterUser_GreaterThanFifteenCharacterPasswordGiven_ShouldReturnException() throws InvalidPasswordException, FieldEmptyException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException{
		user.setPassword("abcdefghijklmnop");
		userService.registerUser(user);
	}
	
	@Test(expected = InvalidPasswordException.class)
	public void testRegisterUser_AllLowerCasePasswordGiven_ShouldReturnException() throws InvalidPasswordException, FieldEmptyException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		user.setPassword("password");
		userService.registerUser(user);
	}
	
	@Test(expected = InvalidPasswordException.class)
	public void testRegisterUser_PasswordWithoutASpecialCharacterGiven_ShouldReturnException() throws InvalidPasswordException, FieldEmptyException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		user.setPassword("BoringPass");
		userService.registerUser(user);
	}
	
	@Test(expected = InvalidPasswordException.class)
	public void testRegisterUser_PasswordContainingWhiteSpaceGiven_ShouldReturnException() throws InvalidPasswordException, FieldEmptyException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		user.setPassword("White Sp@ce");
		userService.registerUser(user);
	}
	
	@Test(expected = InvalidEmailException.class)
	public void testRegisterUser_EmailWithoutComercialAtGiven_ShouldReturnException() throws InvalidPasswordException, FieldEmptyException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		user.setEmail("karl.roth.com");
		userService.registerUser(user);
	}
	
	@Test(expected = InvalidEmailException.class)
	public void testRegisterUser_EmailWithoutDotDomainGiven_ShouldReturnException() throws InvalidPasswordException, FieldEmptyException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		user.setEmail("karl.roth@yash");
		userService.registerUser(user);
	}
	
	@Test(expected = InvalidEmailException.class)
	public void testRegisterUser_EmailWithoutComercialAtOrDotDomainGiven_ShouldReturnException() throws InvalidPasswordException, FieldEmptyException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		user.setEmail("karl.roth");
		userService.registerUser(user);
	}
	
	@Test
	public void testRegisterUser_AllValidInputGiven_ShouldReturnTrue() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, AlreadyExistsException, InvalidEmailException, InvalidContactException {
		Mockito.when(mockedDAO.insert(user)).thenReturn(true);
		assertEquals(true,userService.registerUser(user));
	}
	
	@Test(expected = UserAuthenticationException.class) 
	public void testAuthenticate_NonExistantLoginNameGiven_ShouldReturnException() throws UserAuthenticationException {
		User mockedUser = new User();
		mockedUser.setLoginName("abcd");
		Mockito.when(mockedDAO.list()).thenReturn(Arrays.asList(mockedUser));
		
		userService.authenticateUser("karoth","GoodP@ss");
	}
	
	@Test(expected = UserAuthenticationException.class) 
	public void testAuthenticate_IncorrectLoginNameGiven_ShouldReturnException() throws UserAuthenticationException {
		User mockedUser = new User();
		mockedUser.setLoginName("wrongLogin");
		mockedUser.setPassword("GoodP@ss");
		Mockito.when(mockedDAO.list()).thenReturn(Arrays.asList(mockedUser));
		
		userService.authenticateUser("karoth","WrongP@ss");
	}
	
	@Test(expected = UserAuthenticationException.class) 
	public void testAuthenticate_IncorrectPasswordGiven_ShouldReturnException() throws UserAuthenticationException {
		User mockedUser = new User();
		mockedUser.setLoginName("karoth");
		mockedUser.setPassword("GoodP@ss");
		Mockito.when(mockedDAO.list()).thenReturn(Arrays.asList(mockedUser));
		
		userService.authenticateUser("karoth","WrongP@ss");
	}
		
	@Test 
	public void testAuthenticate_CorrectLoginNameAndPasswordGiven_ShouldReturnUser() throws UserAuthenticationException {
		Mockito.when(mockedDAO.list()).thenReturn(Arrays.asList(user));
		assertEquals(user,userService.authenticateUser("karoth","GoodP@ss"));
	}
	
	@Test 
	public void testListUsers_NoInputGiven_ShouldReturnUserList() throws UserAuthenticationException {
		Mockito.when(mockedDAO.list()).thenReturn(Arrays.asList(user));
		assertEquals(Arrays.asList(user),userService.listUsers());
	}
	
	@Test (expected = DoesNotExistException.class)
	public void testDeleteUser_NonExistentUserGiven_ShouldReturnException()  throws DoesNotExistException {
		User mockedUser = new User();
		mockedUser.setId(101);
		Mockito.when(mockedDAO.list()).thenReturn(Arrays.asList(mockedUser));
		
		user.setId(100);
		userService.removeUser(user);
	}
	
	@Test 
	public void testDeleteUser_ExistentUserGiven_ShouldReturnTrue() throws DoesNotExistException {
		Mockito.when(mockedDAO.list()).thenReturn(Arrays.asList(user));
		Mockito.when(mockedDAO.delete(100)).thenReturn(true);
		
		user.setId(100);
		assertEquals(true,userService.removeUser(user));
	}
	
	@Test (expected = DoesNotExistException.class) 
	public void testUpdateUser_NonExistentUserGiven_ShouldReturnException() throws DoesNotExistException {
		User mockedUser = new User();
		mockedUser.setId(101);
		
		Mockito.when(mockedDAO.list()).thenReturn(Arrays.asList(mockedUser));
		userService.updateUser(user);
	}
	
	@Test 
	public void testUpdateUser_ExistentUserGiven_ShouldReturnUser() throws DoesNotExistException  {
		Mockito.when(mockedDAO.list()).thenReturn(Arrays.asList(user));
		Mockito.when(mockedDAO.update(user)).thenReturn(true);
		
		user.setId(100);
		assertEquals(true,userService.updateUser(user));
	}
	
	@Test (expected = DoesNotExistException.class)
	public void testFindUserByProperty_NonExistentPropertyGiven_ShouldReturnException() throws DoesNotExistException {
		user.setId(100);
		userService.findUserByProperty("blah",100);
	}
	
	@Test
	public void testFindUserByProperty_ExistentPropertyGiven_ShouldReturnTrue() throws DoesNotExistException {
		user.setId(100);
		Mockito.when(mockedDAO.findByProperty("id",100)).thenReturn(user);
		assertEquals(user,userService.findUserByProperty("id",100));
	}
	
}
