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
		
		String title = book.getTitle();

		checkTitle(title); 
		
		List<Book> registry = bookDAO.readRegistry();
		bookAlreadyinRegistry(book, registry);
		
		bookDAO.insert(book);
		
		System.out.println("\""+title+"\" successfully added to the registry!");
		
		
	}

	private void bookAlreadyinRegistry(Book book, List<Book> registry) {
		for(Book entry : registry ) {
			String title = book.getTitle();
			int id = book.getId();
			if(entry.getTitle().equals(title) && entry.getId() == id ) {
				throw new IllegalArgumentException("This book is already in the registry");
			} else if(entry.getId() == id) {
				throw new IllegalArgumentException("This id is already in use");
			}
		}
	}

	private void checkTitle(String title) {
		if(title == null || title.equals("")) {
			throw new IllegalArgumentException("Title information must be given");
		}
	}
	
}
