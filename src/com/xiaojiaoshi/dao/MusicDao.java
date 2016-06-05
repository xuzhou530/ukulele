package com.xiaojiaoshi.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.xiaojiaoshi.dto.MVCombineDto;
import com.xiaojiaoshi.dto.ObjectPicturesDto;
import com.xiaojiaoshi.model.Music;
import com.xiaojiaoshi.model.Pager;
import com.xiaojiaoshi.util.PropertiesUtil;

@Repository("musicDao")
public class MusicDao extends BaseDao<Music> implements IMusicDao
{

	@Override
	public List<MVCombineDto> mvCombineDtos()
	{
		Query query = getSession().createSQLQuery("SELECT * from "
				+ "(SELECT id,musicName,musicSrc,scanfcount,type from t_music "
				+ "UNION ALL "
				+ "select id,vedioTitle,musicSrc,scanfcount,type from  t_vedio) t1 "
				+ "ORDER BY t1.scanfcount  DESC")
				.setResultTransformer(Transformers.aliasToBean(MVCombineDto.class))
				.setFirstResult(0)
				.setMaxResults(10);
		 
		return query.list();
	}

	@Override
	public Pager<ObjectPicturesDto<Music>> musicPager(int id)
	{
		Pager<ObjectPicturesDto<Music>> pager = new Pager<ObjectPicturesDto<Music>>();
		int pageSie = 1;
		int pageOffset = id;
		
		String  query = getCountHql("from Music");
		long pagerCont = (Long)getQuety(query, null).uniqueResult();
		
	 	long preCount = (Long)getQuety(getCountHql("from Music c where id< ?"), new Object[]{pageOffset})
	 			.uniqueResult();
	 	String sql ="";
	 	if(preCount>=2){
	 		if((pagerCont-preCount-1)<2){
	 			sql = "select * from t_music where id in( "
						+"select t1.id from ("
						+"(select id from t_music WHERE id<=? ORDER BY id Desc limit 0,"+(5-(pagerCont-preCount-1))+" )" 
						+"UNION ALL "
						+"( select id from t_music where id>? ORDER BY id )"
						+") t1) order by id";

	 		}else{
	 			sql = "select * from t_music where id in( "
						+"select t1.id from ("
						+"(select id from t_music WHERE id<=? ORDER BY id Desc limit 0,3 )" 
						+"UNION ALL "
						+"( select id from t_music where id>? ORDER BY id limit 0,2 )"
						+") t1) order by id ";
	 		}
	 	}else{
	 		
	 		sql = "select * from t_music where id in( "
					+"select t1.id from ("
					+"(select id from t_music WHERE id<=? ORDER BY id Desc )" 
					+"UNION ALL "
					+"( select id from t_music where id>? ORDER BY id limit 0,"+(5-preCount-1)+" )"
					+") t1) order by id";
	 			
	 	}
		List<Music> musics = getSession()
				.createSQLQuery(sql)
				.addEntity(Music.class)
				.setParameter(0, pageOffset)
				.setParameter(1, pageOffset)
				.list();
		List<ObjectPicturesDto<Music>> args = new ArrayList<ObjectPicturesDto<Music>>();
		String rootsrc = PropertiesUtil.getImgProperties().getProperty("imgsrc");
		if(musics != null){
			for(int i=0 ; i < musics.size(); i ++ ){
				ObjectPicturesDto<Music> dto = getObjectPicturesDto(musics.get(i), rootsrc);
				dto.getObj().setSmallSrc(rootsrc+dto.getObj().getMusicSrc());
				args.add(dto);
			}
		}
		
		pager.setPageCount(pagerCont);
		pager.setObjs(args);
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

	@Override
	public List<Music> listsSize(int offset, int pageSize)
	{
		String Hql ="from Music m order by m.scanfcount desc";
		return getSession().createQuery(Hql).setFirstResult(offset).setMaxResults(pageSize).list();
	}
	
}
