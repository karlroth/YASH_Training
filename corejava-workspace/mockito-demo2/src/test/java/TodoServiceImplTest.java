import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.yash.mockito_stub_demo.dao.TodoDAO;
import com.yash.mockito_stub_demo.service.TodoService;
import com.yash.mockito_stub_demo.serviceimpl.TodoServiceImpl;

public class TodoServiceImplTest {

	
	
	@Test
	public void testListTrainingRelatedTodos_UserGiven_ShouldReturnTrainingRelatedTodos() {
		
		TodoDAO mockedTodo = mock(TodoDAO.class);
		
		List<String> list = Arrays.asList("work on training","take training test","meeting");
		when(mockedTodo.listTodos("Karl")).thenReturn(list);
		
		TodoService todoService = new TodoServiceImpl(mockedTodo);
		List<String> todos = todoService.listTrainingRelatedTodos("Karl");
		
		assertEquals( Arrays.asList("work on training","take training test"), todos );
		
	}

}
