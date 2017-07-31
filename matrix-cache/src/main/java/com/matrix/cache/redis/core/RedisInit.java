package com.matrix.cache.redis.core;

import org.apache.commons.lang3.StringUtils;

import com.matrix.base.BaseClass;
import com.matrix.cache.inf.IRedisCall;

public class RedisInit extends BaseClass {
	private static RedisCacheConfig CONFIG = new RedisCacheConfig();
	
	private static String model = "";
	
	public RedisInit(){
		model = this.getConfig("matrix-core.model");
	}
	
	/**
	 * @descriptions 读取 config.matrix-cache.properties 中的Redis默认配置路径 cache_url_default
	 * 
	 * @date 2016年8月1日上午10:29:53
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public static IRedisCall getDefault() {
		if(StringUtils.isBlank(model)){
			new RedisInit();
		}
		return CONFIG.getValue(model);   // matrix-cache.cache_url_  |dev or master
	}
	
	/**
	 * @descriptions 读取 config.matrix-cache.properties 中的Redis其他自定义的配置路径 示例如右：cache_url_other
	 * 此方法项目中暂无应用，作为示例扩展。
	 * 如果您是第一个使用了此方法的人，请备注为已使用。
	 * 
	 * @date 2016年8月1日上午10:29:53
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public static IRedisCall getOtherConfig() {
		return CONFIG.getValue("matrix-cache.cache_url_other");
	}
}
