package com.xiaojiaoshi.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xiaojiaoshi.exception.XiaoJiaoShiException;
import com.xiaojiaoshi.model.User;
import com.xiaojiaoshi.service.IUserService;
import com.xiaojiaoshi.util.DirUtil;
import com.xiaojiaoshi.util.PropertiesUtil;
import com.xiaojiaoshi.util.StringUtil;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport 
{

	private static String REDIRECT = "redirect";
	private File file;
	private String fileFileName;
	private String fileContentType;
	private IUserService userService;
	private User u;
	
//	用户登录
	public String login(){
		u = userService.login(u.getUsername(), u.getPassword());
		if( u == null ){
			ActionContext.getContext().put("error", "用户名或密码不正确");
			User user = userService.all();
			Properties properties = PropertiesUtil.getImgProperties();
			user.setPicSrc(properties.getProperty("imgsrc")+user.getPicSrc());
			ActionContext.getContext().put("user", user);
			return ERROR;
		}
		Properties properties = PropertiesUtil.getImgProperties();
		u.setPicSrc(properties.getProperty("imgsrc")+u.getPicSrc());
		ActionContext.getContext().getSession().put("u", u);
		ActionContext.getContext().put("url", "userInfo");
		return REDIRECT;
	}

	//	跳转到用户登录页面
	public String userLoginInput(){
		User user = userService.all();
		if(user==null){ throw new XiaoJiaoShiException("请先完成注册");}
		Properties properties = PropertiesUtil.getImgProperties();
		user.setPicSrc(properties.getProperty("imgsrc")+user.getPicSrc());
		ActionContext.getContext().put("user", user);
		return SUCCESS;
	}
	
//	注册用户
	@SuppressWarnings("deprecation")
	public String addUser(){
		DirUtil.createDir();
		try
		{
			FileUtils.copyFile(file, new File(PropertiesUtil.getImgProperties().getProperty("rootPath")+"/user/logo"+ StringUtil.getfiletype(fileFileName) ));
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		u.setPicSrc( "/user/logo"+ StringUtil.getfiletype(fileFileName) );
		u.setCreatedate(new Date());
		userService.addUser(u);
		

		u = userService.all();
		Properties properties = PropertiesUtil.getImgProperties();
		u.setPicSrc(properties.getProperty("imgsrc")+u.getPicSrc());
		ActionContext.getContext().getSession().put("u", u);
		ActionContext.getContext().put("url", "userInfo");
		return REDIRECT;
	}
	
//	用户个人信息页面
	public String userInfo(){
		return SUCCESS;
	}
	
//	用户修改个人信息页面
	public String updateUser(){
		User user = userService.all();
		user.setNickname(u.getNickname());
		user.setPassword(u.getPassword());
		user.setUsername(u.getUsername());
		userService.update(user);
		if(file!=null){
			try
			{
				FileUtils.copyFile(file, new File(PropertiesUtil.getImgProperties().getProperty("rootPath")+"/user/logo"+ StringUtil.getfiletype(fileFileName) ));
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		Properties properties = PropertiesUtil.getImgProperties();
		user.setPicSrc(properties.getProperty("imgsrc")+user.getPicSrc());
		ActionContext.getContext().getSession().put("u", user);
		ActionContext.getContext().put("url", "userInfo");
		return REDIRECT;
	}
	
	
	

	public IUserService getUserService()
	{
		return userService;
	}
	
	@Resource(name="userService")
	public void setUserService(IUserService userService)
	{
		this.userService = userService;
	}

	public User getU()
	{
		return u;
	}

	public void setU(User u)
	{
		this.u = u;
	}

	


	public File getFile()
	{
		return file;
	}

	public void setFile(File file)
	{
		this.file = file;
	}

	public String getFileFileName()
	{
		return fileFileName;
	}

	public void setFileFileName(String fileFileName)
	{
		this.fileFileName = fileFileName;
	}

	public String getFileContentType()
	{
		return fileContentType;
	}

	public void setFileContentType(String fileContentType)
	{
		this.fileContentType = fileContentType;
	}
	
	

}
