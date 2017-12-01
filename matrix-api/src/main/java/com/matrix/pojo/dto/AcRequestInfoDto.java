package com.matrix.pojo.dto;

import com.matrix.pojo.entity.AcRequestInfo;

public class AcRequestInfoDto extends AcRequestInfo {
	private Integer isallot;  // 如果是第三方请求者，标识在编辑方法中是否为分配系统开放接口。0：否|1：是
	private String targets;		// API的自增id，逗号分隔

	public Integer getIsallot() {
		return isallot;
	}
	public void setIsallot(Integer isallot) {
		this.isallot = isallot;
	}
	public String getTargets() {
		return targets;
	}
	public void setTargets(String targets) {
		this.targets = targets;
	}
}
