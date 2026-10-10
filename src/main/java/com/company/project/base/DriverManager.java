package com.company.project.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {  
	
	private static WebDriver driver;
	
	private  DriverManager() {
		// prevent object creation 
	}
	               
	    
//	private static ThreadLocal<WebDriver> driver;
	
	public static void initializeBrowser(String browser) {
		switch (browser.toLowerCase()) {  
		case "chrome":
			driver = new ChromeDriver();
			
			break;
			
		case "firefox":  
			driver=new FirefoxDriver();  
			break; 
			
		case "edge": 
			driver= new EdgeDriver(); 
			break;

		default: 
			throw new IllegalArgumentException(
				" unsupported browser "+ browser);
			
		} 
		
	} 
    
	public static WebDriver getDriver() {
		if (driver == null) {
			throw  new IllegalStateException(
					" WebSite is not initialized ");
		}
		
		return driver;
	}
	
	public static void quitDriver(){
		if(driver!=null) {
			driver.quit();
			driver=null;
		}
	}
}
