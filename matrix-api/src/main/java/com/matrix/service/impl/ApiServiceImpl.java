package com.matrix.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseClass;
import com.matrix.base.interfaces.IBaseProcessor;
import com.matrix.base.interfaces.ILoadCache;
import com.matrix.cache.CacheLaunch;
import com.matrix.cache.enums.DCacheEnum;
import com.matrix.cache.inf.IBaseLaunch;
import com.matrix.cache.inf.ICacheFactory;
import com.matrix.pojo.dto.Head;
import com.matrix.service.IApiService;
import com.matrix.util.SignUtil;

@Service("apiService")
public class ApiServiceImpl extends BaseClass implements IApiService {

	private IBaseLaunch<ICacheFactory> launch = CacheLaunch.getInstance().Launch();
	
	/**
	 * @description: 开放接口入口|接口类型 private:私有 即公司内部使用的接口| public:公开，即开放给第三方的接口
	 *
	 * @param key 请求秘钥
	 * @param value 请求秘钥加密后的消息体    平台分配给第三方的秘钥+接口名称+请求发起时间(精确到小时，格式为：yyyy-MM-dd HH:mm:ss) 做md5后的结果
	 * @param json 请求消息体
	 * @author Yangcl
	 * @date 2017年11月10日 上午11:49:21 
	 * @version 1.0.0
	 */
	public JSONObject apiService(HttpServletRequest request, HttpServletResponse response , String json) {
		JSONObject requester = JSONObject.parseObject(json);
		Head dto = JSONObject.parseObject(requester.getString("head"), Head.class); 
		JSONObject result = this.checkRequest(request, response, dto);
		if (result.getString("status").equals("success")){  
			try {
				// 备调用接口处理类  IBaseProcessor          
				Class<?> clazz = Class.forName("com.matrix.processor." + result.getString("processor"));   
				if (clazz != null && clazz.getDeclaredMethods() != null){
					IBaseProcessor iprocessor = (IBaseProcessor) clazz.newInstance();
					return iprocessor.processor(request , response , requester);  
				}else {
					JSONObject err = new JSONObject();
					err.put("status", "error");
					err.put("code", "10010");
					err.put("msg", this.getInfo(600010010 , dto.getTarget()));  // 600010010=系统错误, 未找到{0}接口对应的处理类.请联系开发人员!
					return err;
				}
			}catch (Exception e) {
				e.printStackTrace();
				JSONObject err = new JSONObject();
				err.put("status", "error");
				err.put("code", "10010");
				err.put("msg", this.getInfo(600010011));  // 600010011=系统错误, 请联系开发人员!
				return err;
			}
		}else { 
			return result;
		}
	}
	
	/**
	 * @description: 开始进行md5签名验证|如果成功则返回ApiInfo缓存Json结构体
	 *
	 * @param key
	 * @param value
	 * @param json 
	 * @author Yangcl
	 * @date 2017年11月10日 下午3:59:15 
	 * @version 1.0.0
	 */
	private JSONObject checkRequest(HttpServletRequest request, HttpServletResponse response , Head dto) {
		JSONObject result = new JSONObject();
		String key = dto.getKey();
		String value = dto.getValue();
		if(StringUtils.isAnyBlank(key , value)) {
			result.put("status", "error");
			result.put("code", "10016");  
			result.put("msg", this.getInfo(600010016));  // 600010016=非法的请求数据结构，缺少key或value
			return result;
		}
		if(StringUtils.isBlank(dto.getTarget())) {  
			result.put("status", "error");
			result.put("code", "10003");
			result.put("msg", this.getInfo(600010003));  // 非法的请求数据结构，缺少所访问的接口名。
			return result;
		}
		
		String requestInfo = launch.loadDictCache(DCacheEnum.ApiRequester , "InitApiRequester").get(key);  // ac_request_info表的缓存
		if(StringUtils.isBlank(requestInfo)) {
			result.put("status", "error");
			result.put("code", "10012"); 
			result.put("msg", this.getInfo(600010012));  // 非法的请求! 您请求的公钥未包含在我们的系统中.
			return result;
		}
		JSONObject requester = JSONObject.parseObject(requestInfo);
		if(StringUtils.isBlank(requester.getString("value"))) {
			result.put("status", "error");
			result.put("code", "10002");
			result.put("msg", this.getInfo(600010002));  // 系统秘钥数据为空，请联系开发人员，为您带来不便请谅解!
			return result;
		}
		
		String md5 = SignUtil.md5Sign( requester.getString("value") + dto.getTarget()	+ dto.getRequestTime() ); 
		if( !value.equals(md5) ){
			result.put("status", "error");
			result.put("code", "10005");
			result.put("msg", this.getInfo(600010005));  // 秘钥验证失败
			return result;
		}
		
		String apiInfoStr = launch.loadDictCache(DCacheEnum.ApiInfo , "InitApiInfo").get(dto.getTarget()); 
		if(StringUtils.isBlank(apiInfoStr)){
			result.put("status", "error");
			result.put("code", "10014"); 
			result.put("msg", this.getInfo(600010014));  // 600010014=系统未检测到您所访问的接口
			return result;
		} 
		JSONObject apiInfo = JSONObject.parseObject(apiInfoStr);
		if(!requester.getString("atype").equals(apiInfo.getString("atype"))) {
			result.put("status", "error");
			result.put("code", "10007");
			result.put("msg", this.getInfo(600010007));  // 600010007=非法的请求! 您的请求域不匹配!
			return result;
		}
		if(apiInfo.getInteger("discard") == 0) {
			result.put("status", "error");
			result.put("code", "10013");
			result.put("msg", this.getInfo(600010013));  // 600010013=您所访问的接口已停用
			return result;
		}
		if(StringUtils.isBlank(apiInfo.getString("processor"))) {
			result.put("status", "error");
			result.put("code", "10014"); 
			result.put("msg", this.getInfo(600010015));  // 600010015=系统未检测到对应接口处理类!请联系开发人员!
			return result;
		}
		
		if(requester.getString("atype").equals("public")) {
			// TODO 遍历该请求者是否拥有该接口的请求权限。
		}
		
		String originHeader = request.getHeader("Origin");
		if(!dto.getClient().equals("0") && !dto.getClient().equals("1") && StringUtils.isNotBlank(originHeader)) {
			if(apiInfo.getString("list") == null ||apiInfo.getString("list").length() == 2) {
				result.put("status", "error");
				result.put("code", "10008");
				result.put("msg", this.getInfo(600010008 , dto.getTarget()));  // 600010008=您所请求的接口{0}不支持跨域访问!
				return result;
			}
			if (StringUtils.contains(apiInfo.getString("list"), originHeader)) { 
				response.setHeader("Access-Control-Allow-Origin", originHeader); // 移除跨域访问限制 
			}else {
				result.put("status", "error");
				result.put("code", "10009");
				result.put("msg", this.getInfo(600010009 , dto.getTarget()));  // 600010009=非法的请求!您尚未包含在{0}跨域访问名单中!
				return result;
			}
		}
		
		apiInfo.put("status", "success");
		this.apiRequestLogger(requester, apiInfo); 
		return apiInfo;
	}
	

	/**
	 * @description: 记录请求日志 
	 *
	 * @param requester
	 * @param apiInfo 
	 * @author Yangcl
	 * @date 2017年12月3日 下午9:18:25 
	 * @version 1.0.0.1
	 */
	private void apiRequestLogger(JSONObject requester , JSONObject apiInfo) {
		
	}
}


















