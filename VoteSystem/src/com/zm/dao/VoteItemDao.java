package com.zm.dao;

import java.util.List;

import com.zm.entity.VoteItem;

public interface VoteItemDao {
	public List findAllItemByVoteId(int id);
	public void deleteItemById(int id);
	public VoteItem findItemById(int id);
	public void updateItem(VoteItem voteItem);
	public void add(VoteItem v);

}
