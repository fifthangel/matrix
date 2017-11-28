package com.matrix.pojo.entity;

import java.util.Date;

public class AcApiProject {
    private Integer id;
    private String target;
    private String atype;  // 接口类型 private:私有 即公司内部使用的接口| public:公开，即开放给第三方的接口
    private Integer aflag;
    private Date createTime;
    private Integer createUserId;
    private Date updateTime;
    private Integer updateUserId;
    
    
	public String getAtype() {
		return atype;
	}
	public void setAtype(String atype) {
		this.atype = atype;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public Integer getAflag() {
		return aflag;
	}
	public void setAflag(Integer aflag) {
		this.aflag = aflag;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}
}