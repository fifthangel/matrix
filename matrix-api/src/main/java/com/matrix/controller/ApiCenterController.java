package com.matrix.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseController;
import com.matrix.pojo.dto.AcApiInfoDto;
import com.matrix.pojo.entity.AcApiInfo;
import com.matrix.pojo.entity.AcApiProject;
import com.matrix.pojo.entity.AcIncludeDomain;
import com.matrix.service.IApiCenterService;

/**
 * @description: api模块的系统页面配置信息入口。后台页面的行为在此处统一封装。 
 *
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2017年11月13日 下午3:42:46 
 * @version 1.0.0
 */
@Controller
@RequestMapping("apicenter")
public class ApiCenterController extends BaseController {
private static Logger logger=Logger.getLogger(ApiCenterController.class);
	
	@Autowired
	private IApiCenterService service;  
	
	
	
	//////////////////////////////////////////////////////////////////////////////【api所属项目】/////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * @description: 跳转到api所属项目列表页面
	 *
	 * @param session
	 * @author Yangcl
	 * @date 2017年11月13日 下午7:50:27 
	 * @version 1.0.0
	 */
	@RequestMapping("page_apicenter_project_list")  
	public String apiProjectList(HttpSession session){ 
		super.userBehavior(session, logger, "page_apicenter_project_list", "api所属项目列表");
		return service.apiProjectList(); 
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
	@RequestMapping(value = "ajax_api_project_list", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject ajaxApiProjectList(AcApiProject entity , HttpServletRequest request, HttpSession session){ 
		super.userBehavior(session, logger, "ajax_api_project_list", "ac_api_project 列表数据信息");
		return service.ajaxApiProjectList(entity, request, session);  
	}
	/**
	 * @description: ac_api_project表添加信息
	 *
	 * @param entity
	 * @param session
	 * @author Yangcl
	 * @date 2017年11月14日 上午10:34:12 
	 * @version 1.0.0
	 */
	@RequestMapping(value = "ajax_api_project_add", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject ajaxApiProjectAdd(AcApiProject entity , HttpSession session){ 
		super.userBehavior(session, logger, "ajax_api_project_add", "向ac_api_project表添加信息");
		return service.ajaxApiProjectAdd(entity, session);  
	}
	/**
	 * @description: ac_api_project表修改信息
	 *
	 * @param entity
	 * @param session
	 * @author Yangcl
	 * @date 2017年11月14日 上午10:34:12 
	 * @version 1.0.0
	 */
	@RequestMapping(value = "ajax_api_project_edit", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject ajaxApiProjectEdit(AcApiProject entity , HttpSession session){ 
		super.userBehavior(session, logger, "ajax_api_project_edit", "向ac_api_project表修改信息");
		return service.ajaxApiProjectEdit(entity, session);  
	}
	
	//////////////////////////////////////////////////////////////////////////////【跨域白名单】/////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * @description: 前往跨域白名单列表页面
	 *
	 * @param session
	 * @return 
	 * @author Yangcl
	 * @date 2017年11月15日 上午11:19:17 
	 * @version 1.0.0
	 */
	@RequestMapping("page_apicenter_include_domain_list")  
	public String apiIncludeDomainList(HttpSession session){ 
		super.userBehavior(session, logger, "page_apicenter_include_domain_list", "前往跨域白名单列表页面");
		return service.apiIncludeDomainList(); 
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
	@RequestMapping(value = "ajax_include_domain_page_list", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject ajaxIncludeDomainPageList(AcIncludeDomain entity , HttpServletRequest request, HttpSession session){ 
		super.userBehavior(session, logger, "ajax_include_domain_page_list", "ac_include_domain 跨域白名单列表数据请求");
		return service.ajaxIncludeDomainPageList(entity, request, session);  
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
	@RequestMapping(value = "ajax_include_domain_list", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject ajaxIncludeDomainList(AcIncludeDomain entity , HttpServletRequest request, HttpSession session){ 
		super.userBehavior(session, logger, "ajax_include_domain_list", "ac_include_domain 全量跨域白名单列表数据，不分页");
		return service.ajaxIncludeDomainList(entity, request, session);  
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
	@RequestMapping(value = "ajax_api_domain_add", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject ajaxApiDomainAdd(AcIncludeDomain entity , HttpSession session){ 
		super.userBehavior(session, logger, "ajax_api_domain_add", "向ac_api_project表添加信息");
		return service.ajaxApiDomainAdd(entity, session);  
	}
	/**
	 * @description: 编辑跨域白名单|删除修改走同一套逻辑
	 *
	 * @param entity
	 * @param session
	 * @author Yangcl
	 * @date 2017年11月18日 下午9:56:10 
	 * @version 1.0.0.1
	 */
	@RequestMapping(value = "ajax_api_domain_edit", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject ajaxApiDomainEdit(AcIncludeDomain entity , HttpSession session){ 
		super.userBehavior(session, logger, "ajax_api_domain_edit", "向ac_api_project表添加信息");
		return service.ajaxApiDomainEdit(entity, session);  
	}
	
	//////////////////////////////////////////////////////////////////////////////【系统api信息】/////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * @description: api信息树 
	 *
	 * @param session
	 * @author Yangcl
	 * @date 2017年11月19日 下午2:33:26 
	 * @version 1.0.0
	 */
	@RequestMapping("page_apicenter_api_info_list")  
	public String apiInfoList(HttpSession session){ 
		super.userBehavior(session, logger, "page_apicenter_api_info_list", "前往api信息树页面");
		return service.apiInfoList(); 
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
	@RequestMapping(value = "ajax_api_info_list", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject ajaxApiInfoList(AcApiInfo e , HttpSession session){ 
		super.userBehavior(session, logger, "ajax_api_info_list", "获取api树结构列表信息");
		return service.ajaxApiInfoList(e, session);  
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
	@RequestMapping(value = "ajax_api_info_add", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject ajaxApiInfoAdd(AcApiInfoDto d , HttpSession session){ 
		super.userBehavior(session, logger, "ajax_api_info_add", "添加api信息");
		return service.ajaxApiInfoAdd(d, session);  
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
	@RequestMapping(value = "ajax_api_info_find", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject ajaxApiInfoFind(AcApiInfoDto dto , HttpSession session){ 
		super.userBehavior(session, logger, "ajax_api_info_find", "依据target 查找一个api信息");
		return service.ajaxApiInfoFind(dto);  
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
	@RequestMapping(value = "ajax_api_info_edit", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JSONObject ajaxApiInfoEdit(AcApiInfoDto d , HttpSession session){ 
		super.userBehavior(session, logger, "ajax_api_info_edit", "修改api信息");
		return service.ajaxApiInfoEdit(d, session);  
	}
}









































