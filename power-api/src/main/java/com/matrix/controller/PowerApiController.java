package com.matrix.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matrix.base.BaseController;
import com.matrix.service.IPowerApiService;
import com.matrix.util.JarUtil;

@Controller
@RequestMapping("powerApi")
public class PowerApiController extends BaseController{
	private static Logger logger=Logger.getLogger(PowerApiController.class);

	@Autowired
	private IPowerApiService powerApiService;
	
	@SuppressWarnings("resource")
	@RequestMapping("page_powerApi_index")
	public String toAddPage(HttpSession session){ 
		return "jsp/api_pages/index"; 
	}
}
























