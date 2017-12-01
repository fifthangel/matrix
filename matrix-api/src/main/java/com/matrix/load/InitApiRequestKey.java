package com.matrix.load;

import com.matrix.base.interfaces.ILoadCache;
/**
 * @description: init  ApiRequestKey to cache
 * key: xd-ApiRequestKey-133C9C129D53
 * value:
				 {
				    "key": "133C9C129D53",     -------------------- 接口调用方公钥
				    "value": "6DFA608D49324E47A5D69A13523BDFDA",     -------------------- 接口调用方私钥 
				    "flag": 1,     -------------------- 接口调用方状态：启用1 禁用 0
				    "atype": "private",     -------------------- 接口调用方分类。private:开放给公司内部接口请求者| public:公开，即注册给第三方的接口请求者
				    "organization": "IOS乘客端",
				    "createUserId": 1,
				    "createTime": 1512119626795,
				    "updateUserId": 1,
				    "updateTime": 1512119627160,
				    "id": 1,
				    "list": [] -------------------- 如果atype=public，此处应有对其开放的接口访问标识列表
				}
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2017年11月20日 下午9:34:34 
 * @version 1.0.0.1
 */
public class InitApiRequestKey implements ILoadCache {

	// TODO 等待这个缓存结构设计完成。
	@Override
	public String load(String key, String field) {
		
		return "";
	}

}
