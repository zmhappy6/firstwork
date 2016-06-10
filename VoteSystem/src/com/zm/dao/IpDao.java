package com.zm.dao;

import java.util.List;

import com.zm.entity.TbIp;

public interface IpDao {
	
	public List findIpByAddress(String ip);
	public void addIp(TbIp ip);
   
}
