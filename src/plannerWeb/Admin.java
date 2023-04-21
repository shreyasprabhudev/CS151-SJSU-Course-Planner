package plannerWeb;

import java.util.ArrayList;

public class Admin extends User{
	private ArrayList<CourseSystem> courseList;
	
	public Admin(String firstName, String lastName, String id, String password)
	{
		super(firstName, lastName, id, password);
	}
	
	public void addCourse(CourseSystem course)
	{
		courseList.add(course);
	}
	
	public void deleteCourse(CourseSystem course)
	{
		courseList.remove(course);
	}

	

}
