package com.company.projects.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {

	private static Properties properties;
	
	static {
		loadTestData();
	}
	
	private static void loadTestData() {
		
		String testDataPath  = "src/test/resources/testdata.properties";
		
		try(FileInputStream fileInputStream = new FileInputStream(testDataPath)){
			
			properties = new Properties();
			properties.load(fileInputStream);
			
		}catch (IOException e) {
			throw new RuntimeException(
					" failed to load test data properties file " , e);
		}
			
	}
	
	
	public static String getTestData(String Key) {
	    String value = properties.getProperty(Key);
	    
	    if (value==null || value.trim().isEmpty()) {
	    	throw  new RuntimeException(" test data is not found or Empty ");
	    }
	    
	    return value.trim();
	}  
}
