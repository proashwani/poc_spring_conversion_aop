package com.example.demo.bo;

import java.io.Serializable;

public class CustomerSSN implements Serializable {
	private int area;
	private int group;
	private int serial;


	public CustomerSSN(int a, int g, int s) {
		this.area = a;
		this.group = g;
		this.serial = s;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	@Override
	public String toString() {
		return "CustomerSSN [area=" + area + ", group=" + group + ", serial=" + serial + "]";
	}


}
