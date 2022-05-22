package com.jfs415.jutil;

import com.jfs415.jutil.database.DatabaseManager;
import com.jfs415.jutil.database.configs.SQLConfigAnnotation;
import com.jfs415.jutil.database.configs.SQLConfigInterface;

public class JUtil {

	private static final JUtil INSTANCE = new JUtil();
	private static final DatabaseManager DBMANAGER = DatabaseManager.getInstance();

	private static Class<? extends SQLConfigInterface> sqlConfig; //Check annotation and class assignment before registering to verify type safety. Casting will be done in db manager

	private static SQLConfigAnnotation configAnnotation;

	private JUtil() { }

	public static JUtil getInstance() {
		return INSTANCE;
	}

	public static void registerConfig(Class<? extends SQLConfigInterface> configClass) {
		final SQLConfigAnnotation configAnnotation = configClass.getDeclaredAnnotation(SQLConfigAnnotation.class);

		if (configAnnotation == null) {
			throw new IllegalArgumentException("SQL Config classes must be annotated with @" + SQLConfigAnnotation.class.getSimpleName() + "!");
		} else if (!SQLConfigInterface.class.isAssignableFrom(configClass)) {
			throw new IllegalArgumentException("SQL config class must implement " + SQLConfigInterface.class.getSimpleName() + " !");
		}

		sqlConfig = configClass;
	}

	public static void startDatabase() {
		DBMANAGER.consumeSqlAnnotatedConfig(configAnnotation, sqlConfig);
	}

}
