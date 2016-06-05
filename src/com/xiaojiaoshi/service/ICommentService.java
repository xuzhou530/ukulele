package com.xiaojiaoshi.service;

import java.util.List;

import com.xiaojiaoshi.model.Comment;

public interface ICommentService
{
	public void add(Comment comment);
	public void update(Comment coment); 
	public Comment load(int id);
	public void delete(int id);
	public long countBYCartId(int id);
	public List<Comment> listByCartId(int cartid);
	public List<Comment> listsSize(int offset, int pageSize);
	public List<Comment> listByMusicId(int id);
	public List<Comment> listByVedioId(int id);
	public List<Comment> listByNull();
}
