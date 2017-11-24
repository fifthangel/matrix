package com.matrix.pojo.view;

public class ApiTreeView {
	private Integer id;
    private String name; 		// api名称
    private String atype;			// 接口类型 private:私有 即公司内部使用的接口| public:公开，即开放给第三方的接口
    private String module;			// maven sub module name  比如：matrix-file
    private String processor;		// 业务处理接口的类 com.matrix.processor.publics.example.TestPublicProcessor
    private Integer domain;		// 接口是否拥有跨域行为 0 不允许  1 允许跨域访问|ac_api_domain表作为关联
    private Integer seqnum;		 // 顺序码 同一层次显示顺序
    private Integer parentId;	// 所属内部项目id,用于树形结构展示|ac_api_project表id
    private Integer discard;		// 这个api是否废弃|0:废弃 1:使用中
    private String remark;
    private Boolean open = true;
    
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getOpen() {
		return open;
	}
	public void setOpen(Boolean open) {
		this.open = open;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getSeqnum() {
		return seqnum;
	}
	public void setSeqnum(Integer seqnum) {
		this.seqnum = seqnum;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
}
