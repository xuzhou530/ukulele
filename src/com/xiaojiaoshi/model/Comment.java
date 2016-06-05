package com.xiaojiaoshi.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="t_comment")
public class Comment
{

	private int id;
	private Date createDate;
	
	/*
	 * 置顶次数
	 */
	private int topCount;
	
	/*
	 * bottom 反对次数
	 */
	
	private int bottomCount;
	/*
	 * 发表评论的作者姓名
	 */
	private String name; 
	/**
	 * 用于上传作者的头像
	 */
	private String selfPic;
	private String content;
	private Music music;
	private Vedio vedio;
	private Cart cart;
	private int dangerCount;
	
	
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
	
	@Column(name="creat_date")
	public Date getCreateDate()
	{
		return createDate;
	}
	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}
	public int getTopCount()
	{
		return topCount;
	}
	public void setTopCount(int topCount)
	{
		this.topCount = topCount;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	@Column(name="content",columnDefinition="text")
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	
	public int getBottomCount()
	{
		return bottomCount;
	}
	public void setBottomCount(int bottomCount)
	{
		this.bottomCount = bottomCount;
	}
	public String getSelfPic()
	{
		return selfPic;
	}
	public void setSelfPic(String selfPic)
	{
		this.selfPic = selfPic;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="music_id")
	public Music getMusic()
	{
		return music;
	}
	public void setMusic(Music music)
	{
		this.music = music;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="vedio_id")
	public Vedio getVedio()
	{
		return vedio;
	}
	public void setVedio(Vedio vedio)
	{
		this.vedio = vedio;
	}
	
	public int getDangerCount()
	{
		return dangerCount;
	}
	public void setDangerCount(int dangerCount)
	{
		this.dangerCount = dangerCount;
	}
	public Comment(int id, Date createDate, int topCount, String name,
			String content)
	{
		super();
		this.id = id;
		this.createDate = createDate;
		this.topCount = topCount;
		this.name = name;
		this.content = content;
	}
	
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cart_id")
	public Cart getCart()
	{
		return cart;
	}
	public void setCart(Cart cart)
	{
		this.cart = cart;
	}
	public Comment()
	{
	}
	@Override
	public String toString()
	{
		return "Comment [id=" + id + ", createDate=" + createDate
				+ ", topCount=" + topCount + ", bottomCount=" + bottomCount
				+ ", name=" + name + ", selfPic=" + selfPic + ", content="
				+ content + ", music=" + music + ", vedio=" + vedio + ", cart="
				+ cart + "]";
	}
	
	
	
	
}
