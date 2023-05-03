package courseplanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
//import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Course implements Comparable<Course> {

	private String name;											//Course name should be similar to our system, like "CS 151-06"
	public TreeMap<Student, ArrayList<Course>> studentBase;
	public TreeSet<String> courseNameList;	
	public HashMap<String, Course> Courses;//This is needed because students may have different Courses. 
	
	public Course(String name, TreeMap<Student, ArrayList<Course>> studentBase) {
		this.name = name;
		this.studentBase = studentBase;
		this.courseNameList = new TreeSet<String>();
		Courses = new HashMap<String, Course>();
	}
	
	public Course(String name, Professor professor) {
		this.name = name;
		this.studentBase = new TreeMap<Student, ArrayList<Course>>();
		this.courseNameList = new TreeSet<String>();
		Courses = new HashMap<String, Course>();

	}

	public Course(String name) {
		this.name = name;
		this.studentBase = new TreeMap<Student, ArrayList<Course>>();
		this.courseNameList = new TreeSet<String>();
		Courses = new HashMap<String, Course>();

	}

	/**
	 * This method is called multiple times by GradeSystem. This is so each student
	 * gets the Course.
	 */
	public void addCourse(Student student, Course asgn) {
		studentBase.get(student).add(asgn);
		courseNameList.add(asgn.getName());
	}
	
	public void addCourse(String in, Course Course) {
		this.Courses.put(in, Course);
	}
	
	/**
	 * If an Course is removed, I presume that it will be for each student...
	 * However, for the sake of ease of use later on, this remove an Course 
	 * for a the designated student and Course name.
	 * 
	 * If Course is not found, nothing is removed. 
	 * 
	 * Edit: Now returns boolean. False if it fails, true if it worked. 
	 */
	public boolean removeCourse(Student student, String asgnName) {
		ArrayList<Course> asgn = studentBase.get(student);
		
		for (int i = 0; i < asgn.size(); i++) {
			if (asgn.get(i).getName().equals(asgnName)) {
				asgn.remove(i);
				return true;
			}
		}
    
		verifyAsgnExistence(asgnName);
		return false;
	}
	
	/**
	 * Removes an Course given the name for ALL students in the class.
	 * Then, removes that Course from the set recording the names of all Courses added in so far
	 */
	public void removeCourseAllStudents(String asgnName) {
		ArrayList<Student> students = new ArrayList<Student>(studentBase.keySet());
		for (int i = 0; i < students.size(); i++) {
			removeCourse(students.get(i), asgnName);
		}
		courseNameList.remove(asgnName);
	}


	/**
	 * Checks if a given Course name exists anymore. If it doesn't, remove it from the 
	 * list of Course names set, and if it does, exit the method. 
	 */
	public void verifyAsgnExistence(String asgnName) {
		ArrayList<Student> students = new ArrayList<Student>(studentBase.keySet());
		for (int i = 0; i < students.size(); i++) {
			ArrayList<Course> asgnList = studentBase.get(students.get(i));
			for (int j = 0; j < asgnList.size(); j++) {
				if (asgnList.get(j).getName().equals(asgnName)) {
					return;
				}
			}
		}
		//Reaching here means it doesn't exist
		courseNameList.remove(asgnName);
	}
	
	public boolean addNewStudent(Student student) {
		if (!studentBase.containsKey(student)) {
			studentBase.put(student, new ArrayList<Course>());
			return false;
		} else {
			return true;
		}
	}
	
	public void addOldStudent(Student student, ArrayList<Course> asgn) {
		studentBase.put(student, asgn);
	}
	
	
	public boolean removeStudent(Student student) {
		if (!studentBase.containsKey(student)) {
			return false;
		} else {
			studentBase.remove(student);
			return true;
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<Student> getStudents() {
		return new ArrayList<Student>(studentBase.keySet());
	}
	
	public ArrayList<Course> getStudentCourses(Student student) {
		return studentBase.get(student);
	}
	
	public ArrayList<String> getcourseNameList() {
		return new ArrayList<String>(courseNameList);
	}

	@Override
	public int compareTo(Course other) {
		return this.name.compareTo(other.name);
	}
  
}

