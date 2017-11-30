package com.matrix.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.matrix.base.BaseServiceImpl;
import com.matrix.cache.CacheLaunch;
import com.matrix.cache.enums.DCacheEnum;
import com.matrix.cache.inf.IBaseLaunch;
import com.matrix.cache.inf.ICacheFactory;
import com.matrix.dao.IAcApiDomainDao;
import com.matrix.dao.IAcApiInfoDao;
import com.matrix.dao.IAcApiProjectDao;
import com.matrix.dao.IAcIncludeDomainDao;
import com.matrix.dao.IAcRequestInfoDao;
import com.matrix.pojo.dto.AcApiInfoDto;
import com.matrix.pojo.entity.AcApiDomain;
import com.matrix.pojo.entity.AcApiInfo;
import com.matrix.pojo.entity.AcApiProject;
import com.matrix.pojo.entity.AcIncludeDomain;
import com.matrix.pojo.view.AcApiProjectListView;
import com.matrix.pojo.view.AcIncludeDomainView;
import com.matrix.pojo.view.ApiTreeView;
import com.matrix.pojo.view.McUserInfoView;
import com.matrix.service.IApiCenterService;

@Service("apiCenterService")
public class ApiCenterServiceImpl extends BaseServiceImpl<AcApiInfo, Integer> implements IApiCenterService {

	private IBaseLaunch<ICacheFactory> launch = CacheLaunch.getInstance().Launch();
	
	@Resource
	private IAcApiDomainDao acApiDomainDao;
	@Resource
	private IAcApiInfoDao acApiInfoDao;
	@Resource
	private IAcApiProjectDao acApiProjectDao;
	@Resource
	private IAcIncludeDomainDao acIncludeDomainDao;
	@Resource
	private IAcRequestInfoDao acRequestInfoDao;   
	
	
	/**
	 * @description: api所属项目列表
	 *
	 * @param session
	 * @author Yangcl
	 * @date 2017年11月13日 下午7:50:27 
	 * @version 1.0.0
	 */
	public String apiProjectList(){ 
		return "jsp/api/project/api-project-list";  
	}

	/**
	 * @description: ac_api_project 列表数据信息
	 *
	 * @param entity
	 * @param session
	 * @author Yangcl
	 * @date 2017年11月14日 上午9:38:58 
	 * @version 1.0.0
	 */
	public JSONObject ajaxApiProjectList(AcApiProject entity, HttpServletRequest request, HttpSession session) {
		JSONObject result = new JSONObject();
		String pageNum = request.getParameter("pageNum"); // 当前第几页
		String pageSize = request.getParameter("pageSize"); // 当前页所显示记录条数
		int num = 1;
		int size = 10;
		if (StringUtils.isNotBlank(pageNum)) {
			num = Integer.parseInt(pageNum);
		}
		if (StringUtils.isNotBlank(pageSize)) {
			size = Integer.parseInt(pageSize);
		}
		PageHelper.startPage(num, size);
		List<AcApiProjectListView> list = acApiProjectDao.queryPageList(entity); 
		if (list != null && list.size() > 0) {
			result.put("status", "success");
		} else {
			result.put("status", "error");
			result.put("msg", this.getInfo(100090002));  // 没有查询到可以显示的数据 
		}
		PageInfo<AcApiProjectListView> pageList = new PageInfo<AcApiProjectListView>(list);
		result.put("data", pageList);
		result.put("entity", entity);
		return result;
	}

