package com.yash.pim.dao;

import java.util.List;
import com.yash.pim.model.Category;

public interface CategoryDAO   {
	
	void insert(Category category);
	
	void update(int position, String newName);
	
	void delete(Category category);
	
	void delete(long id);
	
	
	List<Category> list();
	
	
	

}
