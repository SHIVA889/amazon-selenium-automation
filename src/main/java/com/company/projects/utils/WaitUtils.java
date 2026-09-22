package com.company.projects.utils;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.company.project.constants.FrameworkConstants;

public class WaitUtils { 

	private WebDriver driver;
	private WebDriverWait wait;
	
	public WaitUtils(WebDriver driver) {
		this.driver = driver;
		
		this.wait =  new WebDriverWait(driver,
				Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT));
		
	} 
	
	
	// wait until the element is visible on the page 
	public WebElement waitForVisibility(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	// wait for element to be present and  click able
	public WebElement waitForClickability(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
		
	}
	
	
	// Waits until the element is present in the DOM.
	public WebElement waitForPresence(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	  
	
	// wait until the element is no longer visible 
	public boolean waitForInvisibility(By locator ) {
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public <T> T until(Function<WebDriver, T> condition) {
	    return wait.until(condition);
	}

}
