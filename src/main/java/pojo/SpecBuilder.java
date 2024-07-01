package pojo;

import static io.restassured.RestAssured.given;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.*;

public class SpecBuilder {
	
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
				//Use SpecBuilder for code optimization
				//RestAssured.baseURI="https://rahulshettyacademy.com";
				RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123")
						.setContentType(ContentType.JSON).build();				
				//given().queryParam("key","qaclick123").header("Content-Type","application/json");
				ResponseSpecification res1=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
				RequestSpecification reqextend=given().spec(req).body(a);
				//.body(a).when().post("maps/api/place/add/json")
				Response res=reqextend.when().post("/maps/api/place/add/json").then().spec(res1).extract().response();
				//.then().log().all().statusCode(200);
				String responsestring=res.asString();
				System.out.println(responsestring);
	}
	}


