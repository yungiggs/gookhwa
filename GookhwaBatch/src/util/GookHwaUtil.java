package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import config.ISytemConstant;


public class GookHwaUtil {
	


	public static String makeFullURL(String domain,Map param){
		
		String result =""; 

		Iterator<String> iterator = param.keySet().iterator();
		
		while(iterator.hasNext()) { 
			
			 String key = (String) iterator.next();
			 String value = (String) param.get(key);
			 
			 result=result+"&"+key+"="+value;
		}
		 
		return domain+"?"+result.substring(0);
	}	
	public static String nowDate(){
		

        return nowDate("yyyy-MM-dd HH:mm:ss");
	}
	public static String nowDate(String type){
		
		Calendar calendar = Calendar.getInstance();
        java.util.Date date = calendar.getTime();
        String today = (new SimpleDateFormat(type).format(date));	
		
        return today;
	}	
	
	
}
