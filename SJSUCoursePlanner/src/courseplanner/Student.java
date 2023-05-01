package courseplanner;

import java.util.ArrayList;

public class Student extends User {
	private String major;
	private String graduationSemester;
	private ArrayList<PlannerSystem> courseList;
	public int graduationYear;

	public Student(String firstName, String lastName, String id, String password) {
		super(firstName, lastName, id, password);
		courseList = new ArrayList<PlannerSystem>();

	}

	public void addCourse(PlannerSystem course) {
		courseList.add(course);
	}

	public void deleteCourse(PlannerSystem course) {
		courseList.remove(course);
	}

	public void viewAssignedAdvisor(Advisor advisor) // need to fix
	{
		System.out.println("Assigned advisor: " + advisor.getFirstName() + " " + advisor.getLastName());
	}



}