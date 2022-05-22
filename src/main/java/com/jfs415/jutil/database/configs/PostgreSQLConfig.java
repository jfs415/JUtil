package com.jfs415.jutil.database.configs;

public class PostgreSQLConfig extends SQLConfigClass {

	public PostgreSQLConfig(SQLConfigInterface config) {
		super(config);
	}

	@Override
	public String getConnectionUrl() {
		return "jdbc:postgresql://" + getHost() + "/" + getDatabase();
	}

	@Override
	public String getDriverClassName() {
		return "org.postgresql.Driver";
	}

}
