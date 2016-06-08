package com.github.ming6.autocode.utils;

public class NameUtil {
	
	/**
	 * @param 表名称
	 * @return 类名称
	 * */
	public static final String handleClassName(String tableName){
		String className = "";
		for(String word : tableName.split("_")){
			className = className + handleFirstWordUppercaseAndOtherLowercase(word);
		}
		return className;
	}
	
	/**
	 * @param 列名称
	 * @return 类属性名称
	 * */
	public static final String handleFieldName(String columnName){
		String fieldName = "";
		int i = 0;
		for(String word : columnName.split("_")){
			if(i == 0){
				fieldName = fieldName + word.toLowerCase();
			}else{
				fieldName = fieldName + handleFirstWordUppercaseAndOtherLowercase(word);
			}
			i++;
		}
		return fieldName;
	}
	
	public static final String handleFieldGetMethodName(String fieldName){
		return "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
	}
	public static final String handleFieldSetMethodName(String fieldName){
		return "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
	}
	
	public static final String handleFieldTypeName(String columnTypeName){
		if(columnTypeName.startsWith("char") || columnTypeName.startsWith("varchar")){
			return "String";
		}else if(columnTypeName.startsWith("int")){
			return "Integer";
		}else if(columnTypeName.startsWith("tinyint")){
			return "Boolean";
		}else if(columnTypeName.startsWith("date")){
			return "java.util.Date";
		}else if(columnTypeName.startsWith("decimal")){
			return "java.util.BigDecimal";
		}else{
			return "?";
		}
	}
	
	public static final String handleFirstWordUppercaseAndOtherLowercase(String word){
		return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
	}
}