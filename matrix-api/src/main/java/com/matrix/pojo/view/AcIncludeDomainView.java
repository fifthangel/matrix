package com.matrix.pojo.view;


import com.matrix.pojo.entity.AcIncludeDomain;

public class AcIncludeDomainView extends AcIncludeDomain{
    private String creator;
    private String updater;
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
    
}