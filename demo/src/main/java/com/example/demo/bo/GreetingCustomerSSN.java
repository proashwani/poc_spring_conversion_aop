package com.example.demo.bo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GreetingCustomerSSN implements Serializable{
	private long id;
	private String content;

	@JsonIgnore
	private CustomerSSN ssn;

	public GreetingCustomerSSN() {
	}

	public GreetingCustomerSSN(long id, String content, CustomerSSN ssn) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public CustomerSSN getSsn() {
		return ssn;
	}

	public void setSsn(CustomerSSN ssn) {
		this.ssn = ssn;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "GreetingCustomerSSN [id=" + id + ", content=" + content + ", ssn=" + ssn + "]";
	}

}
