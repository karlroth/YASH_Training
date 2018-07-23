package com.yash.pem.service;

import java.util.List;

import com.yash.pem.model.Category;

public interface CategoryService {

	/**
	 * Inserts a category into the list.
	 * @param category
	 */
	void addCategory(Category category);
	
	/**
	 * Returns the categories as an ArrayList.
	 * @return
	 */
	List<Category> listCategory();
	
	/**
	 * Retrieves the category name from the given category id.
	 * @param id of the category
	 * @return the category name
	 */
	String getCategoryNameFromId(long id);
}
