package com.yash.pem.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.yash.pem.dao.CategoryDAO;
import com.yash.pem.model.Category;

/**
 * Implementation of the Category DAO interface.
 * @author karoth
 *
 */
public class CategoryDAOImpl implements CategoryDAO {

	/**
	 * Array List containing categories.
	 */
	List<Category> categoryList;
	
	/**
	 * Constructor that initializes the category list.
	 */
	public CategoryDAOImpl() {
		categoryList = new ArrayList<>();
	}
	
	/**
	 * Overridden insert function.
	 */
	@Override
	public void insert(Category category) {
		categoryList.add(category);
	}
	
	/**
	 * Overridden list function
	 */
	@Override
	public List<Category> list() {
		return categoryList;
	}

	@Override
	public String getNameFromId(long id) {
		for(int i=0; i < categoryList.size(); i++) {
			if(categoryList.get(i).getId() == id) {
				return categoryList.get(i).getName();
			}
		}	
		return null;
	}

}
