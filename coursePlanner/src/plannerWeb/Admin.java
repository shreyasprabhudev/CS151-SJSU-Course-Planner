package plannerWeb;

import java.util.ArrayList;

public class Admin extends User{
	private ArrayList<Course> courseList;
	
	public Admin(String firstName, String lastName, String id, String password)
	{
		super(firstName, lastName, id, password);
	}
	
	public void addCourse(Course course)
	{
		courseList.add(course);
	}
	
	public void deleteCourse(Course course)
	{
		courseList.remove(course);
	}

	@Override
	public boolean login() {
		// TODO Auto-generated method stub
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		for (Admin admin : adminList) {
			if (admin.getId().equals(this.getId()) && admin.getPassword().equals(this.getPassword())) {
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
