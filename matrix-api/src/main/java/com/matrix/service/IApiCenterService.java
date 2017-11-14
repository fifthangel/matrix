package com.matrix.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.interfaces.IBaseService;
import com.matrix.pojo.entity.AcApiInfo;
import com.matrix.pojo.entity.AcApiProject;

public interface IApiCenterService extends IBaseService<AcApiInfo, Integer>{

	// ac_api_project
	public String apiProjectList();
	public JSONObject ajaxApiProjectList(AcApiProject entity, HttpServletRequest request, HttpSession session);
	public JSONObject ajaxApiProjectAdd(AcApiProject entity, HttpSession session);
	public JSONObject ajaxApiProjectEdit(AcApiProject entity, HttpSession session);    

}