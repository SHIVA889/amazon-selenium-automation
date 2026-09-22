package com.company.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.company.project.pages.HomePage;
import com.company.project.pages.ProductDetailsPage;
import com.company.project.pages.SearchResultsPage;
import com.company.projects.utils.TestDataReader;
  
public class ProductTest extends BaseTest {

	@Test( priority = 4,  groups= {"smoke","regression"})
	public void verifyProductDetailsandAddToCart() {
  
		// search for known product
		HomePage homepage = new HomePage(driver);
		String product  = TestDataReader.getTestData("searchProduct");
		homepage.searchProduct(product);

		// select the product from search result page
		SearchResultsPage searchresultpage = new SearchResultsPage(driver);
		String expectedProduct = searchresultpage.getProductNames()
				.stream()
				.filter(name -> name.toLowerCase().contains("notebook"))
				.findFirst()
				.orElseThrow(() -> new RuntimeException(" excepted product was not found "));
		searchresultpage.selectProduct(expectedProduct);

		// verifying ProductDetailsPage is displayed
		ProductDetailsPage productdetailspage = new ProductDetailsPage(driver);
		Assert.assertTrue(productdetailspage.isProductDetailsPageDisplayed(),
				"Product details page was not displayed.");

		// verify product name
		Assert.assertTrue(productdetailspage.getProductTitle().toLowerCase().contains("notebook"),
				"product name does not match the expected product ");

		// verify product price
		Assert.assertTrue(
			    !productdetailspage.getProdctPrice().isBlank(),
			    "Product price was not displayed"
			);

		productdetailspage.addToCart();

	}
}
