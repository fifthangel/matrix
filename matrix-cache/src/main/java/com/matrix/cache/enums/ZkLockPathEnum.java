package com.matrix.cache.enums;

/**
 * @description: zookeeper分布式锁路径描述，基于zookeeper的分布式锁的参数皆依据此枚举类
 *
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2018年9月6日 下午11:34:54 
 * @version 1.0.0.1
 */
public enum ZkLockPathEnum {

	zkLockRoot,        // zookeeper锁基础路径
	
	zkTest ,                  // 测试锁
	
}
