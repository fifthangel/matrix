package com.matrix.hystrix;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;

import org.apache.log4j.Logger;

@Activate(group = Constants.CONSUMER, before = "future")
public class CircuitBreakerFilter implements Filter {

	private static Logger logger = Logger.getLogger(CircuitBreakerFilter.class);

	private final String FALLBACK_METHOD_NAME = "fallback";
	
	
	
	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		
		return null;
	}

}

































































