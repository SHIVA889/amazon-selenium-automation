package com.company.project.tests;

import org.testng.Assert;
//import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.company.project.pages.HomePage;
import com.company.project.pages.LoginPage;

public class LogOutTest extends BaseTest{

	@Test( priority = 7 , groups = {"smoke","regression"})
	public void verifyLogout() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login("9844423990","shivakumar2233");
		
		HomePage  homepage = new HomePage(driver);
		homepage.logOut();
		 
		// verify logout 
		Assert.assertTrue(loginpage.isLoginPageDisplayed(), 
				" log in page is not displyed after log out ");
		
		
	}
}
