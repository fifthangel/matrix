package com.matrix.pojo.entity;

import com.matrix.base.BaseEntity;

public class SysJobHost extends BaseEntity {
	
	private static final long serialVersionUID = 6165741889213989497L;
	
	private Long id;
    private Long sysJobId;
    private String ip;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSysJobId() {
		return sysJobId;
	}
	public void setSysJobId(Long sysJobId) {
		this.sysJobId = sysJobId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}