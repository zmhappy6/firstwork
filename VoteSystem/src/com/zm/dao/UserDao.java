package com.zm.dao;



import com.zm.entity.User;

public interface UserDao{
   public User findUserByName(String name);
   
}
