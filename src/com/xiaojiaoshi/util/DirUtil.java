package com.xiaojiaoshi.util;

import java.io.File;

public class DirUtil
{
	
	public static void createDir(){
		
		File file = new File(PropertiesUtil.getImgProperties().getProperty("rootPath")+"/user");
		if(!file.isDirectory()){
			file.mkdirs();
		}
		
	}
	
	public static String creatMusicDir(){
		File file = new File(PropertiesUtil.getImgProperties().getProperty("rootPath")+"/user/music");
		if(!file.isDirectory()){
			file.mkdirs();
		}
		return "/user/music";
	}
	
	
	public static String creatVedioDir(){
		File file = new File(PropertiesUtil.getImgProperties().getProperty("rootPath")+"/user/vedio");
		if(!file.isDirectory()){
			file.mkdirs();
		}
		return "/user/vedio";
	}

	public static String creatSmallDir()
	{
		File file = new File(PropertiesUtil.getImgProperties().getProperty("rootPath")+"/user/small");
		if(!file.isDirectory()){
			file.mkdirs();
		}
		return "/user/small/";
		
	}

}
