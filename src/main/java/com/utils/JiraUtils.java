package com.utils;

import com.constants.FrameworkConstants;

import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.io.IOException;

public final class JiraUtils {
	
	private JiraUtils() {
		
	}
	
	public static String createIssueInJira(String errorMessage) {
		String body = null;
		try {
			body = ApiUtils.readJsonFile(FrameworkConstants.REQUEST_JSON_PATH+"/request1.json")
			        .replace("KEY","DEM")
			.replace("description",errorMessage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        Response response = given()
        		.config(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeader("Authorization")))
                .header("Authorization","Basic dGVzdGluZ21pbmlieXRlczpBbWJhdHR1cjEh")
                .header("Content-Type","application/json")
                .log()
                .all()
                .body(body)
                .post("http://localhost:8080/rest/api/2/issue/");

        response.prettyPrint();
        return response.jsonPath().getString("key");
	}
	

}
