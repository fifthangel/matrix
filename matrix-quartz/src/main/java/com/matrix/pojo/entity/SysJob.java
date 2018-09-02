package com.matrix.pojo.entity;

import java.util.Date;
import java.util.List;

import com.matrix.base.BaseEntity;

public class SysJob extends BaseEntity{
	
	private static final long serialVersionUID = 3203663999653179352L;
	
	private Long id;
	private String jobName;
    private String jobTitle;
    private String jobClass;
    private String jobTriger;
    private Long runGroupId;
    private Integer concurrentType;
    private Date beginTime;
    private Integer maxExecTime;
    private Date endTime;
    private Date nextTime;
    private Integer flagEnable;
    private String remark;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobClass() {
		return jobClass;
	}
	public void setJobClass(String jobClass) {
		this.jobClass = jobClass;
	}
	public String getJobTriger() {
		return jobTriger;
	}
	public void setJobTriger(String jobTriger) {
		this.jobTriger = jobTriger;
	}
	public Long getRunGroupId() {
		return runGroupId;
	}
	public void setRunGroupId(Long runGroupId) {
		this.runGroupId = runGroupId;
	}
	public Integer getConcurrentType() {
		return concurrentType;
	}
	public void setConcurrentType(Integer concurrentType) {
		this.concurrentType = concurrentType;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Integer getMaxExecTime() {
		return maxExecTime;
	}
	public void setMaxExecTime(Integer maxExecTime) {
		this.maxExecTime = maxExecTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getNextTime() {
		return nextTime;
	}
	public void setNextTime(Date nextTime) {
		this.nextTime = nextTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getFlagEnable() {
		return flagEnable;
	}
	public void setFlagEnable(Integer flagEnable) {
		this.flagEnable = flagEnable;
	}
}




























