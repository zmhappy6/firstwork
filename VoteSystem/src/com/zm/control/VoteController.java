package com.zm.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.zm.dao.IpDao;
import com.zm.dao.VoteDao;
import com.zm.dao.VoteItemDao;
import com.zm.entity.TbIp;
import com.zm.entity.TbIp;
import com.zm.entity.Vote;
import com.zm.entity.VoteItem;

public class VoteController extends MultiActionController{
	
	private VoteDao voteDao;
	private VoteItemDao voteItemDao;
	private IpDao ipDao;
	private String userView;
	
	public String getUserView() {
		return userView;
	}
	public void setUserView(String userView) {
		this.userView = userView;
	}
	public IpDao getIpDao() {
		return ipDao;
	}
	public void setIpDao(IpDao ipDao) {
		this.ipDao = ipDao;
	}
	private String toVote;
	
	public String getToVote() {
		return toVote;
	}
	public void setToVote(String toVote) {
		this.toVote = toVote;
	}
	public VoteDao getVoteDao() {
		return voteDao;
	}
	public void setVoteDao(VoteDao voteDao) {
		this.voteDao = voteDao;
	}
	public VoteItemDao getVoteItemDao() {
		return voteItemDao;
	}
	public void setVoteItemDao(VoteItemDao voteItemDao) {
		this.voteItemDao = voteItemDao;
	}
	
   public  ModelAndView toVote(HttpServletRequest request,HttpServletResponse response){
	      Vote vote=new Vote();
	      List<VoteItem>list=new ArrayList<VoteItem>();
	      int id=Integer.parseInt(request.getParameter("id"));
	      vote=voteDao.findVoteById(id);
	      list=voteItemDao.findAllItemByVoteId(id);
	      String title=vote.getTitle();
	      request.setAttribute("title", title);
	      request.setAttribute("voteId", id);
	      request.setAttribute("itemList", list);
	   return new ModelAndView(getToVote());
   }
   public  void count(HttpServletRequest request,HttpServletResponse response){
	   int id=Integer.parseInt(request.getParameter("item"));
	   VoteItem voteItem;
	   TbIp tbIp=new TbIp();
	   String ip=tbIp.getIp();
	   List list=ipDao.findIpByAddress(ip);
	   List<Vote> voteList=voteDao.findAllVote();
	  
	   if (list.size()>0) {
		   try {
			response.getWriter().write("false");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	}else{
		tbIp.setIp(ip);
		ipDao.addIp(tbIp);
		voteItem=voteItemDao.findItemById(id);
		int num=voteItem.getVotenum();
		num=num+1;
		voteItem.setVotenum(num);
		voteItemDao.updateItem(voteItem);
		try {
			response.getWriter().write("true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	}
   }
   public ModelAndView show(HttpServletRequest request,HttpServletResponse response){
	   
	   List<Vote>list=voteDao.findAllVote();
	   request.setAttribute("votes", list);
	   return new ModelAndView(getUserView());
   }
}
