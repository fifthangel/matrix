package com.matrix.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.interfaces.IBaseService;
import com.matrix.pojo.entity.TcLandedProperty;

public interface ITcLandedPropertyService  extends IBaseService<TcLandedProperty, Integer>{

	public String pageDemoLandedProperty(ModelMap model); 

	public JSONObject ajaxDemoLandedPropertyList(TcLandedProperty entity, HttpServletRequest request, HttpSession session); 

}
