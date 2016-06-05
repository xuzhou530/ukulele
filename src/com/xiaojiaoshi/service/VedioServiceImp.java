package com.xiaojiaoshi.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import com.xiaojiaoshi.dao.IVedioDao;
import com.xiaojiaoshi.dto.ObjectPicturesDto;
import com.xiaojiaoshi.model.Pager;
import com.xiaojiaoshi.model.Vedio;
import com.xiaojiaoshi.util.DirUtil;
import com.xiaojiaoshi.util.FileUtil;
import com.xiaojiaoshi.util.PropertiesUtil;
import com.xiaojiaoshi.util.StringUtil;
import com.xiaojiaoshi.util.UUIDUtil;

@Service("vedioService")
public class VedioServiceImp implements IVedioService
{
	private IVedioDao vedioDao;
	
	@Override
	public void addVedio(Vedio m, File file[], String fileFileName[], String root,File file2, String file2Name)
	{
		String files = "";
		if(file!=null){
			for( int i = 0 ; i < file.length ; i ++ ){
				String fileType =  StringUtil.getfiletype(fileFileName[i]);
				String fileName = UUIDUtil.getShortUuid();
				String rootSrc = DirUtil.creatVedioDir();
				try
				{
					FileUtils.copyFile(file[i], new File(root+rootSrc+"/"+fileName+fileType));
					files += rootSrc+"/"+fileName+fileType+"|";
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			files = files.substring(0, files.length()-1);
			m.setMusicSrc(files);
		}
		
		String fileType =  StringUtil.getfiletype(file2Name);
		String fileName = UUIDUtil.getShortUuid();
		String rootSrc = DirUtil.creatVedioDir();
		
		try
		{
			FileInputStream fis = new FileInputStream(file2);
			BufferedImage bufferedImg = ImageIO.read(fis);
			
			int imgWidth = bufferedImg.getWidth();
			int imgHeight = bufferedImg.getHeight();
			Thumbnails.of(bufferedImg).size(290, 290*imgHeight/imgWidth).toFile(root+rootSrc+"/"+fileName+fileType);
			m.setVedioPicSrc(rootSrc+"/"+fileName+fileType);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	
		Date date = new Date();
		m.setCreatedate(date);
		vedioDao.add(m);
	}

	@Override
	public Vedio loadVedio(int id)
	{
		return vedioDao.load(id);
	}

	@Override
	public void delete(int id, String root)
	{
			
		Vedio m = vedioDao.load(id);
		FileUtil.delete(root, m.getMusicSrc());
		FileUtil.delete(root, m.getVedioPicSrc());
		vedioDao.delete(m);
		
	}

	@Override
	public List<ObjectPicturesDto<Vedio>> listVedio()
	{
		List<ObjectPicturesDto<Vedio>> list = new ArrayList<ObjectPicturesDto<Vedio>>();
		List<Vedio> vedios = vedioDao.lists("from Vedio");
		String rootSrc =  PropertiesUtil.getImgProperties().get("imgsrc")+"";
		
		if(vedios!=null){
			for( int i = 0; i < vedios.size() ; i ++ ){
				list.add(getVedioDto(vedios.get(i), rootSrc));
			}	
		}
		return list;
	}

	@Override
	public void update(Vedio m, File file[], String fileFileName[], String root,File file2, String file2Name)
	{
		if(file!=null){
			String files = "";
			FileUtil.delete(root, m.getMusicSrc());
			for( int i = 0; i < file.length ; i ++ ) {
				String fileType =  StringUtil.getfiletype(fileFileName[i]);
				String fileName = UUIDUtil.getShortUuid();
				String rootSrc = DirUtil.creatVedioDir();
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
			m.setMusicSrc( files );
			
		}
		
		String fileType =  StringUtil.getfiletype(file2Name);
		String fileName = UUIDUtil.getShortUuid();
		String rootSrc = DirUtil.creatVedioDir();
		
		try
		{
			FileUtil.delete(root, m.getVedioPicSrc());
			FileInputStream fis = new FileInputStream(file2);
			BufferedImage bufferedImg = ImageIO.read(fis);
			
			int imgWidth = bufferedImg.getWidth();
			int imgHeight = bufferedImg.getHeight();
			Thumbnails.of(bufferedImg).size(290, 290*imgHeight/imgWidth).toFile(root+rootSrc+"/"+fileName+fileType);
			m.setVedioPicSrc(rootSrc+"/"+fileName+fileType);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		m.setCreatedate(new Date());
		vedioDao.update(m);
		
		
	}

	public IVedioDao getVedioDao()
	{
		return vedioDao;
	}

	@Resource
	public void setVedioDao(IVedioDao vedioDao)
	{
		this.vedioDao = vedioDao;
	}

	private ObjectPicturesDto<Vedio> getVedioDto(Vedio music,String rootSrc){
		
		ObjectPicturesDto<Vedio> picturesDto = new ObjectPicturesDto<Vedio>();
		picturesDto.setObj(music);
		if(!( music.getMusicSrc() == null || "".equals(music.getMusicSrc()) )){
			String musicStr = music.getMusicSrc();
			String[] srcs = musicStr.split("\\|");
			ArrayList<String> picsrc = new ArrayList<String>();
			for( int j = 0 ; j < srcs.length ; j ++ ){
				
				picsrc.add(rootSrc+srcs[j]);
				
			}
			picturesDto.setPicsrc(picsrc);
		}
		
		return picturesDto;
	}
	
	@Override
	public Pager<Vedio> pagerIndex()
	{
		String Hql = "form Vedio m order by m.scanfcount desc";
		return vedioDao.pager(Hql);
	}

	@Override
	public List<ObjectPicturesDto<Vedio>> listsSize(int offset, int pageSize)
	{
		List<ObjectPicturesDto<Vedio>> list = new ArrayList<ObjectPicturesDto<Vedio>>();
		List<Vedio> vedios = vedioDao.listsSize(offset, pageSize);
		if(vedios!=null){
			for(int i = 0; i < vedios.size() ; i ++ ){
				String vps = vedios.get(i).getVedioPicSrc();
				if(!(vps==null||"".equals(vps))){
					vedios.get(i).setVedioPicSrc(PropertiesUtil.getImgProperties().get("imgsrc")+vps);
					ObjectPicturesDto<Vedio> dto = new ObjectPicturesDto<Vedio>();
					dto.setObj(vedios.get(i));
					list.add(dto);
				}
				
			}
		}
		
		return list;
	}

	@Override
	public Pager<ObjectPicturesDto<Vedio>> showPager(String Hql)
	{
		Pager<Vedio> pager = vedioDao.pager(Hql);
		
		Pager<ObjectPicturesDto<Vedio>> pager2 = new Pager<ObjectPicturesDto<Vedio>>();
		pager2.setPageCount(pager.getPageCount());
		pager2.setPageOffset(pager.getPageOffset());
		pager2.setPagerindex(pager.getPagerindex());
		pager2.setPagerSize(pager.getPagerSize());
		List<Vedio> vedios = pager.getObjs();
		String rootSrc =  PropertiesUtil.getImgProperties().get("imgsrc")+"";
		List<ObjectPicturesDto<Vedio>> list = new ArrayList<ObjectPicturesDto<Vedio>>();
		if(vedios!=null){
			for( int i = 0; i < vedios.size() ; i ++ ){
				Vedio v = vedios.get(i);
				 v.setVedioPicSrc(rootSrc+ v.getVedioPicSrc());
				list.add(getVedioDto(v, rootSrc));
			}
		}
		pager2.setObjs(list);
		return pager2;
	}

	@Override
	public void updateCommom(Vedio vedio1)
	{
		vedioDao.update(vedio1);
		
	}

	@Override
	public Pager<Vedio> vedioInfo(int current)
	{
		return vedioDao.vedioPager(current);
	}

}
