package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.AcApiProject;
import com.matrix.pojo.view.AcApiProjectListView;

public interface IAcApiProjectDao extends IBaseDao<AcApiProject, Integer>{

	public List<AcApiProjectListView> queryPageList(AcApiProject entity);

	public List<AcApiProjectListView> findAll();  
	
}