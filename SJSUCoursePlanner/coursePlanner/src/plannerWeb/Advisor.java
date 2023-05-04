package plannerWeb;

import java.util.ArrayList;

public class Advisor extends User{
	private ArrayList<Student> studentList;
	
	public Advisor(String firstName, String lastName, String id, String password)
	{
		super(firstName, lastName, id, password);
	}

	@Override
	public boolean login() {
		// TODO Auto-generated method stub
		ArrayList<Advisor> advisorList = new ArrayList<Advisor>();
		for (Advisor advisor: advisorList) {
			if (advisor.getId().equals(this.getId()) && advisor.getPassword().equals(this.getPassword())) {
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
