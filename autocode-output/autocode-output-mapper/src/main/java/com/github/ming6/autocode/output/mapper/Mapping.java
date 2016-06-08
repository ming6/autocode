package com.github.ming6.autocode.output.mapper;

public class Mapping {
	
	private String property;
	private String column;
	private String javaType;
	
	public Mapping(){}
	public Mapping(String property, String column){
		this.property = property;
		this.column = column;
	}
	public Mapping(String property, String column, String javaType){
		this(property, column);
		this.javaType = javaType;
	}
	
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String getJavaType() {
		return javaType;
	}
	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}
}