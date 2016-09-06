package system;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import config.Status;

public abstract class  BaseContainer implements IRequestContainer{
	
	@Override
	public Map connect(String reqeustUrl) {
		// TODO Auto-generated method stub
		
		Map result = new HashMap();
		
		HttpURLConnection con=null;
		InputStreamReader isr=null;
		
		try {
			URL url = new URL(reqeustUrl);
			con = (HttpURLConnection)url.openConnection();
			isr = new InputStreamReader(con.getInputStream(), "UTF-8");	
			
			result.put("result", JSONValue.parseWithException(isr));
			result.put("status",Status.SUCCESS);
		}catch (Exception e) {
			// TODO: handle exception
			result.put("status",Status.REQUEST_ERROR);
			
		}finally {
			
			
			try {con.disconnect();} catch (Exception e) {}
			try {isr.close();} catch (IOException e) {}
		}		
		
		return result;
	}

}
