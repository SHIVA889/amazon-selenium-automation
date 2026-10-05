package com.company.project.api.tests;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.company.project.api.base.BaseApi;
import com.company.project.clients.UserApi;
import com.company.project.models.User;
import com.company.project.spec.ResponseSpecifi;

import io.restassured.response.Response;

// import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;


import static org.hamcrest.Matchers.equalTo;

public class UserApiTest extends BaseApi {
  
	@Test(groups = "api")
	public void verifyUserList() {

		UserApi userapi = new UserApi();
		Response response = userapi.getAllUsers();
		  
		response.then()
 
				.spec(ResponseSpecifi.getResponseSpec())
				.body("$", hasSize(10))
				// Fixed the syntax here to [0].name to target the first array element cleanly
				.body("[0].name", equalTo("Leanne Graham"));
	}
	  
	
	
	// Data Driven  Testing 
	
	@DataProvider(name = "userData")
	public Object[][] userData() {
	    return new Object[][] {
	        {"John", "john123", "john@gmail.com"},
	        {"Mike", "mike123", "mike@gmail.com"},
	        {"David", "david123", "david@gmail.com"}
	    };
	}

	@Test(dataProvider = "userData")
	public void verifycreateUser(String name, String username, String email) {
	    UserApi userapi = new UserApi();
	      
	    // FIX: Map the parameters provided by the DataProvider
	    User user = new User();
	    user.setName(name);          
	    user.setUsername(username);  
	    user.setEmail(email);        

	    Response response = userapi.createUser(user);
	    
	    User responseuser = response.as(User.class);
	    System.out.println(responseuser.getName());
	    
	    response.then()
	            .spec(ResponseSpecifi.createResponseSpec());
	}

			
		
  
	// verify userById
	
	@Test(groups = "api")  
	public void verifygetUserById() {

		UserApi userspi = new UserApi(); 

		Response response = userspi.getUserById(1);
		
		

		response.then().statusCode(200).body("id", equalTo(1));
	}
	
	
	@Test(groups = "api")
	public void verifyInvalidUserById() {
		UserApi userapi = new UserApi();
		Response response = userapi.getUserById(9999);
		
		response.then()
		.statusCode(404)
		.log()
		.body();
	}
	
	
  
	// verify user update
	@Test(groups = "api")
	public void verifyupdateUser() {

		UserApi userapi = new UserApi();

		Response response = userapi.updateUser(1, "shiva updated", "shiva999", "updaetd@email.com");

		response.then().statusCode(200).body("name", equalTo("shiva updated")).body("username", equalTo("shiva999"))
				.body("email", equalTo("updaetd@email.com"));

	}

	@Test(groups="api")
	public void verifypatchUser() {

		UserApi userapi = new UserApi();

		Response response = userapi.patchUser(5, "updatedEmail@.com");

		response.then().body("email", equalTo("updatedEmail@.com"));

	}
	
	     
	@Test(groups = "api")																													
	public void verifydeleteUser() {

		UserApi userapi = new UserApi();

		Response response = userapi.deleteUser(1);

		response.then().statusCode(200);
	}    
	
	  
	
	
	@Test(groups = "api")
	public void verifyUserResponseSchema() {

	    UserApi userApi = new UserApi(); 

	    Response response = userApi.getUserById(1);

	    response.then()
	            .spec(ResponseSpecifi.getResponseSpec())
	            .body(matchesJsonSchemaInClasspath("com/company/project/schemas/user-schema.json"));
	}
	      
	


}
