import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.yash.ota.dao.BatchDAO;
import com.yash.ota.exception.AlreadyExistsException;
import com.yash.ota.exception.DoesNotExistException;
import com.yash.ota.model.Batch;
import com.yash.ota.service.BatchService;
import com.yash.ota.serviceimpl.BatchServiceImpl;

public class BatchServiceImplTest {

	private BatchDAO mockedDAO;
	private BatchService batchService;
	private Batch testBatch;
	private Batch storedBatch;
	
	@Before
	public void SetUp() {
		mockedDAO = mock(BatchDAO.class);
		batchService = new BatchServiceImpl(mockedDAO);
		testBatch = new Batch();	
		storedBatch = new Batch();
		
		storedBatch.setTitle("2018");
		storedBatch.setId(100);
	}
	
	@Test
	public void testAddBatch_NonExistentBatchGiven_ShouldReturnTrue() throws AlreadyExistsException {
		testBatch.setTitle("2017");
		Mockito.when(mockedDAO.insert(testBatch)).thenReturn(true);
		assertEquals(true,batchService.addBatch(testBatch));
	}
	
	@Test (expected = AlreadyExistsException.class)
	public void testAddBatch_AlreadyExistentBatchGiven_ShouldReturnException()  throws AlreadyExistsException {
		testBatch.setTitle("2018");
		Mockito.when(mockedDAO.list()).thenReturn(Arrays.asList(storedBatch));
		batchService.addBatch(testBatch);
	}
	
	@Test (expected = DoesNotExistException.class)
	public void testDeleteBatch_NonExistentBatchGiven_ShouldReturnException()  throws DoesNotExistException {
		Mockito.when(mockedDAO.list()).thenReturn(Arrays.asList(storedBatch));
		batchService.delete(101);
	}
	
	@Test 
	public void testDeleteBatch_AlreadyExistentBatchGiven_ShouldReturnTrue() throws DoesNotExistException {
		Mockito.when(mockedDAO.list()).thenReturn(Arrays.asList(storedBatch));
		Mockito.when(mockedDAO.delete(100)).thenReturn(true);
		assertEquals(true,batchService.delete(100));
	}
	
	@Test
	public void testListBatch_NoInputGiven_ShouldReturnListOfBatches() {
		Mockito.when(mockedDAO.list()).thenReturn(Arrays.asList(storedBatch));
		assertEquals(Arrays.asList(storedBatch),batchService.listBatch());
	}
	
	@Test (expected = DoesNotExistException.class) 
	public void testUpdateBatch_NonExistantBatchGiven_ShouldReturnException() throws DoesNotExistException {
		testBatch.setId(101);
		testBatch.setTitle("2017");
		
		Mockito.when(mockedDAO.list()).thenReturn(Arrays.asList(storedBatch));
		batchService.updateBatch(testBatch);
	}
	
	@Test
	public void testUpdateBatch_ExistentBatchGiven_ShouldReturnTrue() throws DoesNotExistException {
		testBatch.setId(100);
		testBatch.setTitle("2018");
		
		Mockito.when(mockedDAO.list()).thenReturn(Arrays.asList(storedBatch));
		Mockito.when(mockedDAO.update(testBatch)).thenReturn(true);
		assertEquals(true, batchService.updateBatch(testBatch));
	}
}










