package com.matrix.helper;


/**
 * @description: 基于Zookeeper的高可用分布式锁
 * 	
 * 	有效的解决单点问题，不可重入问题，非阻塞问题以及锁无法释放的问题
 *
 *			    基于zookeeper，curator实现的分布式锁，
 *		包括InterProcessMutex锁、InterProcessReadWriteLock读写锁、
 *		信号量InterProcessSemaphoreV2、 分布式栅栏DistributedBarrier		https://blog.csdn.net/chinabestchina/article/details/78659302
 *		
 *																											dev_zk_host=
 *		从性能角度（从高到低） 缓存 > 
 *			Zookeeper >= 数据库
 *		从可靠性角度（从高到低） 
 *			Zookeeper > 缓存 > 数据库
 *
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2018年9月4日 下午11:56:47 
 * @version 1.0.0.1
 */
public class DistributedZkLockHelper {

	private DistributedZkLockHelper() {
	}
	private static class LazyHolder {
		private static final DistributedZkLockHelper INSTANCE = new DistributedZkLockHelper();
	}
	public static final DistributedZkLockHelper getInstance() {
		return LazyHolder.INSTANCE; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



























































