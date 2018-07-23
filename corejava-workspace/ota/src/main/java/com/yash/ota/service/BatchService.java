package com.yash.ota.service;

import java.util.List;

import com.yash.ota.exception.AlreadyExistsException;
import com.yash.ota.exception.DoesNotExistException;
import com.yash.ota.model.Batch;

public interface BatchService {
	boolean addBatch(Batch batch) throws AlreadyExistsException;
	boolean updateBatch(Batch batch) throws DoesNotExistException;
	boolean delete(int id) throws DoesNotExistException;
	List<Batch> listBatch();

}
