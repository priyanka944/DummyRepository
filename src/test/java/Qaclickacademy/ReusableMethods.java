package Qaclickacademy;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class ReusableMethods {
	
	public static JsonPath rawToJson(Response r)
	{
		String resp=r.asString();
		JsonPath jsp=new JsonPath(resp);
		return jsp;
	}

}
