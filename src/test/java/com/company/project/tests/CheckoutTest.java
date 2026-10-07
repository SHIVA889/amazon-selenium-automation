package com.company.project.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.company.project.pages.CartPage;
import com.company.project.pages.CheckOutPage;
import com.company.project.pages.HomePage;
import com.company.project.pages.LoginPage;
import com.company.project.pages.ProductDetailsPage;
import com.company.project.pages.SearchResultsPage;
import com.company.projects.utils.TestDataReader;

public class CheckoutTest extends BaseTest{

	
	@Test( enabled =  false,  groups = {"smoke"})
	public void verifyCheckoutTotal() {
		//home page 
		HomePage homepage = new HomePage(driver);
		homepage.searchProduct("laptop");
		
		// Search result page 
		SearchResultsPage searchresultpage = new SearchResultsPage(driver);
		String productName = searchresultpage.getProductNames().get(0);
		
		searchresultpage.selectProduct(productName);
		
		// Products details page 
		ProductDetailsPage productdetailspage = new ProductDetailsPage(driver);

		Assert.assertTrue(productdetailspage.isProductDetailsPageDisplayed(), 
		        "product details page was not displyed ");

		String expectedProductName = productdetailspage.getProductTitle();

		productdetailspage.addToCart();

		// open the cart page 
		homepage.openCart();
		
		CartPage cartpage = new CartPage(driver);
		
		 // Verify that the cart contains the product.
		Assert.assertFalse(cartpage.isCartEmpty(),
				" cart is empty after adding the product ");
		  
		String actualProductName = cartpage.getProductName();

		String expectedProductPrefix =
		        expectedProductName.length() > 30
		        ? expectedProductName.substring(0, 30)
		        : expectedProductName;

		Assert.assertTrue(actualProductName.startsWith(expectedProductPrefix),
		        "Expected product was not found in the cart.");
		
		cartpage.proceedToCheckOut();
		
		// Debug information to verify where Amazon redirected the browser.
		System.out.println("Current URL: " + driver.getCurrentUrl());
		System.out.println("Current Title: " + driver.getTitle());
		
		CheckOutPage checkoutpage = new CheckOutPage(driver);
		
		Assert.assertTrue(checkoutpage.isCheckoutPageDisplayed(), 
				" chekout page was not displyed ");
		
		String checkoutTotal = checkoutpage.getOrderTotal();
		
		Assert.assertNotNull(checkoutTotal,
				" checkout total was empty ");
		
		 Assert.assertFalse(
	             checkoutTotal.trim().isEmpty(),
	                "Checkout total was empty.");

	}
	
	
	// ==========================================================================================
	  
	@Test(priority = 6 ,   groups = {"regression"})
	public void completeCheckout() {
		
		
		// Login mechanism 
		String username = TestDataReader.getTestData("username");
		String password = TestDataReader.getTestData("password");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.clickLogin();
		loginpage.loginFromCheckout(username, password);
		 
		
		HomePage homepage = new HomePage(driver);
		
		homepage.searchProduct("notebook");
		
		SearchResultsPage searchresultpage= new SearchResultsPage(driver);
		
		String productName = searchresultpage.getProductNames().get(0);
		
		searchresultpage.selectProduct(productName);
		
		ProductDetailsPage productdetailspage = new ProductDetailsPage(driver);
		Assert.assertTrue(productdetailspage.isProductDetailsPageDisplayed(), 
				" product details page was not displyed ");
		
		productdetailspage.addToCart();
		  
		// open the cart 
		homepage.openCart();
		
		CartPage cartpage = new CartPage(driver);
		
		Assert.assertFalse(cartpage.isCartEmpty(), 
				"cart is emptyu after adding the product  ");
		
		// proceed to check out 
		cartpage.proceedToCheckOut();

		CheckOutPage checkoutpage = new CheckOutPage(driver);
		
		Assert.assertTrue(checkoutpage.isCheckoutPageDisplayed(), 
				"checkout page was not displayed ");
		
		
		// selecting the payment method   
		checkoutpage.paymentMethodCash();
		
		  
		// verify the final order total 
		String checkoutTotal = checkoutpage.getOrderTotal();
		
		Assert.assertNotNull(checkoutTotal, " final order total was null ");
		
		Assert.assertFalse(checkoutTotal.trim().isEmpty(), 
				"final order total was empty ");
		          
		// confirm 
		checkoutpage.clickContinue();
		  
		// order 
		//checkoutpage.placeOrder();

	} 

}
 