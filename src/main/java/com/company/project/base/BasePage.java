
// BasePage - for basic and re-accuring actions 

// Methods - in these methods we send locators as well as text to perform some basic actions
	// like example clicking button , entering text 
 
package com.company.project.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.company.projects.utils.WaitUtils;

public class BasePage {

	protected WebDriver driver;
	protected WaitUtils wait;

	// Automatically created when class called - initializer 
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WaitUtils(driver);
	}
	
	  
	public void click(By locator) {
		wait.waitForClickability(locator).click();
	}                    

	public void enterText(By locator, String text) {
		WebElement element = wait.waitForClickability(locator);
		element.clear();
		element.sendKeys(text);

	}

	public String getElementText(By locator) {
		return wait.waitForVisibility(locator).getText();
	}

	public WebElement waitElementToBeVisible(By locator) { 
		return wait.waitForVisibility(locator);  
	}  

	public WebElement waitForElementToBeClickable(By locator) {
		return wait.waitForClickability(locator);
	}  
	
	
	public void openAccountMenu(By locator) {
		WebElement accountMenu = 
				wait.waitForVisibility(locator);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(accountMenu).perform();
		   
	}         
	
	public void switchToNewWindow(String originalWindow) {
		  
		// wait until extra window opens 
	    wait.until(driver -> driver.getWindowHandles().size() > 1);

	    for (String windowHandle : driver.getWindowHandles()) {

	        if (!windowHandle.equals(originalWindow)) {
	            driver.switchTo().window(windowHandle);
	            break;
	        }
	    }    
	}

}
