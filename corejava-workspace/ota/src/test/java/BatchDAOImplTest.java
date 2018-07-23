import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yash.ota.dao.BatchDAO;
import com.yash.ota.daoimpl.BatchDAOImpl;
import com.yash.ota.model.Batch;

public class BatchDAOImplTest {

	BatchDAO batchDAO;
	Batch batch;
	Batch secondBatch;
	
	@Before
	public void SetUp() {
		batchDAO = new BatchDAOImpl();
		batch = new Batch();
		batch.setTitle("2018");
		secondBatch = new Batch();
	}
	
	@After
	public void CleanUp() {
		File file = new File("batchStorage.txt");
		if(file.exists()) {
			file.delete();
		}
	}
	
	@Test
	public void testList_NoInputGiven_ShouldReturnEmptyList() {
		assertEquals(Arrays.asList(), batchDAO.list());
	}
	
	@Test
	public void testInsert_BatchGiven_ShouldReturnTrue() {
		assertEquals(true,batchDAO.insert(batch));
	}
	
	@Test
	public void testInsert_OneBatchGiven_ShouldReturnListOfSizeOne() {
		batchDAO.insert(batch);
		assertEquals(1,batchDAO.list().size());
	}
	
	public void testInsert_OneBatchGiven_LastBatchShouldHaveIdOneZeroZero() {
		batchDAO.insert(batch);
		assertEquals(100, batchDAO.list().get(0).getId());
	}
	
	public void testInsert_TwoBatchesGiven_ShouldReturnListOfSizeTwo() {
		batchDAO.insert(batch);
		batchDAO.insert(secondBatch);
		assertEquals(2, batchDAO.list().size());
	}
	
	public void testInsert_TwoBatchesGiven_LastBatchShourldHaveIdOneZeroOne() {
		batchDAO.insert(batch);
		batchDAO.insert(secondBatch);
		assertEquals(101, batchDAO.list().get(1).getId());
	}
	
	@Test
	public void testList_NoInputGiven_ShouledReturnBatchList() {
		batchDAO.insert(batch);
		batchDAO.insert(secondBatch);
		assertEquals(101, batchDAO.list().get(1).getId());
	}

	@Test
	public void testDelete_IdGiven_ShouldReturnTrue() {
		batchDAO.insert(batch);
		batchDAO.insert(secondBatch);
		batchDAO.delete(100);
		
		assertEquals(101, batchDAO.list().get(0).getId() );
	}
	
	@Test
	public void testUpdate_BatchGiven_ShouldReturnTrue() {
		batchDAO.insert(batch);
		batchDAO.insert(secondBatch);
		secondBatch.setTitle("2019");
		batchDAO.update(secondBatch);
		assertEquals("2019",  batchDAO.list().get(1).getTitle());
	}
}
