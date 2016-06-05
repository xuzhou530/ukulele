package com.xiaojiaoshi.dao;


import java.util.List;

import com.xiaojiaoshi.model.Comment;

public interface ICommentDao extends IBaseDao<Comment>
{
	public List<Comment> listsSize(int offset, int pageSize); 
}
