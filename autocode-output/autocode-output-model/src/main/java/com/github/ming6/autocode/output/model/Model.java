package com.github.ming6.autocode.output.model;

import java.util.List;

public class Model {
	
	private String[] declarations;
	private String note;
	private String version;
	private String author;
	private String date;
	
	private String packageName;
	private String name;
	private List<Field> fields;
	
	
	public String[] getDeclarations() {
		return declarations;
	}
	public void setDeclarations(String[] declarations) {
		this.declarations = declarations;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
}