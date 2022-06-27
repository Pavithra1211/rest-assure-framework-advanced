package com.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.response.Response;

public final class ApiUtils {
	
	private ApiUtils() {
		
	}
	
	public static String readJsonFile(String filePath) throws IOException {
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}
	
	public static void storeResponseAsJsonFile(String filePath, Response response) throws IOException {
		Files.write(Paths.get(filePath), response.asByteArray());
	}

}
