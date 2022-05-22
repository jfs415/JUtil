package com.jfs415.jutil.database.util;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.UUID;

import com.jfs415.jutil.database.DatabaseType;

public class TypeMap {

	private static EnumMap<DatabaseType, HashMap<Class<?>, String>> enumTypes = new EnumMap<>(DatabaseType.class);

	static {
		// BASE SQL TYPES
		HashMap<Class<?>, String> sqlBaseTypes = new HashMap<>();
		sqlBaseTypes.put(boolean.class, "TINYINT(1)");
		sqlBaseTypes.put(Boolean.class, "TINYINT(1)");
		sqlBaseTypes.put(byte.class, "TINYINT");
		sqlBaseTypes.put(Byte.class, "TINYINT");
		sqlBaseTypes.put(short.class, "SMALLINT");
		sqlBaseTypes.put(Short.class, "SMALLINT");
		sqlBaseTypes.put(int.class, "INT");
		sqlBaseTypes.put(Integer.class, "INT");
		sqlBaseTypes.put(long.class, "BIGINT");
		sqlBaseTypes.put(Long.class, "BIGINT");
		sqlBaseTypes.put(float.class, "FLOAT");
		sqlBaseTypes.put(Float.class, "FLOAT");
		sqlBaseTypes.put(double.class, "DOUBLE");
		sqlBaseTypes.put(Double.class, "DOUBLE");
		sqlBaseTypes.put(UUID.class, "CHAR(36)");
		sqlBaseTypes.put(Date.class, "DATE");
		sqlBaseTypes.put(Time.class, "TIME");

		// ADD MYSQL SPECIFICS
		HashMap<Class<?>, String> mysqlTypes = new HashMap<>(sqlBaseTypes);
		mysqlTypes.put(Timestamp.class, "TIMESTAMP");
		mysqlTypes.put(String.class, "VARCHAR");

		// TODO: Other types if needed

		enumTypes.put(DatabaseType.SQLITE, sqlBaseTypes);
		enumTypes.put(DatabaseType.MYSQL, mysqlTypes);
	}

	public static String getTypeString(DatabaseType type, Class<?> valueClass) {
		return enumTypes.getOrDefault(type, new HashMap<>()).getOrDefault(valueClass, null);
	}

}
