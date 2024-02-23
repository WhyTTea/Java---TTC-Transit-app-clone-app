package transitapp;

public abstract class User {
	String FirstName;
	String LastName;
	
	public User(String FirstName, String LastName) {
		this.FirstName = FirstName;
		this.LastName = LastName;
	}
	public abstract String getName();
	public abstract String setFirstName();
	public abstract String setLastName();
}
