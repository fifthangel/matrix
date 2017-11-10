package com.matrix.pojo.dto;

public class Head {
	private String target; // 所开放的接口名称
	private String source; // 请求源 。private:私有 即公司内部使用的接口| public:公开，即开放给第三方的接口
	private String client; // 请求客户端类型。0:IOS   1:Android   2:微信   3:服务器
	private String version; // 客户端版本
	private String requestTime; // 请求发起时间
	private String accessToken; // 
	
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
}
