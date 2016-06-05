package com.xiaojiaoshi.conveter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;


public class DaTeConveter extends StrutsTypeConverter
{
	private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private final static SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2)
	{
		try
		{
			if(arg1!=null&&arg1.length==1){
				return dateFormat.parse(arg1[0]);				
			}
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1)
	{
		Date date = (Date)arg1;
		Date currentDate = new Date();
        long temp = currentDate.getTime() - date.getTime();    
        long hours = temp / 1000 / 3600;                //相差小时数
        if( hours<1 ){
       	 long mins = temp / 1000 / 60; //相差分钟数
       	 return mins+"分钟前";
       }
        if( hours<24 )
    	{
        	return hours+"小时前";
    	}
        
		return dateFormat1.format(arg1);
	}

}
