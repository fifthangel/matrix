package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.AcApiInfo;
import com.matrix.pojo.view.ApiTreeView;

public interface IAcApiInfoDao extends IBaseDao<AcApiInfo , Integer>{

	public List<ApiTreeView> findApiInfoList(AcApiInfo e); 
    
}