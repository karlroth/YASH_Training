package com.yash.pim.serviceimpl;

import java.util.List;

import com.yash.pim.dao.ItemDAO;
import com.yash.pim.daoimpl.ItemDAOImpl;
import com.yash.pim.model.Item;
import com.yash.pim.service.ItemService;

public class ItemServiceImpl implements ItemService {

	private ItemDAO itemDAO;

	public ItemServiceImpl() {
		itemDAO = new ItemDAOImpl();
	}
	
	@Override
	public void insertItem(Item item) {
		itemDAO.insert(item);
		
	}

	@Override
	public void deleteItem(Item item) {
		itemDAO.delete(item);
		
	}

	@Override
	public void deleteItem(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Item> listItem() {
		return itemDAO.list();
	}
	
	
	
}
