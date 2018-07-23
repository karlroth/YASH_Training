package bookregistery;

import java.util.List;

import dao.BookInventoryDAO;
import model.Book;

public class BookInventoryServiceImpl implements BookInventoryService {

	private BookInventoryDAO bookDAO;
	
	public BookInventoryServiceImpl(BookInventoryDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	public void registerCopy(Book book) {
		// Should check if book can be registered.
		
		
		
		if(book.getTitle() == null || book.getTitle().equals("")) {
			throw new IllegalArgumentException("Title information must be given");
		} 
		
		List<Book> registry = bookDAO.readRegistry();
		
		for(Book entry : registry ) {
			if(entry.getTitle().equals(book.getTitle()) && entry.getId() == book.getId() ) {
				throw new IllegalArgumentException("This book is already in the registry");
			}
		}
		
		bookDAO.insert(book);
		
		
	}
	
}
