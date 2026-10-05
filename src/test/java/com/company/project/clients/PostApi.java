package com.company.project.clients;
import com.company.project.spec.RequestSpec;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class PostApi {

	public Response createPost(int userId, String title , String body){
		
		return given()
				.spec(RequestSpec.getRequestSpec())
				.body(
			"""
			{
			"userId":"%d",
			"title":"%s",  
			"body":"%s"
			
			}    
			
			""".formatted(userId, title , body)  
						
		) 
				.when()
				.post("/posts");		
		  
	}
	
	public Response getSingleProduct(int Id) {
		
		return given()
				.spec(RequestSpec.getRequestSpec())
				.when()
				.get("/posts/{Id}", Id);
		
	}  
	
	
	  
	
}
