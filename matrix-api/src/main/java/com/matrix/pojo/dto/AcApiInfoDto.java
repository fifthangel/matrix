package com.matrix.pojo.dto;

public class AcApiInfoDto {
	private Integer id;
	private String name;  // 接口中文描述   树展示使用
    private String target; // 系统接口名称 比如：TEST-PUBLIC-PROCESSOR，访问标识
    private String atype;
    private String module;
    private String processor;
    private Integer domain;
    private Integer parentId;
    private Integer seqnum;
    private Integer discard;
    private String remark;
    private String domainList;
    private String domainContentList;
    
	public String getDomainContentList() {
		return domainContentList;
	}
	public void setDomainContentList(String domainContentList) {
		this.domainContentList = domainContentList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getAtype() {
		return atype;
	}
	public void setAtype(String atype) {
		this.atype = atype;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public Integer getDomain() {
		return domain;
	}
	public void setDomain(Integer domain) {
		this.domain = domain;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getSeqnum() {
		return seqnum;
	}
	public void setSeqnum(Integer seqnum) {
		this.seqnum = seqnum;
	}
	public Integer getDiscard() {
		return discard;
	}
	public void setDiscard(Integer discard) {
		this.discard = discard;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDomainList() {
		return domainList;
	}
	public void setDomainList(String domainList) {
		this.domainList = domainList;
	}
}
