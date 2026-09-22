package com.company.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


import com.company.project.base.BasePage;

public class HomePage extends BasePage{
	
	private  By searchbox = By.id("twotabsearchtextbox");
	private By loginButton = By.id("ap_email_login");
	private By cartButton = By.id("nav-cart-count");
	private By productsTitle = By.xpath("//div[@class ='inventory_item_name ']");
	private By accountAndListsButton = By.cssSelector("#nav-link-accountList-nav-line-1");
	private By logOutButton = By.cssSelector("#nav-item-signout");
	
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void searchProduct(String productName) {
		enterText(searchbox, productName);// by locator and string text. 
		waitForElementToBeClickable(searchbox).sendKeys(Keys.ENTER);
		
	}
	
	// navigating to login 
	public void navigatToLogin() {
		click(loginButton);
	}
	
	// Opening a cart 
	public void openCart() {
		click(cartButton);
	}  
	
	public boolean isProductsDisplayed() {
		return waitElementToBeVisible(productsTitle).isDisplayed();
	}  

	public void clickSignOutFromAccountMenu() {
		openAccountMenu(accountAndListsButton);
	}
	  
	 

	
	public void logOut() {
	    clickSignOutFromAccountMenu();
	    waitElementToBeVisible(logOutButton);
	    click(logOutButton);
	}
	
	public boolean isAccountMenuDisplayed() {
	    return waitElementToBeVisible(accountAndListsButton).isDisplayed();
	}

	
}
