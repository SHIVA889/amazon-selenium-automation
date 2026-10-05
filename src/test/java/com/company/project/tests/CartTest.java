package com.company.project.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.company.project.pages.CartPage;
import com.company.project.pages.HomePage;
import com.company.project.pages.ProductDetailsPage;
import com.company.project.pages.SearchResultsPage;


public class CartTest extends BaseTest {


	@Test(priority = 4 ,   groups =  "smoke" )
	public void addProductToCart() {
		HomePage homepage = new HomePage(driver);

		homepage.searchProduct("notebook");

		SearchResultsPage searchresultpage = new SearchResultsPage(driver);

		String selectedProductName = searchresultpage.getProductNames().get(0);

		searchresultpage.selectProduct(selectedProductName);

		ProductDetailsPage productdetailspage = new ProductDetailsPage(driver);
		Assert.assertTrue(productdetailspage.isProductDetailsPageDisplayed(),
				" prodduct details page was not displyed  ");
  
		String expectedProductName = productdetailspage.getProductTitle();
		System.out.println("Product Details Name: " + expectedProductName);

		String expectedProductPrice = productdetailspage.getProdctPrice();

		productdetailspage.addToCart();

		homepage.openCart(); 
		                    
		CartPage cartpage = new CartPage(driver);  

		String actualProductName = cartpage.getProductName();
		System.out.println("Cart Product Name: " + actualProductName);

		// Use a safe prefix so the test does not fail with
		// StringIndexOutOfBoundsException for shorter titles.
		String expectedProductPrefix = expectedProductName.length() > 30 ? expectedProductName.substring(0, 30)
				: expectedProductName;
  
		Assert.assertTrue(actualProductName.startsWith(expectedProductPrefix),
				"Expected product was not found in the cart.");

		String actualProductPrice = cartpage.getProductPrice();

		String normalizedExpectedPrice = expectedProductPrice.replace(",", "");

		String normalizedActualPrice = actualProductPrice.replace("₹", "").replace(",", "").replace(".00", "").trim();

		Assert.assertEquals(normalizedActualPrice, normalizedExpectedPrice,
				"Product price in the cart does not match the product details price.");
  
		Assert.assertFalse(cartpage.isCartEmpty(), "Cart is empty after adding the product.");
	}
	
	
	    
  
	@Test( priority = 5 ,  groups = { "regression" })
	public void removeProductFromCart() {
		
		HomePage homepage = new HomePage(driver);
		
		 
		homepage.searchProduct("marker");

		SearchResultsPage searchresultpage = new SearchResultsPage(driver);
  
		System.out.println("Product count: " + searchresultpage.getProductCount());
		System.out.println("Product names: " + searchresultpage.getProductNames());

		String productName = searchresultpage.getProductNames().get(0);
		System.out.println("Search Result Product Name: " + productName);

		searchresultpage.selectProduct(productName);

		ProductDetailsPage productdetailspage = new ProductDetailsPage(driver);

		Assert.assertTrue(productdetailspage.isProductDetailsPageDisplayed(),
		        "Product details page was not displayed");

		String expectedProductName = productdetailspage.getProductTitle();

		productdetailspage.addToCart();

		homepage.openCart();

		System.out.println("cart is opened");

		CartPage cartpage = new CartPage(driver);

		Assert.assertFalse(cartpage.isCartEmpty(),
		        "Cart is empty after adding the product");

		System.out.println("cart has a product");

		String actualProductName = cartpage.getProductName();

		System.out.println("Expected Product Name: " + expectedProductName);
		System.out.println("Cart Product Name: " + actualProductName);

		String expectedProductPrefix = expectedProductName.length() > 30
		        ? expectedProductName.substring(0, 30)
		        : expectedProductName;

		Assert.assertTrue(actualProductName.startsWith(expectedProductPrefix),
		        "Expected product was not found in the cart.");

		System.out.println("Product names are matching");

		cartpage.removeProduct();

	
		    
		}
		
}
