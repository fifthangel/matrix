package com.matrix.base;

import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.matrix.pojo.view.McUserInfoView;
import com.matrix.util.SignUtil;

public class BaseController extends BaseClass{

	/**
	 * @description: 用户行为日志记录
	 * 	super.userBehavior(session, logger, "", "");
	 * @param session
	 * @param logger
	 * @param action ：controller 方法名
	 * @param remark ：备注描述，可以为空
	 * 
	 * @author Yangcl 
	 * @date 2017年5月25日 下午2:48:11 
	 * @version 1.0.0.1
	 */
	public boolean userBehavior(HttpSession session , Logger logger , String action , String remark){
		String name = "未授权用户";
		McUserInfoView e = (McUserInfoView) session.getAttribute("userInfo");
		if(e != null){
			name = "用户:  " + e.getUserName();
		}
		logger.info( name + " - 尝试请求 - " + action + "() - 方法 - " + remark); 
		
		
		// TODO 开始拦截用户的按钮权限 2017-10-20
		
		
		return true;
	}
	
	/**
	 * @descriptions api权限验证|内网web项目间的服务访问跟踪|非对外开放类型的api适用此方法
	 *
	 * @param key 所属项目名称，在config.matrix-file中会定义每一个项目的名称以及为他分配的验证秘钥
	 * @param value md5加密验证的结果
	 * @param action ：controller 方法名
	 * @param remark ：备注描述，可以为空
	 * 
	 * @date 2017年8月4日 上午10:15:42
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public JSONObject apiAuthorityValidata(String key , String value , Logger logger , String action , String remark){
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























