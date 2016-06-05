package com.xiaojiaoshi.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xiaojiaoshi.model.Pager;
import com.xiaojiaoshi.util.ThreadLocalUtil;

@SuppressWarnings("unchecked")
public class BaseDao<T> implements IBaseDao<T> 
{

	private SessionFactory sessionFactory;
	private Class<T> clz;
	
	
	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	public Class<T> getCls()
	{
		if(clz==null) {
			//获取泛型的Class对象
			clz = ((Class<T>)
					(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return clz;
	}

	@Override
	public void add(T t)
	{
		getSession().save(t);
	}

	@Override
	public void update(T t)
	{
		getSession().update(t);
	}

	@Override
	public void delete(T t)
	{
		getSession().delete(t);
	}

	@Override
	public T load(int id)
	{
		return (T)getSession().load(getCls(), id);
	}

	@Override
	public List<T> lists(String Hql, Object[] args)
	{
		return getQuety(Hql, args).list();
	}
	
	@Override
	public List<T> lists(String Hql, Object args)
	{
		return lists(Hql, new Object[]{args});
	}

	@Override
	public List<T> lists(String Hql)
	{
		return lists(Hql,null);
	}

	@Override
	public Pager<T> pager(String Hql, Object[] args)
	{
		int pageSie = ThreadLocalUtil.getPagerSize();
		int pageOffset = ThreadLocalUtil.getPageroffset();
		
		Pager<T> pager = new Pager<T>();
		pager.setPageOffset(pageOffset);
		pager.setPagerSize(pageSie);
		List<T> list = getQuety(Hql, args).setFirstResult(pageOffset).setMaxResults(pageSie).list();
		pager.setObjs(list);
		String  query = getCountHql(Hql);
		long pagerCont = (Long)getQuety(query, args).uniqueResult();
		pager.setPageCount(pagerCont);
		getQuety(Hql, args);
		return pager;
	}

	@Override
	public Pager<T> pager(String Hql, Object args)
	{
		
		return pager(Hql, new Object[]{args});
	}

	@Override
	public Pager<T> pager(String Hql)
	{
	
		return pager(Hql,null);
	}

	@Override
	public void executeUpdate(String Hql, Object[] args)
	{
		getQuety(Hql, args).executeUpdate();
	}

	@Override
	public void executeUpdate(String Hql, Object args)
	{
		executeUpdate(Hql, new Object[]{args});
	}

	@Override
	public void executeUpdate(String Hql)
	{
		executeUpdate(Hql, null);
	}

	
	@Override
	public Object queryByHql(String hql, Object[] args)
	{
		
		return getQuety(hql, args).uniqueResult();
	}

	@Override
	public Object queryByHql(String hql, Object arg)
	{
		
		return queryByHql(hql, new Object[]{arg});
	}

	@Override
	public Object queryByHql(String hql)
	{
		return queryByHql(hql,null);
	}

	
	
	protected Query getQuety(String Hql,Object[] args){
		
		Query query = getSession().createQuery(Hql);
		if(args!=null){
			for(int i = 0 ; i< args.length ; i ++ ){
				query.setParameter(i, args[i]);
			}
		}
		
		return query;
		
	}
	
	protected String getCountHql(String Hql){
		int iFrom = Hql.indexOf("from ");
		String tar = "";
		if( iFrom == 0){
			tar +=" select count(*) " + Hql;
		}else{
			String str = Hql.substring(iFrom);
			tar +=" select count(*) " + str;
		}
		tar.replace("fetch", " ");
		return tar;
	}

	@Override
	public List<Object> listObject(String Hql, Object[] args)
	{
		
		return getQuety(Hql, args).list();
	}

	@Override
	public List<Object> listObject(String Hql, Object args)
	{
		return listObject(Hql, new Object[]{args});
	}

	@Override
	public List<Object> listObject(String Hql)
	{
		return listObject(Hql, null);
	}

	@Override
	public Object object(String Hql, Object[] args)
	{
		return getQuety(Hql, args).uniqueResult();
	}

	@Override
	public Object object(String Hql, Object args)
	{
		return object(Hql, new Object[]{args});
	}
	
	
	
	@Override
	public Object object(String Hql)
	{
		return object(Hql, null);
	}

}
