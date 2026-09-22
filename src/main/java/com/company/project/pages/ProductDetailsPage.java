package com.company.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.company.project.base.BasePage;

public class ProductDetailsPage extends BasePage{
  
	// product title  
	private By productTitle = By.xpath("//span[@id='productTitle']");
	
	// product price 
	private By productPrice = By.xpath("//span[contains(@class,'priceToPay')]//span[contains(@class,'a-price-whole')]");
	
	// add to cart button   
	private By addToCart = By.xpath("//input[@id='add-to-cart-button']");
	
	// constructor 
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	// === Methods ===   
	// method to retrieve product title 
	public String getProductTitle() {
		return getElementText(productTitle);
	}
	
	// method for verifying product is display  or not 
	public boolean isProductDetailsPageDisplayed() {
		return waitElementToBeVisible(productTitle).isDisplayed();
	}
	
	// method for retrieve  product price
	public String getProdctPrice() {
		return getElementText(productPrice);
	}
	
	// method for add to cart 
	public void addToCart() {
		click(addToCart);
	}
	
}

