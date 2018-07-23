package com.yash.pem.serviceimpl;

import java.util.List;

import com.yash.pem.dao.CategoryDAO;
import com.yash.pem.daoimpl.CategoryDAOImpl;
import com.yash.pem.model.Category;
import com.yash.pem.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	/**
	 * Variable that holds a specific categoryDAO
	 */
	private CategoryDAO categoryDAO;
	
	/**
	 * constructor that initializes the categoryDAO
	 */
	public CategoryServiceImpl( ) {
		categoryDAO = new CategoryDAOImpl();
	}
	
	
	@Override
	public void addCategory(Category category) {
		categoryDAO.insert(category);
		
	}

	
	@Override
	public List<Category> listCategory() {
		return categoryDAO.list();
	}

	@Override
	public String getCategoryNameFromId(long id) {
		return categoryDAO.getNameFromId(id);
	}

}
