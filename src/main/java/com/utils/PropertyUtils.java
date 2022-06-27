package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import com.constants.FrameworkConstants;

public final class PropertyUtils {
	
	private PropertyUtils() {
		
	}
	
	// To read the contents from property file and store it in Hash map
	// Read the properties and store it in a java collections
	
	private static Properties properties = new Properties();
	private static HashMap<String, String> map = new HashMap<String, String>();
	
	
	
	// Problem: Generic Exception
	
	
	static {  // Static bock will be executed before the whole execution starts
		
		try {
			FileInputStream file = new FileInputStream(FrameworkConstants.PROPERTY_FILE_PATH);
			properties.load(file);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);  // To exit the execution when the exception is thrown
		}
		
		properties.entrySet().forEach(e -> map.put(String.valueOf(e.getKey()), String.valueOf(e.getValue())));
	}
	
	public static String getPropertyValue(String key) {
		return map.get(key);
	}

}
