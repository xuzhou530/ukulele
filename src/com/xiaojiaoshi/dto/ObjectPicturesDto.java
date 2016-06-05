package com.xiaojiaoshi.dto;


import java.util.List;

public class ObjectPicturesDto<E>
{
	
	private E obj;
	private List<String> picsrc;
	public E getObj()
	{
		return obj;
	}
	public void setObj(E obj)
	{
		this.obj = obj;
	}
	public List<String> getPicsrc()
	{
		return picsrc;
	}
	public void setPicsrc(List<String> picsrc)
	{
		this.picsrc = picsrc;
	}
	
	

}
