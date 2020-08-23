package Addingplace;


public class payload {

	public static String getpostdata()
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
				
				"}";
		return b;

	}
	
	public static String AddBook(String isbn,String aisle)
	{
		String body="{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}";
return body;
	}
	
}
