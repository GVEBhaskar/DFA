package com.UExAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StartDate 
{
	@Test(priority=0) /*Validating startDate with valid format*/
	public void startDateWithValidFormat()
	{
		RestAssured.baseURI = "http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-10-25 00:00:00")
				.queryParam("endDate", "2019-11-24 23:59:59")
				.request(Method.GET);
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);
		
		System.out.println("Does ResponseBody contains solidId? : "+response.asString().contains("solidId"));
		Assert.assertEquals(response.asString().contains("solidId"), true);
		System.out.println("Does ResponseBody contains dfaCircuitNumber? : "+response.asString().contains("dfaCircuitNumber"));
		Assert.assertEquals(response.asString().contains("dfaCircuitNumber"), true);
		System.out.println("Does ResponseBody contains linkSpeed? : "+response.asString().contains("linkSpeed"));
		Assert.assertEquals(response.asString().contains("linkSpeed"), true);
		
		System.out.println("Status Code is : "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status Line is : "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		System.out.println("Response Time is : "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "Response Time should be withing limit");
		System.out.println();
	}
	
	@Test(priority=1) /*Validating startDate with invalid format*/
	public void startDateWithInvalidFormat()
	{
		RestAssured.baseURI = "http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "25-10-2019 00:00:00")
				.queryParam("endDate", "2019-11-24 23:59:59")
				.request(Method.GET);
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);
		//boolean errorMsg=response.asString().contains("{\"success\":\"false\",\"message\":\"11: Invalid Start Date\"}");
		Assert.assertEquals(responseBody, "{\"success\":\"false\",\"message\":\"11: Invalid Start Date\"}");
		System.out.println("Does errorMsg contains? : "+response.asString().contains("11: Invalid Start Date"));
		
		System.out.println("Status Code is : "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is : "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is : "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "Response Time should be withing limit");
		System.out.println();
	}
	
	@Test(priority=2) /*Validating startDate without 25th date*/
	public void startDateWithout25thdate()
	{
		RestAssured.baseURI = "http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-10-20 00:00:00")
				.queryParam("endDate", "2019-11-24 23:59:59")
				.request(Method.GET);
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);
		//boolean errorMsg=response.asString().contains("{\"success\":\"false\",\"message\":\"11: Invalid Start Date\"}");
		Assert.assertEquals(responseBody, "{\"success\":\"false\",\"message\":\"11: Invalid Start Date\"}");
		System.out.println("Does errorMsg contains? : "+response.asString().contains("11: Invalid Start Date"));
		
		System.out.println("Status Code is : "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is : "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is : "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "Response Time should be withing limit");
		System.out.println();
	}
	
	@Test(priority=3) /*Validating startDate with invalid midnight time*/
	public void startDateWithInvalidMidnigtTime()
	{
		RestAssured.baseURI = "http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
				.queryParam("startDate", "2019-10-25 00:00:01")
				.queryParam("endDate", "2019-11-24 23:59:59")
				.request(Method.GET);
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);
		//boolean errorMsg=response.asString().contains("{\"success\":\"false\",\"message\":\"11: Invalid Start Date\"}");
		Assert.assertEquals(responseBody, "{\"success\":\"false\",\"message\":\"11: Invalid Start Date\"}");
		System.out.println("Does errorMsg contains? : "+response.asString().contains("11: Invalid Start Date"));
		
		System.out.println("Status Code is : "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 400);
		System.out.println("Status Line is : "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
		System.out.println("Response Time is : "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000, "Response Time should be withing limit");
		System.out.println();
	}

}
