package com.xiaojiaoshi.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xiaojiaoshi.model.Cart;
import com.xiaojiaoshi.model.Comment;
import com.xiaojiaoshi.service.ICartService;
import com.xiaojiaoshi.service.ICommentService;
import com.xiaojiaoshi.util.ThreadLocalUtil;

@Controller("cartAction")
@Scope("prototype")
public class CartAction extends ActionSupport
{
	private static String REDIRECT = "redirect";
	private ICartService cartService;
	private Cart cart;
	private String orderby; 
	private ICommentService commentService;
	
	public String add(){
		
		cart.setCreatedate(new Date());
		cart.setType(1);
		cartService.addCart(cart);
		ActionContext.getContext().put("url", "pagerCart?pager.offset=0");
		return REDIRECT;
	}
	
	public String update(){
		ActionContext.getContext().put("url", "pagerCart?pager.offset=0");
		return REDIRECT;
	}
	
	public void updatedanger() throws IOException {
		Cart ct = cartService.load(cart.getId());
		ct.setDanger(1);
		cartService.update(ct);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");  
	    PrintWriter out = response.getWriter();  
	    out.write("举报");
	};
	
	public void updatetopCount() throws IOException {
		Cart ct = cartService.load(cart.getId());
		ct.setTopCount(ct.getTopCount()+1);
		cartService.update(ct);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");  
	    PrintWriter out = response.getWriter();  
	    out.write("支持");
	};
	
	public void updatebottomCount() throws IOException {
		Cart ct = cartService.load(cart.getId());
		ct.setBottomCount(ct.getBottomCount()+1);
		cartService.update(ct);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");  
	    PrintWriter out = response.getWriter();  
	    out.write("反对");
	};
	
	
	public String pagerCart(){
		if(orderby==null||"".equals(orderby)){
			ActionContext.getContext().put("pager", cartService.pager());
		}else if(orderby.equals("createdate")){
			String Hql = "from Cart c order by c.createdate desc";
			ThreadLocalUtil.setPagerSize(10);
			ActionContext.getContext().put("pager",cartService.selectorderVy(Hql, null));
		}else if(orderby.equals("scanfCount")){
			String Hql = "from Cart c order by c.scanfCount desc";
			ActionContext.getContext().put("pager",cartService.selectorderVy(Hql, null));
		} else if(orderby.equals("top")){
			String Hql = "from Cart c where c.top=1";
			ActionContext.getContext().put("pager",cartService.selectorderVy(Hql, null));
		}
		return SUCCESS;
	}
	
	public String list(){
		ActionContext.getContext().put("carts", cartService.lists());
		return SUCCESS;
	}
	
	public String delete(){
		cartService.delete(cart.getId());
		ActionContext.getContext().put("url", "listCart");
		return REDIRECT;
	}
	
	public String updateTop(){
		Cart cart1 =  cartService.load(cart.getId());
		cart1.setTop(cart.getTop());
		cartService.update(cart1);
		ActionContext.getContext().put("url", "listCart");
		return REDIRECT;
	}
	
	public String show(){
		
		Cart ct = cartService.load(cart.getId());
		ct.setScanfCount(ct.getScanfCount()+1);
		cartService.update(ct);
		List<Comment> comments = commentService.listByCartId(ct.getId());
		ActionContext.getContext().put("cart", ct);
		ActionContext.getContext().put("comments", comments);
		return SUCCESS;
	}
	
	public ICartService getCartService()
	{
		return cartService;
	}
	@Resource
	public void setCartService(ICartService cartService)
	{
		this.cartService = cartService;
	}

	public Cart getCart()
	{
		return cart;
	}

	public void setCart(Cart cart)
	{
		this.cart = cart;
	}

	public String getOrderby()
	{
		return orderby;
	}

	public void setOrderby(String orderby)
	{
		this.orderby = orderby;
	}

	public static String getREDIRECT()
	{
		return REDIRECT;
	}

	public static void setREDIRECT(String rEDIRECT)
	{
		REDIRECT = rEDIRECT;
	}

	public ICommentService getCommentService()
	{
		return commentService;
	}
	@Resource
	public void setCommentService(ICommentService commentService)
	{
		this.commentService = commentService;
	}
	
	
	
	
	
	
}
