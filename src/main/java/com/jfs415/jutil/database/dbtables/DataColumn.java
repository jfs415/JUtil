package com.jfs415.jutil.database.dbtables;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jfs415.jutil.database.util.SQLConstants;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataColumn {

	boolean primary() default false;

	boolean unique() default false;

	boolean nullable() default false;

	boolean autoIncrement() default false;

	int maxLength() default 16;

	String defaultValue() default SQLConstants.NULL;

}
