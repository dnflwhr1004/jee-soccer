package com.soccer.web.factory;

public class DatabaseFactory {
	
	// 데이터베이스 객체를 여기서 만든다.
	public static Database createDatabase(String vendor) {
		Database db = null;
		switch(vendor) {
		case "oracle" : db = new Oracle(); break;
		case "mariadb" : db = new Mariadb(); break;
		case "h2" : break;
		case "db2" : break;
	
		}	
		return db;
	}
}
