package com.github.ming6.autocode.input.jdbc;

import java.util.ArrayList;
import java.util.List;

import com.github.ming6.autocode.core.CodeInput;

public class JdbcsCodeInput implements CodeInput<List<Table>> {

	private String driverClass;
	private String url;
	private String username;
	private String password;
	private String[] tableNames;
	
	public List<Table> read() {
		List<Table> tables = new ArrayList<Table>();
		JdbcCodeInput input = new JdbcCodeInput();
		input.setDriverClass(driverClass);
		input.setUrl(url);
		input.setUsername(username);
		input.setPassword(password);
		for(String tableName : tableNames){
			input.setTableName(tableName);
			Table table = input.read();
			tables.add(table);
		}
		return tables;
	}

	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String[] getTableNames() {
		return tableNames;
	}
	public void setTableNames(String[] tableNames) {
		this.tableNames = tableNames;
	}
}