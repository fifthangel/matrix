package com.matrix.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseController;
import com.matrix.service.IFileUploadService;

/**
 * @descriptions 上传文件相关接口 | 所有上传的文件必须以二进制方式上传
 * 		所有的文件上传操作每次只允许上传一个文件，不允许多个文件同时提交
 *
 * @author Yangcl 
 * @home https://github.com/PowerYangcl
 * @date 2017年7月31日 下午10:34:37
 * @version 1.0.1
 */
@Controller
@RequestMapping("file")
public class FileUploadController  extends BaseController{

	private static Logger logger=Logger.getLogger(FileUploadController.class);
	
	@Autowired
	private IFileUploadService service;
	
	/**
	 * @descriptions 支持其他web系统上传文件到公司指定文件服务器
	 *
	 * @param request 页面提交的数据
	 * @param type 上传文件类型 |image or word or excel or html or vedio
	 * @date 2017年7月31日 下午10:42:29
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "api_file_remote_upload", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject apiFileRemoteUpload(HttpServletRequest request , String type){
		return service.apiFileRemoteUpload(request , type);
	}
}































