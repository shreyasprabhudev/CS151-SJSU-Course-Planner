package courseplanner;

import plannerWeb.*;
import java.io.File;
import java.util.ArrayList;

import plannerWeb.UserInterface;

public class Controller {
	private UserInterface ui;
	public PlannerSystem system;

	/*
	 * Inspired by MVC.
	 * Idea is that the UserInterface and GradeSystem interact through this class
	 * medium.
	 * 
	 * Predictably, UserInterface is often the one the initiates contact, since that
	 * is what the user is interacting with directly.
	 */

	public Controller() {
		system = new PlannerSystem(this);
		ui = new UserInterface(this);
	}

	// LOGGING IN USER
	// If such a user does not exists, returns false;
	public boolean loginUser(String id, String password) {
		return system.loginAttempt(id, password);
	}

	
	//LOGGING OUT USER
	public void logoutUser() {
		system.logoutAttempt();
	}
	

	// ADDING A USER - MAINLY FOR DRIVER USE
	public void addUser(User user) {
		system.addUser(user);
	}

	// ----------------------------- ADMIN OPTIONS -----------------------------

	// ADDING A USER - Returns the randomly generated ID String made for the User.
	public String addUser(String type, String firstName, String lastName, String password) {
		return system.addUser(type, firstName, lastName, password);
	}

	// REMOVING A USER - Returns boolean indication if operation is successful.
	// Failure may occur for Admin removal attempt, with only 1 Admin left.
	public boolean removeUser(String id) {
		return system.removeUser(id);
	}

	// ADD A COURSE
	public void addCourse(Course course) {
		system.addCourse(course);
	}
	
	public void addCourse(String courseName) {
		system.addCourse(courseName);
	}

	public void addCourse(String courseName, String professorID) {
		system.addCourse(courseName, professorID);
	}

	// REMOVE A COURSE
	public void removeCourse(String name) {
		system.removeCourse(name);
	}

	// ADD STUDENT TO COURSE - Returns boolean indicating if operation is success.
	// Failure may occur if student is already in that course.
	public boolean addStudentToCourse(String courseName, String studentId) {
		return system.addStudentToCourse(courseName, studentId);
	}

	// REMOVE STUDENT FROM COURSE
	public boolean removeStudentFromCourse(String courseName, String studentId) {
		return system.removeStudentFromCourse(courseName, studentId);
	}

	// Special: VIEW ALL USERS - Handled by GUI.

	// Special: VIEW ALL COURSES - Likely to be handled by GUI.
	
	//GENERATES A TXT DETAILING ALL STUDENTS IN THEIR COURSES + GRADES
	public void generateClassRosterTxt() { //change to studentcourse
		system.generateClassRosterTxt();
	}
	
	//GENERATES A TXT DETAILING ALL STUDENTS IN THEIR COURSES + GRADES (specific prof)
	public void generateClassRosterTxt(String profId) {
		system.generateClassRosterTxt(profId);
	}
	
	// ----------------------------- PROFESSOR OPTIONS -----------------------------

	// ADD STUDENT TO COURSE - Use addStudentToCourse from Admin.

	// REMOVE STUDENT FROM COURSE - Use removeStudentFromCourse from Admin.

	// VIEW STUDENTS + GRADES - Handled by the GUI after using getters from the
	// backend??

	// ----------------------------- STUDENT OPTIONS -----------------------------


	// ----------------------------- MISC. OPTIONS -----------------------------

	// GET CURRENT USER
	public User getCurrentUser() {
		return system.getCurrentUser();
	}

	// GET USER LIST
	public ArrayList<User> getUserList() {
		return system.getUserList();
	}

	// GET ALL COURSES
	public ArrayList<Course> getAllCourses() {
		return system.getAllCourses();
	}
	
	public Course getCourse(String course) {
		return system.getCourse(course);
	}
	
	// Saves the information of the gradebook into a txt file. 
	public String generateTxtSaveFile() {
		return system.generateTxtSaveFile();
	}
	
	//Reads and loads a gradebook. To be completed
	public void loadTxtFile(String fileName) throws Exception {
		PlannerSystem sys = new PlannerSystem(this);
		File file = new File(fileName);
		try {
			sys.loadTxtFile(file);
			this.system = sys;
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public void setSystem(PlannerSystem system) {
		this.system = system;
	}
  
}