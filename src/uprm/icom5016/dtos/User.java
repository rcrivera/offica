package uprm.icom5016.dtos;

public class User {

	private String userName;
	private String pass;
	private String isAdmin;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	private String email;
	private String phone;
	
	
	public User(String username, String pass, String first,
			String last, String email, String phone,
			String address, String city, String state, String zipcode,
			String country, String isAdmin) {
		super();
		this.userName = username;
		this.pass = pass;
		this.isAdmin = isAdmin;
		this.firstName = first;
		this.lastName = last;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
		this.email = email;
		this.phone = phone;
	}
	
	
	public  User() {
		super();
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String userPass) {
		this.pass = userPass;
	}
	
	
	public String getIsAdmin(){
		return isAdmin;
	}
	
	
	public void setIsAdmin(String isAdmin){
		this.isAdmin = isAdmin;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}



	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	
	
}
