package com.yash.pim.daoimpl;


import java.util.ArrayList;
import java.util.List;

import com.yash.pim.dao.ItemDAO;
import com.yash.pim.model.Item;

public class ItemDAOImpl implements ItemDAO {

	List<Item> itemList;
	
	public ItemDAOImpl() {
		this.itemList = new ArrayList<>();
	}
	
	@Override
	public void insert(Item item) {
		itemList.add(item);
		
	}

	@Override
	public void delete(int id) {
		itemList.remove(id);
		
	}

	@Override
	public void delete(Item item) {
		itemList.remove(item);
		
	}

	@Override
	public void update(int id) {
		
		
	}

	@Override
	public List<Item> list() {
		return itemList;
	}

}
