package com.yash.pim.service;

import java.util.List;

import com.yash.pim.model.Item;

public interface ItemService {

	void insertItem(Item item);
	
	void deleteItem(Item item);
	
	void deleteItem(long id);
	
	void updateItem(Item item);
	
	List<Item> listItem();
}
