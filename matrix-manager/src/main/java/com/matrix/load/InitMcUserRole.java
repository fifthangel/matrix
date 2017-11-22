package com.matrix.load;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.matrix.annotation.Inject;
import com.matrix.base.BaseClass;
import com.matrix.base.interfaces.ILoadCache;
import com.matrix.cache.CacheLaunch;
import com.matrix.cache.enums.DCacheEnum;
import com.matrix.cache.inf.IBaseLaunch;
import com.matrix.cache.inf.ICacheFactory;
import com.matrix.dao.IMcUserInfoDao;
import com.matrix.dao.IMcUserRoleDao;
import com.matrix.pojo.cache.McRoleCache;
import com.matrix.pojo.cache.McUserRoleCache;
import com.matrix.pojo.entity.McSysFunction;
import com.matrix.pojo.entity.McUserInfo;
import com.matrix.pojo.entity.McUserRole;
/**
 * @description: 如果缓存取值为空则此处做处理
 *
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2017年11月20日 下午10:09:18 
 * @version 1.0.0.1
 */
public class InitMcUserRole extends BaseClass implements ILoadCache {
	
	private IBaseLaunch<ICacheFactory> launch = CacheLaunch.getInstance().Launch();
	@Inject
	private IMcUserInfoDao userInfoDao;
	@Inject
	private IMcUserRoleDao userRoleDao;
	
	
	@Override
	public String load(String key, String field) {
		// 这里偷懒，沿用LoadCacheUserRole.java中的方法。
		List<McUserInfo> list = userInfoDao.queryPage(null);
		if(list != null && list.size() != 0){
			for(McUserInfo u : list){
				if(u.getId().toString().equals(key)) {
					return this.reloadUserFunction(u.getId()); 
				}
			}
		}
		return "";
	}
	
	private String reloadUserFunction(Integer userId){
		McUserRoleCache cache = new McUserRoleCache();
		cache.setMcUserId(userId);
		List<McUserRole> list = userRoleDao.selectByMcUserId(userId);
		if(list != null && list.size() != 0){
			Set<Integer> set = new TreeSet<Integer>();  
			for(McUserRole r : list){
				String roleJson = launch.loadDictCache(DCacheEnum.McRole , "InitMcRole").get(r.getMcRoleId().toString());
				if(StringUtils.isNotBlank(roleJson)){
					McRoleCache role = JSONObject.parseObject(roleJson, McRoleCache.class);
					if(role == null){
						continue;
					}
					if(StringUtils.isNotBlank(role.getIds())){
						String [] arr = role.getIds().split(",");
						for(String s : arr){
							set.add(Integer.valueOf(s)); 
						}
					}
				}
			}
			if(set != null && set.size() != 0){
				for(Integer id : set){
					String rfJson = launch.loadDictCache(DCacheEnum.McSysFunc , "InitMcSysFunc").get(id.toString());
					if(StringUtils.isNotBlank(rfJson)){
						McSysFunction rf = JSONObject.parseObject(rfJson, McSysFunction.class);
						if(rf == null){
							continue;
						}
						cache.getMsfList().add(rf); 
					}
				}
			}
			String value = JSONObject.toJSONString(cache);
			launch.loadDictCache(DCacheEnum.McUserRole , null).set(userId.toString(), value); 
			return value;
		}else {
			return "";
		}
	}

}


































