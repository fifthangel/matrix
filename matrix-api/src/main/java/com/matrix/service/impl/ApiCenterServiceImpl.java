package com.matrix.service.impl;

import org.springframework.stereotype.Service;

import com.matrix.base.BaseServiceImpl;
import com.matrix.pojo.entity.AcApiInfo;
import com.matrix.service.IApiCenterService;

@Service("apiCenterService")
public class ApiCenterServiceImpl extends BaseServiceImpl<AcApiInfo, Integer> implements IApiCenterService {
	
}
