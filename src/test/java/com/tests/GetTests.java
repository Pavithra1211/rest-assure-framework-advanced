package com.tests;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.annotations.FrameworkAnnotations;
import com.report.ExtentLogger;
import com.requestBuilder.RequestBuilder;

import io.restassured.response.Response;

public class GetTests extends BaseTest {
	
	
	@FrameworkAnnotations(author = "Pavithra", catagory = {"Smoke"})
	@Test
	public void getEmployeesDetail() {
		Response response = RequestBuilder
						.buildingRequestForGetCalls()
						.get("/employees");
		
		
		ExtentLogger.logResponse(response.prettyPrint());

		
		assertThat(response.getStatusCode())
			.isEqualTo(200);
		
		assertThat(response.jsonPath().getList("$").size()).isPositive();
	}
	
	
	@Test(dataProvider = "getData")
	@FrameworkAnnotations(author = "Pavithra", catagory = {"Smoke"})
	public void getEmployeeDetails(Integer id, String lastname) {
		Response response = given()
				.queryParam("id", id)
				.get("http://192.168.1.6:3000/employees");
		
		ExtentLogger.logResponse(response.prettyPrint());
		
		assertThat(response.getStatusCode())
			.isEqualTo(200);	
		assertThat(response.jsonPath().get("lastname").equals(lastname));
		
	}
	
	
	@DataProvider
	public Object[][] getData() {
		return new Object[][] {
			{2, "Palmer"},
			{3, "Smith"},
			{753, "Tremblay"}
		};
	}
	
	@Test
	@FrameworkAnnotations(author = "Pavithra", catagory = {"Smoke"})
	public void verifyBasicAuth() {
		Response response = given()
				.auth()
				.basic("postman", "password")
				.get("https://postman-echo.com/basic-auth");	
		
		assertThat(response.getStatusCode())
			.isEqualTo(200);	
		assertThat(response.jsonPath().get("authenticated").equals("true"));
		ExtentLogger.logResponse(response.prettyPrint());
		
	}
	
	
	

}
