package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.AcIncludeDomain;
import com.matrix.pojo.view.AcIncludeDomainView;

public interface IAcIncludeDomainDao extends IBaseDao<AcIncludeDomain, Integer>{

	public List<AcIncludeDomainView> queryPageList(AcIncludeDomain entity); 

}