package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.AcRequestInfo;
import com.matrix.pojo.view.AcRequestInfoView;

public interface IAcRequestInfoDao extends IBaseDao<AcRequestInfo, Integer>{

	public List<AcRequestInfoView> queryPageList(AcRequestInfo entity); 
	public AcRequestInfo findByKey(String key);
    
}