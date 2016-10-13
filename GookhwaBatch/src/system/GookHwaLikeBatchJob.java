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

import config.ISytemConstant;
import config.Status;
import sqlmap.SqlMapConfig;
import util.GookHwaUtil;
import util.StringUtil;

public class GookHwaLikeBatchJob extends BaseJob {
	
	final  Logger logger = Logger.getLogger(GookHwaLikeBatchJob.class);

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		
		logger.info(GookHwaUtil.nowDate()+":¹èÄ¡***************************************");

		
		SqlMapClient sqlmap =	SqlMapConfig.getSqlMapInstance();
		
		List list = new ArrayList();
		Map param = new HashMap();
		
		
		
		try {
			String groupTitle  =  GookHwaUtil.nowDate("yyyy-MM-dd HH")+"/LIKE";
			Map batchParam = new HashMap();
			
			batchParam.put("batch_group_type", "LIKE");
			batchParam.put("batch_group_title",groupTitle);
			batchParam.put("year",GookHwaUtil.nowDate("yyyy"));
			batchParam.put("month",GookHwaUtil.nowDate("MM"));
			batchParam.put("day",GookHwaUtil.nowDate("dd"));
			batchParam.put("hour",GookHwaUtil.nowDate("HH"));

			list	=	sqlmap.queryForList("history.getCherishShareHistoryList");
			
			int bactGroupId 	=	(Integer)sqlmap.insert("history.insertBatchGroup",batchParam);
			
			FBContainer fbContainer = new FBContainer();
			
			for (int i = 0; i < list.size(); i++) {
				
				Map item = (Map)list.get(i);
				
				batchParam.put("post_id",StringUtil.nvl(item, "post_id"));
				batchParam.put("access_token",StringUtil.nvl(item, "access_token"));
				
				Map resultMap = fbContainer.getLikes(ISytemConstant.FACEBOOK_URL, batchParam);
				
				logger.info(resultMap);
				
				Status resultStatus = (Status)resultMap.get("status");
				
				if(resultStatus.equals(Status.SUCCESS)){
					
					List tempList = (List)resultMap.get("result");
					
					logger.info(tempList);
					
					batchParam.put("list", tempList);
					batchParam.put("count", tempList.size());
					
					if(tempList.size()>0){
						sqlmap.insert("history.insertBatchHistory",batchParam);
					}
					sqlmap.update("history.updateShareHisotryCount",batchParam);

							
				}else{

				}
				
				
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
