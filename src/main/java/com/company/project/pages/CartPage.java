package com.company.project.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.company.project.base.BasePage;


public class CartPage extends BasePage {

	
    // Represents each individual product/item row inside the cart.
	private By cartItems = By.cssSelector("#activeCartViewForm div[data-asin]");

	
	// Represents the product name inside a cart item.
	private By productName = By.cssSelector(".sc-product-title");
	
	// representing the product price inside  the cart item 
	private By productPrice = By.xpath("//span[@id='sc-subtotal-amount-buybox']");
			//cssSelector("#sc-subtotal-amount-buybox");
	
	// Amazon cart removes products through the Delete input, not the trash icon span.
	private By removeButton = By.xpath("//button[@class='a-declarative']//span[@class='a-icon a-icon-small-trash']");
	
	
	 // Represents the cart subTotal / total price.
	private By cartSubtotal = By.cssSelector(".sc-subtotal .a-price .a-offscreen");
	
	 // Represents the Proceed to checkout button.
	private By checkOutButton = By.name("proceedToRetailCheckout");
	
	 
	// Constructor accepts WebDriver and passes it to BasePage.
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	
	// ==== Methods ==== 
	// returning the product name from the cart 
	public String getProductName() {
		
		List<WebElement> products = 
				driver.findElements(cartItems);
		
		if(products.isEmpty()) {
			throw new RuntimeException(" Cart is Empty ");
			
		}
		
		return products.get(0)
				.findElement(productName).getText();

	}  
	
	// Returns the product price from the cart.
	public String  getProductPrice() {
		List<WebElement> products = 
				driver.findElements(cartItems);
		if(products.isEmpty()) {
			throw new RuntimeException(" Cart is empty ");
		}
		
		return products.get(0)
				.findElement(productPrice).getText();
		
	}
	
	// return the cart total or subTotal
	public String getCartTotal() {
		return getElementText(cartSubtotal);
		
	}  
	
	 // Removes the first product from the cart.
	public void removeProduct() {
		
		List<WebElement> products = 
				driver.findElements(cartItems);
		if(products.isEmpty()) {
			throw new RuntimeException(" cart is empty ");
		}
	
		 
		 products.get(0)  
				.findElement(removeButton).click();
		 
	}
	
	 // Proceeds to checkout.
	public void proceedToCheckOut() {
		click(checkOutButton);
	}
	
	
	// Returns true when the cart contains no products.
	public boolean isCartEmpty() {
		return driver.findElements(cartItems).isEmpty();
	}
	
	
	
	
}
   
