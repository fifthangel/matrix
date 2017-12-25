package com.matrix.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

public interface IApiService {

	public JSONObject apiService(HttpServletRequest request, HttpServletResponse response, String json); 

}
