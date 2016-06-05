package com.xiaojiaoshi.test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.swing.plaf.InputMapUIResource;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaojiaoshi.dao.ICartDao;
import com.xiaojiaoshi.dao.IMusicDao;
import com.xiaojiaoshi.dao.IUserDao;
import com.xiaojiaoshi.dao.IVedioDao;
import com.xiaojiaoshi.dao.MusicDao;
import com.xiaojiaoshi.exception.XiaoJiaoShiException;
import com.xiaojiaoshi.model.Music;
import com.xiaojiaoshi.model.Pager;
import com.xiaojiaoshi.model.User;
import com.xiaojiaoshi.model.Vedio;
import com.xiaojiaoshi.service.ICartService;
import com.xiaojiaoshi.service.IMusicService;
import com.xiaojiaoshi.service.IUserService;
import com.xiaojiaoshi.util.ThreadLocalUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestBaseDao
{
	/*private IUserDao userDao;
	private IUserService userService;
	private IMusicService musicService;*/
	//@Resource
	//private ICartDao cartDao;
	@Resource
	private IMusicDao musicDao;
	@Resource
	private IVedioDao vedioDao;
	
	@Test
	public void testadd() throws XiaoJiaoShiException{
		
		/*ThreadLocalUtil.setPagerSize(15);
		ThreadLocalUtil.setPageroffset(0);
		System.out.println(cartDao.cartPager());*/
		/*System.out.println(".j|pg".split("\\|").length);*/
		/*System.out.println();
		Object objec1 = 1;
		//System.out.println(musicDao.load(26).getId());
		System.out.println(musicService.loadMusic(26).getId());*/
	/*	String Hql = "from User u where u.username = ?";
		String object = "12";
		System.out.println(userDao.lists(Hql, object));
		ThreadLocalUtil.setPageroffset(0);
		ThreadLocalUtil.setPagerSize(3);
		System.out.println(userDao.pager(Hql, object));
		String Hql1 = "delete User u where u.id =?";
		int id = 3;
		userDao.executeUpdate(Hql1, id);*/
		try
		{
			int i =1;
			if( i ==1)
			throw new XiaoJiaoShiException("123123");
			System.out.println("qwe");
			System.out.println("qwe");
			System.out.println("qwe");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
				
	}
	
/*	@Test
	public void testBeanUtils()
	{
		
		User user = new User();
		user.setId(123);
		user.setNickname("123");
		User user2 = new User();
		user2.setId(1234);
		user2.setNickname("123");
		try
		{
			BeanUtils.copyProperties(user, user2);
			System.out.println(user);
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		} catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
		
		
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

	public IUserService getUserService()
	{
		return userService;
	}

	@Resource
	public void setUserService(IUserService userService)
	{
		this.userService = userService;
	}

	public IMusicService getMusicService()
	{
		return musicService;
	}

	@Resource
	public void setMusicService(IMusicService musicService)
	{
		this.musicService = musicService;
	}*/
	
	@Test
	public void testmusicShow(){
		
		//musicDao.musicPager(25); 
		ArrayList<Music> musics= new ArrayList<Music>();
		
		
	}
	
	@Test
	public void testvedioShow(){
		
		//musicDao.musicPager(25); 
		
		Pager<Vedio> vedio= vedioDao.vedioPager(20);
		System.out.println(vedio);
		
	}
	
	

}
