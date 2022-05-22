package com.jfs415.jutil.database.configs;

public class MySQLConfig extends SQLConfigClass {

	public MySQLConfig(SQLConfigInterface configInterface) {
		super(configInterface);
	}

	@Override
	public String getDriverClassName() {
		return "com.mysql.cj.jdbc.Driver";
	}

	@Override
	public String getConnectionUrl() {
		return getDatabase() == null || getHost() == null || getPort() <= 0 ? null : "jdbc:mysql://" + getHost() + ":" + getPort() + "/" + getDatabase() + (usesMultipleQueries() ? "?allowMultiQueries=true" : "");
	}

}
