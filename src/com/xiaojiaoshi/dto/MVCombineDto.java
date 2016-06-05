package com.xiaojiaoshi.dto;

public class MVCombineDto
{
	private int id;
	private int scanfcount;
	private String musicName;
	private String musicSrc;
	private int type;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getScanfcount()
	{
		return scanfcount;
	}
	public void setScanfcount(int scanfcount)
	{
		this.scanfcount = scanfcount;
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
		this.type = type;
	}
	public MVCombineDto(int id, int scanfcount, String musicName,
			String musicSrc, int type)
	{
		super();
		this.id = id;
		this.scanfcount = scanfcount;
		this.musicName = musicName;
		this.musicSrc = musicSrc;
		this.type = type;
	}
	public MVCombineDto()
	{
	}
	@Override
	public String toString()
	{
		return "MVCombineDto [id=" + id + ", scanfcount=" + scanfcount
				+ ", musicName=" + musicName + ", musicSrc=" + musicSrc
				+ ", type=" + type + "]";
	}
	
	

}
