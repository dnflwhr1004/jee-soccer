package com.soccer.web.factory;

import com.soccer.web.enums.DB;

public class DatabaseFactory {
	
	// 데이터베이스 객체를 여기서 만든다.
	public static Database createDatabase(String vendor) {
		Database db = null;
		
		switch(DB.valueOf(vendor)) {
		case ORACLE : db = new Oracle(); break;
		case MARIADB : db = new Mariadb(); break;
		case H2 : break;
		case DB2 : break;
	
		}	
		return db;
	}
}
