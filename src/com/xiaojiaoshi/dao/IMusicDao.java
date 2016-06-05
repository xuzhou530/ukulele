package com.xiaojiaoshi.dao;

import java.util.List;

import com.xiaojiaoshi.dto.MVCombineDto;
import com.xiaojiaoshi.dto.ObjectPicturesDto;
import com.xiaojiaoshi.model.Music;
import com.xiaojiaoshi.model.Pager;

public interface IMusicDao extends IBaseDao<Music>
{
	public List<MVCombineDto> mvCombineDtos();
	public Pager<ObjectPicturesDto<Music>> musicPager(int id);
	public List<Music> listsSize(int offset, int pageSize);
	
}
