package com.matrix.load;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.matrix.annotation.Inject;
import com.matrix.base.BaseClass;
import com.matrix.base.interfaces.IBaseCache;
import com.matrix.base.interfaces.ILoadCache;
import com.matrix.cache.CacheLaunch;
import com.matrix.cache.enums.DCacheEnum;
import com.matrix.cache.inf.IBaseLaunch;
import com.matrix.cache.inf.ICacheFactory;
import com.matrix.dao.IAcApiProjectDao;
import com.matrix.dao.IAcIncludeDomainDao;
import com.matrix.pojo.view.AcApiProjectListView;
import com.matrix.pojo.view.AcIncludeDomainView;

/**
 * @description: 加载 apicenter.ac_api_project表的字典缓存
 * key: xd-ApiDomain-all
 * value:
			 {
			    "status": "success",
			    "data": [
			        {
			            "domain": "www.baidu.com",
			            "companyName": "百度",
			            "createTime": 1510932551000,
			            "updateUserId": 1,
			            "updateTime": 1510932551000,
			            "id": 1,
			            "updater": "admin"
			        },
			        {
			            "domain": "www.sina.com",
			            "companyName": "sina",
			            "createTime": 1511012845000,
			            "updateUserId": 1,
			            "updateTime": 1511012845000,
			            "id": 3,
			            "updater": "admin"
			        }
			    ]    
			}
				 
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2017年11月23日 下午14:42:28 
 * @version 1.0.0
 */
public class InitApiDomain extends BaseClass implements ILoadCache{
	
	private IBaseLaunch<ICacheFactory> launch = CacheLaunch.getInstance().Launch();
	
	@Inject
	private IAcIncludeDomainDao acIncludeDomainDao;
	
	
	@Override
	public String load(String key, String field) {
		List<AcIncludeDomainView> list = acIncludeDomainDao.queryPageList(null); 
		if(list != null && list.size() > 0) {
			JSONObject cache = new JSONObject();
			cache.put("status", "success");
			cache.put("data", list);
			String value = cache.toJSONString();
			launch.loadDictCache(DCacheEnum.ApiDomain , null).set(key , value);   
			return value ;
		}
		
		return "";
	}

}






















