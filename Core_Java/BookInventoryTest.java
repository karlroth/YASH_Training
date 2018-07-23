package bookregistery;

import org.mockito.Mockito.*;


import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import dao.BookInventoryDAO;
import model.Book;

public class BookInventoryTest {

	@Test
	public void testRegisterCopy_GoodCopyGiven_ShouldNotReturnAnything() {
		Book book = new Book();
		book.setTitle("Intro to Data Science");
		book.setId(100);
	
		BookInventoryDAO mockedDAO = Mockito.mock(BookInventoryDAO.class);
		
		List<Book> bookList = Arrays.asList(new Book("Harry Potter", 101), new Book("Lord of the Rings",102));
		Mockito.when(mockedDAO.readRegistry()).thenReturn(bookList);
	
		BookInventoryService inventory = new BookInventoryServiceImpl(mockedDAO);
		
		inventory.registerCopy(book);	
	}
	
	@Test
	public void testRegisterCopy_SameTitleGiven_ShouldNotReturnAnything() {
		Book book = new Book();
		book.setTitle("Harry Potter");
		book.setId(100);
		
		BookInventoryDAO mockedDAO = Mockito.mock(BookInventoryDAO.class);
		
		List<Book> bookList = Arrays.asList(new Book("Harry Potter", 101), new Book("Lord of the Rings",102));
		Mockito.when(mockedDAO.readRegistry()).thenReturn(bookList);
	
		BookInventoryService inventory = new BookInventoryServiceImpl(mockedDAO);
		
		inventory.registerCopy(book);	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRegisterCopy_NullTitleGiven_ShouldReturnException() {
		Book book = new Book();
		book.setId(100);

		BookInventoryDAO mockedDAO = Mockito.mock(BookInventoryDAO.class);
		
		List<Book> bookList = Arrays.asList(new Book("Harry Potter", 101), new Book("Lord of the Rings",102));
		Mockito.when(mockedDAO.readRegistry()).thenReturn(bookList);
	
		BookInventoryService inventory = new BookInventoryServiceImpl(mockedDAO);
		
		inventory.registerCopy(book);	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRegisterCopy_EmptyTitleGiven_ShouldReturnException() {
		Book book = new Book();
		book.setTitle("");
		book.setId(100);

		BookInventoryDAO mockedDAO = Mockito.mock(BookInventoryDAO.class);
		
		List<Book> bookList = Arrays.asList(new Book("Harry Potter", 101), new Book("Lord of the Rings",102));
		Mockito.when(mockedDAO.readRegistry()).thenReturn(bookList);
	
		BookInventoryService inventory = new BookInventoryServiceImpl(mockedDAO);
		
		inventory.registerCopy(book);	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRegisterCopy_SameCopyGiven_ShouldReturnException() {
		Book book = new Book();
		book.setTitle("Harry Potter");
		book.setId(101);

		BookInventoryDAO mockedDAO = Mockito.mock(BookInventoryDAO.class);
		
		List<Book> bookList = Arrays.asList(new Book("Harry Potter", 101), new Book("Lord of the Rings",102));
		Mockito.when(mockedDAO.readRegistry()).thenReturn(bookList);
	
		BookInventoryService inventory = new BookInventoryServiceImpl(mockedDAO);
		
		inventory.registerCopy(book);	
	}
	
}