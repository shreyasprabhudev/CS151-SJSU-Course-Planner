package plannerWeb;

import java.awt.Container;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPasswordField;

import courseplanner.*;

public class UserInterface {
	Controller control;

	/*
	 * The guy that the user actually sees. Good idea to use Java swing for this.
	 * 
	 * The order of how commands work goes as follows: User requests something
	 * through UserInterface. This may call a command from Controller. Controller
	 * may call a command from GradeSystem. GradeSystem takes action.
	 * 
	 * In order to determine what can be shown to the user and what cannot, it will
	 * need to know what instance the current user is. Thankfully, since only one
	 * user can be logged in at any moment, this class only needs to request to see
	 * which one it is without any arguments.
	 * 
	 * =============================================================================
	 * ================================================= IMPORTANT:
	 * 
	 * The biggest catch is that the only way this class can specify an object for
	 * GradeSystem is through Strings. This is because the goal is to only have a
	 * Controller variable in this class. This is why GradeSystem utilizes TreeMaps,
	 * with a String associated with the actual object.
	 * =============================================================================
	 * =================================================
	 * 
	 * Information about the scrollable! - To make something scrollable, use
	 * JScrollPane.
	 * 
	 * - JScrollPane will automatically make something have scroll bars as need, but
	 * ONLY IF the "preferred size" of the panel, container, etc. is smaller than
	 * what is shown. This means you will need to use (container
	 * name).setPreferredSize(Dimension)
	 * 
	 * - Also, in the case a page is made to be scrollable, you only need to add the
	 * JScrollPane into the Frame.
	 */

	public static final JFrame frame = new JFrame();
	public static final Container contentPane = frame.getContentPane();

	// ------------------------------------------------------------------------------------------------------------------------------------------------------

	AdminPage adminPage;
	AdminAddUser adminAddUser;
	AdminRemoveUser adminRemoveUser;
	AdminAddCourse adminAddCourse;
	AdminRemoveCourse adminRemoveCourse;
	/*
	 * AdminViewUser adminViewUsers; AddStudentToCourse addStudentToCourse;
	 * RemoveStudentFromCourse removeStudentFromCourse;
	 */
	// Admin - View all Users in the system


	// ------------------------------------------------------------------------------------------------------------------------------------------------------

	// Student - Pick an option page
	StudentPage studentPage;
	StudentAddCourse studentAddCourse;
	StudentRemoveCourse studentRemoveCourse;
	
	//AdminLoadFile adminLoadFile;
	
	//Advisor - Pick an option page
	AdvisorPage advisorPage;
	

	public UserInterface(Controller control) {
		this.control = control;
		frame.setSize(400, 275);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Gradebook");
		frame.setResizable(false);
		loginPage = new LoginPage(this);
		contentPane.add(loginPage);
		contentPane.validate();
		frame.setVisible(true);
		frame.pack();

		// Setup "Home" menu for Users
		adminPage = new AdminPage();
		studentPage = new StudentPage();

		// Setup Admin specific GUI
		adminAddUser = new AdminAddUser(this);
		adminRemoveUser = new AdminRemoveUser(this);
		adminAddCourse = new AdminAddCourse(this);
		adminRemoveCourse = new AdminRemoveCourse(this);
		//adminViewUsers = new AdminViewUser(this);
		
		
		// Setup Student specific GUI
		studentAddCourse = new StudentAddCourse(this);
		studentRemoveCourse = new StudentRemoveCourse(this);
		
	}

	public void pageTransition(JFrame after) {
		contentPane.removeAll();
		contentPane.add(after);
		contentPane.repaint();
		contentPane.revalidate();

		frame.setSize(1400, 800);

		frame.pack();
	}

	public static String getPwd(JPasswordField field) {
		char[] pwd = field.getPassword();
		String completePwd = "";

		for (int i = 0; i < pwd.length; i++) {
			completePwd += pwd[i];
		}

		pwd = null;

		return completePwd;

	}

}
