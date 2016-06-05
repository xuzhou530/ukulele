package com.xiaojiaoshi.service;

import java.io.File;
import java.util.List;

import com.xiaojiaoshi.dto.MVCombineDto;
import com.xiaojiaoshi.dto.ObjectPicturesDto;
import com.xiaojiaoshi.model.Music;
import com.xiaojiaoshi.model.Pager;

public interface IMusicService
{

	public void addMusic(Music m, File file[], String fileFileName[], String root);
	public Music loadMusic( int id);
	public void delete( int id ,String root);
	public List<ObjectPicturesDto<Music>> listMusic();
	public void update(Music m, File file[], String fileFileName[], String root);
	public List<MVCombineDto> combineDtos();
	public Pager<Music> pagerIndex();
	public Pager<ObjectPicturesDto<Music>> showPager(String Hql);
	public Pager<ObjectPicturesDto<Music>> musicInfo(int id);
	public void updateCommom(Music music1);
	public List<ObjectPicturesDto<Music>> listsSize(int i, int j);
	public List<MVCombineDto> mvCombineDtos();
}
