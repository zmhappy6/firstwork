package com.zm.dao;

import java.util.List;

import com.zm.entity.Vote;

public interface VoteDao {
	public List findAllVote();
	public Vote findVoteById(int id);
	public void deleteVoteById(int id);
	public void updateVote(Vote vote);
	public void add(Vote vote);
}
