package com.xiaojiaoshi.dao;

import java.util.List;

import com.xiaojiaoshi.model.Pager;
import com.xiaojiaoshi.model.Vedio;

public interface IVedioDao extends IBaseDao<Vedio>
{
	public List<Vedio> listsSize(int offset, int pageSize);

	public Pager<Vedio> vedioPager(int current); 

}