	@Override
	public JSONObject ajaxApiProjectAdd(AcApiProject e, HttpSession session) {
		JSONObject result = new JSONObject();
		if(StringUtils.isBlank(e.getTarget())) {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010060));  // 项目名称不得为空
			return result;
		}
		McUserInfoView u = (McUserInfoView) session.getAttribute("userInfo");
		e.setCreateTime(new Date());
		e.setCreateUserId(u.getId());
		e.setUpdateTime(new Date());
		e.setUpdateUserId(u.getId());
		int flag = acApiProjectDao.insertSelective(e);
		if(flag == 1) {
			result.put("status", "success");
			result.put("msg", this.getInfo(600010061));  // 600010061=数据添加成功!
			List<AcApiProjectListView> list = acApiProjectDao.findAll();
			if(list != null && list.size() > 0) {
				JSONObject cache = new JSONObject();
				cache.put("status", "success");
				cache.put("data", list);
				launch.loadDictCache(DCacheEnum.ApiProject , null).set("all" , cache.toJSONString());  
			}else {
				result.put("status", "error");
				result.put("msg", this.getInfo(600010065));  // 600010065=服务器异常，数据缓存修改失败!
			}
		}else {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010062));  // 600010062=服务器异常，数据添加失败!
		}
		return result;
	}

	/**
	 * @description: 更新与删除都会走这里的逻辑 
	 *
	 * @param e
	 * @param session
	 * @return 
	 * @author Yangcl
	 * @date 2017年11月14日 下午4:07:46 
	 * @version 1.0.0
	 */
	@Override
	public JSONObject ajaxApiProjectEdit(AcApiProject e, HttpSession session) {
		JSONObject result = new JSONObject();
		if(StringUtils.isBlank(e.getTarget())) {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010060));  // 项目名称不得为空
			return result;
		}
		McUserInfoView u = (McUserInfoView) session.getAttribute("userInfo");
		e.setUpdateTime(new Date());
		e.setUpdateUserId(u.getId());
		int flag = acApiProjectDao.updateSelective(e); 
		if(flag == 1) {
			result.put("status", "success");
			result.put("msg", this.getInfo(600010063));  // 600010063=数据修改成功!
			List<AcApiProjectListView> list = acApiProjectDao.findAll();
			if(list != null && list.size() > 0) {
				JSONObject cache = new JSONObject();
				cache.put("status", "success");
				cache.put("data", list);
				launch.loadDictCache(DCacheEnum.ApiProject , null).set("all" , cache.toJSONString());   
			}else {
				result.put("status", "error");
				result.put("msg", this.getInfo(600010065));  // 600010065=服务器异常，数据缓存修改失败!
			}
		}else {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010064));  // 600010064=服务器异常，数据修改失败! 
		}
		return result;
	}

	/**
	 * @description: 前往跨域白名单列表页面
	 *
	 * @param session
	 * @return 
	 * @author Yangcl
	 * @date 2017年11月15日 上午11:19:17 
	 * @version 1.0.0
	 */
	public String apiIncludeDomainList() {
		return "jsp/api/domain/api-include-domain-list";
	}

	/**
	 * @description: 跨域白名单列表数据请求
	 *
	 * @param entity
	 * @param request
	 * @author Yangcl
	 * @date 2017年11月15日 上午11:19:57 
	 * @version 1.0.0
	 */
	public JSONObject ajaxIncludeDomainPageList(AcIncludeDomain entity, HttpServletRequest request, HttpSession session) {
		JSONObject result = new JSONObject();
		String pageNum = request.getParameter("pageNum"); // 当前第几页
		String pageSize = request.getParameter("pageSize"); // 当前页所显示记录条数
		int num = 1;
		int size = 10;
		if (StringUtils.isNotBlank(pageNum)) {
			num = Integer.parseInt(pageNum);
		}
		if (StringUtils.isNotBlank(pageSize)) {
			size = Integer.parseInt(pageSize);
		}
		PageHelper.startPage(num, size);
		List<AcIncludeDomainView> list = acIncludeDomainDao.queryPageList(entity); 
		if (list != null && list.size() > 0) {
			result.put("status", "success");
		} else {
			result.put("status", "error");
			result.put("msg", this.getInfo(100090002));  // 没有查询到可以显示的数据 
		}
		PageInfo<AcIncludeDomainView> pageList = new PageInfo<AcIncludeDomainView>(list);
		result.put("data", pageList);
		result.put("entity", entity);
		return result;
	}
	
	/**
	 * @description: 全量跨域白名单列表数据，不分页
	 *
	 * @param entity
	 * @param request
	 * @param session
	 * @author Yangcl
	 * @date 2017年11月27日 下午11:22:33 
	 * @version 1.0.0.1
	 */
	public JSONObject ajaxIncludeDomainList(AcIncludeDomain entity, HttpServletRequest request, HttpSession session) {
		JSONObject result = new JSONObject();
		String value = launch.loadDictCache(DCacheEnum.ApiDomain , "InitApiDomain").get("all");  
		if (StringUtils.isNoneBlank(value)) {
			return JSONObject.parseObject(value);
		} else {
			result.put("status", "error");
			result.put("msg", this.getInfo(100090002));  // 没有查询到可以显示的数据 
		}
		return result;
	}

	/**
	 * @description: 添加跨域白名单
	 *
	 * @param entity
	 * @param session
	 * @author Yangcl
	 * @date 2017年11月17日 下午11:11:25 
	 * @version 1.0.0.1
	 */
	public JSONObject ajaxApiDomainAdd(AcIncludeDomain e, HttpSession session) {
		JSONObject result = new JSONObject();
		if(StringUtils.isBlank(e.getDomain())) {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010066));  // 域名不得为空!
			return result;
		}
		if(StringUtils.isBlank(e.getCompanyName())) {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010067));  // 所属公司不得为空!
			return result;
		}
		
		McUserInfoView u = (McUserInfoView) session.getAttribute("userInfo");
		e.setCreateTime(new Date());
		e.setCreateUserId(u.getId());
		e.setUpdateTime(new Date());
		e.setUpdateUserId(u.getId());
		int flag = acIncludeDomainDao.insertSelective(e);
		if(flag == 1) {
			result.put("status", "success");
			result.put("msg", this.getInfo(600010061));  // 600010061=数据添加成功!
			List<AcIncludeDomainView> list = acIncludeDomainDao.queryPageList(null); 
			if(list != null && list.size() > 0) {
				JSONObject cache = new JSONObject();
				cache.put("status", "success");
				cache.put("data", list);
				launch.loadDictCache(DCacheEnum.ApiDomain , null).set("all" , cache.toJSONString());  
			}else {
				result.put("status", "error");
				result.put("msg", this.getInfo(600010065));  // 600010065=服务器异常，数据缓存修改失败!
			}
		}else {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010062));  // 600010062=服务器异常，数据添加失败!
		}
		return result;
	}

	/**
	 * @description: 编辑跨域白名单
	 *
	 * @param entity
	 * @param session
	 * @author Yangcl
	 * @date 2017年11月18日 下午9:56:10 
	 * @version 1.0.0.1
	 */
	public JSONObject ajaxApiDomainEdit(AcIncludeDomain e, HttpSession session) {
		JSONObject result = new JSONObject();
		if(StringUtils.isBlank(e.getDomain())) {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010066));  // 域名不得为空!
			return result;
		}
		if(StringUtils.isBlank(e.getCompanyName())) {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010067));  // 所属公司不得为空!
			return result;
		}
		
		McUserInfoView u = (McUserInfoView) session.getAttribute("userInfo");
		e.setUpdateTime(new Date());
		e.setUpdateUserId(u.getId());
		int flag = acIncludeDomainDao.updateSelective(e);
		if(flag == 1){
			result.put("status", "success");
			result.put("msg", this.getInfo(600010063));  // 600010063=数据修改成功!
			List<AcIncludeDomainView> list = acIncludeDomainDao.queryPageList(null); 
			if(list != null && list.size() > 0) {
				JSONObject cache = new JSONObject();
				cache.put("status", "success");
				cache.put("data", list);
				launch.loadDictCache(DCacheEnum.ApiDomain , null).set("all" , cache.toJSONString());  
			}else {
				result.put("status", "error");
				result.put("msg", this.getInfo(600010065));  // 600010065=服务器异常，数据缓存修改失败!
			}
		}else {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010064));  // 600010064=服务器异常，数据修改失败! 
		}
		return result;
	}

	/**
	 * @description: api信息树 
	 *
	 * @param session
	 * @author Yangcl
	 * @date 2017年11月19日 下午2:33:26 
	 * @version 1.0.0
	 */
	public String apiInfoList() {
		return "jsp/api/info/api-info-list";  
	}

	/**
	 * @description: 获取api树结构列表信息
	 *
	 * @param entity
	 * @param session															
	 * @author Yangcl
	 * @date 2017年11月20日 下午3:40:07 
	 * @version 1.0.0.1
	 */
	public JSONObject ajaxApiInfoList(AcApiInfo e, HttpSession session) {
		JSONObject result = new JSONObject();
		String project = launch.loadDictCache(DCacheEnum.ApiProject , "InitApiProject").get("all");
		if(StringUtils.isBlank(project)) {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010068));  // 600010068=API树形结构加载失败!api所属项目未能正常初始化，请重试.
			return result;
		}
		JSONObject pobj = JSONObject.parseObject(project);
		if(!pobj.getString("status").equals("success")) {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010069));  // 600010069=API树形结构加载失败!api所属项目缓存异常.
			return result;
		}
		
		JSONArray arr = pobj.getJSONArray("data");
		if(arr.size() == 0) {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010070));  // 600010070=API树形结构加载失败!api所属项目未定义.
			return result;
		}
		List<ApiTreeView> tlist = new ArrayList<ApiTreeView>();
		ApiTreeView root = new ApiTreeView();
		root.setId(0);
		root.setName("root"); 
		root.setSeqnum(1);
		root.setParentId(-1); 
		tlist.add(root);
		for(int i = 0 ; i < arr.size() ; i ++) {
			JSONObject p = arr.getJSONObject(i);
			ApiTreeView a = new ApiTreeView();
			a.setId(p.getInteger("id"));
			a.setName(p.getString("target"));
			a.setAtype(p.getString("atype")); 
			a.setSeqnum(i+1);
			a.setParentId(0);
			tlist.add(a);
		}
		List<ApiTreeView> apiInfoList = acApiInfoDao.findApiInfoList(e);
		if(apiInfoList != null && apiInfoList.size() != 0) {
			tlist.addAll(apiInfoList);
		}
		
		result.put("status", "success");
		result.put("list", tlist);
		return result;
	}

	/**
	 * @description: 添加api信息
	 *
	 * @param e
	 * @param session
	 * @author Yangcl
	 * @date 2017年11月28日 下午3:19:55 
	 * @version 1.0.0
	 */
	public JSONObject ajaxApiInfoAdd(AcApiInfoDto d, HttpSession session) {
		JSONObject result = new JSONObject();
		if(StringUtils.isAnyBlank(d.getName() , d.getTarget() , d.getProcessor() , d.getModule() , d.getRemark())) {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010071));  // 600010071=API关键信息不得为空!请全部填写.
			return result;
		}
		if(d.getDomain() == 1 && StringUtils.isBlank(d.getDomainList())) {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010072));  // 600010072=请勾选API可用跨域列表
			return result;
		}
		if(!StringUtils.startsWith(d.getProcessor(), d.getAtype())) { 
			result.put("status", "error");
			result.put("msg", this.getInfo(600010074 , d.getAtype()));  // 600010074=【业务处理实现】路径输入错误!应该以{0}起始
			return result;
		}
		String isRecord = launch.loadDictCache(DCacheEnum.ApiInfo , "InitApiInfo").get(d.getTarget());
		if(StringUtils.isNotBlank(isRecord)) {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010075 , d.getTarget() ));  // 600010075=系统接口名称：{0} 已经在数据库中存在,请修改.
			return result;
		}
		
		AcApiInfo e = new AcApiInfo();
		e.setName(d.getName());
		e.setTarget(d.getTarget());
		e.setAtype(d.getAtype());
		e.setModule(d.getModule());
		e.setProcessor(d.getProcessor());
		e.setDomain(d.getDomain());
		e.setParentId(d.getParentId());
		e.setSeqnum(d.getSeqnum());
		e.setDiscard(1);
		e.setRemark(d.getRemark());
		
		McUserInfoView u = (McUserInfoView) session.getAttribute("userInfo");
		e.setCreateTime(new Date());
		e.setCreateUserId(u.getId());
		e.setUpdateTime(new Date());
		e.setUpdateUserId(u.getId());
		int flag = acApiInfoDao.insertSelective(e);
		if(flag == 1) {
			try {
				if(d.getDomain() == 1) {							 
					String [] arr = d.getDomainList().split(",");
					for(int i = 0 ; i < arr.length ; i ++) {
						AcApiDomain ad = new AcApiDomain();
						ad.setAcApiInfoId(e.getId());
						ad.setAcIncludeDomainId(Integer.valueOf(arr[i]));
						acApiDomainDao.insertSelective(ad);
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				result.put("status", "error");
				result.put("msg", this.getInfo(600010063));  // 600010073=API信息与跨域域名关联异常,数据库更新失败!请及时查看服务器log日志
				return result;
			}
			
			// 开始初始化API缓存
			JSONObject cache = JSONObject.parseObject(JSONObject.toJSONString(e)); 
			cache.put("list", d.getDomainContentList().split(",")); 
			cache.put("domainIds", d.getDomainList().split(",")); 
			launch.loadDictCache(DCacheEnum.ApiInfo , null).set(d.getTarget() , cache.toJSONString()); 
			
			cache.put("status", "success");
			cache.put("msg", this.getInfo(600010061));  // 600010061=数据添加成功!
			return cache;  // 标识成功并返回全部缓存信息
		}else {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010062));  // 600010062=服务器异常，数据添加失败!
		}
		return result;
	}

	/**
	 * @description: 依据target 查找一个api信息
	 *
	 * @param dto
	 * @param session
	 * @author Yangcl
	 * @date 2017年11月29日 下午4:26:33 
	 * @version 1.0.0
	 */
	public JSONObject ajaxApiInfoFind(AcApiInfoDto d) {
		JSONObject result = new JSONObject();
		if(StringUtils.isBlank(d.getTarget())) {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010076));  // 600010076=系统接口标识"target"参数不得为空!
			return result;
		}
		String record = launch.loadDictCache(DCacheEnum.ApiInfo , "InitApiInfo").get(d.getTarget());
		if(StringUtils.isBlank(record)) {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010077 , d.getTarget()));  // 600010077=目标接口: {0} 不存在!
			return result;
		}
		JSONObject cache =JSONObject.parseObject(record);
		cache.put("status", "success");
		cache.put("msg", this.getInfo(600010006));  // 600010006=数据查询成功! 
		return cache;  
	}

	/**
	 * @description: 修改api信息 
	 *
	 * @param d
	 * @param session
	 * @author Yangcl
	 * @date 2017年11月30日 下午3:26:55 
	 * @version 1.0.0
	 */
	public JSONObject ajaxApiInfoEdit(AcApiInfoDto d, HttpSession session) {
		JSONObject result = new JSONObject();
		if(!StringUtils.startsWith(d.getProcessor(), d.getAtype())) { 
			result.put("status", "error");
			result.put("msg", this.getInfo(600010074 , d.getAtype()));  // 600010074=【业务处理实现】路径输入错误!应该以{0}起始
			return result;
		}
		if(d.getDomain() == 1 && StringUtils.isBlank(d.getDomainList())) {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010072));  // 600010072=请勾选API可用跨域列表
			return result;
		}
		AcApiInfo api = acApiInfoDao.find(d.getId());
		if(api == null) {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010078 , d.getTarget()));  // 600010078=目标接口: {0} 不存在!数据库无此记录,修改失败!
			return result;
		}
		if(!api.getTarget().equals(d.getTarget())) {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010079 , d.getTarget()));  // 600010079=目标接口: {0} 与数据库记录不符, 请勿修改【系统接口名称】
			return result;
		}
		
		AcApiInfo e = new AcApiInfo();
		e.setId(d.getId());  
		e.setProcessor(d.getProcessor());
		e.setModule(d.getModule());
		e.setDomain(d.getDomain());
		e.setSeqnum(d.getSeqnum());
		e.setDiscard(d.getDiscard());
		e.setRemark(d.getRemark());
		McUserInfoView u = (McUserInfoView) session.getAttribute("userInfo");
		e.setUpdateTime(new Date());
		e.setUpdateUserId(u.getId());
		int flag = acApiInfoDao.updateSelective(e);
		if(flag == 1) {
			try {
				if(d.getDomain() == 1) {		
					// 删除旧关联关系
					acApiDomainDao.deleteByApiInfoId(e.getId());
					String [] arr = d.getDomainList().split(",");
					for(int i = 0 ; i < arr.length ; i ++) {
						AcApiDomain ad = new AcApiDomain();
						ad.setAcApiInfoId(e.getId());
						ad.setAcIncludeDomainId(Integer.valueOf(arr[i]));
						acApiDomainDao.insertSelective(ad);
					}
					
					// 开始初始化API缓存
					api = acApiInfoDao.find(e.getId());
					JSONObject cache = JSONObject.parseObject(JSONObject.toJSONString(api)); 
					cache.put("list", d.getDomainContentList().split(",")); 
					cache.put("domainIds", d.getDomainList().split(",")); 
					launch.loadDictCache(DCacheEnum.ApiInfo , null).set(api.getTarget() , cache.toJSONString()); 
					cache.put("status", "success");
					cache.put("msg", this.getInfo(600010080));  // 600010080=API接口信息修改成功!
					return cache;  // 标识成功并返回全部缓存信息
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				result.put("status", "error");
				result.put("msg", this.getInfo(600010063));  // 600010073=API信息与跨域域名关联异常,数据库更新失败!请及时查看服务器log日志
				return result;
			}
		}else {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010064));  // 600010064=服务器异常，数据修改失败! 
		}
		return result;
	}
	
}










































