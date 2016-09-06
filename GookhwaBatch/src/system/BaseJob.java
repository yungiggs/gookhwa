package system;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.ibatis.sqlmap.client.SqlMapClient;

import sqlmap.SqlMapConfig;
import util.GookHwaUtil;
import util.StringUtil;

public abstract class BaseJob implements Job{

	final static Logger logger = Logger.getLogger(BaseJob.class);
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		
	
	}


}
