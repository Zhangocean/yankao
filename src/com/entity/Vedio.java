package com.entity;

import com.util.VeDate;

public class Vedio {
	private String vedioid = "V" + VeDate.getStringId();
	private String title;
	private String courseid;
	private String url;
	private String addtime;
	private String hits;
	private String coursename;

	public String getVedioid() {
		return vedioid;
	}

	public void setVedioid(String vedioid) {
		this.vedioid = vedioid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getHits() {
		return this.hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
}
