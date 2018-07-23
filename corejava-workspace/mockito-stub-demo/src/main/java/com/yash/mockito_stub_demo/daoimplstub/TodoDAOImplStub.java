package com.yash.mockito_stub_demo.daoimplstub;

import java.util.Arrays;
import java.util.List;

import com.yash.mockito_stub_demo.dao.TodoDAO;

public class TodoDAOImplStub implements TodoDAO {

	public List<String> listTodos(String user) {
		
		return Arrays.asList("work on training","take training test","watch youtube");
	}

}
