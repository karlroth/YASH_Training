package com.yash.pim.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.yash.pim.dao.CategoryDAO;
import com.yash.pim.model.Category;

public class CategoryDAOImpl implements CategoryDAO {

	List<Category> categoryList;
	
	public CategoryDAOImpl() {
		categoryList = new ArrayList<>();
	}

	@Override
	public void insert(Category category) {
		categoryList.add(category);
		
	}

	@Override
	public void update(int position, String newName) {
		
		categoryList.get(position).setName(newName);;
		
		
	}

	@Override
	public void delete(Category category) {
		categoryList.remove(category);
		
	}

	@Override
	public void delete(long id) {
		for(int i=0; i < categoryList.size(); i++) {
			if(categoryList.get(i).getId() == id) {
				categoryList.remove(i);
			}
		}	
	}

	@Override
	public List<Category> list() {
		return categoryList;
	}

}
