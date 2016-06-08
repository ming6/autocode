package com.github.ming6.autocode.output.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.ming6.autocode.core.AbstractCoder;
import com.github.ming6.autocode.input.jdbc.JdbcsCodeInput;
import com.github.ming6.autocode.input.jdbc.Table;

public class MappersCoder extends AbstractCoder<List<Table>, List<Mapper>> {

	private String packageName;
	
	@Override
	public List<Mapper> convert(List<Table> tables) {
		MapperCoder coder = new MapperCoder();
		coder.setPackageName(packageName);
		List<Mapper> mappers = new ArrayList<>();
		for(Table table : tables){
			mappers.add(coder.convert(table));
		}
		return mappers;
	}

	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	public static void main(String[] args) {
		JdbcsCodeInput input = new JdbcsCodeInput();
		input.setDriverClass("com.mysql.jdbc.Driver");
		input.setUrl("jdbc:mysql://10.1.1.68:3306/nbl_bidding");
		input.setUsername("jiaoyipt");
		input.setPassword("8kS#0(M");
		input.setTableNames(new String[]{ "APP_FORM", "APP_FORM_ITEM" });
		
		MappersCodeOutput output = new MappersCodeOutput();
		output.setDirPath("D:\\c");
		
		MappersCoder coder = new MappersCoder();
		coder.setPackageName("cn.bidlink.nbl.appset.model");
		coder.coding(input, output);
	}
}