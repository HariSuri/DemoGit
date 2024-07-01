package files;

import io.restassured.path.json.JsonPath;

public class Reusable {
	
	public static JsonPath payloadToRaw(String response) {
		JsonPath js2=new JsonPath(response);
		return js2;
	}

}
