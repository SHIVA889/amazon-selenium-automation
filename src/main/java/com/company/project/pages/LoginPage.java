package com.company.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.company.project.base.BasePage;

public class LoginPage extends BasePage{

	private By usernamePhonNum = By.cssSelector("#ap_email_login");
	private By userNumContinue = By.xpath("//input[@class='a-button-input']");
	private By password = By.cssSelector("#ap_password");
	private By passSignButton = By.cssSelector("#signInSubmit");
	private By loginButton = By.xpath("//div[@id='nav-al-signin']//span[normalize-space()='Sign in']");
	private By errorMessage = By.xpath("//div[@id='auth-error-message-box']");
	private By loginPageIdentifier  = By.cssSelector("input#ap_email_login");
	private By accountAndListsButton  = By.xpath("//span[contains(text(),'Account & Lists')]");
	// here 
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	    
	// Enter name
	public void enterName(String userNameValue) {
		enterText(usernamePhonNum,  userNameValue);
	}
	
	// Enter Password 
	public void enterPassword(String userPassword) {
		enterText(password, userPassword);
	}
	
	
	// Login
	public void clickSignInFromAccountMenu() {
		openAccountMenu(accountAndListsButton);
	}  
	    
	public void clickLogin() {
		clickSignInFromAccountMenu();
		waitElementToBeVisible(loginButton);
		click(loginButton);
	}  
	 
	public void login(String userNameValue , String userPassword) {
		clickLogin();
		enterName(userNameValue);
		click(userNumContinue);
		enterPassword(userPassword);
		click(passSignButton);  
		
	}
	
	public String getLoginError() {
		return getElementText(errorMessage);
	}
	  
	public boolean isLoginPageDisplayed() {
		return waitElementToBeVisible(loginPageIdentifier).isDisplayed();
	}
	  
	
	public void loginFromCheckout(String userNameValue, String userPassword) {
	    enterName(userNameValue);
	    click(userNumContinue);
	    enterPassword(userPassword);
	    click(passSignButton);
	}

}


