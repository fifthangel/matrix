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
	 * @返回结构示例：
			 {
			    "status": "success",				状态：success or error
			    "msg": "文件上传完成",
			    "original": "bc.png",			图片原标题
			    "title": "bf92f1576b23470a948dbdcb8feba788.png",  		图片新标题
			    "size": "62091",        文件大小
			    "save": "image/29c10/bf92f1576b23470a948dbdcb8feba788.png",            用于保存到数据库
			    "type": "image",		文件类型
			    "url": "http://192.168.1.34:8080/matrix-file/image/29c10/bf92f1576b23470a948dbdcb8feba788.png",	可访问路径
			    "height": "247"		图片高
			    "width": "163",		图片宽
			}
	 *
	 * @param request 页面提交的数据
	 * @param key 所属项目名称
	 * @param value md5加密验证的结果
	 *   
	 * @date 2017年7月31日 下午10:42:29
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "api_file_remote_upload", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject apiFileRemoteUpload(HttpServletRequest request , String key , String value){
//		JSONObject validate = super.apiAuthorityValidata(key, value, logger, "api_file_remote_upload", "支持其他web系统上传文件到公司指定文件服务器");
//		if(validate.getString("status").equals("error")){           TODO 暂时不用
//			return validate;
//		}
		return service.apiFileRemoteUpload(request);
	}
}































