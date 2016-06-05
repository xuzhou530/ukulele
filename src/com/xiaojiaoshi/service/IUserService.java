package com.xiaojiaoshi.service;

import com.xiaojiaoshi.model.User;

public interface IUserService
{
	
	public User login(String username, String password);
	public void addUser(User u);
	public User all();
	public void update(User u);
	
}
