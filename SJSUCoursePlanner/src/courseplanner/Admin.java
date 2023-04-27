package courseplanner;

import java.util.ArrayList;

public class Admin extends User {
	private ArrayList<PlannerSystem> courseList;

	public Admin(String firstName, String lastName, String id, String password) {
		super(firstName, lastName, id, password);
	}

	public void addCourse(PlannerSystem course) {
		courseList.add(course);
	}

	public void deleteCourse(PlannerSystem course) {
		courseList.remove(course);
	}

}
