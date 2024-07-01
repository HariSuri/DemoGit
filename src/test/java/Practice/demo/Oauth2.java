package Practice.demo;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojo.Api;
import pojo.GetCourses;
import pojo.WebAutomation;

public class Oauth2 {
	
	@Test
	
	public void oAuth() {	
	RestAssured.baseURI="https://rahulshettyacademy.com";
	String[] course={"Selenium Webdriver Java","Cypress","Protractor"};
	//Generate token
	String response =given().formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		   .formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		   .formParam("grant_type", "client_credentials")
		   .formParam("scope", "trust")
		   .post("/oauthapi/oauth2/resourceOwner/token").then().extract().response().asString();
	
			JsonPath js=new JsonPath(response);
			String access_token=js.getString("access_token");
			System.out.println(response);
			System.out.println(access_token);
			
			System.out.println("================================================================================");
			//Get Course details
			GetCourses gc=given().queryParam("access_token", access_token)
			   .get("/oauthapi/getCourseDetails").as(GetCourses.class);
			
			String url=gc.getUrl();
			System.out.println(url);
			String courseTitle=gc.getCourses().getWebAutomation().get(1).getCourseTitle();
			System.out.println(courseTitle);
			//Get all propries in API Array
			List<Api> count=gc.getCourses().getApi();
			for(int i=0;i<count.size();i++) {
				String price=gc.getCourses().getApi().get(i).getPrice();
				System.out.println(price);
				
			//Validate webAutomation courseTitle
				ArrayList<String> a= new ArrayList<String>();
				List<WebAutomation> w=gc.getCourses().getWebAutomation();
				for(int j=0;j<w.size();j++) {
					a.add(w.get(j).getCourseTitle());
					//System.out.println(webCourseTitle);
				
			}
				List<String> expectedcourse=Arrays.asList(course);
				Assert.assertTrue(a.equals(expectedcourse));
					   }

	}
}
