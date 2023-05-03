package courseplanner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class PlannerSystem {
	/*
	 * private String dptRelatedCourses; private String courseNum; private String
	 * courseName; private String preReq; private String objectives; private String
	 * requiredText; private int totalSeats; private Professor professor; private
	 * int units; private String offeredTerm;
	 */
	private Controller control;
	private TreeMap<String, User> users; // Key: UserID Value: User
	private TreeMap<String, Course> courses; // Key: course's name Value: Course
	private User currentUser;
	private static ArrayList<String> user = new ArrayList<>();


	/*
	 * This is the underlying system that take cares of most of the logic in the
	 * system. The Controller would call this system's commands in order to get work
	 * done.
	 * 
	 * ================================================================ THINGS TO
	 * KEEP IN MIND================================================================
	 * 
	 * 1.) A Course only have 1 Professor. This can be defined, or null.
	 * 
	 * 2.) Removal of a Student in a Course will destroy all assignments associated
	 * with them in that Course.
	 * 
	 * 3.) Removal of a Professor in a Course will simply set the Course's Professor
	 * to null.
	 * 
	 * 4.) Removal of an Admin will have no effect on the grades in the system.
	 * 
	 * 5.) Removal of a Student in the system will remove them from all Courses,
	 * past or present.
	 * 
	 * 6.) Removal of a Professor in the system will set all Courses' Professors
	 * they are associated with to null.
	 * 
	 * 7.) Only an Admin can add Users into the system. One is created by default
	 * upon system startup.
	 * 
	 * 8.) Professors and Admins can both add or remove Students from a Course. The
	 * difference is that an Admin is not restricted by the Courses they are
	 * responsible for (a Course's Professor).
	 * 
	 * 9.) Professors can only edit the points earned for an Assignment. Debatable
	 * as to whether they should also be able to edit the total and name.
	 * 
	 * 10.) Every time an assignment is added, the student's grade should be
	 * automatically updated. On top of that, the student's overall GPA should also
	 * be changed. This also applies when an assignment is edited.
	 * 
	 * 11.) Removal of a Course will cause all Students to be kicked from the
	 * Course.
	 * 
	 * 12.) Admins cannot be removed by themselves if they are the only admin left.
	 * Admins that do remove themselves will be immediately redirected to the login
	 * screen.
	 * 
	 * =============================================================================
	 * ===========================================================================
	 *
	 * ------ Completed ------ - Basic GUI for logging in - GUI home page for each
	 * User type - Actually logging the user in. - Preventing non-users from
	 * entering and using the system
	 * 
	 *
	 * ------ Work in Progress/To be worked on ------ (X = GUI created, O =
	 * Functioning) - GUI for each of the specific user options
	 * 
	 * - Admin Options Adding User to system X Removing User from system X
	 * 
	 * Adding Course to system X Removing Course from system
	 * 
	 * Assigning Professor to a Course Removing Professor from a Course
	 * 
	 * Adding Student to a Course Removing Student from a Course
	 * 
	 * - Professor Options Adding Student to a Course Removing Student from a Course
	 * 
	 * Adding an Assignment (for all Students). Possible: Editing an Assignment (for
	 * one Student)? Removing an Assignment (for all Students)
	 * 
	 * Viewing each Student in the class, and their grade in said class.
	 * 
	 * - Student Options Viewing their current and past Courses, and Grades for
	 * each. Includes GPA probs Printing a transcript of their grades and courses.
	 *
	 * 
	 * ------ Possible future implementations ------ - Making a "Finish Course"
	 * option. This would be different from removing a course, in insert the Course
	 * into the pastCourse for each student in that class. - Canvas API????
	 * 
	 */

	public PlannerSystem(Controller control) {
		this.control = control;
		users = new TreeMap<String, User>();
		courses = new TreeMap<String, Course>();
	}

	// ------------------------------------------------------ LOG IN or LOG OUT
	// PORTION ------------------------------------------------------

	/**
	 * Login attempt method, sets the current user to be one with matching
	 * credentials and returns true. If the user does not exist, then it is not set,
	 * and false is returned instead.
	 * 
	 * @param id
	 * @param password
	 * @return
	 */
	
	public static String checkUser(String username, String password) {
		boolean userExists = false;
		boolean wrongPassword = false;

		for (int i = 0; i < user.size(); i++) {
			String currentLine = user.get(i);
			String[] fields = currentLine.split(" ");
			String currentUsername = fields[0];
			String currentPassword = fields[1];

			if (username.equals(currentUsername))
				userExists = true;
			if (username.equals(currentUsername) && !password.equals(currentPassword))
				wrongPassword = true;
		}

		if (!userExists)
			return "User does not exist";
		else if (wrongPassword)
			return "Wrong password";
		else
			return "Valid user";
	}

	public static String getUser(String username, String password) {
		for (int i = 0; i < user.size(); i++) {
			String currentLine = user.get(i);
			String[] fields = currentLine.split(" ");
			String currentUsername = fields[0];

			if (username.equals(currentUsername))
				return currentLine;
		}
		return null;
	}
	public String createUsername(String role, String firstName, String lastName) {
		String output = "";
		if (role.equals("Student"))
			output += "SS";
		else if (role.equals("Admin"))
			output += "UA";
		else if (role.equals("Advisor"))
			output += "SA";
		output += "-";

		Random random = new Random();
		output += random.nextInt((9999 - 100) + 1) + 10;

		return output;
	}
	
	
	public boolean loginAttempt(String id, String password) {
		if (users.containsKey(id) && users.get(id).getPassword().equals(password)) {
			currentUser = users.get(id);
			return true;
		}
		return false;
	}

	/**
	 * Logs out current user. Pretty much a guaranteed success operation.
	 */
	public void logoutAttempt() {
		currentUser = null;
	}

	// ------------------------------------------------------ Admin Options
	// ------------------------------------------------------

	// Generic method. Not sure if it will be used a lot.
	public void addUser(User user) {
		users.put(user.getId(), user);
	}

	// ----------- Adds a User into the system. Generates an ID for them, which is
	// returned (for GUI purposes).-----------
	public String addUser(String type, String firstName, String lastName, String password) {
		String id = createUsername(type, firstName, lastName);
		if (type.equals("Admin")) {
			users.put(id, new Admin(firstName, lastName, id, password));
		} else if (type.equals("Professor")) {
			users.put(id, new Professor(firstName, lastName, id, password));
		} else if (type.equals("Student")) {
			users.put(id, new Student(firstName, lastName, id, password));
		}
		return id;
	}

	// Exception AddUser Case: loading in a file
	public void addUser(String type, String firstName, String lastName, String id, String password) {
		if (type.equals("Admin")) {
			users.put(id, new Admin(firstName, lastName, id, password));
		} else if (type.equals("Advisor")) {
			users.put(id, new Advisor(firstName, lastName, id, password));
		} else if (type.equals("Student")) {
			users.put(id, new Student(firstName, lastName, id, password));
		}
	}

	// ----------- Removing Users from the system -----------
	// Returns true if completed successfully, return false if failure.
	public boolean removeUser(String id) {
		if (users.get(id) instanceof Student) { // Student - Remove them from each course they are a part of, also
												// deleting their assignments.
			ArrayList<Course> courses = new ArrayList<Course>(((Student) users.get(id)).getCourseList()); // Current
																													// courses
			for (int i = 0; i < courses.size(); i++) {
				courses.get(i).removeStudent((Student) users.get(id));
			}

			// No longer needed
//				courses = new ArrayList<Course>( ((Student)users.get(id)).getPastCourses().keySet());		//Removes past courses
//				for (int i = 0; i < courses.size(); i++) {
//					courses.get(i).removeStudent((Student)users.get(id));
//				}

		} else if (users.get(id) instanceof Admin) { // Professor - Remove association with each course they are a
															// part of.
			ArrayList<Course> courses = ((Admin) users.get(id)).getCourses();
			for (int i = 0; i < courses.size(); i++) {
				((Admin) users.get(id)).deleteCourse(courses.get(i));
			}

		} else { // Advisor(s) do not have any particular ties with Students or Professors.
					// HOWEVER, there must at least be one. This is the only means in which removal
					// can fail.
			ArrayList<Advisor> advisor = getAdvisorList();

			if (advisor.size() <= 1) {
				return false;
			}

		}
		users.remove(id); // After necessary operations done, the user is permanently removed from the
							// system.
		return true;
	}

	// ----------- Adding Courses to the system -----------
	public void addCourse(String name) { // Occurs when N/a is selected
		courses.put(name, new Course(name));
	}

	public void addCourse(String courseName, String professorID) { // Occurs when a Professor is selected
		courses.put(courseName, new Course(courseName, (Professor) users.get(professorID)));
	}

	public void addCourse(Course course) { // Used in Driver to add in some dummy courses.
		courses.put(course.getName(), course);
	}

	// ----------- Removing an (active) Course from the system -----------
	public void removeCourse(String name) {
		Course course = courses.get(name);
		courses.remove(name);
		ArrayList<Student> students = course.getStudents();

		// For each student, removes the course from their active courses. Also updates
		// their GPA.
		for (int i = 0; i < students.size(); i++) {
			TreeMap<Course, Character> curCourses = students.get(i).getCurCourses();
			curCourses.remove(course);
		}
	}
	
	// ------------------------------------------------------ Professor Options
	// ------------------------------------------------------

	
	// Prints the entire roster of the classes the Professor has into a txt
	public void generateClassRosterTxt() {
		try {
			String fileName = currentUser.getId() + "ClassRoster.txt";
			File file = new File(fileName);

			// File generation and naming process
			int counter = 1;
			while (!file.createNewFile()) { // If a file is already generated, then it makes another one.
				fileName = currentUser.getId() + "ClassRoster {" + counter + ").txt";
				file = new File(fileName);
				counter++;
			}
			FileWriter writer = new FileWriter(file);

			Professor prof = (Professor) currentUser;
			ArrayList<Course> coursesOwned = prof.getCourses();

			for (int i = 0; i < coursesOwned.size(); i++) {

				Course course = coursesOwned.get(i);
				ArrayList<Student> roster = course.getStudents();
				writer.write("=========| Start " + course.getName() + " Roster |=========\n");

				for (int j = 0; j < roster.size(); j++) {
					Student student = roster.get(i);
					writer.write(student.getFirstName() + " " + student.getLastName() + ", "
							+ String.format("%-14s", student.getGrade(course)) + "\n");
				}
				writer.write("=========| End " + course.getName() + " Roster |=========\n\n");
			}

			writer.close();

		} catch (Exception e) {
			System.out.println("Error during class roster txt generation");

		}

	}

	// Overloaded print class roster method for testing purposes... and maybe for
	// another occasion
	public void generateClassRosterTxt(String profId) {
		try {
			String fileName = profId + "ClassRoster.txt";
			File file = new File(fileName);

			// File generation and naming process
			int counter = 1;
			while (!file.createNewFile()) { // If a file is already generated, then it makes another one.
				fileName = profId + "ClassRoster (" + counter + ").txt";
				file = new File(fileName);
				counter++;
			}

			FileWriter writer = new FileWriter(file);
			Professor prof = (Professor) users.get(profId);
			ArrayList<Course> coursesOwned = prof.getCourses();

			for (int i = 0; i < coursesOwned.size(); i++) {
				Course course = coursesOwned.get(i);
				ArrayList<Student> roster = course.getStudents();
				writer.write("=========| Start " + course.getName() + " Roster |=========\n");

				for (int j = 0; j < roster.size(); j++) {
					Student student = roster.get(j);
					writer.write(String.format("%-10s", student.getFirstName() + " " + student.getLastName() + ", "
							+ student.getId() + "\t" + student.getGrade(course)) + "\n");
				}
				writer.write("=========| End " + course.getName() + " Class |=========\n\n");
			}

			writer.close();

		} catch (Exception e) {
			System.out.println("Error during class roster txt generation");

		}

	}

	// ------------------------------------------------------ Student-related
	// Options ------------------------------------------------------

	// Print transcripts in txt format. Experimental.

	/*
	 * public void printTranscript() { try { String fileName = currentUser.getId() +
	 * "Transcript.txt"; File file = new File(fileName);
	 * 
	 * int counter = 1; while (!file.createNewFile()) { // If a file is already
	 * generated, then it makes another one. fileName = currentUser.getId() +
	 * "Transcript (" + counter + ").txt"; file = new File(fileName); counter++; }
	 * 
	 * // Option is only accessible by a student. Student student = (Student)
	 * currentUser; FileWriter writer = new FileWriter(file);
	 * writeStudentTranscript(file, writer, student); writer.close(); //
	 * file.setReadOnly();
	 * 
	 * } catch (IOException e) { System.out.println("Error occurred");
	 * 
	 * } }
	 */

	// ------------------------------------------------------ GETTING STUFF FROM THE
	// SYSTEM ------------------------------------------------------

	public User getCurrentUser() {
		return currentUser;
	}

	public ArrayList<User> getUserList() {
		return new ArrayList<User>(users.values());
	}

	public ArrayList<Course> getAllCourses() {
		return new ArrayList<Course>(courses.values());
	}


	public Course getCourse(String in) {
		return courses.get(in);
	}

	public User getUser(String in) {
		return users.get(in);
	}

	public ArrayList<Admin> getAdminList() {
		ArrayList<User> userList = new ArrayList<User>(users.values());
		ArrayList<Admin> admins = new ArrayList<Admin>();

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i) instanceof Admin) {
				admins.add((Admin) userList.get(i));
			}
		}
		return admins;
	}

	public ArrayList<Advisor> getAdvisorList() {
		ArrayList<User> userList = new ArrayList<User>(users.values());
		ArrayList<Advisor> advisors = new ArrayList<Advisor>();

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i) instanceof Professor) {
				advisors.add((Advisor) userList.get(i));

			}
		}
		return advisors;
	}

	public ArrayList<Student> getStudentList() {
		ArrayList<User> userList = new ArrayList<User>(users.values());
		ArrayList<Student> students = new ArrayList<Student>();

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i) instanceof Student) {
				students.add((Student) userList.get(i));
			}
		}
		return students;
	}

	 
	/*
	 * //change to student course planner public void writeStudentTranscript(File
	 * file, FileWriter writer, Student student) throws IOException {
	 * writer.write("Student Name: " + student.getFirstName() + " " +
	 * student.getLastName()); writer.write("\n\nID: " + student.getId());
	 * writer.write("\n\nGPA: " + student.getGPA());
	 * 
	 * writer.write("\n\n=======| CURRENT COURSES |=========="); TreeMap<Course,
	 * Character> curCourses = student.getCurCourses(); for (Map.Entry<Course,
	 * Character> set : curCourses.entrySet()) { writer.write("\n" +
	 * String.format("%-14s", set.getKey().getName()) + "\t\t" + set.getValue()); }
	 * 
	 * writer.write("\n\n=======|  PAST COURSES  |=========="); TreeMap<String,
	 * Character> pastCourses = student.getPastCourses(); for (Map.Entry<String,
	 * Character> set : pastCourses.entrySet()) { writer.write("\n" +
	 * String.format("%-14s", set.getKey()) + "\t\t" + set.getValue()); } }
	 * 
	 */
	// ------------------------------------------------------ MAKE/LOAD FILE
	// INTO SYSTEM ------------------------------------------------------

	public String generateTxtSaveFile() {
		try {
			String fileName = "gradeSystemSaveFile.txt";
			File file = new File(fileName);

			// File generation and naming process
			int counter = 1;
			while (!file.createNewFile()) { // If a file is already generated, then it makes another one.
				fileName = "gradeSystemSaveFile (" + counter + ").txt";
				file = new File(fileName);
				counter++;
			}

			FileWriter writer = new FileWriter(file);
			writeUsers(writer);
			writeActiveCourses(writer);
			writePastCourses(writer);

			writer.write("EndFile");
			writer.close();

			return fileName;
		} catch (IOException e) {
			System.out.println("Error during Txt file generation.");

		}

		return null;
	}

	private void writeUsers(FileWriter writer) {
		// Writing in the base User information
		try {
			ArrayList<User> users = getUserList();

			writer.write("StartUsers\n");
			for (int i = 0; i < users.size(); i++) {
				User curUser = users.get(i);

				// Write the role of the User
				if (curUser instanceof Admin) {
					writer.write("Admin,");
				} else if (curUser instanceof Professor) {
					writer.write("Professor,");
				} else if (curUser instanceof Student) {
					writer.write("Student,");
				}
				// Write the generic information of each User
				writer.write(curUser.getFirstName() + "," + curUser.getLastName() + "," + curUser.getId() + ","
						+ curUser.getPassword() + "\n");
			}
			writer.write("EndUsers\n");
		} catch (IOException e) {
			System.out.println("Error during Txt file generation: User");

		}
	}

	/*
	 * private void writeActiveCourses(FileWriter writer) { try { // Writing ALL of
	 * Courses information, including students, professors, // assignments.
	 * ArrayList<Course> allCourses = getAllCourses(); for (int i = 0; i <
	 * allCourses.size(); i++) { Course course = allCourses.get(i);
	 * 
	 * if (course.getProfessor() != null) { writer.write("StartCourse\n" +
	 * course.getName() + "," + course.getProfessor().getId() + "\n"); // Course //
	 * Name // and // Professor // ID } else { writer.write("StartCourse\n" +
	 * course.getName() + ",null\n"); }
	 * 
	 * ArrayList<Student> students = course.getStudents(); // Get students of that
	 * course
	 * 
	 * for (int j = 0; j < students.size(); j++) { Student student =
	 * students.get(j); writer.write("StartCourseStudent\n");
	 * writer.write(student.getId() + "\n"); // For each student, put their ID
	 * first. ArrayList<Assignment> assignments =
	 * course.getStudentAssignments(student);
	 * 
	 * // For each assignment, write Assignment name, ptsEarned, ptsTotal for (int k
	 * = 0; k < assignments.size(); k++) { Assignment asgn = assignments.get(k);
	 * writer.write( asgn.getName() + "," + asgn.getPointsEarned() + "," +
	 * asgn.getPointsTotal() + "\n"); } writer.write("EndCourseStudent\n"); }
	 * writer.write("EndCourse\n"); } writer.write("EndCourseAdditions\n"); } catch
	 * (IOException e) {
	 * System.out.println("Error during Txt file generation: Courses");
	 * 
	 * } }
	 */

	private void writePastCourses(FileWriter writer) {
		try {
			// Writing info for each Student's past Courses
			ArrayList<Student> students = getStudentList();
			for (int i = 0; i < students.size(); i++) {
				writer.write("StartPastCourseStudent\n");
				Student student = students.get(i);
				TreeMap<String, Character> pastCourses = student.getPastCourses();
				writer.write(student.getId() + "\n");
				for (Map.Entry<String, Character> set : pastCourses.entrySet()) {
					writer.write(set.getKey() + "," + set.getValue() + "\n");
				}

				writer.write("EndPastCourseStudent\n");
			}
		} catch (IOException e) {
			System.out.println("Error during Txt file generation: Courses");

		}
	}

	

	
}