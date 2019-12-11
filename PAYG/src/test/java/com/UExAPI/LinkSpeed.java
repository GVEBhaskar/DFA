package com.UExAPI;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class LinkSpeed 
{
	@Test(priority=0)/*Validating linkSpeed*/
	public void noRecords()
	{
		RestAssured.baseURI = "http://172.25.2.20:8080/PAYGUxAPI/frogfoot/getlinkusage";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.given().header("apiKey", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MCIsImlzcyI6IlNvbGlkaVRlY2giLCJpYXQiOjE1NTQxOTA3ODV9.Am7F2y88LlgsftsZrQVAjvkVji3ORLF5uxcFRhQD2sk")
		.queryParam("startDate", "2019-08-25 00:00:00")
		.queryParam("endDate", "2019-09-24 23:59:59")
		.request(Method.GET);
		
		System.out.println("Response Body is : "+response.getBody().asString());
		System.out.println("Does Response Body contains 'linkSpeed'? : "+response.asString().contains("linkSpeed"));
		System.out.println("Value of solidId : "+response.jsonPath().getList("solidId"));
		//assertTrue(Ordering.natural().isOrdered(response.jsonPath().getList("solidId")));
					
		System.out.println("Status Code : "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status Line : "+response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		System.out.println("Response Time : "+response.getTime());
		Assert.assertTrue(response.getTime()<=60000);
		
	}

}
