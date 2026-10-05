package com.company.projects.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.company.project.constants.FrameworkConstants;

public class ConfigReader {

	private static Properties properties;
	
	static {
		loadProperties();
	}   
	
	// This class is encapsulated - using private 
	private static void loadProperties() {
		
		String configPath = FrameworkConstants.CONFIG_FILE_PATH;
		
		try(FileInputStream fileInputStream = new FileInputStream(configPath))
		{
			properties = new Properties();
			properties.load(fileInputStream);
			   
		}catch (IOException e) {
			throw new RuntimeException(
					" Failed to load the english " , e);
		} 
	}    
	
	public static String getProperties(String key) {
		
		String value = properties.getProperty(key);
		
		if (value ==null || value.trim().isEmpty()) {
			throw new RuntimeException(
					"Configuration property is not found or empty "+" "+ key);
		}
		return value.trim();
	}
}
