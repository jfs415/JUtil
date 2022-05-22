package com.jfs415.jutil.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;

import com.jfs415.jutil.database.configs.SQLConfigClass;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariPool;

public class SQLDatabase {

	private HikariDataSource hikariDataSource;
	private CountDownLatch availableLatch = new CountDownLatch(1);

	private final SQLConfigClass config;

	private boolean initialized;

	public SQLDatabase(SQLConfigClass sqlConfig) {
		this.config = sqlConfig;
		start();
	}

	public void start() {
		HikariConfig hikariConfig = new HikariConfig();

		if (hikariDataSource != null) {
			shutdown();
		}

		try {
			hikariConfig.setJdbcUrl(config.getConnectionUrl());
			hikariConfig.setDriverClassName(config.getDriverClassName());
			hikariConfig.setUsername(config.getUsername());
			hikariConfig.setPassword(config.getPassword());
			hikariConfig.setMinimumIdle(config.getMinimumIdle());
			hikariConfig.setMaximumPoolSize(config.getMaxPoolSize());
			hikariConfig.setConnectionTestQuery("USE " + config.getDatabase());

			hikariConfig.setConnectionTimeout(500L);
			hikariDataSource = new HikariDataSource(hikariConfig);
			availableLatch.countDown();
		} catch (HikariPool.PoolInitializationException e) {
			System.out.println("Failed to connect to database " + config.getDatabase());
			e.printStackTrace();
		}
	}

	protected void close(AutoCloseable... close) {
		for (AutoCloseable closeable : close) {
			if (closeable == null) {
				continue;
			}
			try {
				closeable.close();
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
	}

	public Connection getConnection() {
		if (hikariDataSource == null) {
			throw new IllegalStateException("Database has not been initialized!");
		}
		try {
			try {
				availableLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return hikariDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean isConnected() {
		return hikariDataSource != null && !hikariDataSource.isClosed();//&& source.isRunning();
	}

	public boolean isClosed() {
		return hikariDataSource == null || hikariDataSource.isClosed();
	}

	public void shutdown() {
		if (hikariDataSource != null && !hikariDataSource.isClosed()) {
			hikariDataSource.close();
			hikariDataSource = null;
		}
	}

	public void reload() {
		availableLatch = new CountDownLatch(1);
		shutdown();
		start();
	}

	public void initialize() {
		initialized = true;
	}

	public boolean isInitialized() {
		return initialized;
	}

}
