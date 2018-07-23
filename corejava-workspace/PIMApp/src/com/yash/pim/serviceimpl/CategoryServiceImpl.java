package com.yash.pim.serviceimpl;

import java.util.List;

import com.yash.pim.dao.CategoryDAO;
import com.yash.pim.daoimpl.CategoryDAOImpl;
import com.yash.pim.model.Category;
import com.yash.pim.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	/**
	 * CategoryDAO object to be used to perform CRUD operations
	 */
	private CategoryDAO categoryDAO;
	
	/**
	 * Creator, creates a new DAO for categories
	 */
	public CategoryServiceImpl() {
		categoryDAO = new CategoryDAOImpl();
	}

	/**
	 * Add a category to the DAO
	 */
	@Override
	public void addCategory(Category category) {
		categoryDAO.insert(category);
		
	}
	/**
	 * Delete category from the DAO
	 */
	@Override
	public void deleteCategory(long id) {
		categoryDAO.delete(id);
		
	}

	@Override
	public List<Category> listCategory() {
		return categoryDAO.list();
	}

	@Override
	public void updateCategory(int position, String newName) {
		categoryDAO.update(position, newName);
		
	}



}
