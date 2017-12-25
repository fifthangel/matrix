package com.matrix.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseController;
import com.matrix.service.IApiService;

/**
 * @description: api入口控制器 
 *
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2017年11月10日 上午10:51:38 
 * @version 1.0.0
 */
@Controller
@RequestMapping("api")
public class ApiController  extends BaseController{

	private static Logger logger=Logger.getLogger(ApiController.class);
	
	@Autowired
	private IApiService service;
	
	
	/**
	 * @description: 开放接口入口描述 
	 *
	 * @param key 请求秘钥
	 * @param value 请求秘钥加密后的消息体
	 * @param json 请求消息体
	 * @author Yangcl
	 * @date 2017年11月10日 上午11:49:21 
	 * @version 1.0.0
	 */
	@RequestMapping(value = "matrix", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject apiService(HttpServletRequest request , HttpServletResponse response , String key , String value, String json){ 
		return service.apiService(request , response , json);
	}
}































