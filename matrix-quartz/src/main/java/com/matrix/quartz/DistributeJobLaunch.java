package com.matrix.quartz;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.matrix.annotation.Inject;
import com.matrix.base.interfaces.IBaseJob;
import com.matrix.cache.CacheLaunch;
import com.matrix.cache.enums.DCacheEnum;
import com.matrix.cache.inf.IBaseLaunch;
import com.matrix.cache.inf.ICacheFactory;
import com.matrix.pojo.entity.SysJob;
import com.matrix.quartz.model.MJobInfo;
import com.matrix.quartz.support.JobSupport;
import com.matrix.service.IJobInitService;
import com.matrix.system.init.RootInit;

/**
 * @description: 分布式定时任务实例化。定时任务区分运行组，运行组包含服务器列表信息。
 *
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2018年9月1日 下午12:40:49 
 * @version 1.0.0.1
 */
public class DistributeJobLaunch extends RootInit{
	
	private IBaseLaunch<ICacheFactory> launch = CacheLaunch.getInstance().Launch();
	private static Logger logger = Logger.getLogger(DistributeJobLaunch.class);  
	
	
	@Inject
	private IJobInitService jobInitService;
	
	
	/**
	 * @description: 初始化定时任务|根据定时任务项目所部署的服务器IP地址段不同，有选择行的根据
	 * 	ip地址来进行定时任务的初始化工作。
	 *
	 * @author Yangcl
	 * @date 2018年9月1日 下午12:56:01 
	 * @version 1.0.0.1
	 */
	public boolean onInit() {
		boolean flag = true;
        try {
        	InetAddress addr = InetAddress.getLocalHost();  
        	String ip = addr.getHostAddress().toString(); 				// 获取本机	ip 
        	
        	List<SysJob> list = new ArrayList<SysJob>();  
        	List<SysJob> list_ = jobInitService.findSysJobList();
        	if(list_ == null || list_.size() == 0) {
        		return true;
        	}
        	for( SysJob s : list_ ){ 
        		String jobjson = launch.loadDictCache(DCacheEnum.SysJob , "SysJobInit").get( String.valueOf(s.getId()) ); 
    			if(StringUtils.isNotBlank(jobjson)){
    				JSONObject job = JSONObject.parseObject(jobjson);
    				if(ip.equals(job.getString("ip"))){		// 根据ip地址过滤定时任务
    					list.add(s);
    				}
    			}
        	}
        	
        	if(list == null || list.size() == 0) {
        		return true;
        	}
        	for( SysJob s : list ) {
        		String triger = s.getJobTriger();
        		if(StringUtils.isBlank(triger)) {	// 如果事件定义的时间为空 则系统加载时则执行|数据库字段定义为非空，此种情况不会发生，但保留情况处理
        			IBaseJob iJob = (IBaseJob) ClassUtils.getClass(s.getJobClass()).newInstance();
					iJob.doExecute(null);
					this.getLogger(logger).logInfo(200010004 , s.getJobTitle());  
        		}else {
        			MJobInfo mJobInfo = new MJobInfo();
    				mJobInfo.setJobClass(s.getJobClass());
    				mJobInfo.setJobTriger(s.getJobTriger());
    				mJobInfo.setJobName(s.getJobName());
    				JobSupport.getInstance().addJob(mJobInfo);
    				this.getLogger(logger).logInfo(200010005 , s.getJobName() , s.getJobTitle() , s.getJobTriger() );  // 开始加载任务{0}，任务执行周期为{1}
        		}
        	}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return flag;
	}
	
	
	public boolean onDestory() {
		
		return true;
	}

}


































































