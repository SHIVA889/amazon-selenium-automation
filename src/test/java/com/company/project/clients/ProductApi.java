package com.company.project.clients;
import static io.restassured.RestAssured.given;

import com.company.project.models.Product;
import com.company.project.spec.RequestSpec;

import io.restassured.response.Response;

public class ProductApi {  

	  
	public Response getAllProducts() { 
		
		return given()
				.spec(RequestSpec.getRequestSpec())
				
				
				.when()
				.get("/products");
	}
	  
	
	public Response addNewProduct(Product product) {
		  
		return given()
				.spec(RequestSpec.getRequestSpec())   
				  
				.body(product)
				.when()
				.post("/products");  
	}
	
	public Response getSingleProduct(int Id) {
		
		return given()
				.spec(RequestSpec.getRequestSpec())
				.when()
				.get("/products/{id}", Id);
		     
	}  
	
	
	
	public Response deleteProduct(int Id) {
		return given()
				.spec(RequestSpec.getRequestSpec())
				.when()
				.delete("/products/{id}", Id);
	}
	
	
	
	public Response updateProduct(int Id, String title , Double price , String description ,
			String category , String image) {
		
		return given()
				.spec(RequestSpec.getRequestSpec())
				.body("""
						    
						{
						"id":"%d",
						"title":"Hululu",
						"price":100000.00,
						"description":"i am hululu",
						"category":"Hulu",
						"image":"https://aparichithud.com"
						
						}
						""".formatted(Id, title , price , description, category , image )
						
						)  
				.when()
				.put("/products/{Id}", Id);  
				
	}
}
