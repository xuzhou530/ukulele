package com.xiaojiaoshi.action;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xiaojiaoshi.dto.ObjectPicturesDto;
import com.xiaojiaoshi.model.Cart;
import com.xiaojiaoshi.model.Comment;
import com.xiaojiaoshi.model.Music;
import com.xiaojiaoshi.model.Pager;
import com.xiaojiaoshi.model.Vedio;
import com.xiaojiaoshi.service.ICartService;
import com.xiaojiaoshi.service.ICommentService;
import com.xiaojiaoshi.service.IMusicService;
import com.xiaojiaoshi.service.IVedioService;
import com.xiaojiaoshi.util.PropertiesUtil;


@Controller("musicAction")
@Scope("prototype")
public class MusicAction extends ActionSupport 
{
	
	private static String REDIRECT = "redirect";
	private File file[];
	private String fileFileName[];
	private String fileContentType[];
	private IMusicService musicService;
	private ICartService cartService;
	private ICommentService commentService;
	private IVedioService vedioService;
	private Music music;
	
//	添加用户界面
	public String add(){
		return SUCCESS;
	}
	public String update(){
		ActionContext.getContext().put("music", musicService.loadMusic(music.getId()));
		return SUCCESS;
	}
	
	public String addMusic(){
		musicService.addMusic(music,file,fileFileName, PropertiesUtil.getImgProperties().getProperty("rootPath") );
		ActionContext.getContext().put("url", "listMusic");
		return REDIRECT;
	}
	
	public String listMusic(){
		ActionContext.getContext().put("musics", musicService.listMusic());
		return SUCCESS;
	}
	
	public String deleteMusic(){
		musicService.delete(music.getId(), PropertiesUtil.getImgProperties().getProperty("rootPath"));
		ActionContext.getContext().put("url", "listMusic");
		return REDIRECT;
	}
	
	public String updateMusic(){
		Music m = musicService.loadMusic(music.getId());
		System.out.println(m.getId());
		String src = m.getMusicSrc();
		try
		{
			BeanUtils.copyProperties(m, music);
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		} catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
		m.setMusicSrc(src);
		musicService.update(m,file,fileFileName,PropertiesUtil.getImgProperties().getProperty("rootPath"));
		ActionContext.getContext().put("url", "listMusic");
		return REDIRECT;
	}
	
	public String showMusicList(){
		
		Pager<ObjectPicturesDto<Music>> pager = musicService.showPager("from Music m order by m.createdate desc");
		List<Cart> carts = cartService.listsSize(0, 10);
		List<Comment> comments = commentService.listsSize(0, 5);
		List<ObjectPicturesDto<Vedio>> vedios = vedioService.listsSize(0, 1); 
		ActionContext.getContext().put("pager", pager);
		ActionContext.getContext().put("carts", carts);
		ActionContext.getContext().put("comments", comments);
		ActionContext.getContext().put("vedios", vedios);
		return SUCCESS;
	}
	
	
	public String showMusic(){
		int current = music.getId();
		Music music1 = musicService.loadMusic(current);
		music1.setScanfcount(music1.getScanfcount()+1);
		musicService.updateCommom(music1);
		Pager<ObjectPicturesDto<Music>> pager = musicService.musicInfo(current);
		List<Comment> comments = commentService.listsSize(0, 5);
		List<Cart> carts = cartService.listsSize(0, 10);
		List<ObjectPicturesDto<Vedio>> vedios = vedioService.listsSize(0, 1); 
		ActionContext.getContext().put("current", current);
		ActionContext.getContext().put("pager", pager);
		ActionContext.getContext().put("comments", comments);
		ActionContext.getContext().put("carts", carts);
		ActionContext.getContext().put("vedios", vedios);
		ActionContext.getContext().put("music", music1);
		ServletActionContext.getRequest().setAttribute("aaa", music1.getVediokey());
		return SUCCESS;
	}
	
	public String ukuleleAbout(){
		List<Cart> carts = cartService.listsSize(0, 10);
		List<Comment> comments = commentService.listsSize(0, 5);
		List<ObjectPicturesDto<Vedio>> vedios = vedioService.listsSize(0, 1); 
		ActionContext.getContext().put("carts", carts);
		ActionContext.getContext().put("comments", comments);
		ActionContext.getContext().put("vedios", vedios);
		return SUCCESS;
	}
	
	public String show(){
		
		return SUCCESS;
	}
	
	public File[] getFile()
	{
		return file;
	}
	public void setFile(File[] file)
	{
		this.file = file;
	}
	public String[] getFileFileName()
	{
		return fileFileName;
	}
	public void setFileFileName(String[] fileFileName)
	{
		this.fileFileName = fileFileName;
	}
	public String[] getFileContentType()
	{
		return fileContentType;
	}
	public void setFileContentType(String[] fileContentType)
	{
		this.fileContentType = fileContentType;
	}
	public IMusicService getMusicService()
	{
		return musicService;
	}
	@Resource
	public void setMusicService(IMusicService musicService)
	{
		this.musicService = musicService;
	}

	public Music getMusic()
	{
		return music;
	}

	public void setMusic(Music music)
	{
		this.music = music;
	}
	public ICartService getCartService()
	{
		return cartService;
	}
	@Resource
	public void setCartService(ICartService cartService)
	{
		this.cartService = cartService;
	}
	
	public ICommentService getCommentService()
	{
		return commentService;
	}
	@Resource
	public void setCommentService(ICommentService commentService)
	{
		this.commentService = commentService;
	}
	public IVedioService getVedioService()
	{
		return vedioService;
	}
	@Resource
	public void setVedioService(IVedioService vedioService)
	{
		this.vedioService = vedioService;
	}

	
}
