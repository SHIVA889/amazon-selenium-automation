package com.company.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.company.project.base.BasePage;

public class RegistrationPage extends BasePage {

	private By name = By.id("ap_customer_name");
	private By email = By.id("ap_email");
	private By password = By.id("ap_password");
	private By passwordCheck = By.id("ap_password_check");

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	// enter name
	public void enterName(String nameValue) {
		enterText(name, nameValue);
	}

	// enter email
	public void enterEmail(String emailValue) {
		enterText(email, emailValue);
	}

	// enter password
	public void enterPassword(String passwordValue) {
		enterText(password, passwordValue);
	}

	// check/ confirm password
	public void confirmPassword(String passwordValue) {
		enterText(passwordCheck, passwordValue);
	}

	// public button to create user -> it is public because we will access this
	// button from Test
	public By createAccountButton = By.id("continue");

	public void cilckCreateAccount() {
		click(createAccountButton);

	}

	
	private By nameError = By.cssSelector("#auth-customerName-missing-alert");
	private By mobileOrEmailError = By.cssSelector("#auth-email-missing-alert");
	private By passwordError = By.cssSelector("#auth-password-missing-alert");
	
	public String  getErronName() {
		return getElementText(nameError);
	}  
	
	public String getMobileorEmailError() {
		return getElementText(mobileOrEmailError);
	}
	
	public String getPasswordError() {
		return getElementText(passwordError);
	}
	              
}
