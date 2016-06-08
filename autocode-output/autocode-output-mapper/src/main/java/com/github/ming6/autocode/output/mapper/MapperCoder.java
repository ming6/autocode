package com.github.ming6.autocode.output.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.ming6.autocode.core.AbstractCoder;
import com.github.ming6.autocode.input.jdbc.Column;
import com.github.ming6.autocode.input.jdbc.JdbcCodeInput;
import com.github.ming6.autocode.input.jdbc.Table;
import com.github.ming6.autocode.utils.NameUtil;

public class MapperCoder extends AbstractCoder<Table, Mapper> {
	
	private String packageName;

	@Override
	public Mapper convert(Table table) {
		Mapper mapper = new Mapper();
		mapper.setTableName(table.getName());
		mapper.setSimpleModelName(NameUtil.handleClassName(table.getName()));
		mapper.setModelName(packageName + "." + mapper.getSimpleModelName());
		mapper.setNamespace(mapper.getModelName());
		List<Mapping> mappings = new ArrayList<>();
		for(Column column : table.getColumns()){
			String property = NameUtil.handleFieldName(column.getName());
			String javaType = NameUtil.handleFieldTypeName(column.getType());
			Mapping mapping = new Mapping(property, column.getName(), javaType);
			mappings.add(mapping);
		}
		mapper.setMappings(mappings);
		return mapper;
	}

	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	public static void main(String[] args) {
		JdbcCodeInput input = new JdbcCodeInput();
		input.setDriverClass("com.mysql.jdbc.Driver");
		input.setUrl("");
		input.setUsername("");
		input.setPassword("");
		input.setTableName("");
		
		MapperCodeOutput output = new MapperCodeOutput();
		output.setDirPath("");
		
		MapperCoder coder = new MapperCoder();
		coder.setPackageName("");
		coder.coding(input, output);
	}
}