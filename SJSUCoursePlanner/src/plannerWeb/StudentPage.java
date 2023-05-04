package plannerWeb;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import plannerWeb.*;

public class StudentPage extends JFrame implements ActionListener {
	JComboBox<String> majorBox;
	JComboBox<String> stuOptBox;
	JLabel major;
	JLabel studentWelcomeLabel;
	JButton majorConfirmBtn;
	JButton stuOptConfirmBtn;
<<<<<<< HEAD
	JButton stuLogoutBtn;
	UserInterface frame;
=======
	JButton logoutButton;
>>>>>>> a9f4ebab79e5abfaf833844ad77174cf7586829f

	JMenuItem compSci;
	JMenuItem elecEng;
	JMenuItem aeroEng;
	JMenuItem softEng;
	JMenuItem bioEng;
	JMenuItem chemEng;
	JMenuItem compEng;
	JMenuItem mechEng;
	JMenuItem intEng;
	JMenuItem indEng;
	JMenuItem civilEng;
	JMenuItem math;
	JMenuItem physics;
	JMenuItem bio;
	JMenuItem art;
	JMenuItem soc;
	JMenuItem pubHealth;
	JMenuItem chem;

	public StudentPage(UserInterface in) {

		frame = in;
		this.setSize(1400, 800);
		this.setLayout(null);
		this.setTitle("Majors");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String[] majors = { "Computer Science", "Software Engineering", "Electrical Engineering",
				"Aerospace Engineering", "Biomedical Engineering", "Mechanical Engineering", "Industrial Engineering",
				"Civil Engineering", "Interdisciplinary Engineering", "Mathematics", "Physics", "Biology",
				"Chemistry" };

		String[] studentOpt = { "Add Course", "Remove Course", "View Assigned Advisor" };
		majorBox = new JComboBox<>(majors);
		majorBox.setBounds(100, 220, 200, 25);
		this.add(majorBox);

		majorConfirmBtn = new JButton("Confirm");
		majorConfirmBtn.addActionListener(this);
		majorConfirmBtn.setBounds(150, 280, 90, 25);
		this.add(majorConfirmBtn);

		studentWelcomeLabel = new JLabel("Welcome Student");
		studentWelcomeLabel.setHorizontalAlignment(JLabel.CENTER);
		studentWelcomeLabel.setFont(new Font("Serif", Font.BOLD, 50));
		studentWelcomeLabel.setBounds(90, 80, 400, 80);
		this.add(studentWelcomeLabel);

		major = new JLabel("Select Major");
		major.setBounds(100, 170, 220, 50);
		major.setFont(new Font("Serif", Font.PLAIN, 20));
		this.add(major);

		stuOptBox = new JComboBox<>(studentOpt);
		stuOptBox.setBounds(100, 400, 200, 25);
		this.add(stuOptBox);

		stuOptConfirmBtn = new JButton("Confirm");
		stuOptConfirmBtn.addActionListener(this);
		stuOptConfirmBtn.setBounds(100, 450, 90, 25);
		this.add(stuOptConfirmBtn);
<<<<<<< HEAD
		
		stuLogoutBtn = new JButton("Logout");
		stuLogoutBtn.addActionListener(this);
		stuLogoutBtn.setBounds(210, 450, 90, 25);
		this.add(stuLogoutBtn);
		
=======

		//new added section for log out 
		logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				Planner.selectUserTypeScreen();
			}
		});
		logoutButton.setBounds(1200, 20, 150, 30);
		add(logoutButton);

>>>>>>> a9f4ebab79e5abfaf833844ad77174cf7586829f
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == majorConfirmBtn) {
			if ((String) majorBox.getSelectedItem() == "Computer Science") {
				displayClasses("cs");

			} else if ((String) majorBox.getSelectedItem() == "Software Engineering") {
				displayClasses("swe");

			} else if ((String) majorBox.getSelectedItem() == "Electrical Engineering") {
				displayClasses("ee");

			} else if ((String) majorBox.getSelectedItem() == "Aerospace Engineering") {
				displayClasses("aeroe");

			} else if ((String) majorBox.getSelectedItem() == "Biomedical Engineering") {
				displayClasses("bme");

			} else if ((String) majorBox.getSelectedItem() == "Mechanical Engineering") {
				displayClasses("meche");

			} else if ((String) majorBox.getSelectedItem() == "Industrial Engineering") {
				displayClasses("industriale");

			} else if ((String) majorBox.getSelectedItem() == "Civil Engineering") {
				displayClasses("civile");

			} else if ((String) majorBox.getSelectedItem() == "Interdisciplinary Engineering") {
				displayClasses("interdisciplinarye");

			} else if ((String) majorBox.getSelectedItem() == "Mathematics") {
				displayClasses("math");

			} else if ((String) majorBox.getSelectedItem() == "Physics") {
				displayClasses("physics");

			} else if ((String) majorBox.getSelectedItem() == "Biology") {
				displayClasses("bio");

			} else if ((String) majorBox.getSelectedItem() == "Chemistry") {
				displayClasses("chem");

			}
		}
		if (e.getSource() == stuOptConfirmBtn) {
<<<<<<< HEAD
			if((String) stuOptBox.getSelectedItem() == "Add course") {
				frame.studentAddCourse = new StudentAddCourse(frame);
				frame.pageTransition(frame.studentAddCourse);
			}
			else if((String) stuOptBox.getSelectedItem() == "Remove course"){
				frame.studentRemoveCourse = new StudentRemoveCourse(frame);
				frame.pageTransition(frame.studentRemoveCourse);
			}
			else if((String) stuOptBox.getSelectedItem() == "View Assigned Advisor"){
			
=======
			if ((String) stuOptBox.getSelectedItem() == "Add course") {

			} else if ((String) stuOptBox.getSelectedItem() == "Remove course") {

			} else if ((String) stuOptBox.getSelectedItem() == "View Assigned Advisor") {

>>>>>>> a9f4ebab79e5abfaf833844ad77174cf7586829f
			}

		}

	}

	private void displayClasses(String major) {
		try {
			// Open the text file containing the classes
			FileReader fileReader = new FileReader(major + ".txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// Read each line of the file and add it to a list of classes
			List<String> classes = new ArrayList<>();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				classes.add(line);
			}

			// Close the file reader
			bufferedReader.close();

			// Display the list of classes in a Swing component
			JList<String> classList = new JList<>(classes.toArray(new String[0]));
			JScrollPane scrollPane = new JScrollPane(classList);
			JOptionPane.showMessageDialog(null, scrollPane, "Classes for " + major, JOptionPane.PLAIN_MESSAGE);
		} catch (IOException e) {
			// Handle the exception (e.g. display an error message)
		}
	}


}
