package com.matrix.pojo.view;

import com.matrix.base.BaseView;

public class SysJobHostView extends BaseView {

	private static final long serialVersionUID = 9684847366770760L;
	
	private Long id;
    private Long sysJobGroupId;
    private String ip;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSysJobGroupId() {
		return sysJobGroupId;
	}
	public void setSysJobGroupId(Long sysJobGroupId) {
		this.sysJobGroupId = sysJobGroupId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}
