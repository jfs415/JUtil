package com.jfs415.jutil;

public class Reflection {

	public static Object getInstance(Class<?> clazz) throws InstantiationException, IllegalAccessException {
		return clazz.newInstance();
	}

}
