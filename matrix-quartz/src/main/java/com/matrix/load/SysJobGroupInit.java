package com.matrix.load;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.matrix.annotation.Inject;
import com.matrix.base.BaseClass;
import com.matrix.base.interfaces.ILoadCache;
import com.matrix.cache.CacheLaunch;
import com.matrix.cache.enums.DCacheEnum;
import com.matrix.cache.inf.IBaseLaunch;
import com.matrix.cache.inf.ICacheFactory;
import com.matrix.dao.ISysJobGroupMapper;
import com.matrix.pojo.entity.SysJobGroup;


/**
 * @description: 获取定时任务组的缓存信息
 *		key: xd-SysJobGroup-298357293792834
 *
 *		TODO 补充value!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2018年9月1日 下午4:35:04 
 * @version 1.0.0.1
 */
public class SysJobGroupInit extends BaseClass implements ILoadCache{

	private IBaseLaunch<ICacheFactory> launch = CacheLaunch.getInstance().Launch();
	
	@Inject
	private ISysJobGroupMapper sysJobGroupMapper;
	
	
	public String load(String key, String field) {
		JSONObject result = new JSONObject();
		SysJobGroup s = sysJobGroupMapper.find(Long.valueOf(key));
		if(s != null) {
			result.put("groupName", s.getGroupName());
			result.put("remark", s.getRemark());
			
			List<String> list = new ArrayList<>();
			String ips = launch.loadDictCache(DCacheEnum.SysJobHost, "SysJobHostInit").get(key);
			if(StringUtils.isNotBlank(ips)) {
				list = JSONArray.parseArray(ips , String.class);
			}
			result.put("ipList", list);
			
			String value = result.toJSONString();
			launch.loadDictCache(DCacheEnum.SysJobGroup , null).set(key, value);
			return value;
		}
		
		return "";
	}

}
































