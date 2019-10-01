package com.soccer.web.enums;

public enum DBDriver {
	ORACLE_DRIVER,
	MARIADB_DRIVER;
	
	@Override
	public String toString() {
		String driver = "";
		switch (this) {
		case ORACLE_DRIVER:
			driver = "oracle.jdbc.OracleDriver";
			break;
		case MARIADB_DRIVER :
			driver = "org.mariadb.jdbc.Driver";
			break;
		default:
			break;
		}
		return driver;
	}
}
