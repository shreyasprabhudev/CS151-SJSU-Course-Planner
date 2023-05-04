package plannerWeb;

import java.util.ArrayList;

public class Professor extends User{
	
	
	public Professor() {
		
	}

	public Professor(String firstName, String lastName, String id, String password) {
		super(firstName, lastName, id, password);
	}
	
	//public void addSyllabus(Course course) //do we need a syllabus class? 
	//public void removeSyllabus(Syllabus syllabus)
	
	
	
	@Override
	public boolean login() {
		// TODO Auto-generated method stub
		ArrayList<Professor> professorList = new ArrayList<Professor>();
		for(Professor professor: professorList)
		{
			if(professor.getId().equals(this.getId()) && professor.getPassword().equals(this.getPassword())){
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
