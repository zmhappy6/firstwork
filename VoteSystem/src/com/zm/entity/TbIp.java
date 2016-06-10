package com.zm.entity;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TbIp implements Serializable{
	private int id;
	private String ip;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIp() {
		
			// TODO: handle exception
			try {
				return (InetAddress.getLocalHost().toString());
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error";
			}
		
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	

}
