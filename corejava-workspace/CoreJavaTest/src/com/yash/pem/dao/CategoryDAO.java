package com.yash.pem.dao;

import java.util.List;

import com.yash.pem.model.Category;

/**
 * DAO Interface for the Category class. Includes insert and list capabilities.
 * @author karoth
 *
 */
public interface CategoryDAO {

	/**
	 * Inserts a category into the list.
	 * @param category
	 */
	void insert(Category category);
	
	/**
	 * Returns the categories as an ArrayList.
	 * @return
	 */
	List<Category> list();
	
	/**
	 * Retrieves the category name from the given category id.
	 * @param id of the category
	 * @return the category name
	 */
	String getNameFromId(long id);
}
