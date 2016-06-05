package com.xiaojiaoshi.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * 论坛 帖子
 * @author Administrator
 *
 */
@Entity
@Table(name="t_cart")
public class Cart
{
	
	private int id; 
	
	/**
	 *0  入门教程
	 *1 交流讨论
	 *2 资料库
	 *3 自扒普
	 *4 z转载
	 */
	private int type;
	/**
	 * 0 表示正常 
	 * 1 表示被举报
	 */
	private int danger;
	
	private Date createdate;
	
	private int scanfCount;
	private int topCount;
	private int bottomCount;
	/*
	 * 发表人昵称
	 */
	private String username;
	/**
	 * 发表人上传个人头像
	 */
	private String selfpic;
	
	/**
	 * 发帖标题
	 */
	private String title;
	/**
	 * 内容部分
	 */
	private String content;
	
	/*
	 *置顶
	 *0表示不置顶 
	 *1表示加精
	 *
	 */
	private int top; 
	
	private Set<Comment> comments; 
	
	
	
	

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


	public int getType()
	{
		return type;
	}


	public void setType(int type)
	{
		this.type = type;
	}


	public int getDanger()
	{
		return danger;
	}


	public void setDanger(int danger)
	{
		this.danger = danger;
	}


	public Date getCreatedate()
	{
		return createdate;
	}


	public void setCreatedate(Date createdate)
	{
		this.createdate = createdate;
	}


	public int getScanfCount()
	{
		return scanfCount;
	}


	public void setScanfCount(int scanfCount)
	{
		this.scanfCount = scanfCount;
	}

	@Column(name="content",columnDefinition="text")
	public String getContent()
	{
		return content;
	}

	public String getTitle()
	{
		return title;
	}


	public void setTitle(String title)
	{
		this.title = title;
	}


	public void setContent(String content)
	{
		this.content = content;
	}


	public int getTop()
	{
		return top;
	}


	public void setTop(int top)
	{
		this.top = top;
	}


	public String getUsername()
	{
		return username;
	}


	public void setUsername(String username)
	{
		this.username = username;
	}


	public String getSelfpic()
	{
		return selfpic;
	}


	public void setSelfpic(String selfpic)
	{
		this.selfpic = selfpic;
	}

	@OneToMany(cascade = { CascadeType.REMOVE },mappedBy="cart")
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<Comment> getComments()
	{
		return comments;
	}

	
	public void setComments(Set<Comment> comments)
	{
		this.comments = comments;
	}
	

	public int getTopCount()
	{
		return topCount;
	}


	public void setTopCount(int topCount)
	{
		this.topCount = topCount;
	}


	public int getBottomCount()
	{
		return bottomCount;
	}


	public void setBottomCount(int bottomCount)
	{
		this.bottomCount = bottomCount;
	}


	@Override
	public String toString()
	{
		return "Cart [id=" + id + ", type=" + type + ", danger=" + danger
				+ ", createdate=" + createdate + ", scanfCount=" + scanfCount
				+ ", username=" + username + ", selfpic=" + selfpic
				+ ", title=" + title + ", content=" + content + ", top=" + top
				+ ", comments=" + comments + "]";
	}
	
	
	
	
	
	
	
	
	
}
