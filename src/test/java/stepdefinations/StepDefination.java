package stepdefinations;

import static io.restassured.RestAssured.given;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.Resources;
import resources.TestDataBuild;
import resources.Utils;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class StepDefination extends Utils {
	
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data= new TestDataBuild();
	JsonPath js;
	static String place_id;
	
	@Given("Add place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		res=given().spec(requestSpecification())
		.body(data.addPlacePayload(name, language, address));
	}
	@When("User calls {string} with {string} with http request")
	public void user_calls__with_with_http_request(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
		Resources rc=Resources.valueOf(resource);
		System.out.println("Endpiont: "+rc.getResource());
		resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(method.equalsIgnoreCase("POST")) 
			response=res.when().post(rc.getResource());
		else if(method.equalsIgnoreCase("GET"))
				response=res.when().get(rc.getResource());
		
	}
	@Then("The API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(),200);
	}
	@Then("{string} is response body is {string}")
	public void is_response_body_is(String keyValue, String ExpectedValue) {
	    // Write code here that turns the phrase above into concrete actions
		String resp=response.asString();
		js= new JsonPath(resp);
		place_id=js.get("place_id");
		assertEquals(getJsonPath(response, keyValue),ExpectedValue);
	}
	
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedname, String resource) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		place_id=getJsonPath(response, "place_id");
		res=given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls__with_with_http_request(resource, "GET");
		String actualname=getJsonPath(response, "name");
		assertEquals(actualname, expectedname);
	}
	
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		res=given().spec(requestSpecification())
		.body(data.deletePayload(place_id));
	}


}
