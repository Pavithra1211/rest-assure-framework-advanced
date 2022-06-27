package com.tests;

import com.annotations.FrameworkAnnotations;
import com.constants.FrameworkConstants;
import com.constants.FrameworkConstantsWithSingleton;
import com.pojo.Employee;
import com.report.ExtentLogger;
import com.requestBuilder.RequestBuilder;
import com.utils.ApiUtils;
import com.utils.RandomUtils;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class PostTests {
	
	@FrameworkAnnotations(author = "Pavithra", catagory = {"Smoke"})
	@Test
	public void postEmployee() {
		Employee obj = Employee.builder().id(RandomUtils.generateID())
				.firstName(RandomUtils.generateFirstName())  // I can do static imports to skip mentioning class name(Random utils)
				.lastName(RandomUtils.generateLastName())
				.email(RandomUtils
				.generateEmail())
				.build();
		
		Response response = RequestBuilder.buildingRequestForPostCalls()
					.body(obj)
					.post("/employees");
		
		Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
	}
	
	@FrameworkAnnotations(author = "Pavithra", catagory = {"Smoke"})
	@Test
	public void postEmployeeByExternalFile() throws IOException {
		String obj = ApiUtils.readJsonFile(FrameworkConstants.REQUEST_JSON_PATH + "/request.json")
					.replace("idNumber", String.valueOf(RandomUtils.generateID()))
					.replace("fname", RandomUtils.generateFirstName())
					.replace("lname", RandomUtils.generateLastName());
		
		RequestSpecification requestSpecification = RequestBuilder
									.buildingRequestForPostCalls()
									.body(obj);
				
		ExtentLogger.logRequest(requestSpecification);
		
		Response response = requestSpecification
				.post("/employees");
	
	Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
	
	ApiUtils.storeResponseAsJsonFile(FrameworkConstants.REQUEST_JSON_PATH + "/response.json", response);

	}
	
	@FrameworkAnnotations(author = "Pavithra", catagory = {"Smoke"})
	@Test
	public void postEmployeeByExternalFileSingleton() throws IOException {
		String obj = ApiUtils.readJsonFile(FrameworkConstantsWithSingleton.getInstance().REQUEST_JSON_PATH + "request.json")
					.replace("idNumber", String.valueOf(RandomUtils.generateID()))
					.replace("fname", RandomUtils.generateFirstName())
					.replace("lname", RandomUtils.generateLastName());
		
		Response response = RequestBuilder.buildingRequestForPostCalls()
				.body(obj)
				.post("/employees");
	
	Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
	
	ApiUtils.storeResponseAsJsonFile(FrameworkConstantsWithSingleton.getInstance().REQUEST_JSON_PATH + "response.json", response);

	}

}
