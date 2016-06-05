package com.xiaojiaoshi.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.xiaojiaoshi.model.Cart;
import com.xiaojiaoshi.model.Pager;
import com.xiaojiaoshi.util.ThreadLocalUtil;

@Repository("cartDao")
public class CartDao extends BaseDao<Cart> implements ICartDao
{

	@SuppressWarnings("unchecked")
	@Override
	public Pager<Cart> cartPager()
	{
		int pageSie = ThreadLocalUtil.getPagerSize();
		int pageOffset = ThreadLocalUtil.getPageroffset();
		
		Pager<Cart> pager = new Pager<Cart>();
		pager.setPageOffset(pageOffset);
		pager.setPagerSize(pageSie);
		String Hql = "select * from t_cart c order BY c.top DESC,IF(c.scanfCount>100,"
				+ "c.scanfCount,c.top) DESC,c.createdate DESC";
		List<Cart> list = getSession().createSQLQuery(Hql)
				.addEntity(Cart.class)
				.setFirstResult(pageOffset)
				.setMaxResults(pageSie).list();
		
		pager.setObjs(list);
		String Hql1 = "select count(id) from t_cart";
		BigInteger count = (BigInteger)getSession().createSQLQuery(Hql1).uniqueResult();
		pager.setPageCount(count.longValue());

		return pager;
	}

	@Override
	public List<Cart> listsSize(int offset, int pagerSize)
	{
		String Hql ="from Cart c order by c.scanfCount DESC";
		return getSession().createQuery(Hql).setFirstResult(offset).setMaxResults(pagerSize).list();
	}
}
