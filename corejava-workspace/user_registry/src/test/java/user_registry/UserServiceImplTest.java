package user_registry;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.yash.user_registration.exceptions.FieldEmptyException;
import com.yash.user_registration.exceptions.InvalidPasswordException;
import com.yash.user_registration.exceptions.NonAlphabeticNameException;
import com.yash.user_registration.exceptions.UserAlreadyExistsException;
import com.yash.user_registration.exceptions.UserAuthenticationException;
import com.yash.user_registry.dao.UserDAO;
import com.yash.user_registry.model.User;
import com.yash.user_registry.service.UserService;
import com.yash.user_registry.serviceimpl.UserServiceImpl;

public class UserServiceImplTest {

	private UserDAO mockedDAO;
	private UserService service;
	private User user;
	
	
	@Before
	public void Setup() {
		
		user = new User();
		mockedDAO = mock(UserDAO.class);
		service = new UserServiceImpl(mockedDAO);
	}
	
	@Test(expected = InvalidPasswordException.class)
	public void testRegisterUser_ShortPasswordGiven_ShouldReturnException() throws InvalidPasswordException, FieldEmptyException, NonAlphabeticNameException, UserAlreadyExistsException{
		user.setName("Karl");
		user.setLoginName("karoth");
		user.setPassword("short");
		
		service.registerUser(user);
	}
	
	@Test(expected = InvalidPasswordException.class)
	public void testRegisterUser_LongPasswordGiven_ShouldReturnException() throws InvalidPasswordException, FieldEmptyException, NonAlphabeticNameException, UserAlreadyExistsException{
		user.setName("Karl");
		user.setLoginName("karoth");
		user.setPassword("longpassworddddd");
		
		
		service.registerUser(user);
	}
	
	@Test(expected = InvalidPasswordException.class)
	public void testRegisterUser_LowerCasePasswordGiven_ShouldReturnException() throws InvalidPasswordException, FieldEmptyException, NonAlphabeticNameException, UserAlreadyExistsException{
		user.setName("Karl");
		user.setLoginName("karoth");
		user.setPassword("password");
		
		service.registerUser(user);
	}
	
	@Test(expected = InvalidPasswordException.class)
	public void testRegisterUser_NoSpecialCharacterPasswordGiven_ShouldReturnException() throws InvalidPasswordException, FieldEmptyException, NonAlphabeticNameException, UserAlreadyExistsException{
		user.setName("Karl");
		user.setLoginName("karoth");
		user.setPassword("BoringPass");
		
		service.registerUser(user);
	}
	
	@Test(expected = InvalidPasswordException.class)
	public void testRegisterUser_WhiteSpacePasswordGiven_ShouldReturnException() throws InvalidPasswordException, FieldEmptyException, NonAlphabeticNameException, UserAlreadyExistsException{
		user.setName("Karl");
		user.setLoginName("karoth");
		user.setPassword("White Sp@ce");
		
		service.registerUser(user);
	}
	
	/* Password Confirmation functionality was delegated to the startup application.
	@Test(expected = InvalidPasswordException.class)
	public void testRegisterUser_DifferentPasswordsGiven_ShouldReturnException() throws InvalidPasswordException, FieldEmptyException, NonAlphabeticNameException, UserAlreadyExistsException{
		service.registerUser("Karl","karoth","GoodP@ss","NoMatch3s");
	}
	*/
	
	@Test(expected = FieldEmptyException.class)
	public void testRegisterUser_NoNameGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, UserAlreadyExistsException {
		user.setName("");
		user.setLoginName("karoth");
		user.setPassword("GoodP@ss");
		
		service.registerUser(user);
	}
	
	
	@Test(expected = FieldEmptyException.class)
	public void testRegisterUser_NoLoginGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, UserAlreadyExistsException {
		user.setName("Karl");
		user.setLoginName("");
		user.setPassword("GoodP@ss");
		
		service.registerUser(user);
	}
	
