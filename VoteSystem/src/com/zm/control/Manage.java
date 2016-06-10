package com.zm.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.zm.dao.VoteDao;
import com.zm.dao.VoteItemDao;
import com.zm.entity.User;
import com.zm.entity.Vote;
import com.zm.entity.VoteItem;

public class Manage extends MultiActionController {
	private VoteDao voteDao;
	private VoteItemDao voteItemDao;
	private  String freshView;
    private String updateView;
   

	public VoteItemDao getVoteItemDao() {
		return voteItemDao;
	}

	public void setVoteItemDao(VoteItemDao voteItemDao) {
		this.voteItemDao = voteItemDao;
	}

	public String getUpdateView() {
		return updateView;
	}

	

	public void setFreshView(String freshView) {
		this.freshView = freshView;
	}

	public void setUpdateView(String updateView) {
		this.updateView = updateView;
	}

	public String getFreshView() {
		return freshView;
	}

	

	public VoteDao getVoteDao() {
		return voteDao;
	}

	public void setVoteDao(VoteDao voteDao) {
		this.voteDao = voteDao;
	}
	public void delete(HttpServletRequest request,HttpServletResponse response){
		
		int id=Integer.parseInt(request.getParameter("id"));
			voteDao.deleteVoteById(id);
		
				try {
						response.sendRedirect("operate.htm?method=show");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			
		
	    
     }
	
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response){
		System.out.print(".................");
		int id=Integer.parseInt(request.getParameter("id"));
		Vote vote=voteDao.findVoteById(id);
		List<VoteItem>list=voteItemDao.findAllItemByVoteId(id);
		 String name=vote.getName();
		 String title=vote.getTitle();
		 String votetype=vote.getVotetype();
		 String pictype=vote.getPictype();
		 request.setAttribute("id", id);
		 request.setAttribute("name", name);
		 request.setAttribute("title", title);
		 request.setAttribute("votetype", votetype);
		 request.setAttribute("pictype", pictype);
		 request.setAttribute("voteItemList", list);
		 return new ModelAndView(getUpdateView());
		
	}
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response){
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String title=request.getParameter("title");
		String votetype=request.getParameter("votetype");
		String pictype=request.getParameter("pictype");
		Vote vote=voteDao.findVoteById(id);
		vote.setName(name);
		vote.setTitle(title);
		vote.setVotetype(votetype);
		vote.setPictype(pictype);
		voteDao.updateVote(vote);
		List<Vote> list=voteDao.findAllVote();
		return new ModelAndView(getFreshView(),"votes",list);
	}
	public  void add(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("add_name");
		String title=request.getParameter("add_title");
		String votetype=request.getParameter("add_votetype");
		String pictype=request.getParameter("add_pictype");
		Vote vote=new Vote();
		vote.setName(name);
		vote.setTitle(title);
		vote.setPictype(pictype);
		vote.setVotetype(votetype);
		voteDao.add(vote);
		try {
			response.sendRedirect("operate.htm?method=show");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public ModelAndView show(HttpServletRequest request,HttpServletResponse response){
		List<Vote> list=voteDao.findAllVote();
		return new ModelAndView(getFreshView(),"votes",list);
		
	}
	 
         }
