package com.jfs415.jutil.database.configs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jfs415.jutil.database.DatabaseType;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLConfigAnnotation {

	DatabaseType dbType() default DatabaseType.MYSQL;

}
