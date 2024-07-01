package Practice.demo;

import files.AddPlacePayload;
import io.restassured.path.json.JsonPath;

public class JsonValidation {
	public static void main(String args[]) {
	//Initialize JsonPath		
	JsonPath js=new JsonPath(AddPlacePayload.jsonPathPayload());
	//TC1:Get courses count
	int count=js.getInt("courses.size()");
	System.out.println(count);
	//TC2:Print purchase amount
	int purchase_amount=js.getInt("dashboard.purchaseAmount");
	System.out.println(purchase_amount);
	//TC3:Print first title of the course
	String title=js.getString("courses[0].title");
	System.out.println(title);
	//TC4:Print All course titles and their respective Prices
	for(int i=0;i<count;i++) {
		String course=js.getString("courses["+i+"].title");
		int price=js.getInt("courses["+i+"].price");
		System.out.println(course);
		System.out.println(price);
	}
	//TC5:Print no of copies sold by RPA course
	for(int i=0;i<count;i++) {
		String course1=js.getString("courses["+i+"].title");
		if(course1.equalsIgnoreCase("RPA")) {
		int copies=js.getInt("courses["+i+"].copies");
		System.out.println(copies);
		break;
		}
	}
	//TC:Verify i Sum of all course prices and match with purchase amount
	}
	
}
