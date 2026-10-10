package com.company.project.tests;

  
import org.testng.Assert;
import org.testng.annotations.Test;

import com.company.project.pages.HomePage;
import com.company.project.pages.SearchResultsPage;
import com.company.projects.utils.TestDataReader;
   
public class SearchTest extends BaseTest {
  
	@Test(priority =  3 ,  groups= {"smoke","regression"})
	public void validTest() {

		HomePage homepage = new HomePage(driver);
		String product = TestDataReader.getTestData("searchProduct");
		homepage.searchProduct(product);

		SearchResultsPage searchresult = new SearchResultsPage(driver);

		Assert.assertTrue(searchresult.getProductCount() > 0, 
				"product is not avaialable");

		Assert.assertTrue(
				searchresult.getProductNames()
				.stream()
				.anyMatch(name -> name.toLowerCase().contains(product)),
				"Expected product was not found");
	}  


}
