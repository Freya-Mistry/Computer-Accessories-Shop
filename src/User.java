
public class User {
	private int ID;
	private String username;
	private String name;
	private int houseNumber;
	private String postcode;
	private String city;
	private Role role;
	
	public User (int ID, String username, String name, int houseNumber, String postcode, String city, Role role) {
		this.ID = ID;
		this.username = username;
		this.name = name;
		this.houseNumber = houseNumber;
		this.postcode = postcode;
		this.city = city;
		this.role = role;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getName() {
		return name;
	}
	
	public int getHouseNumber() {
		return houseNumber;
	}
	
	public String getPostcode() {
		return postcode;
	}
	
	public String getCity() {
		return city;
	}
	
	public Role getRole() {
		return role;
	}
	
	public String toString() {
		String str = ID +
					", " + username +
					", " + name +
					", " + houseNumber +
					", " + postcode +
					", " + city +
					", " + role;
		return str;
	}
}
