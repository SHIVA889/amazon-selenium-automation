package com.company.project.tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.company.project.models.RootData;
import com.company.project.pages.HomePage;
import com.company.project.pages.LoginPage;
import com.company.projects.utils.TestDataReader;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginTest extends BaseTest{
	
	
	
	@DataProvider(name = "loginJsonDataProvider")
    public Object[][] getLoginData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        RootData root = mapper.readValue(new File("src/test/resources/testdata/loginData.json"), RootData.class);
        
        Object[][] data = new Object[root.getUsers().size()][1];
        for (int i = 0; i < root.getUsers().size(); i++) {
            data[i][0] = root.getUsers().get(i);
        }
        return data;  
    }
	      
	        
	@Test(priority = 1, groups =  {"smoke","regression"})
	public void  validLogin() {
	
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
