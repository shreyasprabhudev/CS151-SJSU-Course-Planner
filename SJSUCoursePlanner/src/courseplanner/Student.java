package courseplanner;

import java.util.ArrayList;

public class Student extends User {
	private String major;
	private String graduationSemester;
	private ArrayList<Course> courseList;
	public int graduationYear;
	
	public Student() {
		super();
	}

	public Student(String firstName, String lastName, String id, String password) {
		super(firstName, lastName, id, password);
		courseList = new ArrayList<Course>();

	}

	public void addCourse(Course course) {
		courseList.add(course);
	}

	public void deleteCourse(Course course) {
		courseList.remove(course);
	}

	public void viewAssignedAdvisor(Advisor advisor) // need to fix
	{
		System.out.println("Assigned advisor: " + advisor.getFirstName() + " " + advisor.getLastName());
	}
	
	public ArrayList<Course> getCourseList(){
		return courseList;
	}



}