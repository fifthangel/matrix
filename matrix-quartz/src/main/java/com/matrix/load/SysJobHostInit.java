package com.matrix.load;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.matrix.annotation.Inject;
import com.matrix.base.BaseClass;
import com.matrix.base.interfaces.ILoadCache;
import com.matrix.cache.CacheLaunch;
import com.matrix.cache.enums.DCacheEnum;
import com.matrix.cache.inf.IBaseLaunch;
import com.matrix.cache.inf.ICacheFactory;
import com.matrix.dao.ISysJobHostMapper;
import com.matrix.pojo.entity.SysJobHost;

/**
 * @description: 获取分布式定时任务主机地址信息，从缓存。
 *	key: xd-SysJobHost-96346234565766518    |   sys_job_group 表主键 Long型
 *
 * 		TODO 补充value!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 *
 *
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2018年9月1日 下午2:18:46 
 * @version 1.0.0.1
 */
public class SysJobHostInit extends BaseClass implements ILoadCache  {

	private IBaseLaunch<ICacheFactory> launch = CacheLaunch.getInstance().Launch();
	
	@Inject
	private ISysJobHostMapper sysJobHostMapper;
	
	
	@Override
	public String load(String key, String field) {
		List<SysJobHost> list = sysJobHostMapper.findListByForeignKey(Long.valueOf(key));
		if(list != null && list.size() != 0) {
			List<String> ipList = new ArrayList<String>(list.size());
			for(SysJobHost s : list) {
				ipList.add(s.getIp());
			}
			String value = JSONObject.toJSONString(ipList);
			launch.loadDictCache(DCacheEnum.SysJobHost , null).set(key , value); 
			return value;
		}
		
		return "";
	}

}

















































