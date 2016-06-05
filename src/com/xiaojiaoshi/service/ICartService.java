package com.xiaojiaoshi.service;

import java.util.List;

import com.xiaojiaoshi.model.Cart;
import com.xiaojiaoshi.model.Pager;

public interface ICartService
{
	public void addCart(Cart cart);
	public void delete(int id);
	public Cart load(int id);
	public void update(Cart cart);
	public Pager<Cart> pager(); 
	public List<Cart> lists();
	public List<Cart> listsSize(int offset , int pagerSize);
	public Pager<Cart> selectorderVy(String Hql, Object[] argo);
	
}
