package com.xiaojiaoshi.dao;

import java.util.List;

import com.xiaojiaoshi.model.Pager;

public interface IBaseDao<T>
{
	public void add(T t);
	public void update(T t);
	public void delete(T t);
	public T load(int id);
	
	public List<T> lists(String Hql, Object []args);
	public List<T> lists(String Hql, Object args);
	public List<T> lists(String Hql);
	
	public List<Object> listObject(String Hql, Object []args);
	public List<Object> listObject(String Hql, Object args);
	public List<Object> listObject(String Hql);
	
	public Object object(String Hql, Object []args);
	public Object object(String Hql, Object args);
	public Object object(String Hql);
	
	
	
	public Pager<T> pager(String Hql, Object []args);
	public Pager<T> pager(String Hql, Object args);
	public Pager<T> pager(String Hql );
	
	
	public void executeUpdate(String Hql, Object []args);
	public void executeUpdate(String Hql, Object args);
	public void executeUpdate(String Hql);
	
	
	public Object queryByHql(String hql,Object[] args);
 	public Object queryByHql(String hql,Object arg);
	public Object queryByHql(String hql);
	
}
