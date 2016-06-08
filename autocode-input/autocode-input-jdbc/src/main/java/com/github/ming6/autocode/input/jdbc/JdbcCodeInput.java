package com.github.ming6.autocode.input.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.github.ming6.autocode.core.CodeInput;

public class JdbcCodeInput implements CodeInput<Table> {
	
	private String driverClass;
	private String url;
	private String username;
	private String password;
	private String tableName;
	
	public Table read() {
		Table table = new Table(tableName);
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, username, password);
			ps = conn.prepareStatement("SHOW FULL COLUMNS FROM " + tableName);
			rs = ps.executeQuery();
			List<Column> columns = new ArrayList<Column>();
			while(rs.next()){
				columns.add(new Column(rs.getString("Field"), rs.getString("Type"), rs.getString("Comment")));
			}
			table.setColumns(columns);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return table;
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
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}