package com.company.project.api.tests;
import org.testng.annotations.Test;
import com.company.project.api.base.BaseApi;
import com.company.project.clients.PostApi;
import io.restassured.response.Response;



public class PostApiTest extends BaseApi {   
       
	
	@Test
	public void verifycreatePost() {    
		
		PostApi postapi = new PostApi();
		Response response = postapi.createPost(1, "This is title ", "This is Body");
		
		response.then()
		.statusCode(201);
				
	}
	
	  
	@Test
	public void verifyGetSingleProduct() {
		PostApi postapi = new PostApi();
		Response response = postapi.getSingleProduct(1);
		System.out.println("Response created : ");
		String result = response.jsonPath().getString("body");
		System.out.println(result);
		
		
		response.then()
		.statusCode(200);
	}
	
}
