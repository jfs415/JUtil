package com.jfs415.jutil.database.configs;

public interface SQLConfigInterface {
	
	/*
		Establish a contract the provided config must follow in order to 
		ensure type safety and ensure the user knows what info must be provided
		for a successful connection to occur.
	 */

	String getHost();

	String getUsername();

	String getPassword();

	String getDatabase();

	int getPort();

	int getMinimumIdle();

	void setMinimumIdle(int minimumIdle);

	int getMaxPoolSize();

	void setMaxPoolSize(int maxPoolSize);

	boolean usesMultipleQueries();

	void setUsesMultipleQueries(boolean useMultipleQueries);

}
