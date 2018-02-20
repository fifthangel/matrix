package com.matrix.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.matrix.base.BaseServiceImpl;
import com.matrix.dao.ITcLandedPropertyDao;
import com.matrix.pojo.entity.TcLandedProperty;
import com.matrix.service.ITcLandedPropertyService;

@Service("tcLandedPropertyService")
public class TcLandedPropertyServiceImpl extends BaseServiceImpl<TcLandedProperty , Integer> implements ITcLandedPropertyService {

	@Resource
	private ITcLandedPropertyDao dao;
	
	
	
	
}
