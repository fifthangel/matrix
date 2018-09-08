package com.matrix.hystrix;

import com.alibaba.dubbo.common.extension.SPI;


/**
 * @description: 业务失败返回处理函数
 *
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2018年9月8日 下午1:11:31 
 * @version 1.0.0.1
 */
@SPI
public interface IFallback {
	public Object invoke();
}