	@Test(expected = FieldEmptyException.class)
	public void testRegisterUser_NoPasswordGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, UserAlreadyExistsException {
		user.setName("Karl");
		user.setLoginName("karoth");
		user.setPassword("");
		
		service.registerUser(user);
	}
	
	/* Password Confirmation functionality was delegated to the startup application.
	@Test(expected = FieldEmptyException.class)
	public void testRegisterUser_NoConfirmationPasswordGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, UserAlreadyExistsException {
		service.registerUser("Karl","karoth","GoodP@ss","");
	}
	*/
	@Test(expected = FieldEmptyException.class)
	public void testRegisterUser_NullNameGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, UserAlreadyExistsException {
		user.setName(null);
		user.setLoginName("karoth");
		user.setPassword("GoodP@ss");
		
		service.registerUser(user);
	}
	
	@Test(expected = FieldEmptyException.class)
	public void testRegisterUser_NullUserNameGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, UserAlreadyExistsException {
		user.setName("Karl");
		user.setLoginName(null);
		user.setPassword("GoodP@ss");
		
		service.registerUser(user);
	}
	
	@Test(expected = FieldEmptyException.class)
	public void testRegisterUser_NullPasswordGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, UserAlreadyExistsException {
		user.setName("Karl");
		user.setLoginName("karoth");
		user.setPassword(null);
		
		service.registerUser(user);
	}
	
	/* Password Confirmation functionality was delegated to the startup application.
	@Test(expected = FieldEmptyException.class)
	public void testRegisterUser_NullConfirmationPasswordGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, UserAlreadyExistsException {
		service.registerUser("Karl","karoth","GoodP@ss",null);
	}
	*/
	
	@Test(expected = NonAlphabeticNameException.class)
	public void testRegisterUser_NonAlphabeticNameGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, UserAlreadyExistsException {
		user.setName("K@rl2");
		user.setLoginName("karoth");
		user.setPassword("GoodP@ss");
		
		service.registerUser(user);
	}
	
	@Test(expected = NonAlphabeticNameException.class)
	public void testRegisterUser_NonAlphabeticLoginGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, UserAlreadyExistsException {
		user.setName("Karl");
		user.setLoginName("k@roth4");
		user.setPassword("short");
		
		service.registerUser(user);
	}
	

	@Test(expected = UserAlreadyExistsException.class)
	public void testRegisterUser_LoginNameTakenGiven_ShouldReturnException() throws FieldEmptyException, InvalidPasswordException, NonAlphabeticNameException, UserAlreadyExistsException {
		Mockito.when(mockedDAO.containsUser("karoth")).thenReturn(true);

		user.setName("Karl");
		user.setLoginName("karoth");
		user.setPassword("GoodP@ss");
		
		service.registerUser(user);
	}
	
	@Test(expected = UserAuthenticationException.class)
	public void testLogin_IncorrectUserNameGiven_ShouldReturnException() throws UserAuthenticationException {
		Mockito.when(mockedDAO.containsUser("karoth")).thenReturn(false);
		
		service.login("karoth","GoodP@ss");
	}
	
	@Test(expected = UserAuthenticationException.class)
	public void testLogin_IncorrectPasswordGiven_ShouldReturnException() throws UserAuthenticationException {
		Mockito.when(mockedDAO.containsUser("karoth")).thenReturn(true);
		Mockito.when(mockedDAO.userAuthentication("karoth","GoodP@ss")).thenReturn(false);
		service.login("karoth","GoodP@ss");
	}
	
	@Test
	public void testLogin_CorrectUserNameAndPasswordGiven_ShouldReturnNothing() throws UserAuthenticationException {
		Mockito.when(mockedDAO.containsUser("karoth")).thenReturn(true);
		Mockito.when(mockedDAO.userAuthentication("karoth","GoodP@ss")).thenReturn(true);
		Mockito.when(mockedDAO.getName("karoth")).thenReturn("Karl");
		
		service.login("karoth","GoodP@ss");
	}
}
