package util;

import java.util.Map;


public class StringUtil {

	public static String nvl(Map map, String key) {
		if(map == null){
			return "";
		}
		Object obj = null;
		if(map.containsKey(key)){
			obj = map.get(key);
		} else if (map.containsKey(key.toUpperCase())) {
			obj = map.get(key.toUpperCase());
		} else {
			return "";
		}
		return obj == null ? "" : String.valueOf(obj);
	
	}	
}
