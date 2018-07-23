package com.yash.ota.model;

import java.io.Serializable;

public class Batch implements Serializable {

	private int id;
	private String title;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
