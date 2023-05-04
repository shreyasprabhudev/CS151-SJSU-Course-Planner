package plannerWeb;

import java.util.ArrayList;

public abstract class User {
	private String firstName;
	private String lastName;
	private String id;
	private String password;

	public User() {

	}

	public User(String firstName, String lastName, String id, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.password = password;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public abstract boolean login();

	public abstract void viewCourses();

}