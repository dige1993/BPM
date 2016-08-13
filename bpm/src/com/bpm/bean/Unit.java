package com.bpm.bean;

import java.util.ArrayList;

public class Unit {
	
	private int id;
	private String name;
	private String parentName;
	private ArrayList<Unit> children;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public ArrayList<Unit> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<Unit> children) {
		this.children = children;
	}

}
