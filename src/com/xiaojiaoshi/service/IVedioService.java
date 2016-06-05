package com.xiaojiaoshi.service;

import java.io.File;
import java.util.List;

import com.xiaojiaoshi.dto.ObjectPicturesDto;
import com.xiaojiaoshi.model.Pager;
import com.xiaojiaoshi.model.Vedio;

public interface IVedioService
{
	public void addVedio(Vedio m, File file[], String fileFileName[], String root, File flvedio, String flvedioFileName);
	public Vedio loadVedio( int id);
	public void delete( int id ,String root);
	public List<ObjectPicturesDto<Vedio>> listVedio();
	public void update(Vedio m, File file[], String fileFileName[], String root, File flvedio, String flvedioFileName);
	public Pager<Vedio> pagerIndex();
	public List<ObjectPicturesDto<Vedio>> listsSize(int offset, int pageSize);
	public Pager<ObjectPicturesDto<Vedio>> showPager(String string);
	public void updateCommom(Vedio vedio1);
	public Pager<Vedio> vedioInfo(int current);
}
