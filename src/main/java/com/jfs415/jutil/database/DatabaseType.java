package com.jfs415.jutil.database;

public enum DatabaseType {

	MYSQL("MySQL"),
	SQLITE("SQLite"),
	MONGODB("MongoDB"),
	POSTGRESQL("ProstreSQL"),
	ORACLE("Oracle"),
	MSSQL("MsSQL"),

	;

	private String name;

	private DatabaseType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
