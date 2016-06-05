package com.xiaojiaoshi.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xiaojiaoshi.model.Comment;
import com.xiaojiaoshi.service.ICommentService;

@Controller("commentAction")
@Scope("prototype")
public class CommentAction extends ActionSupport
{
	private static String REDIRECT = "redirect";
	private ICommentService commentService;
	private Comment comment;
	private int type;
	private List<Comment> comments;

	
	
	public String add(){
		comment.setCreateDate(new Date());
		commentService.add(comment);
		ActionContext.getContext().put("url", "../cart/show?cart.id="+comment.getCart().getId());
		return REDIRECT;
	}
	
	public void addAjax()throws IOException {
		comment.setCreateDate(new Date());
		commentService.add(comment);
		HttpServletResponse response=ServletActionContext.getResponse();  
		response.setContentType("text/html;charset=utf-8");  
	    PrintWriter out = response.getWriter();  
	    out.write("添加成功");
	}
	
	
	public String ajaxList(){
		
		if(type ==0 ){
			comments = commentService.listByMusicId(comment.getMusic().getId());
		}
		if(type ==1 ){
			comments = commentService.listByVedioId(comment.getVedio().getId());
		}
		if(type ==2 ){
			comments = commentService.listByNull();
		}
		return SUCCESS;
	}
	
	
	public void updateDanger() throws IOException {
		Comment comment1 = commentService.load(comment.getId());
		comment1.setDangerCount(comment.getDangerCount()+1);
		commentService.update(comment1);
		HttpServletResponse response=ServletActionContext.getResponse();  
		response.setContentType("text/html;charset=utf-8");  
	    PrintWriter out = response.getWriter();  
	    out.write("举报");
	}
	
	public void updatetopCount() throws IOException {
		Comment comment1 = commentService.load(comment.getId());
		comment1.setTopCount(comment.getTopCount()+1);
		commentService.update(comment1);
		HttpServletResponse response=ServletActionContext.getResponse();  
		response.setContentType("text/html;charset=utf-8");  
	    PrintWriter out = response.getWriter();  
	    out.write("支持");
	}
	
	public void updateBottomCount() throws IOException {
		Comment comment1 = commentService.load(comment.getId());
		comment1.setBottomCount(comment.getBottomCount()+1);
		commentService.update(comment1);
		HttpServletResponse response=ServletActionContext.getResponse();  
		response.setContentType("text/html;charset=utf-8");  
	    PrintWriter out = response.getWriter();  
	    out.write("反对");
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

	public Comment getComment()
	{
		return comment;
	}

	public void setComment(Comment comment)
	{
		this.comment = comment;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public List<Comment> getComments()
	{
		return comments;
	}

	public void setComments(List<Comment> comments)
	{
		this.comments = comments;
	}
	
	
}
