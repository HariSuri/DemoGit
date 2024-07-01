package Practice.demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GraphQLTest {
	public static void main(String args[]) {
		//Use given, when and then keywords to send request and get response back.
		//RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().header("Content-Type","application/json")
		.body("{\"query\":\"query{\\n location(locationId: 7){\\n  name\\n  dimension\\n}\\n}\",\"variables\":null}")
		.when().post("https://rahulshettyacademy.com/gq/graphql").then().log().all();
					}

}
