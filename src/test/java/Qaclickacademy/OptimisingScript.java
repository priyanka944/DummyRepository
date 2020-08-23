package Qaclickacademy;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import Qaclickacademy.ReusableMethods;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import Addingplace.payload;
//import Addingplace.resources;
import Addingplace.resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
//import resusecode.ReusableMethods;

public class OptimisingScript {
	
	private static Logger log=LogManager.getLogger(OptimisingScript.class.getName());
	
	
	Properties prop=new Properties();//property class in java 
	
	@BeforeTest
	public void getData() throws IOException
	{System.out.println("before test");
		
		//now tell to fis object  where is your file
	//via system.getproperty("user.dir") ctrl comes to your project that is mavenjava
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//env.properties");
		prop.load(fis);//integerating property with file,prop object load the file
		//prop.get("HOST");
		
		
	}

	@Test
	public void postdata()
	{
//System.out.println("test");
		log.info("Host information"+prop.getProperty("HOST"));
		
		RestAssured.baseURI=prop.getProperty("HOST");
		Response res=given().
				queryParam(prop.getProperty("KEY")).
				body(payload.getpostdata()).
				when().
				post(resources.postRequest()).
				then().
				assertThat().and().contentType(ContentType.JSON).and().
				body("status",equalTo("OK")).extract().response();
//String response=res.asString();
//log.info("response is"+response);
//JsonPath json=new JsonPath(response);
//	
		JsonPath json=ReusableMethods.rawToJson(res);
	//log.info("response is"+json);
		String placeid=json.get("place_id");
		log.info("place id"+placeid);
		int statuscode=res.getStatusCode();
		System.out.println("response code is :"+statuscode );
	
	
	//after grabbing deleting the placeid
		String placeid1="{" + 
				"    \"place_id\":\""+placeid+"\""+
				"}";
		System.out.println(placeid1);
		Response del=given().
				queryParam("KEY").
				body(placeid1).
				when().
				post(resources.deleteRequest()).
				then().
				assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
		String rs1=del.asString();
		System.out.println(rs1);
		System.out.println("placeid deleted successfully");
		
		
	}
}
