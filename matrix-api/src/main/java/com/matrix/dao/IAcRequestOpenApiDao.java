package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.AcRequestOpenApi;
import com.matrix.pojo.view.AcRequestOpenApiView;

public interface IAcRequestOpenApiDao extends IBaseDao<AcRequestOpenApi, Integer> {

	public List<AcRequestOpenApiView> findListById(Integer acRequestInfoId); 
}
