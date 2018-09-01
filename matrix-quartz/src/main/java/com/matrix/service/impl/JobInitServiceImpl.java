package com.matrix.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.matrix.dao.ISysJobMapper;
import com.matrix.service.IJobInitService;


/**
 * @description: 分布式定时任务初始化执行服务实现类
 *
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2018年9月1日 下午12:54:49 
 * @version 1.0.0.1
 */
@Service("jobInitService")
public class JobInitServiceImpl implements IJobInitService {

	@Resource
	private ISysJobMapper sysJobMapper;
	
	
	
	
}













































