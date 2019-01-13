package com.entity;

import com.util.VeDate;

public class Files {
	private String filesid = "F" + VeDate.getStringId();
	private String filesname;
	private String courseid;
	private String url;
	private String addtime;
	private String coursename;

	public String getFilesid() {
		return filesid;
	}

	public void setFilesid(String filesid) {
		this.filesid = filesid;
	}

	public String getFilesname() {
		return this.filesname;
	}

	public void setFilesname(String filesname) {
		this.filesname = filesname;
	}

	public String getCourseid() {
		return this.courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
}
