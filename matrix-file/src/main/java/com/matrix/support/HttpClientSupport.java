package com.matrix.support;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseClass;

/**
 * @description: 基于HttpClient 4.5.1的封装类。用于调用第三方的开放接口使用。
 * 	这是一个抽象类，在项目的单元测试目录下有可以参考的测试类：HttpClientSupportTest.java
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2017年11月06日 下午2:06:08 
 * @version 1.0.0
 */
public abstract class HttpClientSupport extends BaseClass{
	
	
	/**
	 * @description: 非加密方式请求第三方服务器接口
	 *
	 * @param url
	 * @author Yangcl
	 * @date 2017年11月6日 下午2:29:21 
	 * @version 1.0.0
	 */
	public JSONObject requestServerStream(String url){ 
		JSONObject result = new JSONObject(); 
		result.put("status", "success"); 
		result.put("msg", "成功！"); 
		
		InputStream inputStream = this.streamInit();
		HttpPost post = this.postInit(url, inputStream);
		
		HttpClientBuilder clientBuilder = HttpClientBuilder.create();
		RequestConfig.Builder configBuilder = RequestConfig.custom()
			.setConnectTimeout(60*1000)
			.setConnectionRequestTimeout(60*1000)
			.setSocketTimeout(60*1000);
		
		clientBuilder.setDefaultRequestConfig(configBuilder.build());
		clientBuilder.disableContentCompression();  // 4.3以后会自动在interceptor中实现启用压缩和自动解压，所以不需要gzip的时候需要指定一下---binfile-gzip true/false
		
		CloseableHttpClient client = clientBuilder.build();
		HttpResponse response = null;
		try {
			response = client.execute(post);
			result.put("status", "success"); 
			result.put("msg", "成功！"); 
			result.put("status-code", response.getStatusLine().getStatusCode()); 
			result.put("data", EntityUtils.toString(response.getEntity())); 
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result.put("status", "error"); 
			result.put("msg", "ClientProtocolException at com.matrix.support.HttpClientSupport.java function requestServerStream(String url)");  
		} catch (IOException e) {
			e.printStackTrace();
			result.put("status", "error"); 
			result.put("msg", "IOException at com.matrix.support.HttpClientSupport.java function requestServerStream(String url)");
		}
		
		return result;
	}
	
	/**
	 * @description: 子类方法中需要根据具体情况来构建InputStream对象。
	 * 		当需要请求的第三方接口需要传递给他一个二进制流的时候，这个方法会用到。
	 *
	 * @param url
	 * @author Yangcl
	 * @date 2017年11月6日 下午2:29:21 
	 * @version 1.0.0
	 */
	public abstract InputStream streamInit();
	
	
	/**
	 * @description: 子类方法中需要根据具体情况来构建HttpPost对象
	 *
	 * @param url
	 * @author Yangcl
	 * @date 2017年11月6日 下午2:29:21 
	 * @version 1.0.0
	 */
	public abstract HttpPost postInit(String url , InputStream inputStream);

	
	
 
}


















