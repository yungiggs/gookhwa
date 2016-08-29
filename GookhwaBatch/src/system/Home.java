package system;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import config.ISytemConstant;
import util.GookHwaUtil;


public class Home {
	
	final static Logger logger = Logger.getLogger(Home.class);
	
	/*
	 * 1.�Žð� ���� Ÿ�� ƽ �߻� 
	 * 2.�۾� �غ� 
	 * 2-1 ũ�Ѹ� ������.
	 * 2-2 rdb ����
	 * 2-3 ��
	 * */
	public static void main(String[] args) {
		
		String tempDomain = ISytemConstant.FACEBOOK_URL+"/616654368500780_659663660866517/likes";
		
		String targetURL = GookHwaUtil.makeFullURL(tempDomain,  GookHwaUtil.getFacebookParam());
		HttpURLConnection con=null;
		InputStreamReader isr=null;
		try {
			
			URL url = new URL(targetURL);
			con = (HttpURLConnection)url.openConnection();
			isr = new InputStreamReader(con.getInputStream(), "UTF-8");
			
			JSONObject object = (JSONObject)JSONValue.parseWithException(isr);
			
			logger.info(object+"");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			
			try {con.disconnect();} catch (Exception e) {e.printStackTrace();}
			try {isr.close();} catch (IOException e) {e.printStackTrace();}
			
		}
		
	}

}
