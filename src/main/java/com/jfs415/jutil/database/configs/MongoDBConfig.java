package com.jfs415.jutil.database.configs;

public class MongoDBConfig extends SQLConfigClass {

	public MongoDBConfig(SQLConfigInterface configInterface) {
		super(configInterface);
	}

	public String getDataSourceType() {
		return "com.zaxxer.hikari.HikariDataSource";
	}

	@Override
	public String getConnectionUrl() {
		return "jdbc:mongo://" + getHost() + "/" + getDatabase();
	}

	@Override
	public String getDriverClassName() {
		return null;
	}

}
