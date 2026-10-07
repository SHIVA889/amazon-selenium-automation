package com.company.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.company.project.pages.HomePage;
import com.company.project.pages.LoginPage;
import com.company.projects.utils.TestDataReader;

public class LoginTest extends BaseTest{
	  
	      
	@Test(priority = 1, groups =  {"smoke","regression"})
	public void  validLogin() {
		System.out.println("LOGIN TEST DRIVER = " + driver);
		LoginPage loginpage = new LoginPage(driver);
		String username = TestDataReader.getTestData("username");
		String password = TestDataReader.getTestData("password");
		 
		loginpage.login(username, password);
	    
//		// verify login                                                         
		HomePage homepage = new HomePage(driver);
		Assert.assertTrue(homepage.isAccountMenuDisplayed(),
		        "Login was not successful");

	}    
	
	@Test( enabled=false,   groups = {"regression"})
	public void invalidLogin() {
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.login("secretshiva", "invalid_password");
		
		String message = loginpage.getLoginError();
		
		Assert.assertTrue(message.contains("There was a problem"),
				"expected login error message was not displayed ");
	}

}
