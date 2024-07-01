package pojo;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;


public class Serialization {
	
	@Test
	public void objectToJson() {
		
				Addplace a=new Addplace();
				a.setAccuracy("50");
				a.setAddress("Kolamadugu");
				a.setName("Frontline house");
				a.setPhone_number("(+91) 983 893 3937");
				a.setWebsite("http://google.com");
				a.setLanguage("language");
				Location l=new Location();
				l.setLat(-38.383494);
				l.setLng(33.427362);
				a.setLocation(l);
				List<String> list=new ArrayList<String>();
				list.add("shoe park");
				list.add("shop");
				a.setTypes(list);
		//Use given, when and then keywords to send request and get response back.
				RestAssured.baseURI="https://rahulshettyacademy.com";
				given().queryParam("key","qaclick123").header("Content-Type","application/json")
				.body(a).when().post("maps/api/place/add/json")
				.then().log().all().statusCode(200);
	}
	}


