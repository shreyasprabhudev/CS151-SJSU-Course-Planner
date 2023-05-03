package courseplanner;

import java.util.ArrayList;

public class Advisor extends User {
	private ArrayList<Student> studentList;

	public Advisor(String firstName, String lastName, String id, String password) {
		super(firstName, lastName, id, password);
	}

}
