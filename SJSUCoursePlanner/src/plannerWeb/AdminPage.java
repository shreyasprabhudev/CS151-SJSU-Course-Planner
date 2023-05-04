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

	public AdminPage() {

		this.setSize(1400, 800);
		this.setLayout(null);
		this.setTitle("Majors");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String[] adminOptions = { "Add User", "Remove User", "Add Course", "Remove Course", "View Courses" };

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
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				Planner.homepage();
			}
		});
		this.add(adminLogoutBtn);

		adminWelcomeLabel = new JLabel("Welcome Admin!");
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
				selectStudent();

			} else if (((String) adminOptionsBox.getSelectedItem()).equals("Remove Course")) {


			} else if (((String) adminOptionsBox.getSelectedItem()).equals("View Courses")) {
				// create a new frame to display the courses
				JFrame courseFrame = new JFrame("All Courses");
				courseFrame.setSize(800, 600);

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

				// add the text area to a scroll pane
				JScrollPane scrollPane = new JScrollPane(courseTextArea);
				scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

				// add the scroll pane to the frame and display it
				courseFrame.add(scrollPane);
				courseFrame.setVisible(true);
			}

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

			Planner.writeFile(username, password, firstName, lastName, "admin_generated");

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

	public static void selectStudent(){
		JFrame addFrame = new JFrame("Select Student");
		addFrame.setSize(400, 300);
		addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addFrame.setLayout(null);
		addFrame.setLocationRelativeTo(null);

		JLabel usernameLabel = new JLabel("Enter student username:");
		usernameLabel.setBounds(125, 90, 200, 25);
		addFrame.add(usernameLabel);

		JTextField usernameField = new JTextField();
		usernameField.setBounds(100, 150, 200, 25);
		addFrame.add(usernameField);

		JButton addButton = new JButton("Select Student");
		addButton.setBounds(150, 200, 100, 25);
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String currentUsername = usernameField.getText();
				addFrame.dispose();
				StudentPage.addCourse(currentUsername);
			}
		});
		addFrame.add(addButton);

		addFrame.setVisible(true);

	}

	public static void main(String[] args) {
		new AdminPage();
	}

}
