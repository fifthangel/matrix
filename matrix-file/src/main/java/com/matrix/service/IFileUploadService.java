package com.matrix.service;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

public interface IFileUploadService {

	public JSONObject apiFileRemoteUpload(HttpServletRequest request, String type);

}
