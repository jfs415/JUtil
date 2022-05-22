package com.jfs415.jutil.database.configs;

public abstract class SQLConfigClass implements Cloneable {

	private final String host;
	private final String username;
	private final String password;
	private final String database;

	private final int port;

	private int minimumIdle;

	private int maxPoolSize;

	private boolean useMultipleQueries;

	public SQLConfigClass(SQLConfigInterface sqlConfig) {
		this.host = sqlConfig.getHost();
		this.username = sqlConfig.getUsername();
		this.password = sqlConfig.getPassword();
		this.database = sqlConfig.getDatabase();
		this.port = sqlConfig.getPort();
		this.useMultipleQueries = sqlConfig.usesMultipleQueries();
		this.maxPoolSize = sqlConfig.getMaxPoolSize();
		this.minimumIdle = sqlConfig.getMinimumIdle();
	}

	public abstract String getConnectionUrl();

	public abstract String getDriverClassName();

	protected String getHost() {
		return host;
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

	protected int getPort() {
		return port;
	}

	public final int getMaxPoolSize() {
		return maxPoolSize;
	}

	protected void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

	public final int getMinimumIdle() {
		return minimumIdle;
	}

	protected final void setMinimumIdle(int minimumIdle) {
		this.minimumIdle = minimumIdle;
	}

	protected final boolean usesMultipleQueries() {
		return useMultipleQueries;
	}

	protected final void setUsesMultipleQueries(boolean useMultipleQueries) {
		this.useMultipleQueries = useMultipleQueries;
	}

	@Override
	public SQLConfigInterface clone() {
		try {
			return (SQLConfigInterface) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

}
