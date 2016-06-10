package com.zm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zm.dao.IpDao;
import com.zm.entity.TbIp;

public class IpDaoImpl extends HibernateDaoSupport implements IpDao {
 private SessionFactory sessionFactory;
  private String hqlString="from TbIp where ip=?";
	@Override
	public List findIpByAddress(String ip) {
		// TODO Auto-generated method stub
		List<TbIp> list=new ArrayList<TbIp>();
		list=getHibernateTemplate().find(hqlString, ip);
		return list;
	}

	@Override
	public void addIp(TbIp ip) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(ip);
		
	}

}
