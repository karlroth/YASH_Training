package com.yash.pim.service;

import java.util.List; 
import com.yash.pim.model.Category;

public interface CategoryService {

	void addCategory(Category category);

	void deleteCategory(long id);

	void updateCategory(int position, String newName);
	
	List<Category> listCategory();
	
	

	 
	

}
