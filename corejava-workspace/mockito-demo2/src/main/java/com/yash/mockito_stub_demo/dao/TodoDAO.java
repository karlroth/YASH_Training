package com.yash.mockito_stub_demo.dao;

import java.util.List;

public interface TodoDAO {

	List<String> listTodos(String user);
	
}
