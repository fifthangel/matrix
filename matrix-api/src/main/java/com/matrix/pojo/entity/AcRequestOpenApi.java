package com.matrix.pojo.entity;

import java.util.Date;

public class AcRequestOpenApi {
    private Integer id;
    private Integer acRequestInfoId;
    private Integer acApiInfoId;
    private Date createTime;
    private Integer createUserId;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAcRequestInfoId() {
		return acRequestInfoId;
	}
	public void setAcRequestInfoId(Integer acRequestInfoId) {
		this.acRequestInfoId = acRequestInfoId;
	}
	public Integer getAcApiInfoId() {
		return acApiInfoId;
	}
	public void setAcApiInfoId(Integer acApiInfoId) {
		this.acApiInfoId = acApiInfoId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getCreateUser() {
		return createUserId;
	}
	public void setCreateUser(Integer createUserId) {
		this.createUserId = createUserId;
	}
}