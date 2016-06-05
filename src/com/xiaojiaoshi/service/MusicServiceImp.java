package com.xiaojiaoshi.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import com.xiaojiaoshi.dao.IMusicDao;
import com.xiaojiaoshi.dto.MVCombineDto;
import com.xiaojiaoshi.dto.ObjectPicturesDto;
import com.xiaojiaoshi.model.Music;
import com.xiaojiaoshi.model.Pager;
import com.xiaojiaoshi.util.DirUtil;
import com.xiaojiaoshi.util.FileUtil;
import com.xiaojiaoshi.util.PropertiesUtil;
import com.xiaojiaoshi.util.StringUtil;
import com.xiaojiaoshi.util.UUIDUtil;

@Service("musicService")
public class MusicServiceImp implements IMusicService
{
	private IMusicDao musicDao;
	
	@Override
	public void addMusic(Music m, File file[], String fileFileName[], String root)
	{
		
		String filenames = "";
		String smallSrc="";
		for( int i = 0; i < fileFileName.length ; i ++) {
			if(i==0){
				System.out.println("123123123123");
				smallSrc = FileUtil.setSmallFile(file[i], fileFileName[i]);
			}
			String fileType =  StringUtil.getfiletype(fileFileName[i]);
			
			String fileName = UUIDUtil.getShortUuid();
			String rootSrc = DirUtil.creatMusicDir();
			try
			{
				FileUtils.copyFile(file[i], new File(root+rootSrc+"/"+fileName+fileType));
				filenames += rootSrc+"/"+fileName+fileType+"|";
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		filenames = filenames.substring(0, filenames.lastIndexOf("|"));
		m.setSmallSrc(smallSrc);
		m.setMusicSrc( filenames );
		m.setCreatedate(new Date());
		musicDao.add(m);
	}

	@Override
	public Music loadMusic(int id)
	{
		return musicDao.load(id);
	}

	@Override
	public void delete(int id, String root)
	{
			
		Music m = musicDao.load(id);
		FileUtil.delete(root, m.getMusicSrc());
		musicDao.delete(m);
	}

	@Override
	public List<ObjectPicturesDto<Music>> listMusic()
	{
		List<ObjectPicturesDto<Music>> list = new ArrayList<ObjectPicturesDto<Music>>();
		List<Music> musics = musicDao.lists("from Music");
		String rootSrc =  PropertiesUtil.getImgProperties().get("imgsrc")+"";
		if(musics!=null){
			for( int i = 0; i < musics.size() ; i ++ ){
				list.add(getMusicDto(musics.get(i), rootSrc));
			}
		}
		return list;
	}
	public Pager<Music> pagerList(String Hql){
		
		return musicDao.pager(Hql);
	}
	
	public Pager<ObjectPicturesDto<Music>> showPager(String Hql){
		Pager<Music> pager = musicDao.pager(Hql);
		
		Pager<ObjectPicturesDto<Music>> pager2 = new Pager<ObjectPicturesDto<Music>>();
		pager2.setPageCount(pager.getPageCount());
		pager2.setPageOffset(pager.getPageOffset());
		pager2.setPagerindex(pager.getPagerindex());
		pager2.setPagerSize(pager.getPagerSize());
		List<Music> musics = pager.getObjs();
		String rootSrc =  PropertiesUtil.getImgProperties().get("imgsrc")+"";
		List<ObjectPicturesDto<Music>> list = new ArrayList<ObjectPicturesDto<Music>>();
		if(musics!=null){
			for( int i = 0; i < musics.size() ; i ++ ){
				musics.get(i).setSmallSrc(rootSrc+musics.get(i).getSmallSrc());
				list.add(getMusicDto(musics.get(i), rootSrc));
			}
		}
		pager2.setObjs(list);
		return pager2;
	}

	@Override
	public void update(Music m, File file[], String fileFileName[], String root)
	{
		if(file!=null){
			String files = "";
			String smallSrc = "";
			FileUtil.delete(root, m.getSmallSrc());
			FileUtil.delete(root, m.getMusicSrc());
			for( int i = 0; i < file.length ; i ++ ) {
				if(i==0){
					smallSrc = FileUtil.setSmallFile(file[i], fileFileName[i]);
				}
				String fileType =  StringUtil.getfiletype(fileFileName[i]);
				String fileName = UUIDUtil.getShortUuid();
				String rootSrc = DirUtil.creatMusicDir();
				try
				{
					FileUtils.copyFile(file[i], new File(root+rootSrc+"/"+fileName+fileType));
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				
				files += rootSrc+"/"+fileName+fileType+"|";
				
			}
			files = files.substring(0, files.length()-1);
			m.setSmallSrc(smallSrc);
			m.setCreatedate(new Date());
			m.setMusicSrc( files );
			musicDao.update(m);
		}
		
	}

	public IMusicDao getMusicDao()
	{
		return musicDao;
	}

	@Resource
	public void setMusicDao(IMusicDao musicDao)
	{
		this.musicDao = musicDao;
	}

	
	private ObjectPicturesDto<Music> getMusicDto(Music music,String rootSrc){
		
		ObjectPicturesDto<Music> picturesDto = new ObjectPicturesDto<Music>();
	 	String musicStr = music.getMusicSrc();
		picturesDto.setObj(music);
		String[] srcs = musicStr.split("\\|");
		ArrayList<String> picsrc = new ArrayList<String>();
		for( int j = 0 ; j < srcs.length ; j ++ ){
			
			picsrc.add(rootSrc+srcs[j]);
			
		}
		
		picturesDto.setPicsrc(picsrc);
		
		return picturesDto;
	}

	@Override
	public List<MVCombineDto> combineDtos()
	{
		return musicDao.mvCombineDtos();
	}

	@Override
	public Pager<Music> pagerIndex()
	{
		String Hql = "form Music m order by m.scanfcount desc";
		return musicDao.pager(Hql);
	}

	@Override
	public Pager<ObjectPicturesDto<Music>> musicInfo(int id)
	{
		return musicDao.musicPager(id);
	}

	@Override
	public void updateCommom(Music music1)
	{
		musicDao.update(music1);
		
	}

	@Override
	public List<ObjectPicturesDto<Music>> listsSize(int offset, int pageSize)
	{
		List<ObjectPicturesDto<Music>> list = new ArrayList<ObjectPicturesDto<Music>>();
		List<Music> musics = musicDao.listsSize(offset, pageSize);
		if(musics!=null){
			String rootSrc = PropertiesUtil.getImgProperties().get("imgsrc")+"";
			for(int i = 0; i < musics.size() ; i ++ ){
				musics.get(i).setSmallSrc(rootSrc+musics.get(i).getSmallSrc());
				list.add(getMusicDto(musics.get(i), rootSrc));
				
			}
		}
		
		return list;
	}

	@Override
	public List<MVCombineDto> mvCombineDtos()
	{
		return  musicDao.mvCombineDtos();
	}
	

}
