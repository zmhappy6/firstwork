package com.zm.entity;

import java.io.Serializable;

public class Vote implements Serializable{
	private int id;
	private String name;
	private String title;
	private String votetype;
	private String pictype;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVotetype() {
		return votetype;
	}
	public void setVotetype(String votetype) {
		this.votetype = votetype;
	}
	public String getPictype() {
		return pictype;
	}
	public void setPictype(String pictype) {
		this.pictype = pictype;
	}
	

}
