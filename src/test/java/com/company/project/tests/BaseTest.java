package com.company.project.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.company.project.base.DriverManager;
import com.company.projects.utils.ConfigReader;
import com.company.projects.utils.ScreenshotUtils;

public class BaseTest {  
	
	
	protected  WebDriver driver;
	   
//	@BeforeMethod
//	public void setUp() {
//		String browser = ConfigReader.getProperties("browser");
//		DriverManager.initializeBrowser(browser);
//		driver= DriverManager.getDriver();  
//		
//		driver.get(ConfigReader.getProperties("url"));
//		driver.manage().window().maximize();
//	}  
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() {

	    System.out.println("========== SETUP START ==========");

	    String browser = ConfigReader.getProperties("browser");
	    System.out.println("BROWSER = " + browser);

	    DriverManager.initializeBrowser(browser);
	    System.out.println("DRIVER AFTER INITIALIZATION = " + DriverManager.getDriver());

	    driver = DriverManager.getDriver();
	    System.out.println("BASE TEST DRIVER = " + driver);

	    driver.get(ConfigReader.getProperties("url"));
	    driver.manage().window().maximize();

	    System.out.println("========== SETUP END ==========");
	}
	
	  
	      
	 @AfterMethod
	  public void tearDown(ITestResult result) {

	        if (result.getStatus() == ITestResult.FAILURE) {

	            ScreenshotUtils.captureScreenshot(
	                    driver,
	                    result.getMethod().getMethodName()
	            );  
	        } 

	         DriverManager.quitDriver();
	    }
	
}  