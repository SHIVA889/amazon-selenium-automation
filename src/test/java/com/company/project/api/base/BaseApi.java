package com.company.project.api.base;

import org.testng.annotations.BeforeClass;

import com.company.projects.utils.ConfigReader;

import io.restassured.RestAssured;

public class BaseApi {

	@BeforeClass
	public void setUpApi() {
		RestAssured.baseURI=ConfigReader.getProperties("apiBaseUrl");
		
	}
}
