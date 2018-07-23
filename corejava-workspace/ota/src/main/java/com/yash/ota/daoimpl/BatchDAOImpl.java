package com.yash.ota.daoimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yash.ota.dao.BatchDAO;
import com.yash.ota.model.Batch;

public class BatchDAOImpl implements BatchDAO {

	private List<Batch> batchList;
	private File batchFile;


	public BatchDAOImpl() {
		batchFile = new File("batchStorage.txt");
		batchList = getBatchListFromFile();
	}

	public boolean insert(Batch batch) {

		if (batchList.isEmpty()) {
			batch.setId(100);
		} else {
			Batch lastBatch = batchList.get(batchList.size() - 1);
			int nextId = lastBatch.getId()+1;
			batch.setId(nextId);
		}
		batchList.add(batch);
		saveBatchListToFile();
		return true;
	}

	public boolean delete(int id) {
		
		boolean deleted = false;
		Batch batchToBeDeleted = new Batch();
		for(Batch batch : batchList) {
			if(batch.getId() == id) {
				batchToBeDeleted = batch;
				deleted = true;
			}
		}
		batchList.remove(batchToBeDeleted);
		
		saveBatchListToFile();
		return deleted;
	}

	public boolean update(Batch batch) {
		
		boolean updated = false;
		
		for(Batch elem : batchList) {
			if(elem.getId() == batch.getId()) {
				elem.setTitle(batch.getTitle());
				updated = true;
			}
		}
		saveBatchListToFile();
		return updated;
	}

	public List<Batch> list() {
		return batchList;
	}
	
	private void saveBatchListToFile() {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(batchFile));
			oos.writeObject(batchList);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private List<Batch> getBatchListFromFile() {
		List<Batch> batches = new ArrayList<Batch>(); 
		
		try {
			if (batchFile.exists()) {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(batchFile));
				batches = (List<Batch>) ois.readObject();
				ois.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return batches;
	}

}
