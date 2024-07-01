package Practice.demo;

import org.testng.annotations.Test;

import files.AddPlacePayload;
import io.restassured.path.json.JsonPath;

public class SumCourse {
	@Test
	public void sumofCourse() {
		JsonPath js=new JsonPath(AddPlacePayload.jsonPathPayload());
		int count=js.getInt("courses.size()");
		int sum=0;
			for(int i=0;i<count;i++) {
			int price=js.getInt("courses["+i+"].price");
			int copies=js.getInt("courses["+i+"].copies");
			int course_mul=price*copies;
			System.out.println(course_mul);
			sum=sum+course_mul;			
							}
			System.out.println(sum);
		
	}

}
