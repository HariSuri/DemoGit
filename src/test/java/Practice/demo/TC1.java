package Practice.demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import files.AddPlacePayload;
import files.Reusable;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;






public class TC1 {
	public static void main(String args[]) {
		//TC: Add place->Update addr with new addr-> Get new addr and validate if new addr updated to make sure
		//Use given, when and then keywords to send request and get response back.
		RestAssured.baseURI="https://rahulshettyacademy.com";
		//Add address
		System.out.println("Add address");
		String response=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(AddPlacePayload.addPayload()).when().post("maps/api/place/add/json").then().statusCode(200)
					.body("scope", equalTo("APP"))
					.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println("response is "+response);
		
		//Initialize JsonPath		
		JsonPath js=new JsonPath(response);
		String place_id=js.getString("place_id");
		System.out.println("place_id is "+place_id);
		System.out.println("==============================================================================");
		//Update address
		System.out.println("Update address");
		String newadress="Santhipuram2";
		String updateresponse= given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"place_id\": \""+place_id+"\",\r\n"
				+ "    \"address\": \""+newadress+"\",\r\n"
				+ "    \"key\": \"qaclick123\"\r\n"
				+ "}").when().put("maps/api/place/update/json").then().statusCode(200)
					.body("msg", equalTo("Address successfully updated"))
					.extract().response().asString();
		
		System.out.println("Update response is "+updateresponse);
		//Initialize JsonPath		
		JsonPath js1=new JsonPath(updateresponse);
		String msg=js1.getString("msg");
		System.out.println("msg is "+msg);
		System.out.println("==============================================================================");
		//Get address
				System.out.println("Get address");
				String getresponse= given().log().all().queryParam("key","qaclick123")
									.queryParam("place_id",place_id)
				.when().get("maps/api/place/get/json").then().statusCode(200)
							.extract().response().asString();
				
				System.out.println("Get response is "+getresponse);
				//Initialize JsonPath		
				//JsonPath js2=new JsonPath(getresponse);
				JsonPath js2=Reusable.payloadToRaw(getresponse);
				String address=js2.getString("address");
				System.out.println("address is "+address);
				
				//Assert using TestNG
				Assert.assertEquals(address, newadress);
		
		}
	

}
