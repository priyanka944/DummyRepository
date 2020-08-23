package Addingplace;

public class resources {
	
	public static String getRequest()
	{
		String get="/maps/api/place/nearbysearch/json";
		return get;
	}
	
	public static String postRequest()
	{
		String res="/maps/api/place/add/json";
		return res;
				

}
	public static String deleteRequest()
	{
		String del="/maps/api/place/delete/json";
		return del;
	}

	
	public static String postBook()
	{
		String book="/Library/Addbook.php";
		return book;
	}
}

