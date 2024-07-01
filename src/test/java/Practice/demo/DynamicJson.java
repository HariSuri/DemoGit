package Practice.demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import files.AddPlacePayload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {
	
	//TC: Update data in json payload dynamically
	@Test
	public void dynJson() {
			//Use given, when and then keywords to send request and get response back.
			RestAssured.baseURI="https://rahulshettyacademy.com";
			System.out.println("Add book details");
			given().header("Content-Type","application/json")
			.body(AddPlacePayload.addBook("bcd","2926"))
			.when().post("/Library/Addbook.php")
			.then().assertThat().statusCode(200);
	}

}
