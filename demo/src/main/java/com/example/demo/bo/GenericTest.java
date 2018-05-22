package com.example.demo.bo;

import java.math.BigDecimal;

public class GenericTest{

	private BigDecimal salary;

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "TEST [salary=" + salary + "]";
	}

}
