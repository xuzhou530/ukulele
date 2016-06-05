package com.xiaojiaoshi.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="t_vedio")
public class Vedio
{
	private int id;
	private Date createdate;
	private int scanfcount;
	private String vediokey;
	private String vedioPicSrc;
	private String vedioTitle;
	private String vedioCount;
	private String musicName;
	private String musicSrc;
	private int type;
	private User user;
	private Set<Comment> comments;
	private String smallSrc;
	
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
	

	public Date getCreatedate()
	{
		return createdate;
	}
	public void setCreatedate(Date createdate)
	{
		this.createdate = createdate;
	}
	
	public int getScanfcount()
	{
		return scanfcount;
	}
	public void setScanfcount(int scanfcount)
	{
		this.scanfcount = scanfcount;
	}
	
	public String getVediokey()
	{
		return vediokey;
	}
	public void setVediokey(String vediokey)
	{
		this.vediokey = vediokey;
	}
	public String getVedioTitle()
	{
		return vedioTitle;
	}
	public void setVedioTitle(String vedioTitle)
	{
		this.vedioTitle = vedioTitle;
	}
	
	@Column(name="vedio_content", columnDefinition="text")
	public String getVedioCount()
	{
		return vedioCount;
	}
	public void setVedioCount(String vedioCount)
	{
		this.vedioCount = vedioCount;
	}
	public String getMusicName()
	{
		return musicName;
	}
	public void setMusicName(String musicName)
	{
		this.musicName = musicName;
	}
	public String getMusicSrc()
	{
		return musicSrc;
	}
	public void setMusicSrc(String musicSrc)
	{
		this.musicSrc = musicSrc;
	}
	
	public int getType()
	{
		return type;
	}
	public void setType(int type)
	{
		if(type==0){
			this.type = 1;
		}else{
			this.type=type;
		}
		
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="u_id")
	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	
	public String getVedioPicSrc()
	{
		return vedioPicSrc;
	}
	public void setVedioPicSrc(String vedioPicSrc)
	{
		this.vedioPicSrc = vedioPicSrc;
	}

	@OneToMany(cascade = { CascadeType.REMOVE },mappedBy="vedio")
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<Comment> getComments()
	{
		return comments;
	}
	public void setComments(Set<Comment> comments)
	{
		this.comments = comments;
	}
	public Vedio()
	{
	}
	@Override
	public String toString()
	{
		return "Vedio [id=" + id + ", createdate=" + createdate
				+ ", scanfcount=" + scanfcount + ", vediokey=" + vediokey
				+ ", vedioTitle=" + vedioTitle + ", vedioCount=" + vedioCount
				+ ", musicName=" + musicName + ", musicSrc=" + musicSrc
				+ ", user=" + user + "]";
	}
	public Vedio(int id, Date createdate, int scanfcount, String vediokey,
			String vedioTitle, String vedioCount, String musicName,
			String musicSrc, User user)
	{
		super();
		this.id = id;
		this.createdate = createdate;
		this.scanfcount = scanfcount;
		this.vediokey = vediokey;
		this.vedioTitle = vedioTitle;
		this.vedioCount = vedioCount;
		this.musicName = musicName;
		this.musicSrc = musicSrc;
		this.user = user;
	}
	public String getSmallSrc()
	{
		return smallSrc;
	}
	public void setSmallSrc(String smallSrc)
	{
		this.smallSrc = smallSrc;
	}
	
}
