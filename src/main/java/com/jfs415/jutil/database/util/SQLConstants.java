package com.jfs415.jutil.database.util;

public class SQLConstants {

	public static final String NULL = "NULL";
	public static final String FROM = "FROM";
	public static final String CURRENT_TIMESTAMP = "CURRENT_TIMESTAMP";
	public static final String CURRENT_TIMESTAMP_ON_UPDATE = "CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP";
	public static final String NOW = "NOW()";

	public class Column {

		public static final String PRIMARY_KEY = "PRIMARY KEY";
		public static final String FOREIGN_KEY = "FOREIGN KEY";
		public static final String NOT_NULL = "NOT NULL";
		public static final String UNIQUE = "UNIQUE";
		public static final String UNSIGNED = "UNSIGNED";
		public static final String ZERO_FILL = "ZEROFILL";
		public static final String AUTO_INCREMENT = "AUTO INCREMENT";
		public static final String GENERATED = "GENERATED ALWAYS AS () VIRTUAL";
		public static final String CHECK = "CHECK";
		public static final String DEFAULT = "DEFAULT";
		public static final String EXCLUSION = "EXCLUSION";

	}

}
