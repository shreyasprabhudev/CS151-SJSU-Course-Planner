package courseplanner;

import java.util.ArrayList;

public class Admin extends User {
	private ArrayList<Course> courseList;

	public Admin(String firstName, String lastName, String id, String password) {
		super(firstName, lastName, id, password);
	}

	public void addCourse(Course course) {
		courseList.add(course);
	}

	public void deleteCourse(Course course) {
		courseList.remove(course);
	}
	
	public ArrayList<Course> getCourses(){
		return courseList;
	}

}
