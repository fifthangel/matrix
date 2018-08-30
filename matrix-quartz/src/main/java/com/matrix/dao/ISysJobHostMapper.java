package com.matrix.dao;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.dto.SysJobHostDto;
import com.matrix.pojo.entity.SysJobHost;
import com.matrix.pojo.view.SysJobHostView;



public interface ISysJobHostMapper extends IBaseDao<Long , SysJobHost, SysJobHostDto , SysJobHostView>{ 
	
}