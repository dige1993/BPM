package com.bpm.action;

import com.bpm.bean.Unit;
import com.bpm.dao.UnitDao;
import com.opensymphony.xwork2.ActionSupport;

public class UnitAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Unit organization;

	public Unit getOrganization() {
		return organization;
	}

	public void setOrganization(Unit organization) {
		this.organization = organization;
	}

	public String showStructure(){
		UnitDao unitdao = new UnitDao();
		organization = new Unit();
		organization.setName("ÌìççÎÞÏß");
		unitdao.getBranches(organization);
		return SUCCESS;
	}
	
	
	
	public String Test(){
		System.out.println("test");
		return ERROR;
	}
}
