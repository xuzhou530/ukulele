package com.xiaojiaoshi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xiaojiaoshi.model.Comment;

@Repository("commentDao")
public class CommentDao extends BaseDao<Comment> implements ICommentDao
{

	@Override
	public List<Comment> listsSize(int offset, int pageSize)
	{
		String Hql ="from Comment c order by c.createDate desc";
		return getSession().createQuery(Hql).setFirstResult(offset).setMaxResults(pageSize).list();
	}

}
