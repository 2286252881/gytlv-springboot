package com.zh.gytlv.config.quartz;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zh.gytlv.utils.DateUtil;

@Component
public class Jobs  {
	public final static long ONE_Minute =  60 * 1000;
	
	
	//fixedRate就是每多次分钟一次，不论你业务执行花费了多少时间。我都是1分钟执行1次
	/*@Scheduled(fixedDelay=ONE_Minute)
    public void fixedDelayJob(){
        System.out.println(DateUtil.formatDateByFormat(new Date(), DateUtil.DATETIME_FORMAT)+" >>fixedDelay执行....");
    }*/
	
	//fixedDelay是当任务执行完毕后1分钟在执行。
	/*@Scheduled(fixedRate=ONE_Minute)
    public void fixedRateJob(){
        System.out.println(DateUtil.formatDateByFormat(new Date(), DateUtil.DATETIME_FORMAT)+" >>fixedRate执行....");
    }*/
    @Scheduled(cron="0 0 12 * * ?")
    public void cronJob(){
        System.out.println(DateUtil.formatDateByFormat(new Date(), DateUtil.DATETIME_FORMAT)+" >>cron执行....");
    }

}
