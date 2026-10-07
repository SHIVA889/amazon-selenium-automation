package com.company.project.tests;

import org.testng.Assert;
//import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.company.project.pages.HomePage;
import com.company.project.pages.LoginPage;
import com.company.projects.utils.TestDataReader;

public class LogOutTest extends BaseTest {

	@Test(priority = 7, groups = { "smoke", "regression" })
	public void verifyLogout() {
		LoginPage loginpage = new LoginPage(driver);
		String username = TestDataReader.getTestData("username");
		String password = TestDataReader.getTestData("password");

		loginpage.login(username, password);

		HomePage homepage = new HomePage(driver);
		homepage.logOut();

		// verify logout
		Assert.assertTrue(loginpage.isLoginPageDisplayed(), " log in page is not displyed after log out ");

	}
}
