package com.company.project.base;

import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
			ChromeOptions options = new ChromeOptions();  

			// Essential flags for GitHub Actions / Headless Linux
			options.addArguments("--headless=new"); // Runs without a GUI
			options.addArguments("--window-size=1920,1080"); // Forces the standard desktop layout
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");

			// Crucial spoofing flags to bypass Amazon anti-bot protection
			options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
			options.addArguments("--disable-blink-features=AutomationControlled");
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			options.setExperimentalOption("useAutomationExtension", false);

			driver = new ChromeDriver(options);
			
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
