package com.jfs415.jutil.test;

import com.jfs415.jutil.database.configs.SQLConfigAnnotation;
import com.jfs415.jutil.database.configs.SQLConfigInterface;
import com.jfs415.jutil.database.DatabaseType;

@SQLConfigAnnotation(dbType = DatabaseType.MYSQL) //instanceType = InstanceType.STATIC
public class TestConfig implements SQLConfigInterface {

	private final String host;
	private final String username;
	private final String password;
	private final String database;
	private final int port;
	private final boolean useMultipleQueries;
	private final int maxPoolSize;
	private int minimumIdle;

	public TestConfig() {
		this.host = "localhost";
		this.username = "";
		this.password = "";
		this.database = "";
		this.port = 3306;
		this.useMultipleQueries = false;
		this.maxPoolSize = 10;
		this.minimumIdle = 2;
	}

	@Override
	public String getHost() {
		return "localhost";
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getDatabase() {
		return database;
	}

	public String getConnectionUrl() {
		return null;
	}

	public String getDriverClassName() {
		return null;
	}

	public int getPort() {
		return port;
	}

	public int getMinimumIdle() {
		return minimumIdle;
	}

	public void setMinimumIdle(int minimumIdle) {
		this.minimumIdle = minimumIdle;
	}

	public int getMaxPoolSize() {
		return maxPoolSize;
	}

	@Override
	public void setMaxPoolSize(int maxPoolSize) { }

	@Override
	public boolean usesMultipleQueries() {
		return useMultipleQueries;
	}

	@Override
	public void setUsesMultipleQueries(boolean useMultipleQueries) { }

}
