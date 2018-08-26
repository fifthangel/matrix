package com.matrix.pojo.entity;

import com.matrix.base.BaseEntity;

public class SysJobGroup extends BaseEntity{
	private static final long serialVersionUID = -4221585140950224915L;
	
	private Long id;
    private String groupName;
    private String remark;
    
//    private Date createTime;
//    private Long createUserId;
//    private String createUserName;
//    private Date updateTime;
//    private Long updateUserId;
//    private String updateUserName;
//    private Integer deleteFlag;
    
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

































