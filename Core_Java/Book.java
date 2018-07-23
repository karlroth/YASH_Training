package model;

public class Book {

	private String title;
	private int id; 
	
	public Book(String title, int id) {
		this.title = title;
		this.id = id;
	}
	
	public Book() {
		
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public int getId() {
		return this.id;
	}
	
	
}