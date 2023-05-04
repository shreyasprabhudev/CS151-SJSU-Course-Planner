package plannerWeb;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ModuleLayer.Controller;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AdminPage extends JFrame implements ActionListener {

	JComboBox<String> adminOptionsBox;
	JButton adminOptionConfirmBtn;
	JButton adminLogoutBtn;
	JLabel adminWelcomeLabel;
	UserInterface frame;

	public AdminPage(UserInterface in) {
		frame = in;
		this.setSize(1400, 800);
		this.setLayout(null);
		this.setTitle("Majors");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

<<<<<<< HEAD
<<<<<<< HEAD
		String[] adminOptions = { "Add User", "Remove User", "Add Course", "Remove Course", "Add Required Information",
				"View Course Planner" };
=======
		String[] adminOptions = { "Add User", "Remove User", "Add Course", "Remove Course", "View Courses" };
>>>>>>> a9f4ebab79e5abfaf833844ad77174cf7586829f
=======
		String[] adminOptions = { "Add User", "Remove User", "Add Course", "Remove Course", "View Courses" };
>>>>>>> jisoo-branch

		adminOptionsBox = new JComboBox<String>(adminOptions);
		adminOptionsBox.setBounds(100, 220, 200, 25);
		this.add(adminOptionsBox);

		adminOptionConfirmBtn = new JButton("Confirm");
		adminOptionConfirmBtn.addActionListener(this);
		adminOptionConfirmBtn.setBounds(210, 350, 90, 25);
		this.add(adminOptionConfirmBtn);

		adminLogoutBtn = new JButton("Logout");
		adminLogoutBtn.addActionListener(this);
		adminLogoutBtn.setBounds(100, 350, 90, 25);
		adminLogoutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				Planner.selectUserTypeScreen();
			}
		});
		this.add(adminLogoutBtn);

<<<<<<< HEAD
<<<<<<< HEAD
		adminWelcomeLabel = new JLabel("Welcome Admin");
=======
		adminWelcomeLabel = new JLabel("Welcome Admin!");
>>>>>>> a9f4ebab79e5abfaf833844ad77174cf7586829f
=======
		adminWelcomeLabel = new JLabel("Welcome Admin!");
>>>>>>> jisoo-branch
		adminWelcomeLabel.setHorizontalAlignment(JLabel.CENTER);
		adminWelcomeLabel.setFont(new Font("Serif", Font.BOLD, 50));
		adminWelcomeLabel.setBounds(90, 80, 400, 80);
		this.add(adminWelcomeLabel);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == adminOptionConfirmBtn) {
			if (((String) adminOptionsBox.getSelectedItem()).equals("Add User")) {
				addUser();

			} else if (((String) adminOptionsBox.getSelectedItem()).equals("Remove User")) {
				deleteUser();

			} else if (((String) adminOptionsBox.getSelectedItem()).equals("Add Course")) {
				addCourse();

			} else if (((String) adminOptionsBox.getSelectedItem()).equals("Remove Course")) {

<<<<<<< HEAD
<<<<<<< HEAD
			} else if (((String) adminOptionsBox.getSelectedItem()).equals("Add Required Information")) {
=======
=======
>>>>>>> jisoo-branch
			} else if (((String) adminOptionsBox.getSelectedItem()).equals("View Courses")) {
				// create a new frame to display the courses
				JFrame courseFrame = new JFrame("All Courses");
				courseFrame.setSize(800, 600);
<<<<<<< HEAD

				// create a text area to display the courses
				JTextArea courseTextArea = new JTextArea();
				courseTextArea.setEditable(false);
>>>>>>> a9f4ebab79e5abfaf833844ad77174cf7586829f

				// read the course data from a file and display it in the text area
				try {
					File courseFile = new File("EntireCoursesAdmin.txt");
					Scanner scanner = new Scanner(courseFile);
					while (scanner.hasNextLine()) {
						String line = scanner.nextLine();
						courseTextArea.append(line + "\n");
					}
					scanner.close();
				} catch (FileNotFoundException ex) {
					courseTextArea.setText("Course data not found.");
				}

=======

				// create a text area to display the courses
				JTextArea courseTextArea = new JTextArea();
				courseTextArea.setEditable(false);

				// read the course data from a file and display it in the text area
				try {
					File courseFile = new File("EntireCoursesAdmin.txt");
					Scanner scanner = new Scanner(courseFile);
					while (scanner.hasNextLine()) {
						String line = scanner.nextLine();
						courseTextArea.append(line + "\n");
					}
					scanner.close();
				} catch (FileNotFoundException ex) {
					courseTextArea.setText("Course data not found.");
				}

>>>>>>> jisoo-branch
				// add the text area to a scroll pane
				JScrollPane scrollPane = new JScrollPane(courseTextArea);
				scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

				// add the scroll pane to the frame and display it
				courseFrame.add(scrollPane);
				courseFrame.setVisible(true);
			}

<<<<<<< HEAD
<<<<<<< HEAD
		}
		if (e.getSource() == adminLogoutBtn) {
			this.setVisible(false);
			this.dispose();
			Planner.selectUserTypeScreen();
		}
	}

