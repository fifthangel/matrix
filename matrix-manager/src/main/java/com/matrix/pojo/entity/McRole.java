package com.matrix.pojo.entity;

import java.util.Date;

import com.matrix.base.BaseEntity;

public class McRole extends BaseEntity{
	
	private static final long serialVersionUID = 3626119718702587829L;
	private Integer id;
    private String roleName;
    private String roleDesc;
    private String remark;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}