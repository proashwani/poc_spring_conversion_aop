package com.example.demo.bo;

import java.io.Serializable;

public class GreetingAnother implements Serializable{
	private long idd;
	private String contentt;

	private Greeting greet;

	public GreetingAnother() {
	}

	public GreetingAnother(long id, String content) {
		this.idd = id;
		this.contentt = content;
	}

	public long getIdd() {
		return idd;
	}

	public String getContentt() {
		return contentt;
	}



	public Greeting getGreet() {
		return greet;
	}

	public void setGreet(Greeting greet) {
		this.greet = greet;
	}

	@Override
	public String toString() {
		return "GreetingAnother [idd=" + idd + ", contentt=" + contentt + ", greet=" + greet + "]";
	}




}
