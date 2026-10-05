package com.company.project.clients;

import com.company.project.models.User;
import com.company.project.spec.RequestSpec;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

    

public class UserApi {
      
	    
	
	// GET
	public  Response getAllUsers() {
		
		return given()  
				.spec(RequestSpec.getRequestSpec())
				.when()
				.get("/users");
				
	}
	
	
	// POST
	public Response createUser(User user) {
		
		return given()
				.spec(RequestSpec.getRequestSpec())
				.body(user)
	
				.when()
				.post("/users");
	}   
	
	    
	// GET
	public Response getUserById(int userId) {
		
		return given()  
				.spec(RequestSpec.getRequestSpec())
				.when()
				.get("/users/{id}",userId); // Equivalent to -> "/user/userId(value we pass in test class )
	}
	
	
	   
	// PUT 
	public Response updateUser(int userId , String  name , String username , String email) {
		
		return given()
				.spec(RequestSpec.getRequestSpec())
				.body(  
						"""
						{
						"name":"%s",
						"username": "%s",
                        "email": "%s"
                        }  
						
						""".formatted(name , username , email)
						)  
				.when()
				.put("/users/{id}", userId);
	}
	    
	  
	// PATCH 
	public Response patchUser(int userId, String email) {
		  
		return given()
				.spec(RequestSpec.getRequestSpec())
				.body("""
						
						{  
						
						"email":"%s"
						}
						 
						""".formatted(email))
				.when()
				.patch("/users/{id}", userId);
	}
	
	 
	// DELETE 
	public Response deleteUser(int userId) { 
		return given()
				.spec(RequestSpec.getRequestSpec())
				.when()
				.delete("/users/{id}", userId);
	}
	  
	
	  
	  
	
	
	
	
	
	
}
