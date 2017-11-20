package com.matrix.cache.servletContext.core;

import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;

import com.matrix.base.interfaces.ILoadCache;
import com.matrix.cache.CacheLaunch;
import com.matrix.cache.inf.ICacheFactory;
import com.matrix.map.MDataMap;

/**
 * @description: 针对缓存提供基本的增删改查操作 
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2017年4月12日 下午6:31:56 
 * @version 1.0.0
 */
public class ContextFactory implements ICacheFactory{
	
	private String baseKey = "";
	private String load = "";  // ILoadCache		
	private ServletContext context = ContextCore.getInstance().getApplication();

	public ContextFactory(String baseKey , String load) { 
		this.baseKey = baseKey;
		this.load = "com.matrix.load." + load;
	}
	
	/////////////////////////////////////////////////////////////////// 基础json //////////////////////////////////////////////////////////////////////
	public String get(String key){
		String value = (String) context.getAttribute(baseKey + key);
		if(StringUtils.isBlank(value)) {
			synchronized (CacheLaunch.class) {
				value = (String) context.getAttribute(baseKey + key);
				if(StringUtils.isBlank(value)) {
					if(this.load.length() == 16) {
						return "";
					}
					try {
						Class<?> clazz = Class.forName(load);   
						if (clazz != null && clazz.getDeclaredMethods() != null){
							ILoadCache cache = (ILoadCache) clazz.newInstance();
							return cache.load(key , "");
						}else {
							return "";
						}
					}catch (Exception e) {
						e.printStackTrace();
						return "";
					}
				}else {
					return value;
				}
			}
		}else {
			return value;
		}
	}
	
	public String set(String key , String value){
		context.setAttribute(baseKey + key, value);
		return "1";
	}
	
	public Long del(String key){
		context.removeAttribute(baseKey + key);
		return (long) 1;  
	}

    /////////////////////////////////////////////////////////////////// 哈希存储 //////////////////////////////////////////////////////////////////////
	public String hget(String key, String field) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Long hset(String key, String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Long hdel(String key, String field) {
		// TODO Auto-generated method stub
		return null;
	}

	public MDataMap hgetAll(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	
    /////////////////////////////////////////////////////////////////// 其他功能 //////////////////////////////////////////////////////////////////////
	@Override
	public Long incrBy(String key, long integer) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String setex(String key, int seconds, String value) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Long setnx(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean exists(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Long hincrBy(String key, String field, long value) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Long expire(String key, int seconds) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Long ttl(String key) {
		// TODO Auto-generated method stub
		return null;
	}


	

	
	
	
}


























