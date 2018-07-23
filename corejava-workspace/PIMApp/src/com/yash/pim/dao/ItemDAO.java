package com.yash.pim.dao;

import java.util.List;

import com.yash.pim.model.Item;

public interface ItemDAO {
	void insert(Item item);

	void delete(int id);

	void delete(Item item);

	void update(int id);

	List<Item> list();
	
}
