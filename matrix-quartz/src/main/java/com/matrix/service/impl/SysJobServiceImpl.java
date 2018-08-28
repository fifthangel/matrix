package com.matrix.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.matrix.base.BaseServiceImpl;
import com.matrix.dao.ISysJobMapper;
import com.matrix.pojo.dto.SysJobDto;
import com.matrix.pojo.entity.SysJob;
import com.matrix.pojo.view.SysJobView;
import com.matrix.service.ISysJobService;

@Service("sysJobService")
public class SysJobServiceImpl  extends BaseServiceImpl<Long , SysJob, SysJobDto , SysJobView> implements ISysJobService {

	@Resource
	private ISysJobMapper sysJobMapper;
	
	
	
	
	
}
