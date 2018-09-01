package com.matrix.quartz;

import org.apache.log4j.Logger;

import com.matrix.annotation.Inject;
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
public class DistributeJobInit extends RootInit{
	
	
	private static Logger logger = Logger.getLogger(DistributeJobInit.class);  
	
	
	@Inject
	private IJobInitService jobInitService;
	
	
	/**
	 * @description: 初始化定时任务
	 *
	 * @author Yangcl
	 * @date 2018年9月1日 下午12:56:01 
	 * @version 1.0.0.1
	 */
	public boolean onInit() {
		
		
		
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	public boolean onDestory() {
		
		return false;
	}

}


































