=======
=======
>>>>>>> jisoo-branch
		} else

		{

		}
	}

	public void addUser() {
		JTextField usernameField = new JTextField();
		JTextField passwordField = new JTextField();
		JTextField firstNameField = new JTextField();
		JTextField lastNameField = new JTextField();

		Object[] message = { "Username:", usernameField, "Password:", passwordField, "First Name:", firstNameField,
				"Last Name:", lastNameField };

		int option = JOptionPane.showConfirmDialog(null, message, "Add User", JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {
			String username = usernameField.getText();
			String password = passwordField.getText();
			String firstName = firstNameField.getText();
			String lastName = lastNameField.getText();

		}
	}

	public void deleteUser() {
		JTextField usernameField = new JTextField();

		Object[] message = { "Username:", usernameField };

		int option = JOptionPane.showConfirmDialog(null, message, "Delete User", JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {
			String username = usernameField.getText();

		}
	}

	private void addCourse() {
		JFrame addCourseFrame = new JFrame("Add Course");
		addCourseFrame.setSize(400, 300);
		addCourseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addCourseFrame.setLayout(null);
		addCourseFrame.setLocationRelativeTo(null);

		JLabel courseNumberLabel = new JLabel("Course Num:");
		courseNumberLabel.setBounds(50, 50, 100, 25);
		addCourseFrame.add(courseNumberLabel);

		JTextField courseNumberField = new JTextField();
		courseNumberField.setBounds(150, 50, 200, 25);
		addCourseFrame.add(courseNumberField);

		JLabel courseUnitsLabel = new JLabel("Course Units:");
		courseUnitsLabel.setBounds(50, 80, 100, 25);
		addCourseFrame.add(courseUnitsLabel);

		JTextField courseUnitsField = new JTextField();
		courseUnitsField.setBounds(150, 80, 200, 25);
		addCourseFrame.add(courseUnitsField);

		JLabel courseNameLabel = new JLabel("Course Name:");
		courseNameLabel.setBounds(50, 110, 100, 25);
		addCourseFrame.add(courseNameLabel);

		JTextField courseNameField = new JTextField();
		courseNameField.setBounds(150, 110, 200, 25);
		addCourseFrame.add(courseNameField);

		JLabel professorLabel = new JLabel("Professor:");
		professorLabel.setBounds(50, 140, 100, 25);
		addCourseFrame.add(professorLabel);

		JTextField professorField = new JTextField();
		professorField.setBounds(150, 140, 200, 25);
		addCourseFrame.add(professorField);

		JButton addButton = new JButton("Add Course");
		addButton.setBounds(150, 200, 100, 25);
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String courseNumber = courseNumberField.getText();
				String courseUnits = courseUnitsField.getText();
				String courseName = courseNameField.getText();
				String professor = professorField.getText();

				addCourseFrame.dispose();
			}
		});
		addCourseFrame.add(addButton);

		addCourseFrame.setVisible(true);
	}

	public static void main(String[] args) {
		new AdminPage();
	}

>>>>>>> a9f4ebab79e5abfaf833844ad77174cf7586829f
}
