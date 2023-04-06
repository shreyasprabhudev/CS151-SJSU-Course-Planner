package plannerWeb;

import java.util.ArrayList;

public class Student extends User {
	private String major;
	private String graduationSemester;
	private ArrayList<Course> courseList;
	public int graduationYear;

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

	public void viewMajorRelatedClasses() {

	}

	public void viewSyllabus(Course course) {

	}

	@Override
	public boolean login() {
		// TODO Auto-generated method stub
		ArrayList<Student> studentList = new ArrayList<Student>();
		for (Student student : studentList) {
			if (student.getId().equals(this.getId()) && student.getPassword().equals(this.getPassword())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void viewCourses() {
		// TODO Auto-generated method stub

	}
}
