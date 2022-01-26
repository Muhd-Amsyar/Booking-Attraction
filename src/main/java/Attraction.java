
public class Attraction {
	
	 protected int attraction_Id;
	 protected String attractionName;
	 protected String description;
	 protected String image;
	 protected int price;
	 protected String openingHours;
	 protected String address;
	 
	public Attraction(int attraction_Id, String attractionName, String description, String image, int price,
			String openingHours, String address) {
		super();
		this.attraction_Id = attraction_Id;
		this.attractionName = attractionName;
		this.description = description;
		this.image = image;
		this.price = price;
		this.openingHours = openingHours;
		this.address = address;
	}
	public int getAttraction_Id() {
		return attraction_Id;
	}
	public void setAttraction_Id(int attraction_Id) {
		this.attraction_Id = attraction_Id;
	}
	public String getAttractionName() {
		return attractionName;
	}
	public void setAttractionName(String attractionName) {
		this.attractionName = attractionName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
