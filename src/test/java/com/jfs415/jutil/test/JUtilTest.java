package com.jfs415.jutil.test;

import org.junit.jupiter.api.Test;

import com.jfs415.jutil.database.DatabaseManager;
import com.jfs415.jutil.database.configs.SQLConfigAnnotation;
import com.jfs415.jutil.database.configs.SQLConfigInterface;

public class JUtilTest {

	@Test
	public void run() {
		DatabaseManager dbManager = DatabaseManager.getInstance();
		Class<? extends SQLConfigInterface> test = TestConfig.class;
		SQLConfigAnnotation configAnnotation = test.getDeclaredAnnotation(SQLConfigAnnotation.class);
		dbManager.consumeSqlAnnotatedConfig(configAnnotation, test);
		dbManager.getDatabase().start();

		if (dbManager.getDatabase().isConnected()) {
			System.out.println("CONNECTION SUCCESSFUL");
		}

		dbManager.getDatabase().shutdown();

		if (dbManager.getDatabase().isClosed()) {
			System.out.println("SHUTDOWN SUCCESSFUL");
		}
	}

}
