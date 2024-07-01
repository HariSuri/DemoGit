package resources;
import java.util.ArrayList;
import java.util.List;

import pojo.Addplace;
import pojo.Location;
public class TestDataBuild {
	
	public Addplace addPlacePayload(String name, String language, String address ) {
	Addplace a=new Addplace();
	a.setAccuracy("50");
	a.setAddress(address);
	a.setName(name);
	a.setPhone_number("(+91) 983 893 3937");
	a.setWebsite("http://google.com");
	a.setLanguage(language);
	Location l=new Location();
	l.setLat(-38.383494);
	l.setLng(33.427362);
	a.setLocation(l);
	List<String> list=new ArrayList<String>();
	list.add("shoe park");
	list.add("shop");
	a.setTypes(list);
	return a;
	}
	
	public String deletePayload(String place_id) {
		return "{\r\n"
				+ "    \"place_id\": \""+place_id+"\"\r\n"
				+ "}";
	}
}
