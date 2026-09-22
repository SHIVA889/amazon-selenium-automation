package com.company.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.company.project.base.BasePage;

public class CheckOutPage extends BasePage{

	// represents the checkout  page container 
	private By checkoutContainer = By.id("checkout-experience-container");
	
	// Payment method needed here 
	private By paymentCash= By.xpath("//input[@type='radio' and contains(@value,'paymentMethod=COD')]");
	  
	
	// represents the final order total 
	private By orderTotal = By.xpath("(//span[@data-shimmer-target='ordertotals-amount'])[6]");
	 
	// continue button 
	private By continueButton = By.xpath("//span[@id='checkout-secondary-continue-button-id']");
	
	// order place button 
	private By placeOrderButton  = By.id("submitOrderButtonId");
	
	
	//constructor 
	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	public void paymentMethodCash() {
		click(paymentCash);
	}
	  
	
	// Verifies that the checkout page/container is displayed.
	public boolean isCheckoutPageDisplayed() {
		return waitElementToBeVisible(checkoutContainer).isDisplayed();
	}
	
	// Returns the final order total displayed during checkout.
	public 	String getOrderTotal() {
		return getElementText(orderTotal);
	}
	
	public void clickContinue() {
		click(continueButton);
		
	}
	
	// Verifies that an order confirmation is displayed.
	public boolean isOrderSuccessfullyPlaced() {
		return waitElementToBeVisible(placeOrderButton).isDisplayed();
	}
	
	
	public void placeOrder() {
	    click(placeOrderButton);
	}
	
}


