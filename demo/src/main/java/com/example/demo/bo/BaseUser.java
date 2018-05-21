package com.example.demo.bo;

import java.io.Serializable;

public class BaseUser implements Serializable {

	private String id;

	public BaseUser(String id){
		this.id=id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
