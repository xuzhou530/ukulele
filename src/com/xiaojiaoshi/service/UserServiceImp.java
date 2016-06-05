package com.xiaojiaoshi.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiaojiaoshi.dao.IUserDao;
import com.xiaojiaoshi.exception.XiaoJiaoShiException;
import com.xiaojiaoshi.model.User;

@Service("userService")
public class UserServiceImp implements IUserService
{
	private IUserDao userDao; 

	@Override
	public User login(String username, String password)
	{
		Object args[] = new Object[]{username,password};
		
		
		String Hql = "from User u where u.username=? and u.password =?";
		User  u = (User)userDao.object(Hql, args);
		
		return u;
	}

	@Override
	public void addUser(User u)  
	{
		String Hql = "select count(*) from User";
		long count = (Long)userDao.object(Hql);
	
		if(count==1) throw new XiaoJiaoShiException("小站后台管理员唯一，您已完成注册，请直接前往登陆登录<a href='"+"/HouTai/userLoginInput"+"'>登陆<a>");
		userDao.add(u);
	}
	
	public void update(User u){
		userDao.update(u);
		
	}

	public IUserDao getUserDao()
	{
		return userDao;
	}

	@Resource
	public void setUserDao(IUserDao userDao)
	{
		this.userDao = userDao;
	}

	@Override
	public User all()
	{
		String Hql = " from User u";
		User u = (User)userDao.object(Hql);
		if(u==null) throw new XiaoJiaoShiException("用户名不存在");
		return u;
	}

	
	
	
}
