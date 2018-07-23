package com.yash.ota.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.yash.ota.model.Batch;

public interface BatchDAO {
	
	boolean insert(Batch batch);
	boolean delete(int id);
	boolean update(Batch batch);
	List<Batch> list();

}
