package com.entity;

import com.util.VeDate;

public class Users {
	private String usersid = "U" + VeDate.getStringId();
	private String username;
	private String password;
	private String realname;
	private String sex;
	private String birthday;
	private String contact;
	private String image;
	private String regdate;
	private String s_school;  //所在学校s_school
    private String b_school;   //报考院校
    private String b_adress;   //报考地区
	public String getB_adress() {
		return b_adress;
	}

	public void setB_adress(String b_adress) {
		this.b_adress = b_adress;
	}

	public String getS_school() {
		return s_school;
	}

	public void setS_school(String s_school) {
		this.s_school = s_school;
	}

	public String getB_school() {
		return b_school;
	}

	public void setB_school(String b_school) {
		this.b_school = b_school;
	}


	public String getUsersid() {
		return usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRegdate() {
		return this.regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
}
