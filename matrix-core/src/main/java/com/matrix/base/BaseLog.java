package com.matrix.base;

import org.apache.log4j.Logger;

import com.matrix.system.cache.PropVisitor;


/**
 * @description: 基础日志服务类  
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2016年9月29日 下午2:33:16 
 * @version 1.0.0
 */
public class BaseLog{   
	private BaseLog() {};
	private static class LazyHolder {
		private static final BaseLog INSTANCE = new BaseLog();
	}
	public static final BaseLog getInstance() {
		return LazyHolder.INSTANCE; 
	}
	
	private Logger logger = null;
	
	public BaseLog setLogger(Logger log) {
		this.logger = log;
		return BaseLog.getInstance();
	}
	
	/**
	 * @description: 格式化日志输出
	 * 
	 * @param infoCode
	 * @param sParms
	 * @return
	 * @author Yangcl 
	 * @date 2016年11月11日 下午6:35:30 
	 * @version 1.0.0.1
	 */
	public String formatLog(int infoCode, Object... sParms) {
		return " -- [info code: " + String.valueOf(infoCode) + "] -- " + PropVisitor.getLogInfo(infoCode, sParms);
	}
	
	
 
	public void logInfo(int infoCode) {
		this.logger.info(PropVisitor.getLogInfo(infoCode));
	}
	
	public void logInfo(int infoCode, Object... sParms) {
		this.logger.info(formatLog(infoCode, sParms));
	}
	
	public void logInfo(String content) {
		this.logger.info(content);
	}
	
	
	public void logError(int infoCode) {
		this.logger.error(PropVisitor.getLogInfo(infoCode));
	}
	
	public void logError(int infoCode, Object... sParms) {
		this.logger.error(formatLog(infoCode, sParms));
	}
	
	public void logError(String content) {
		this.logger.error(content);
	}
	

	public void logWarn(int infoCode) {
		this.logger.warn(PropVisitor.getLogInfo(infoCode));
	}
	
	public void logWarn(int infoCode, Object... sParms) {
		this.logger.warn(formatLog(infoCode, sParms));
	}
	
	public void logWarn(String content) {
		this.logger.warn(content);
	}
	
	public void logDebug(int infoCode) {
		this.logger.debug(PropVisitor.getLogInfo(infoCode));
	}
	
	public void logDebug(int infoCode, Object... sParms) {
		this.logger.debug(formatLog(infoCode, sParms));
	}
	
	public void logDebug(String content) {
		this.logger.debug(content);
	}
}



















