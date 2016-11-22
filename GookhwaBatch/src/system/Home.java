package system;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.google.gson.Gson;
import com.ibatis.sqlmap.client.SqlMapClient;

import config.ISytemConstant;
import sqlmap.SqlMapConfig;
import util.GookHwaUtil;


public class Home {
	
	final static Logger logger = Logger.getLogger(Home.class);
	
	/*
	 * 1.매시간 정각 타임 틱 발생 
	 * 2.작업 준비 
	 * 2-1 크롤링 돌린다.
	 * 2-2 rdb 저장
	 * 2-3 끝
	 * */
	public static void main(String[] args) {

		GookHwaBatchScheduler batchScheduler = GookHwaBatchScheduler.getInstance();

		try {
			
			logger.info("***��ĳ�췯 ����:0 0 * * * ?");
			
			batchScheduler.makeScheduler(GookHwaLikeBatchJob.class, "0 0/15 * * * ?").start();
			
			
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
