package com.soccer.web.factory;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

import lombok.Data;
@Data
public class DatabaseBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String url, userId, driver, password;
	private Connection conn; 
	
	public DatabaseBean(String driver, String url, String userId,  String password) {
		this.driver = driver;
		this.password = password;
		this.url = url;
		this.userId = userId;
	}
	
	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn = 	DriverManager.getConnection(url,userId,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
}
