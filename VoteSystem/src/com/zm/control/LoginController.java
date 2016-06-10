package com.zm.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.zm.dao.UserDao;
import com.zm.dao.VoteDao;
import com.zm.entity.User;
import com.zm.entity.Vote;


public class LoginController extends MultiActionController{
   private UserDao dao;
   private VoteDao voteDao;
   private String successView;
   private String formView;
   private String userView;
   
   public String getUserView() {
	return userView;
}

public void setUserView(String userView) {
	this.userView = userView;
}

public VoteDao getVoteDao() {
	return voteDao;
}

public void setVoteDao(VoteDao voteDao) {
	this.voteDao = voteDao;
}

   
public String getSuccessView() {
	return successView;
}

public void setSuccessView(String successView) {
	this.successView = successView;
}

public String getFormView() {
	return formView;
}

public void setFormView(String formView) {
	this.formView = formView;
}

public UserDao getDao() {
	return dao;
}

public void setDao(UserDao dao) {
	this.dao = dao;
}
   public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
	   List<Vote> list=voteDao.findAllVote();
	   
	   String username=request.getParameter("username");
	   String password=request.getParameter("password");
	   String check=request.getParameter("check");
	   System.out.println(check);
	    User user=this.getDao().findUserByName(username);
	    if (username!=null) {
	   if(user.getUsername()!=null){
		   if(user.getPassword().equals(password)){
			   
			   
			   //登录成功判断是否记住密码，如果记住密码设置
			   if(check!=null){
				   Cookie c1=new Cookie("username",username); 
				   Cookie c2=new Cookie("password",password); 
				   c1.setMaxAge(60*60*60*24);
				   c2.setMaxAge(60*60*60*24);
				   
				   response.addCookie(c1);
				   response.addCookie(c2);
			   }
			   else{
				    Cookie c1=new Cookie("username",username); 
				    Cookie c2=new Cookie("password",password); 
				    
				    c1.setMaxAge(0);
				    c2.setMaxAge(0);
				   
				    response.addCookie(c1);
				    response.addCookie(c2); 
				   }
			   
			   //设置session
			   HttpSession session=request.getSession();
			   session.setAttribute("user", user);
			   
			   if(user.getIsCheck().equals("admin")){
				   
	          return  new ModelAndView(getSuccessView(),"votes", list);}
			   else{
				    
				   return  new ModelAndView(getUserView(),"votes", list);
			   }
		   }else{
			  
			  return new ModelAndView(getFormView(),"message1","密码错误");
		   }
	   }
	   else {
		  
             return new ModelAndView(getFormView(),"message2","用户不存在");
             }
   }
	    else {
			return new  ModelAndView(getFormView(),"message2","");
		}
	    }
   
   }

