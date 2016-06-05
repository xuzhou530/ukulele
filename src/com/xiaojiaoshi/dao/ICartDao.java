package com.xiaojiaoshi.dao;

import java.util.List;

import com.xiaojiaoshi.model.Cart;
import com.xiaojiaoshi.model.Pager;

public interface ICartDao extends IBaseDao<Cart>
{
	public Pager<Cart> cartPager();
	public List<Cart> listsSize(int offset , int pagerSize);

}
