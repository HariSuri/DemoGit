package Practice.demo;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import files.AddPlacePayload;
import static io.restassured.RestAssured.given;




public class AddPlace {
	public static void main(String args[]) {
		//Use given, when and then keywords to send request and get response back.
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(AddPlacePayload.addPayload()).then().log().all().statusCode(200)
					.body("scope", equalTo("APP"))
					.header("server", "Apache/2.4.18 (Ubuntu)");
					}
	//TC: Add place->Update addr with new addr-> Get new addr and validate if new addr updated to make sure

}
