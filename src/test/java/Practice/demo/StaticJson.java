package Practice.demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import files.AddPlacePayload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class StaticJson {
	
	//TC: Send json paylod statically from system location
	@Test
	public void statJson() throws IOException {
			//Use given, when and then keywords to send request and get response back.
			RestAssured.baseURI="https://rahulshettyacademy.com";
			System.out.println("Add book details");
			given().header("Content-Type","application/json")
			.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\text\\Downloads\\AddBook.json"))))
			.when().post("/Library/Addbook.php")
			.then().log().all().statusCode(200);
	}
	
}