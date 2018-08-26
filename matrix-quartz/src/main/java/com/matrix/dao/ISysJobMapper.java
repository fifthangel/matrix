package com.matrix.dao;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.dto.SysJobDto;
import com.matrix.pojo.entity.SysJob;
import com.matrix.pojo.view.SysJobView;

public interface ISysJobMapper extends IBaseDao<Long , SysJob, SysJobDto , SysJobView> {
	
//	public Integer updateSelectiveByUuid(SysJob entity);

//	public List<SysJob> findListByDto(SysJobDto dto); 
	
}