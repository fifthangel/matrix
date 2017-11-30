package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.AcApiDomain;
import com.matrix.pojo.view.AcApiDomainView;

public interface IAcApiDomainDao extends IBaseDao<AcApiDomain, Integer>{

	public List<AcApiDomainView> selectByApiInfoId(Integer apiInfoId);

	public void deleteByApiInfoId(Integer apiInfoId);   
    
}