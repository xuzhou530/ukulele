package com.xiaojiaoshi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public class User
{
	
	private int id;
	private String username;
	private String password;
	private String nickname;
	private String picSrc;
	private Date createdate;
	
	@Id
	@GeneratedValue
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getNickname()
	{
		return nickname;
	}
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}
	public String getPicSrc()
	{
		return picSrc;
	}
	public void setPicSrc(String picSrc)
	{
		this.picSrc = picSrc;
	}
	
	
	@Column(name="create_date")	
	public Date getCreatedate()
	{
		return createdate;
	}
	
	public void setCreatedate(Date createdate)
	{
		this.createdate = createdate;
	}
	public User()
	{
	}
	@Override
	public String toString()
	{
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", nickname=" + nickname + ", picSrc=" + picSrc
				+ "]";
	}
	
	
	

	
	
	
	
	
	
}
