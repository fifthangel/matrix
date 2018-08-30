package com.matrix.pojo.entity;

import java.util.Date;

import com.matrix.base.BaseEntity;

public class SysJobExecLog extends BaseEntity{
   
	private static final long serialVersionUID = 6607575575396002226L;

	private Long id;
    private Long sysJobId;
    private String jobTitle;
    private String ip;
    private Date beginTime;
    private Date endTime;
    private Integer execCount;
    private Integer flag;
    private String remark;
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
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getExecCount() {
		return execCount;
	}
	public void setExecCount(Integer execCount) {
		this.execCount = execCount;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

    
}