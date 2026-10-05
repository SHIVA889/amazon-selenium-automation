package com.company.project.api.tests;

import org.testng.annotations.Test;

import com.company.project.api.base.BaseApi;
import com.company.project.clients.ProductApi;
import com.company.project.models.Product;

import io.restassured.response.Response;

public class ProductApiTest extends BaseApi{

	    
	//@Test
	public void   verifyGetAllProducts() {
		ProductApi productapi = new ProductApi();
		Response response = productapi.getAllProducts();
		
		response.then()
		.statusCode(200);

	}
	  
	//@Test
	public void verifyaddNewProduct() {
		ProductApi productapi = new ProductApi();
		Product product = new Product();
		product.setUserId(1);
		product.setTitle("Product Title");
		product.setPrice(1000.00);
		product.setDescription(" this is the description  of the product ");
		product.setCategory("Kitchen ");
		product.setImage("https://fakeimg.com");
		
		Response response = productapi.addNewProduct(product);
		
	response.then()
	.statusCode(200);
		
	}     
	
	@Test  
	public void verifygetSingleProduct() {
		ProductApi productapi = new ProductApi();
		Response response = productapi.getSingleProduct(0);
		  
		Product product = response.as(Product.class);
		System.out.println(product.getTitle());
		
		// we  can do this instead of that above instead of this bellow  
//		String result= response.jsonPath().getString("title");
//		System.out.println(result);
		
		response.then()
		.statusCode(200);
	}
	
	  
	//@Test
	public void verifydeleteProduct() {
		
		ProductApi productapi = new ProductApi();
		Response response = productapi.deleteProduct(0);
		  
		response.then()
		.statusCode(200); 
	}
	  
	
	//@Test
	public void verifyupdatePorduct() {
		
		ProductApi productapi = new ProductApi();
		Response response = productapi.updateProduct( 0, " This is updated product ", 10000.0, "This is updated homeproduct ", 
				"Furniture", "https://placehold.co");
		
		response.then()
		.statusCode(200);
	}
	
	
}
