package com.zm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zm.dao.VoteDao;
import com.zm.dao.VoteItemDao;
import com.zm.entity.Vote;
import com.zm.entity.VoteItem;

public class VoteItemDaoImpl extends HibernateDaoSupport implements VoteItemDao{
   private SessionFactory sessionFactory;
   private String sql_all=" from VoteItem";
   private String sql_all_voteId="from VoteItem where vote_id=?";
   private String sql_single="from VoteItem where id=?";
   
	
	

	
	@Override
	public List findAllItemByVoteId(int id) {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		list=getHibernateTemplate().find(sql_all_voteId,id);
		return list;
	}

	@Override
	public void deleteItemById(int id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(findItemById(id));
		
	}

	@Override
	public VoteItem findItemById(int id) {
		// TODO Auto-generated method stub
		VoteItem voteItem=new VoteItem();
		voteItem=(VoteItem)getHibernateTemplate().find(sql_single, id).get(0);
		return voteItem;
	}

	@Override
	public void updateItem(VoteItem voteItem) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(voteItem);
		
	}

	@Override
	public void add(VoteItem v) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(v);
	}

}
