package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.dto.ApiExampleDto;
import com.matrix.pojo.entity.UserDemo;

public interface IUserDemoDao extends IBaseDao<UserDemo, Integer>{

	public List<UserDemo> findEntityByApiDto(ApiExampleDto dto); 

}
