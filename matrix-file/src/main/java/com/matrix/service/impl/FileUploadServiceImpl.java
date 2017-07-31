package com.matrix.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseClass;
import com.matrix.service.IFileUploadService;

@Service("fileUploadService")
public class FileUploadServiceImpl extends BaseClass implements IFileUploadService{

	@Override
	public JSONObject apiFileRemoteUpload(HttpServletRequest request, String type) {
		JSONObject result = new JSONObject();
		result.put("status", "success"); 
		result.put("msg", "文件上传成功!");
		result.put("title", "");
		result.put("original", "");
		result.put("type","文件后缀名");
		result.put("url", "文件路径名");
		result.put("size", "文件大小");
		
		
		
		
		
		return result;
	}

}
