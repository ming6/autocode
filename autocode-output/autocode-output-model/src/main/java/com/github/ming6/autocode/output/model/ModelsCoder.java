package com.github.ming6.autocode.output.model;

import java.util.ArrayList;
import java.util.List;

import com.github.ming6.autocode.core.AbstractCoder;
import com.github.ming6.autocode.input.jdbc.JdbcsCodeInput;
import com.github.ming6.autocode.input.jdbc.Table;

public class ModelsCoder extends AbstractCoder<List<Table>, List<Model>> {

	private String[] declarations;
	private String packageName;
	private String note;
	private String version;
	private String author;
	private String date;
	
	@Override
	public List<Model> convert(List<Table> tables) {
		List<Model> models = new ArrayList<>();
		ModelCoder coder = new ModelCoder();
		coder.setDeclarations(declarations);
		coder.setPackageName(packageName);
		coder.setNote(note);
		coder.setVersion(version);
		coder.setAuthor(author);
		coder.setDate(date);
		for(Table table : tables){
			models.add(coder.convert(table));
		}
		return models;
	}

	public String[] getDeclarations() {
		return declarations;
	}
	public void setDeclarations(String[] declarations) {
		this.declarations = declarations;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
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
	
	public static void main(String[] args) {
		JdbcsCodeInput input = new JdbcsCodeInput();
		input.setDriverClass("com.mysql.jdbc.Driver");
		input.setUrl("jdbc:mysql://10.1.1.68:3306/nbl_bidding");
		input.setUsername("jiaoyipt");
		input.setPassword("8kS#0(M");
		input.setTableNames(new String[]{ "APP_FORM", "APP_FORM_ITEM" });
		
		ModelsCodeOutput output = new ModelsCodeOutput();
		output.setDirPath("D:\\c");
		
		ModelsCoder coder = new ModelsCoder();
		coder.setDeclarations(new String[]{ 
			"Copyright (c) 2001-2016 Bidlink(Beijing) E-Biz Tech Co.,Ltd.",
			"All rights reserved.",
			"必联（北京）电子商务科技有限公司 版权所有"
		});
		coder.setPackageName("cn.bidlink.nbl.appset.model");
//		coder.setNote("");
		coder.setVersion("2.0.0");
		coder.setAuthor("<a href=\"jiamingliu@ebnew.com\">刘佳明</a>");
//		coder.setDate("");
		coder.coding(input, output);
	}
}