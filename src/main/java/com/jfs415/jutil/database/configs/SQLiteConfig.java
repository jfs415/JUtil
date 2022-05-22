package com.jfs415.jutil.database.configs;

import java.io.File;

import com.jfs415.jutil.JUtil;

public class SQLiteConfig extends SQLConfigClass {

	public SQLiteConfig(SQLConfigInterface sqlConfig) {
		super(sqlConfig);
	}

	@Override
	public String getDriverClassName() {
		return "com.mysql.cj.jdbc.Driver";
	}

	@Override
	public String getConnectionUrl() {
		return "jdbc:sqlite:" + new File(JUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getAbsolutePath() + File.separator + "data.db";
	}

}
