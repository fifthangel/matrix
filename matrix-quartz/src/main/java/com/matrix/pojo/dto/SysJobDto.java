package com.matrix.pojo.dto;

import java.util.List;

import com.matrix.base.BaseDto;

public class SysJobDto extends BaseDto{
	
	private static final long serialVersionUID = 5701420615486364113L;
	
	private Integer flagEnable;
    private List<String> rglist; //  runGroupId list - Yangcl 
    
	public Integer getFlagEnable() {
		return flagEnable;
	}
	public void setFlagEnable(Integer flagEnable) {
		this.flagEnable = flagEnable;
	}
	public List<String> getRglist() {
		return rglist;
	}
	public void setRglist(List<String> rglist) {
		this.rglist = rglist;
	}
    
    
}
