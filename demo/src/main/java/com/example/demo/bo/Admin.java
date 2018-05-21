package com.example.demo.bo;

public class Admin extends BaseUser {

	private String profileType;

	public Admin(String profileType,String id) {
		super(id);
		this.profileType = profileType;
	}
	public String getProfileType() {
		return profileType;
	}
	public void setProfileType(String profileType) {
		this.profileType = profileType;
	}

}
