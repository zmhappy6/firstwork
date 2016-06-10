package com.zm.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.zm.dao.VoteDao;
import com.zm.dao.VoteItemDao;
import com.zm.entity.Vote;
import com.zm.entity.VoteItem;

public class VoteItemController extends MultiActionController{
   private VoteDao voteDao;
   private VoteItemDao voteItemDao;
	private String freshView;
	private String updateView;
	
	public String getUpdateView() {
		return updateView;
	}
	public void setUpdateView(String updateView) {
		this.updateView = updateView;
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
	public String getFreshView() {
		return freshView;
	}
	public void setFreshView(String freshView) {
		this.freshView = freshView;
	}
	public void delete(HttpServletRequest request,HttpServletResponse response){
		int id=Integer.parseInt(request.getParameter("id"));
		voteItemDao.deleteItemById(id);
		try {
			response.sendRedirect("operate.htm?method=show");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
  public void add(HttpServletRequest request,HttpServletResponse response){
		String title=request.getParameter("add_title");
		int votenum=Integer.parseInt(request.getParameter("add_votenum"));
		int vote_id=Integer.parseInt(request.getParameter("vote_id"));
		VoteItem voteItem=new VoteItem();
		voteItem.setTitle(title);
		voteItem.setVote_id(vote_id);
		voteItem.setVotenum(votenum);
		voteItemDao.add(voteItem);
		/*try {
			response.sendRedirect("operate.htm?method=show");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			response.getWriter().write("true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
  public ModelAndView update(HttpServletRequest request,HttpServletResponse response){
	  int id=Integer.parseInt(request.getParameter("id"));
	  VoteItem voteItem=voteItemDao.findItemById(id);
	  String title=voteItem.getTitle();
	  int vote_id=voteItem.getVote_id();
	  int votenum=voteItem.getVotenum();
	  request.setAttribute("id", id);
	  request.setAttribute("title", title);
	  request.setAttribute("votenum", votenum);
	  request.setAttribute("vote_id", vote_id);
	  return new ModelAndView(getUpdateView());
  }
  public void save(HttpServletRequest request,HttpServletResponse response){
          int vote_id=Integer.parseInt(request.getParameter("vote_id"));
          int id=Integer.parseInt(request.getParameter("id"));
          int votenum=Integer.parseInt(request.getParameter("votenum"));
          
          String title=request.getParameter("title");
        VoteItem voteItem=voteItemDao.findItemById(id);
        voteItem.setTitle(title);
        voteItem.setVotenum(votenum);
        voteItemDao.updateItem(voteItem);
        try {
			response.sendRedirect("operate.htm?method=update&id="+vote_id+"");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
}
  
}
