package dao;

import java.util.List;

import model.Book;

public interface BookInventoryDAO {

	public void registerCopy(Book book);

	public void insert(Book book);
	
	public List<Book> readRegistry();

}
