package com.zm.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zm.dao.UserDao;
import com.zm.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
	private SessionFactory sessionFactory;
  private String sql="from User where username=?";
	@Override
	public User findUserByName(String name) {
		// TODO Auto-generated method stub
		User user=new User();
		try{
		user=(User)getHibernateTemplate().find(sql, name).get(0);
		}catch(Exception e){
			
		}
		return user;
		
	}

}
