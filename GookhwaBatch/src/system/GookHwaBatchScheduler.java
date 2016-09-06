package system;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class GookHwaBatchScheduler {

	private Map schedulerMap = new HashMap();
	
	private static GookHwaBatchScheduler instance;
	

	public static GookHwaBatchScheduler getInstance () {
		
		if(instance==null){
			instance= new GookHwaBatchScheduler();
		}
		return instance;
	}	
	public GookHwaBatchScheduler(){
		
		
	}
	public Scheduler makeScheduler (Class targetClass,String cron) {
		// TODO Auto-generated constructor stub

		Scheduler sch = null;
		
		try {
			
			String jobTitle=("job"+getSchedulCount()+1);
			String groupTitle=("group"+getSchedulCount()+1);
			
			JobDetail job = JobBuilder.newJob(targetClass).withIdentity(jobTitle, groupTitle).build();
			
			CronTrigger cronTrigger =  TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
			
			SchedulerFactory schFactory = new StdSchedulerFactory();

			sch = schFactory.getScheduler();

			//스케줄러 시작

			sch.scheduleJob(job, cronTrigger);	
			
			schedulerMap.put(schedulerMap, sch);

			return sch;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return sch;
	}

	public int getSchedulCount(){
		
		return schedulerMap.size();
	}

}
