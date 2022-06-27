package com.requestBuilder;
import static io.restassured.RestAssured.*;

import com.utils.PropertyUtils;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class RequestBuilder {
	
	private RequestBuilder() {}
	
	public static RequestSpecification buildingRequestForGetCalls() {
		return given()
				.baseUri("http://192.168.1.6:3000")
				.log()
				.all();
		
	}
	
	public static RequestSpecification buildingRequestForPostCalls() {
		System.out.println(PropertyUtils.getPropertyValue("baseUrl"));
		return given()
				.baseUri(PropertyUtils.getPropertyValue("baseUrl"))
				.contentType(ContentType.JSON)
				.log()
				.all();
		
	}

}
