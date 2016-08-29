package util;

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
//	public static String makeFullURL(String domain,Map subDomain,Map param){
//		
//		String tempDomain = makeURL(domain, subDomain);
//		 
//		return  makeFullURL(tempDomain,param);
//	}	

	public static Map getFacebookParam(){

		Map param = new HashMap();
		
		param.put("summary", "true");
		param.put("access_token", ISytemConstant.COMMON_ACCESS_KEY);
		
		return  param;
	}		
	
	
	
}
