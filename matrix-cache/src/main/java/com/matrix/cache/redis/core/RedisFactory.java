package com.matrix.cache.redis.core;

import org.apache.commons.lang3.StringUtils;

import com.matrix.base.interfaces.ILoadCache;
import com.matrix.cache.CacheLaunch;
import com.matrix.cache.inf.ICacheFactory;
import com.matrix.map.MDataMap;

/**
 * @descriptions 针对缓存提供基本的增删改查操作 
 *
 * @author Yangcl 
 * @home https://github.com/PowerYangcl
 * @date 2016年12月12日 下午10:50:56
 * @version 1.0.1
 */
public class RedisFactory implements ICacheFactory{  // IRedisCall , 

	private String baseKey = "";
	private String load = "";  // ILoadCache		
	public RedisFactory(String sKey , String load) {
		if(StringUtils.isBlank(load)) {
			load = "";
		}
		baseKey = sKey;
		this.load = "com.matrix.load." + load;
	}
	
	/////////////////////////////////////////////////////////////////// 基础json //////////////////////////////////////////////////////////////////////
	public String get(String key) {
		String value = RedisInit.getDefault().get(baseKey + key);
		if(StringUtils.isBlank(value)) {
			synchronized (CacheLaunch.class) {
				value = RedisInit.getDefault().get(baseKey + key);
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
	
	public String set(String key, String value) {
		return RedisInit.getDefault().set(baseKey + key, value);
	}

	public Long del(String key) {
		return RedisInit.getDefault().del(baseKey + key);
	}
	
    /////////////////////////////////////////////////////////////////// 哈希存储 //////////////////////////////////////////////////////////////////////
	public String hget(final String key, final String field) {
		return RedisInit.getDefault().hget(baseKey + key , field); 
	}
	
	public Long hset(String key, String field, String value) {
		return RedisInit.getDefault().hset(baseKey + key , field , value); 
	}
	
	public Long hdel(String key, String field) {
		return RedisInit.getDefault().hdel(baseKey + key, field);
	}
	
	public MDataMap hgetAll(String key) {
		return (MDataMap)RedisInit.getDefault().hgetAll(baseKey + key);
	}
	
    /////////////////////////////////////////////////////////////////// 其他功能 //////////////////////////////////////////////////////////////////////
	public String setex(String key, int seconds, String value) {
		return RedisInit.getDefault().setex(baseKey + key, seconds, value);
	}
	
	public Long incrBy(String key, long integer) {
		return RedisInit.getDefault().incrBy(baseKey + key, integer);
	}

	public Long setnx(String key, String value) {
		return RedisInit.getDefault().setnx(baseKey + key, value);
	}

	public Boolean exists(String key) {
		return RedisInit.getDefault().exists(baseKey + key);
	}

	public Long hincrBy(String key, String field, long value) {
		return RedisInit.getDefault().hincrBy(baseKey + key, field, value);
	}

	public Long expire(String key, int seconds) {
		return RedisInit.getDefault().expire(baseKey + key, seconds);
	}

	public Long ttl(String key) {
		return RedisInit.getDefault().ttl(baseKey + key);
	}

}














