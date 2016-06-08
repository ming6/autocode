package com.github.ming6.autocode.output.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.ming6.autocode.core.AbstractCoder;
import com.github.ming6.autocode.input.jdbc.Column;
import com.github.ming6.autocode.input.jdbc.JdbcCodeInput;
import com.github.ming6.autocode.input.jdbc.Table;
import com.github.ming6.autocode.utils.NameUtil;

public class ModelCoder extends AbstractCoder<Table, Model> {
	
	private String[] declarations;
	private String packageName;
	private String note;
	private String version;
	private String author;
	private String date;

	@Override
	public Model convert(Table table) {
		Model model = new Model();
		model.setDeclarations(declarations);
		model.setPackageName(packageName);
		model.setNote(note);
		model.setVersion(version);
		model.setAuthor(author);
		if(date == null){
			SimpleDateFormat format = new SimpleDateFormat();
			date = format.format(new Date());
		}
		model.setDate(date);
		model.setName(NameUtil.handleClassName(table.getName()));
		List<Field> fields = new ArrayList<>();
		for(Column column : table.getColumns()){
			String name = NameUtil.handleFieldName(column.getName());
			String type = NameUtil.handleFieldTypeName(column.getType());
			fields.add(new Field(name, type, column.getComment()));
		}
		model.setFields(fields);
		return model;
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
		JdbcCodeInput input = new JdbcCodeInput();
		input.setDriverClass("com.mysql.jdbc.Driver");
		input.setUrl("");
		input.setUsername("");
		input.setPassword("");
		input.setTableName("");
		
		ModelCodeOutput output = new ModelCodeOutput();
		output.setDirPath("");
		
		ModelCoder coder = new ModelCoder();
		coder.setDeclarations(new String[]{ });
		coder.setPackageName("");
		coder.setNote("");
		coder.setVersion("");
		coder.setAuthor("");
		coder.setDate("");
		coder.coding(input, output);
	}
}