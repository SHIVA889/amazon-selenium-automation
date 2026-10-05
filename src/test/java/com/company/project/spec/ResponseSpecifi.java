package com.company.project.spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecifi {

	
	public static ResponseSpecification getResponseSpec() {
		return new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType("application/json")
				.build()
				;  
	}  
	  
	
	public static ResponseSpecification createResponseSpec() {
		return new  ResponseSpecBuilder()
				.expectStatusCode(201)
				.expectContentType("application/json")
				.build();
	}
	
	public static ResponseSpecification deleteResponseSpec() {
		return  new ResponseSpecBuilder()
		.expectStatusCode(204)
		.expectContentType("application/json")  
		.build();
	}  
}
 