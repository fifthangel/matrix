package com.matrix.base;

import java.io.Serializable;

/**
 * @description: 数据传输模型基类 | 提供dubbo分布式序列化支持|提供dubbo分布式分页支持
 *
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2018年7月24日 上午2:44:55 
 * @version 1.0.0.1
 */
public class BaseDto implements Serializable {
	
	private static final long serialVersionUID = -7666209205055824390L;

	/** 
	 * 起始页数 - 微服务化项目需要的字段
	 */
	private Integer startIndex = 1;
	
	/**
	 *  分页记录数 - 微服务化项目需要的字段
	 */
	private Integer pageSize = 10;
	
	
	/**
	 *  动态列表排序依据，比如：dto.setOrder("create_time");
	 */
	private String orderBy = null;


	public Integer getStartIndex() {
		return startIndex;
	}


	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}


	public Integer getPageSize() {
		return pageSize;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	public String getOrderBy() {
		return orderBy;
	}


	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
}





















