import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.yash.mockito_stub_demo.daoimplstub.TodoDAOImplStub;
import com.yash.mockito_stub_demo.service.TodoService;
import com.yash.mockito_stub_demo.serviceimpl.TodoServiceImpl;

public class TodoServiceImplTest {

	
	
	@Test
	public void testListTrainingRelatedTodos_UserGiven_ShouldReturnTrainingRelatedTodos() {
		
		TodoService todoService = new TodoServiceImpl(new TodoDAOImplStub());
		List<String> todos = todoService.listTrainingRelatedTodos("Karl");
		
		assertEquals( Arrays.asList("work on training","take training test"), todos );
		
	}

}
