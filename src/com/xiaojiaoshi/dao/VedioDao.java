package com.xiaojiaoshi.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.xiaojiaoshi.dto.ObjectPicturesDto;
import com.xiaojiaoshi.model.Music;
import com.xiaojiaoshi.model.Pager;
import com.xiaojiaoshi.model.Vedio;
import com.xiaojiaoshi.util.PropertiesUtil;

@Repository("vedioDao")
public class VedioDao extends BaseDao<Vedio> implements IVedioDao
{

	@Override
	public List<Vedio> listsSize(int offset, int pageSize)
	{
		String Hql ="from Vedio v order by v.scanfcount desc";
		return getSession().createQuery(Hql).setFirstResult(offset).setMaxResults(pageSize).list();
	}

	@Override
	public Pager<Vedio> vedioPager(int current)
	{
		Pager<Vedio> pager = new Pager<Vedio>();
		int pageSie = 1;
		int pageOffset = current;
		
		String  query = getCountHql("from Vedio");
		long pagerCont = (Long)getQuety(query, null).uniqueResult();
		
	 	long preCount = (Long)getQuety(getCountHql("from Vedio v where v.id< ?"), new Object[]{pageOffset})
	 			.uniqueResult();
	 	String sql ="";
	 	if(preCount>=2){
	 		if((pagerCont-preCount-1)<2){
	 			sql = "select * from t_vedio where id in( "
						+"select t1.id from ("
						+"(select id from t_vedio WHERE id<=? ORDER BY id Desc limit 0,"+(5-(pagerCont-preCount-1))+" )" 
						+"UNION ALL "
						+"( select id from t_vedio where id>? ORDER BY id )"
						+") t1) order by id";

	 		}else{
	 			sql = "select * from t_vedio where id in( "
						+"select t1.id from ("
						+"(select id from t_vedio WHERE id<=? ORDER BY id Desc limit 0,3 )" 
						+"UNION ALL "
						+"( select id from t_vedio where id>? ORDER BY id limit 0,2 )"
						+") t1) order by id ";
	 		}
	 	}else{
	 		
	 		sql = "select * from t_vedio where id in( "
					+"select t1.id from ("
					+"(select id from t_vedio WHERE id<=? ORDER BY id Desc )" 
					+"UNION ALL "
					+"( select id from t_vedio where id>? ORDER BY id limit 0,"+(5-preCount-1)+" )"
					+") t1) order by id";
	 			
	 	}
		List<Vedio> vedios = getSession()
				.createSQLQuery(sql)
				.addEntity(Vedio.class)
				.setParameter(0, pageOffset)
				.setParameter(1, pageOffset)
				.list();
		String rootsrc = PropertiesUtil.getImgProperties().getProperty("imgsrc");
		for( int i = 0 ; i< vedios.size(); i++){
			vedios.get(i).setVedioPicSrc(rootsrc+vedios.get(i).getVedioPicSrc());
		}
		pager.setPageCount(pagerCont);
		pager.setObjs(vedios);
		pager.setPageOffset(pageOffset);
		pager.setPagerSize(pageSie);
		System.out.println(pager);
		return pager;
	}
	
	
	
	private ObjectPicturesDto<Music> getObjectPicturesDto( Music music, String rootSrc){
		ObjectPicturesDto<Music> picturesDto = new ObjectPicturesDto<Music>();
	 	String musicStr = music.getMusicSrc();
		
		String[] srcs = musicStr.split("\\|");
		ArrayList<String> picsrc = new ArrayList<String>();
		for( int j = 0 ; j < srcs.length ; j ++ ){

			picsrc.add(rootSrc+srcs[j]);

		}
		
		picturesDto.setPicsrc(picsrc);
		picturesDto.setObj(music);
		
		return picturesDto;
	}
}
