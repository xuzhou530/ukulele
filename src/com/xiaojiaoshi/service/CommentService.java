package com.xiaojiaoshi.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiaojiaoshi.dao.ICommentDao;
import com.xiaojiaoshi.model.Comment;

@Service("commentService")
public class CommentService implements ICommentService
{
	private ICommentDao commentDao;

	@Override
	public void add(Comment comment)
	{
		commentDao.add(comment);
	}

	@Override
	public void update(Comment coment)
	{
		commentDao.update(coment);
	}

	@Override
	public void delete(int id)
	{
		Comment comment = new Comment();
		comment.setId(id);
		commentDao.delete(comment);
	}

	@Override
	public long countBYCartId(int id)
	{
		
		return 0;
	}

	public ICommentDao getCommentDao()
	{
		return commentDao;
	}
	
	@Resource
	public void setCommentDao(ICommentDao commentDao)
	{
		this.commentDao = commentDao;
	}

	@Override
	public List<Comment> listByCartId(int cartid)
	{
		String Hql = "from Comment c where c.cart.id=? order by c.createDate";
		
		return commentDao.lists(Hql,cartid);
	}

	@Override
	public Comment load(int id)
	{
		return commentDao.load(id);
	}

	@Override
	public List<Comment> listsSize(int offset, int pageSize)
	{
		return commentDao.listsSize(offset, pageSize);
	}

	@Override
	public List<Comment> listByMusicId(int id)
	{
		String Hql = "from Comment c where c.music.id=? ";
		return commentDao.lists(Hql,id);
	}

	@Override
	public List<Comment> listByVedioId(int id)
	{
	String Hql = "from Comment c where c.vedio.id=?";
		
		return commentDao.lists(Hql,id);
	}

	@Override
	public List<Comment> listByNull()
	{
		String hql  = "from Comment c where c.vedio=null and c.music=null and c.cart=null";
		return commentDao.lists(hql);
	}

	
	
}
