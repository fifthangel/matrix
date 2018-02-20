package com.matrix.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matrix.base.BaseController;
import com.matrix.service.ITcLandedPropertyService;

/**
 * @description: 这个类尽可能的贴近实际业务来展示一个完整的开发流程。
 * 
 * 	这个类包含了编写业务所需的全部可能。当你在系统中添加一个新的业务，
 * 	无论是什么样的业务内容，均可在此处复制得出。这是一个样板类，体现了“复制即所得”的思想。
 * 	但请注意修改对应的类名称、Logger里的类名、RequestMapping等等。
 * 	一个完整的业务流程，依赖的类大体结构如下：
 * 		DemoController.java
 * 			-- ITcLandedPropertyService.java
 * 			-- TcLandedPropertyServiceImpl.java
 * 					-- ITcLandedPropertyDao.java
 * 					-- TcLandedProperty.java (对应数据表的entity，还可能包含如：dto、view等等传输实体)
 * 			-- TcLandedPropertyMapper.xml
 * 
 * 		请注意！所有的业务操作都应该在Service层来完成，不要侵入到Controller中，这将降低程序移植过程中的灵活性。
 *
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2018年2月20日 下午4:06:29 
 * @version 1.0.0.1
 */
@Controller
@RequestMapping("demo")
public class DemoController extends BaseController{
	private static Logger logger=Logger.getLogger(DemoController.class);
	
	@Autowired
	private ITcLandedPropertyService service;

}








































