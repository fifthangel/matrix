package com.matrix.processor.privates.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseClass;
import com.matrix.base.IBaseApi;

/**
 * @description: 这是一个测试私有接口处理的类 
 *
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2017年11月13日 下午12:41:42 
 * @version 1.0.0
 */
public class TestPrivateProcessor extends BaseClass implements IBaseApi {

	@Override
	public JSONObject processor(HttpServletRequest request, HttpServletResponse response, JSONObject data) {
		// TODO Auto-generated method stub
		return null;
	}

}
