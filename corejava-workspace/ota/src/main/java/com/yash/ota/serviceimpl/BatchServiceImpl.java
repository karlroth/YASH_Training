package com.yash.ota.serviceimpl;

import java.util.List;

import com.yash.ota.dao.BatchDAO;
import com.yash.ota.daoimpl.BatchDAOImpl;
import com.yash.ota.exception.AlreadyExistsException;
import com.yash.ota.exception.DoesNotExistException;
import com.yash.ota.model.Batch;
import com.yash.ota.service.BatchService;

public class BatchServiceImpl implements BatchService {

	BatchDAO batchDAO;
	
	public BatchServiceImpl() {
		batchDAO = new BatchDAOImpl();
	}
	
	public BatchServiceImpl(BatchDAO batchDAO) {
		this.batchDAO = batchDAO;
	}
	
	public boolean addBatch(Batch batch) throws AlreadyExistsException {
		List<Batch> batchList = batchDAO.list();
		
		for(Batch elem : batchList) {
			if(elem.getTitle().equals(batch.getTitle())) {
				throw new AlreadyExistsException("Batch title "+batch.getTitle()+" already exists.");
			}
		}
		return batchDAO.insert(batch);
	}

	public boolean updateBatch(Batch batch) throws DoesNotExistException {
		List<Batch> batchList = batchDAO.list();
		
		for(Batch elem : batchList) {
			if(elem.getId() == batch.getId()) {
				return batchDAO.update(batch);
			}
		}
		throw new DoesNotExistException("The provided batch "+batch.getTitle()+" does not exist");
	}

	public boolean delete(int id) throws DoesNotExistException {
		List<Batch> batchList = batchDAO.list();
		
		for(Batch elem : batchList) {
			if(elem.getId() == id) {
				return batchDAO.delete(id);
			}
		}
		throw new DoesNotExistException("The ID "+id+" does not exist.");
	}

	public List<Batch> listBatch() {
		return batchDAO.list();
	}

}
