package com.zm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zm.dao.VoteDao;
import com.zm.entity.Vote;

public class VoteDaoImpl extends HibernateDaoSupport implements VoteDao {
    private SessionFactory sessionFactory;
    private String sqlString="from Vote v";
    private String sqlString1="from Vote where id=?";
    private List list=null;
	@Override
	public List findAllVote() {
		// TODO Auto-generated method stub
		
		
			if(getHibernateTemplate().find(sqlString)==null)
			{ 
				list=null;
			}
			else{
				
				list=getHibernateTemplate().find(sqlString);
			}
			
		 return list;
	}
	
	@Override
	public Vote findVoteById(int id) {
		// TODO Auto-generated method stub
		Vote vote=new Vote();
		vote=(Vote)getHibernateTemplate().find(sqlString1, id).get(0);
		return vote;
	}

	@Override
	public void deleteVoteById(int id) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().delete(findVoteById(id));
	}


	@Override
	public void updateVote(Vote vote) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(vote);
	}
  public void add(Vote vote){
	  getHibernateTemplate().save(vote);
  }
}
