package com.yash.mockito_stub_demo.daoimplstubtest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.yash.mockito_stub_demo.dao.TodoDAO;
import com.yash.mockito_stub_demo.daoimplstub.TodoDAOImplStub;

public class TodoDAOImplStubTest {

	@Test
	public void testListTodos_UserGiven_ShouldListTodos() {
		TodoDAO todoDAO = new TodoDAOImplStub();
		List<String> todos = todoDAO.listTodos("Karl");

		assertEquals(3,todos.size());
	}

}
