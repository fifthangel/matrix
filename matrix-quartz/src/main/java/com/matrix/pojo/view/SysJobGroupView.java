package com.matrix.pojo.view;

import com.matrix.base.BaseView;

public class SysJobGroupView extends BaseView {

	private static final long serialVersionUID = 7394357747196750209L;
	
	private Long id;
    private String groupName;
    private String remark;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
