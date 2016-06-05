package com.xiaojiaoshi.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.io.FileUtils;

public class FileUtil
{
	private FileUtil(){};
	
	public static void delete(String root, String src){
		
		String[] arr = getArr(root, src);
		if(arr!=null){
			for( int i = 0; i < arr.length ; i ++ ){
				
				try
				{
					FileUtils.forceDelete(new File(arr[i]));
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				
			}
		}
		
	}
	
	public static String creatFileName(String fileName){
		String UUID = UUIDUtil.getShortUuid();
		fileName = StringUtil.getfiletype(fileName);
		return UUID+fileName;
	}
	
	
	public  static String setSmallFile(File file, String fileName){
		String small = DirUtil.creatSmallDir(); 
		fileName = creatFileName(fileName);
		String toFile = getfullpath(small+fileName);
		try
		{
			FileInputStream fis = new FileInputStream(file);
			BufferedImage bufferedImg = ImageIO.read(fis);
			int imgWidth = bufferedImg.getWidth();
			int imgHeight = bufferedImg.getHeight();
			Thumbnails.of(bufferedImg).size(400, 400*imgHeight/imgWidth).toFile(toFile);		
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return small+fileName;
	}
	
	public static String getFullUrl(String parturl){

		String src = ""+PropertiesUtil.getImgProperties().get("imgsrc");
		src = src+parturl;
		return src;
		
	}
	
	public static String getfullpath(String shortPath){
		return PropertiesUtil.getImgProperties().getProperty("rootPath")+shortPath;
	}
	
	private static String[] getArr(String root,String src){
		
		 if(!(src==null||"".equals(src))){
			 String[] arr = src.split("\\|");
			 
			 for(int i = 0; i < arr.length ; i++ ){
				 
				 arr[i] = root+arr[i];
				 
			 }
			 return arr;
		 }
		 
		 return null;
		
	}
	
	
}
