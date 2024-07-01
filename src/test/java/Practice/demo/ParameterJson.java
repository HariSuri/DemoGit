package Practice.demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.AddPlacePayload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ParameterJson {
	
	//TC: Paramterize json payload and pass multiple test data using data provider
	@Test(dataProvider="Book data")
	public void dynJson(String isbn, String aisle ) {
			//Use given, when and then keywords to send request and get response back.
			RestAssured.baseURI="https://rahulshettyacademy.com";
			System.out.println("Add book details");
			given().header("Content-Type","application/json")
			.body(AddPlacePayload.addBook(isbn,aisle))
			.when().post("/Library/Addbook.php")
			.then().assertThat().statusCode(200);
	}
	
	@DataProvider(name="Book data")
	public Object[][] dataProvide() {
		
	return new Object[][] {{"bcd","2926"},{"bcd","2927"},{"bcd","2928"}};
		
	}

}