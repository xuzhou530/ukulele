package com.xiaojiaoshi.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiaojiaoshi.dao.ICartDao;
import com.xiaojiaoshi.model.Cart;
import com.xiaojiaoshi.model.Pager;

@Service("cartService")
public class CartServiceImp implements ICartService
{
	private ICartDao cartDao;

	@Override
	public void addCart(Cart cart)
	{
		cartDao.add(cart);
		
	}

	@Override
	public void delete(int id)
	{
		Cart cart = new Cart();
		cart.setId(id);
		cartDao.delete(cart);
	}

	@Override
	public Cart load(int id)
	{
		return cartDao.load(id);
	}

	@Override
	public Pager<Cart> pager()
	{
		
		return cartDao.cartPager();
	}

	public ICartDao getCartDao()
	{
		return cartDao;
	}
	@Resource
	public void setCartDao(ICartDao cartDao)
	{
		this.cartDao = cartDao;
	}

	@Override
	public void update(Cart cart)
	{
		cartDao.update(cart);
	}

	@Override
	public List<Cart> lists()
	{
		String Hql = "from Cart c order BY c.top DESC,c.scanfCount DESC, c.createdate DESC";
		return cartDao.lists(Hql);
	}

	@Override
	public Pager<Cart> selectorderVy(String Hql, Object[] argo)
	{
		return cartDao.pager(Hql, argo);
	}

	@Override
	public List<Cart> listsSize(int offset, int pagerSize)
	{
		
		return cartDao.listsSize(offset, pagerSize);
	}


	
	
	
	

}
