package com.matrix.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

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
import com.matrix.pojo.entity.AcApiInfo;
import com.matrix.pojo.entity.AcApiProject;
import com.matrix.pojo.entity.AcIncludeDomain;
import com.matrix.pojo.view.AcApiProjectListView;
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
				launch.loadDictCache(DCacheEnum.ApiProject).set("all" , cache.toJSONString());  
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
				launch.loadDictCache(DCacheEnum.ApiProject).set("all" , cache.toJSONString());   
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
	public JSONObject ajaxIncludeDomainList(AcIncludeDomain entity, HttpServletRequest request, HttpSession session) {
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
		List<AcIncludeDomain> list = acIncludeDomainDao.queryPage(entity); 
		if (list != null && list.size() > 0) {
			result.put("status", "success");
		} else {
			result.put("status", "error");
			result.put("msg", this.getInfo(100090002));  // 没有查询到可以显示的数据 
		}
		PageInfo<AcIncludeDomain> pageList = new PageInfo<AcIncludeDomain>(list);
		result.put("data", pageList);
		result.put("entity", entity);
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
			/*List<AcApiProjectListView> list = acApiProjectDao.findAll();
			if(list != null && list.size() > 0) {
				JSONObject cache = new JSONObject();
				cache.put("status", "success");
				cache.put("data", list);
				launch.loadDictCache(DCacheEnum.ApiProject).set("all" , cache.toJSONString());  
			}else {
				result.put("status", "error");
				result.put("msg", this.getInfo(600010065));  // 600010065=服务器异常，数据缓存修改失败!
			}*/
		}else {
			result.put("status", "error");
			result.put("msg", this.getInfo(600010062));  // 600010062=服务器异常，数据添加失败!
		}
		return result;
	}
	
}










































