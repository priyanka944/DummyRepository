package Qaclickacademy;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddData {
	@Test
	public void PostData()
	{
		String b="{" + 
				"    \"location\":{" + 
				"        \"lat\" : -38.383494,"+
				" \"lng\" : 33.427362" + 
				"    },"+
				"    \"accuracy\":50," + 
				"    \"name\":\"Frontline house\"," + 
				 
				"    \"phone_number\":\"(+91) 983 893 3937\"," + 
				 
				"    \"address\" : \"29, side layout, cohen 09\"," + 
			
				"    \"types\": [\"shoe park\",\"shop\"]," + 
			
				"    \"website\" : \"http://google.com\"," + 
				
				"    \"language\" : \"French-IN\"" + 
				
				"}";//comes under payload.java
		
		RestAssured.baseURI="http://216.10.245.166";//comes under env.properties
		Response res=given().
				queryParam("key","qaclick123").body(b).// key too under env.properties
				when().post("/maps/api/place/add/json").//under resources.java
				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
				extract().response();
		String rs=res.asString();
       System.out.println("response body is :" +rs);
       
	}

}
