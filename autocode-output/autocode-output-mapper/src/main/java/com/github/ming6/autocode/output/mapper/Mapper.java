package com.github.ming6.autocode.output.mapper;

import java.util.List;

public class Mapper {
	
	private String namespace;
	private String tableName;
	private String modelName;
	private String simpleModelName;
	private List<Mapping> mappings;
	
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getSimpleModelName() {
		return simpleModelName;
	}
	public void setSimpleModelName(String simpleModelName) {
		this.simpleModelName = simpleModelName;
	}
	public List<Mapping> getMappings() {
		return mappings;
	}
	public void setMappings(List<Mapping> mappings) {
		this.mappings = mappings;
	}
}