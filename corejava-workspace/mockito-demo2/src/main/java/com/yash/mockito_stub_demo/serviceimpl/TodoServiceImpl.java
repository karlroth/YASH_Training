package com.yash.mockito_stub_demo.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.yash.mockito_stub_demo.dao.TodoDAO;
import com.yash.mockito_stub_demo.service.TodoService;

public class TodoServiceImpl implements TodoService {

	private TodoDAO todoDAO;
	
	public TodoServiceImpl(TodoDAO todoDAO) {
		this.todoDAO = todoDAO;
	}
	
	public List<String> listTrainingRelatedTodos(String user) {
		List<String> filteredList = new ArrayList<String>();
		List<String> todos = todoDAO.listTodos(user);
		
		for(String todo : todos) {
			if(todo.contains("training")) {
				filteredList.add(todo);
			}
		}
		return filteredList;
	}

}
