package com.matrix.quartz.job;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;

import com.matrix.helper.DistributedLockHelper;

/**
 * @description: 这是第二个定时任务的测试类，用于验证定时任务模块是否稳定
 * 
 * @rglist matrix-quartz-test
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2016年11月28日 下午2:16:04 
 * @version 1.0.0
 */
public class JobForTestTwo extends RootJob {
	private static Logger logger = Logger.getLogger(JobForTestTwo.class);
	
	public void doExecute(JobExecutionContext context) {
		String lockCode = "";
		try {
			lockCode = DistributedLockHelper.getInstance().addLock(50 , "JobForTestTwo");	// 分布式锁定
			if (StringUtils.isNotBlank(lockCode)){
				String rglist = "***************** 所属任务组：matrix-quartz-test"; 
				this.getLogger(logger).logInfo(999990001 , "@ JobForTestTwo.java is running" , rglist); 
			}else{
				this.getLogger(logger).logInfo(999990002, "【JobForTestTwo】"); 
			}
		}catch (Exception e) {
			DistributedLockHelper.getInstance().unLock(lockCode);
			e.printStackTrace();
		}
	}

}
