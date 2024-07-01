package resources;

//enum is special class in java which is collection of constants or methods
public enum Resources {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	private String resource;
	Resources(String resource) {
		this.resource=resource;
	}

	public String getResource() {
		return resource;
	}
}
