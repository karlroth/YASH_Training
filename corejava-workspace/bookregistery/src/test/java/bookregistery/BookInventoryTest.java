package bookregistery;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import dao.BookInventoryDAO;
import model.Book;




public class BookInventoryTest {
	
	private BookInventoryDAO mockedDAO;
	private BookInventoryService inventory;
	
	@Before
	public void setUp() {
		List<Book> bookList = Arrays.asList(new Book("Harry Potter", 101), new Book("Lord of the Rings",102));
		
		mockedDAO = Mockito.mock(BookInventoryDAO.class);
		Mockito.when(mockedDAO.readRegistry()).thenReturn(bookList);
		inventory = new BookInventoryServiceImpl(mockedDAO);
	}
	
	
	@Test
	public void testRegisterCopy_GoodCopyGiven_ShouldNotReturnAnything() {
		Book book = new Book();
		book.setTitle("Intro to Data Science");
		book.setId(100);
	
		inventory.registerCopy(book);	
	}
	
	@Test
	public void testRegisterCopy_SameTitleGiven_ShouldNotReturnAnything() {
		Book book = new Book();
		book.setTitle("Harry Potter");
		book.setId(100);
		
		inventory.registerCopy(book);	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRegisterCopy_NullTitleGiven_ShouldReturnException() {
		Book book = new Book();
		book.setId(100);
		
		inventory.registerCopy(book);	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRegisterCopy_EmptyTitleGiven_ShouldReturnException() {
		Book book = new Book();
		book.setTitle("");
		book.setId(100);
		
		inventory.registerCopy(book);	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRegisterCopy_SameCopyGiven_ShouldReturnException() {
		Book book = new Book();
		book.setTitle("Harry Potter");
		book.setId(101);
		
		inventory.registerCopy(book);	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRegisterCopy_SameIdGiven_ShouldReturnException() {
		Book book = new Book();
		book.setTitle("Intro to Data Science");
		book.setId(101);
		
		inventory.registerCopy(book);	
	}
	
}

