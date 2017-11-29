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
import com.matrix.dao.IAcApiDomainDao;
import com.matrix.dao.IAcApiInfoDao;
import com.matrix.dao.IAcIncludeDomainDao;
import com.matrix.pojo.entity.AcApiInfo;
import com.matrix.pojo.view.AcApiDomainView;

public class InitApiInfo  extends BaseClass implements ILoadCache{
	
	private IBaseLaunch<ICacheFactory> launch = CacheLaunch.getInstance().Launch();
	
	@Inject
	private IAcIncludeDomainDao acIncludeDomainDao;
	@Inject
	private IAcApiDomainDao acApiDomainDao;
	@Inject
	private IAcApiInfoDao acApiInfoDao;
	
	/**
	 * @description: 多表联查，加载缓存
	 *
	 * @param key  AcApiInfo.target
	 * @param field null
	 * @return 
	 * @author Yangcl
	 * @date 2017年11月29日 上午11:52:39 
	 * @version 1.0.0
	 */
	@Override
	public String load(String key, String field) {
		AcApiInfo dto = new AcApiInfo();
		dto.setTarget(key); 
		List<AcApiInfo> apiInfoList = acApiInfoDao.selectByEntity(dto); 
		if(apiInfoList == null || apiInfoList.size() == 0) {
			return "";
		}
		AcApiInfo e = apiInfoList.get(0);
		// 开始初始化API缓存
		JSONObject cache = JSONObject.parseObject(JSONObject.toJSONString(e)); 
		cache.put("list", new ArrayList<String>()); 
		cache.put("domainIds", new ArrayList<String>()); 
		if(e.getDomain() == 1) {		// 针对可跨域情况
			List<AcApiDomainView> adList = acApiDomainDao.selectByApiInfoId(e.getId());
			if(adList != null && adList.size() != 0) {
				List<String> ids = new ArrayList<>();
				List<String> domains = new ArrayList<>();
				for(AcApiDomainView v : adList) {
					ids.add(v.getId().toString());
					domains.add(v.getDomain());
				}
				cache.put("list", domains); 
				cache.put("domainIds", ids); 
			}
		}
		String value = cache.toJSONString();
		launch.loadDictCache(DCacheEnum.ApiInfo , null).set(e.getTarget() , value); 
		return value;
	}

}



























