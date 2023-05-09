package plannerWeb;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ModuleLayer.Controller;
import java.util.Scanner;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AdminPage extends JFrame implements ActionListener {

	JComboBox<String> adminOptionsBox;
	JButton adminOptionConfirmBtn;
	JButton adminLogoutBtn;
	JLabel adminWelcomeLabel;

	public AdminPage(String username) {

		this.setSize(1400, 800);
		this.setLayout(null);
		this.setTitle("Majors");
		this.setResizable(false);
		this.getContentPane().setBackground(Color.GRAY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// create a new JLabel to hold the image
		JLabel imageLabel = new JLabel();

		// load the image from a file (replace "image.jpg" with the name of your image
		// file)
		ImageIcon imageIcon = new ImageIcon("SJSUCoursePlanner/homeicon/major.png");

		// set the icon of the JLabel to the loaded image
		imageLabel.setIcon(imageIcon);

		// set the size and position of the JLabel to center it in the JFrame
		imageLabel.setBounds(0, 580, 1400, 200);

		// add the JLabel to the JFrame
		this.add(imageLabel);

		String[] adminOptions = { "Add User", "Remove User", "Add Course", "Remove Course", "View Courses" };

		adminOptionsBox = new JComboBox<String>(adminOptions);
		adminOptionsBox.setBounds(620, 250, 200, 60);
		((JLabel)adminOptionsBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		adminOptionsBox.setFont(new Font("Arial", Font.PLAIN, 20));
		this.add(adminOptionsBox);

		adminOptionConfirmBtn = new JButton("Confirm");
		adminOptionConfirmBtn.addActionListener(this);
		adminOptionConfirmBtn.setBounds(650, 400, 150, 40);
		adminOptionConfirmBtn.setFont(new Font("Arial", Font.PLAIN, 20));
		this.add(adminOptionConfirmBtn);

		adminLogoutBtn = new JButton("Logout");
		adminLogoutBtn.addActionListener(this);
		adminLogoutBtn.setBounds(1225, 30, 150, 40);
		adminLogoutBtn.setFont(new Font("Arial", Font.PLAIN, 20));
		adminLogoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				Planner.homepage();
			}
		});
		this.add(adminLogoutBtn);

		// create a new JLabel to hold the image
		JLabel adminLogoutLabel = new JLabel();

		// load the image from a file (replace "image.jpg" with the name of your image
		// file)
		ImageIcon imageAdminLogoutIcon = new ImageIcon("SJSUCoursePlanner/homeicon/Admin.png");

		// set the icon of the JLabel to the loaded image
		adminLogoutLabel.setIcon(imageAdminLogoutIcon);

		// set the size and position of the JLabel to center it in the JFrame
		adminLogoutLabel.setBounds(1130, 310, 300, 280);

		// add the JLabel to the JFrame
		this.add(adminLogoutLabel);

		adminWelcomeLabel = new JLabel("Welcome Admin, " + username + "!");
		adminWelcomeLabel.setHorizontalAlignment(JLabel.CENTER);
		adminWelcomeLabel.setFont(new Font("Serif", Font.BOLD, 50));
		adminWelcomeLabel.setBounds(400, 80, 600, 80);
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
				removeCourseAdmin();

			} else if (((String) adminOptionsBox.getSelectedItem()).equals("View Courses")) {
				// create a new frame to display the courses
				JFrame courseFrame = new JFrame("All Courses");
				courseFrame.setSize(800, 600);

				// create a text area to display the courses
				JTextArea courseTextArea = new JTextArea();
				courseTextArea.setEditable(false);

				// read the course data from a file and display it in the text area
				try {
					File courseFile = new File("SJSUCoursePlanner/Majors/EntireCoursesAdmin.txt");
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

		} 
	}

	public static void removeCourseAdmin(){
		JFrame addFrame = new JFrame("Select Student");
		addFrame.setSize(300, 300);
		addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addFrame.setLayout(null);
		addFrame.setLocationRelativeTo(null);

		JLabel usernameLabel = new JLabel("Enter student username:");
		usernameLabel.setBounds(75, 90, 200, 25);
		addFrame.add(usernameLabel);

		JTextField usernameField = new JTextField();
		usernameField.setBounds(50, 150, 200, 25);
		addFrame.add(usernameField);

		JButton addButton = new JButton("Select Student");
		addButton.setBounds(75, 200, 150, 25);
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String currentUsername = usernameField.getText();
				addFrame.dispose();
				StudentPage.removeCourse(currentUsername);
			}
		});
		addFrame.add(addButton);

		addFrame.setVisible(true);

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
			Planner.createStudentFile(username);

			JOptionPane.showConfirmDialog(null, "User has been sucessfully added!", "Add User", JOptionPane.DEFAULT_OPTION);
		}

	}

	public void deleteUser() {
		JTextField usernameField = new JTextField();

		Object[] message = { "Username:", usernameField };

		int option = JOptionPane.showConfirmDialog(null, message, "Delete User", JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {
			String username = usernameField.getText();
			try{
				// PrintWriter object for output.txt
				PrintWriter pw = new PrintWriter("output.txt");
				File file = new File("userData.txt");
							  
				// BufferedReader object for input.txt
				BufferedReader br1 = new BufferedReader(new FileReader(file));
				  
				String line1 = br1.readLine();
				String deleted_line = "";
	
				try {
					Scanner myReader = new Scanner(file);
					while (myReader.hasNextLine()) {
						String data = myReader.nextLine();
						String[] partsOfLine = data.split(",");
						if(partsOfLine[0].equals(username))
							deleted_line = data;
					}
					myReader.close();
				} catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
	
				while(line1 != null){
					if(!line1.equals(deleted_line))
						pw.println(line1);
					
					line1 = br1.readLine(); 
				}
				
				pw.flush();
				  
				// closing resources
				br1.close();
				pw.close();
	
				file.delete();
				File newFile = new File("output.txt");
				newFile.renameTo(file);
				System.out.println("File operation performed successfully");
				JOptionPane.showConfirmDialog(null, "User has been sucessfully removed!", "Remove User", JOptionPane.DEFAULT_OPTION);
			}
			catch(IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}

		}
	}

	public static void selectStudent() {
		JFrame addFrame = new JFrame("Select Student");
		addFrame.setSize(300, 300);
		addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addFrame.setLayout(null);
		addFrame.setLocationRelativeTo(null);

		JLabel usernameLabel = new JLabel("Enter student username:");
		usernameLabel.setBounds(75, 90, 200, 25);
		addFrame.add(usernameLabel);

		JTextField usernameField = new JTextField();
		usernameField.setBounds(50, 150, 200, 25);
		addFrame.add(usernameField);

		JButton addButton = new JButton("Select Student");
		addButton.setBounds(75, 200, 150, 25);
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
		new AdminPage("SS-1427");
	}

}
