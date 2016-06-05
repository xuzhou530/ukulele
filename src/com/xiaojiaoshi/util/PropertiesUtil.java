package com.xiaojiaoshi.util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil
{
	
	private static Properties properties;
	
	public static Properties getImgProperties(){
		try
		{
			if(properties==null){
				properties = new Properties();
				properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("Img.Properties"));
				return properties;
			}
			return properties;
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
