package com.matrix.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

public interface IOpenApiService {

	public JSONObject apiOpenService(HttpServletRequest request, HttpServletResponse response, String key , String value , String json); 

}
