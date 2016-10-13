package system;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.omg.CORBA.NVList;

import com.google.gson.Gson;

import config.ISytemConstant;
import config.Status;
import util.GookHwaUtil;
import util.StringUtil;

public class FBContainer extends BaseContainer{
	
	private Logger logger = Logger.getLogger(FBContainer.class);

	public Map getLikes(String domain,Map param) {
		
		Map returnMap 	=	new HashMap();
		List list		=	new ArrayList();
		String postId 	= 	StringUtil.nvl(param,"post_id");
		String accessToken = StringUtil.nvl(param,"access_token");
		domain = domain+"/"+postId+"/likes";
		
		Map urlParam = new HashMap();
		urlParam.put("post_id", postId);
		urlParam.put("access_token", accessToken);
		
		String url  = GookHwaUtil.makeFullURL(domain,urlParam);
			
		try {
			 
			Map resultMap = super.connect(url);
			Status resultStatus = (Status)resultMap.get("status");			
			
			if(resultStatus.equals(Status.SUCCESS)){

				JSONObject obj =  (JSONObject)resultMap.get("result");
				logger.info("REQUEST_SUCCESS:"+postId);
				logger.info(obj);

				Gson gson = new Gson();
				
				Map jsonObject = (Map) gson.fromJson(obj.toString(), Object.class);	
				
				list = (List)jsonObject.get("data");	
				
				returnMap.put("status",resultStatus);
				returnMap.put("result",list);
				
			}else{

				returnMap.put("status",Status.REQUEST_ERROR);
				logger.info("REQUEST_ERROR:"+postId);
			}

		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
			returnMap.put("status",Status.SYSTEM_ERROR);
		}

		return returnMap;
	}
	public Map getShares(Map param){
		
		Map resultMap = new HashMap();
		return param;
	}

}
