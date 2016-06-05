package com.xiaojiaoshi.action;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xiaojiaoshi.dto.MVCombineDto;
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


@Controller("vedioAction")
@Scope("prototype")
public class VedioAction extends ActionSupport 
{

	private static String REDIRECT = "redirect";
	private File file[];
	private String fileFileName[];
	private String fileContentType[];
	
	
	private Vedio vedio;
	private File flvedio;
	private String flvedioFileName;
	private String flvedioContentType;
	
	private IVedioService vedioService;
	private IMusicService musicService;
	private ICartService cartService;
	private ICommentService commentService;
	
	
//	添加用户界面
	public String add(){
		return SUCCESS;
	}
	public String update(){
		ActionContext.getContext().put("vedio", vedioService.loadVedio(vedio.getId()));
		return SUCCESS;
	}
	
	public String addVedio(){
		vedioService.addVedio(vedio,file,fileFileName,PropertiesUtil.getImgProperties().getProperty("rootPath"),flvedio,flvedioFileName);
		ActionContext.getContext().put("url", "listVedio");
		return REDIRECT;
	}
	
	public String listVedio(){
		ActionContext.getContext().put("vedios", vedioService.listVedio());
		return SUCCESS;
	}

	public String deleteVedio(){
		vedioService.delete(vedio.getId(), PropertiesUtil.getImgProperties().getProperty("rootPath"));
		ActionContext.getContext().put("url", "listVedio");
		return REDIRECT;
	}
	
	public String updateVedio(){
		Vedio m = vedioService.loadVedio(vedio.getId());
		String src = m.getMusicSrc();
		String vedioPicSrc = m.getVedioPicSrc();
		try
		{
			BeanUtils.copyProperties(m, vedio);
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		} catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
		m.setMusicSrc(src);
		m.setVedioPicSrc(vedioPicSrc);
		vedioService.update(m,file,fileFileName,PropertiesUtil.getImgProperties().getProperty("rootPath"), flvedio, flvedioFileName);
		ActionContext.getContext().put("url", "listVedio");
		return REDIRECT;
	}
	
	
	public String showVedioList(){
		
		Pager<ObjectPicturesDto<Vedio>> pager = vedioService.showPager("from Vedio v order by v.createdate desc");
		List<Cart> carts = cartService.listsSize(0, 10);
		List<Comment> comments = commentService.listsSize(0, 5);
		List<ObjectPicturesDto<Music>> musics = musicService.listsSize(0, 1); 
		ActionContext.getContext().put("pager", pager);
		ActionContext.getContext().put("carts", carts);
		ActionContext.getContext().put("comments", comments);
		ActionContext.getContext().put("musics", musics);
		return SUCCESS;
	}
	
	public String showVedio(){
		int current = vedio.getId();
		Vedio vedio1 = vedioService.loadVedio(current);
		vedio1.setScanfcount(vedio1.getScanfcount()+1);
		vedioService.updateCommom(vedio1);
		ObjectPicturesDto<Vedio> vdto = returnVedioDto(vedio1,PropertiesUtil.getImgProperties().getProperty("imgsrc"));
		Pager<Vedio> pager = vedioService.vedioInfo(current);
		List<Comment> comments = commentService.listsSize(0, 5);
		List<Cart> carts = cartService.listsSize(0, 10);
		List<ObjectPicturesDto<Music>> musics = musicService.listsSize(0, 1); 
		ActionContext.getContext().put("current", current);
		ActionContext.getContext().put("pager", pager);
		ActionContext.getContext().put("comments", comments);
		ActionContext.getContext().put("carts", carts);
		ActionContext.getContext().put("musics", musics);
		ActionContext.getContext().put("vdto", vdto);
		ServletActionContext.getRequest().setAttribute("aaa", vedio1.getVediokey());
		return SUCCESS;
	}

	
	private ObjectPicturesDto<Vedio> returnVedioDto(Vedio music,String rootSrc){
		
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

	
	public String indexAction(){
		
		List<ObjectPicturesDto<Vedio>> vediodtos =  vedioService.listsSize(0, 6);
		List<ObjectPicturesDto<Music>> musicdtos = musicService.listsSize(0, 9);
		List<MVCombineDto> combineDto = musicService.mvCombineDtos();
		List<Comment> comments = commentService.listsSize(0, 5);
		List<Cart> carts = cartService.listsSize(0, 10);
		
		
		ActionContext.getContext().put("vediodtos", vediodtos);
		ActionContext.getContext().put("musicdtos", musicdtos);
		ActionContext.getContext().put("combineDto", combineDto);
		ActionContext.getContext().put("comments", comments);
		ActionContext.getContext().put("carts", carts);
		
		
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
	public IVedioService getVedioService()
	{
		return vedioService;
	}
	@Resource
	public void setVedioService(IVedioService vedioService)
	{
		this.vedioService = vedioService;
	}

	public Vedio getVedio()
	{
		return vedio;
	}

	public void setVedio(Vedio vedio)
	{
		this.vedio = vedio;
	}
	public File getFlvedio()
	{
		return flvedio;
	}
	public void setFlvedio(File flvedio)
	{
		this.flvedio = flvedio;
	}
	public String getFlvedioFileName()
	{
		return flvedioFileName;
	}
	public void setFlvedioFileName(String flvedioFileName)
	{
		this.flvedioFileName = flvedioFileName;
	}
	public String getFlvedioContentType()
	{
		return flvedioContentType;
	}
	public void setFlvedioContentType(String flvedioContentType)
	{
		this.flvedioContentType = flvedioContentType;
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

}
