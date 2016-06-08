package com.github.ming6.autocode.output.model;

import com.github.ming6.autocode.utils.NameUtil;

public class Field {
	
	private String note;
	private String name;
	private String getMethodName;
	private String setMethodName;
	private String type;
	
	public Field(){}
	public Field(String name, String type){
		this.name = name;
		this.type = type;
		this.getMethodName = NameUtil.handleFieldGetMethodName(name);
		this.setMethodName = NameUtil.handleFieldSetMethodName(name);
	}
	public Field(String name, String type, String note){
		this(name, type);
		this.note = note;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGetMethodName() {
		return getMethodName;
	}
	public void setGetMethodName(String getMethodName) {
		this.getMethodName = getMethodName;
	}
	public String getSetMethodName() {
		return setMethodName;
	}
	public void setSetMethodName(String setMethodName) {
		this.setMethodName = setMethodName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}