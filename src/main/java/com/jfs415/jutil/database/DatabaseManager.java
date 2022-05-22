package com.jfs415.jutil.database;

import com.jfs415.jutil.Reflection;
import com.jfs415.jutil.database.configs.MongoDBConfig;
import com.jfs415.jutil.database.configs.MySQLConfig;
import com.jfs415.jutil.database.configs.PostgreSQLConfig;
import com.jfs415.jutil.database.configs.SQLConfigAnnotation;
import com.jfs415.jutil.database.configs.SQLConfigClass;
import com.jfs415.jutil.database.configs.SQLConfigInterface;
import com.jfs415.jutil.database.configs.SQLiteConfig;

public class DatabaseManager {

	private SQLConfigAnnotation sqlConfigAnnotation;

	private SQLDatabase database;
	private SQLConfigClass sqlConfig;
	private static DatabaseManager INSTANCE;

	private DatabaseManager() { }

	public static DatabaseManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DatabaseManager();
		}
		return INSTANCE;
	}

	public void consumeSqlAnnotatedConfig(SQLConfigAnnotation configAnnotation, Class<? extends SQLConfigInterface> config) {
		this.sqlConfigAnnotation = configAnnotation;
		try {
			this.sqlConfig = getConfigFromType(configAnnotation, config);
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println("Unable to instantiate SQLConfig " + config.getSimpleName());
		}

		this.database = new SQLDatabase(this.sqlConfig);
	}

	public SQLDatabase getDatabase() {
		return database;
	}

	private SQLConfigClass getConfigFromType(SQLConfigAnnotation configAnnotation, Class<? extends SQLConfigInterface> config) throws InstantiationException, IllegalAccessException {
		switch (configAnnotation.dbType()) {
			case MYSQL:
				return new MySQLConfig((SQLConfigInterface) Reflection.getInstance(config));
			case SQLITE:
				return new SQLiteConfig((SQLConfigInterface) Reflection.getInstance(config));
			case MONGODB:
				return new MongoDBConfig((SQLConfigInterface) Reflection.getInstance(config));
			case POSTGRESQL:
				return new PostgreSQLConfig((SQLConfigInterface) Reflection.getInstance(config));
		}
		return null;
	}

}
