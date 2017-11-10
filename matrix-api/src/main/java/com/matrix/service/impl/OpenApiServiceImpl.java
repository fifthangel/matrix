package com.matrix.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseClass;
import com.matrix.cache.CacheLaunch;
import com.matrix.cache.enums.DCacheEnum;
import com.matrix.cache.inf.IBaseLaunch;
import com.matrix.cache.inf.ICacheFactory;
import com.matrix.pojo.dto.Head;
import com.matrix.service.IOpenApiService;
import com.matrix.util.SignUtil;

@Service("openApiService")
public class OpenApiServiceImpl extends BaseClass implements IOpenApiService {

	private IBaseLaunch<ICacheFactory> launch = CacheLaunch.getInstance().Launch();
	
	/**
	 * @description: 开放接口入口描述 
	 *
	 * @param key 请求秘钥
	 * @param value 请求秘钥加密后的消息体    平台分配给第三方的秘钥+接口名称+时间(精确到小时，格式为：yyyy-MM-dd-HH) 做md5后的结果
	 * @param json 请求消息体
	 * @author Yangcl
	 * @date 2017年11月10日 上午11:49:21 
	 * @version 1.0.0
	 */
	public JSONObject apiOpenService(HttpServletRequest request, HttpServletResponse response , String key , String value , String json) {
		
		Head dto = JSONObject.parseObject(JSONObject.parseObject(json).getString("head"), Head.class); 
		JSONObject result = this.apiKeyValidata(key, value, dto);
		if (result.getString("status").equals("success")){  
			response.setHeader("Access-Control-Allow-Origin", "*"); // 解决跨域访问限制
			response.setContentType("application/json;charset=UTF-8");
			response.setHeader("Access-Control-Allow-Methods", "POST");  // , GET, OPTIONS, DELETE
			response.setHeader("Access-Control-Max-Age", "3600");  // 头指定了preflight请求的结果能够被缓存3600s
			// 标明服务器支持的所有头信息字段
			response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
			// Access-Control-Allow-Credentials true 则允许浏览器读取response的内容。当用在对preflight预检测请求的响应中时，它指定了实际的请求是否可以使用credentials。
			//请注意：简单 GET 请求不会被预检；如果对此类请求的响应中不包含该字段，这个响应将被忽略掉，并且浏览器也不会将相应内容返回给网页。
			response.setHeader("Access-Control-Allow-Credentials", "true"); 
			response.setHeader("XDomainRequestAllowed","1");
			
			// TODO 准备调用接口服务
			
			return result;
		}else { 
			return result;
		} 
	}
	
	/**
	 * @description: 开始进行md5签名验证
	 *
	 * @param key
	 * @param value
	 * @param json 
	 * @author Yangcl
	 * @date 2017年11月10日 下午3:59:15 
	 * @version 1.0.0
	 */
	private JSONObject apiKeyValidata(String key ,  String value , Head dto) {
		JSONObject result = new JSONObject();
		if(StringUtils.isBlank(dto.getTarget())) {  
			result.put("status", "error");
			result.put("code", "10003");
			result.put("msg", this.getInfo(600010003));  // 非法的请求数据结构，缺少所访问的接口名。
			return result;
		}
		
		
		
		
		String val = launch.loadDictCache(DCacheEnum.ApiKey).get(key);
		if(StringUtils.isBlank(val)) {
			result.put("status", "error");
			result.put("code", "10001");
			result.put("msg", this.getInfo(600010001));  // 非法的请求! 您请求的公钥未包含在我们的系统中.
			return result;
		}
		JSONObject cache = JSONObject.parseObject(val);
		if(StringUtils.isBlank(cache.getString("value"))) {
			result.put("status", "error");
			result.put("code", "10002");
			result.put("msg", this.getInfo(600010002));  // 系统秘钥数据为空，请联系开发人员，为您带来不便请谅解!
			return result;
		}
		
		return result;
	}
	

	/**
	 * @descriptions api权限验证 
	 *
	 * @param key 所属项目名称，在config.matrix-api中会定义每一个项目的名称以及为他分配的验证秘钥
	 * 						 media_platform_dev=AL92395TLW321K2312K14J
	 * @param value md5加密验证的结果
	 * @param action ：controller 方法名
	 * @param remark ：备注描述，可以为空
	 * 
	 * @date 2017年8月4日 上午10:15:42
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	private JSONObject apiAuthorityValidata(String key , String value , Logger logger , String action , String remark){
		JSONObject re = new JSONObject();
		String password = this.getConfig("matrix-core." + key + this.getConfig("matrix-core.model"));  // 如：media_platform_dev=AL92395TLW321K2312K14J
		String value_ = SignUtil.md5Sign(key + password);
		if(value.equals(value_)){
			logger.info( key + " - 尝试请求 - " + action + "() - 方法 - " + remark);  
			re.put("status", "success");
		}else{
			re.put("status", "error");
			re.put("msg", this.getInfo(100090006)); 
		}
		return re;
	}
}


















