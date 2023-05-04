package plannerWeb;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import javax.swing.JTextField;

import courseplanner.Student;
import courseplanner.User;
import plannerWeb.*;

public class StudentPage extends JFrame implements ActionListener {
	List<Student> studentList = new ArrayList<>();
	JComboBox<String> majorBox;
	JComboBox<String> stuOptBox;
	JLabel major;
	JLabel studentWelcomeLabel;
	JButton majorConfirmBtn;
	JButton stuOptConfirmBtn;

	JButton stuLogoutBtn;

	JButton logoutButton;

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
	String username;

	public StudentPage() {

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

		stuLogoutBtn = new JButton("Logout");
		stuLogoutBtn.addActionListener(this);
		stuLogoutBtn.setBounds(210, 450, 90, 25);
		this.add(stuLogoutBtn);

		// new added section for log out
		logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				Planner.homepage();
			}
		});
		logoutButton.setBounds(1200, 20, 150, 30);
		add(logoutButton);

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

			if ((String) stuOptBox.getSelectedItem() == "Add Course") {
				addCourse();
			} else if ((String) stuOptBox.getSelectedItem() == "Remove Course") {
				removeCourse();
			} else if ((String) stuOptBox.getSelectedItem() == "View Assigned Advisor") {
				assignAdvisors();
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
			e.getMessage();
		}
	}

	private void addCourse() {
		JFrame addFrame = new JFrame("Add Course");
		addFrame.setSize(400, 300);
		addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addFrame.setLayout(null);
		addFrame.setLocationRelativeTo(null);

		JLabel courseNumberLabel = new JLabel("Course Num:");
		courseNumberLabel.setBounds(50, 50, 100, 25);
		addFrame.add(courseNumberLabel);

		JTextField courseNumberField = new JTextField();
		courseNumberField.setBounds(150, 50, 200, 25);
		addFrame.add(courseNumberField);

		JLabel courseUnitsLabel = new JLabel("Course Units:");
		courseUnitsLabel.setBounds(50, 80, 100, 25);
		addFrame.add(courseUnitsLabel);

		JTextField courseUnitsField = new JTextField();
		courseUnitsField.setBounds(150, 80, 200, 25);
		addFrame.add(courseUnitsField);

		JLabel courseNameLabel = new JLabel("Course Name:");
		courseNameLabel.setBounds(50, 110, 100, 25);
		addFrame.add(courseNameLabel);

		JTextField courseNameField = new JTextField();
		courseNameField.setBounds(150, 110, 200, 25);
		addFrame.add(courseNameField);

		JLabel professorLabel = new JLabel("Professor:");
		professorLabel.setBounds(50, 140, 100, 25);
		addFrame.add(professorLabel);

		JTextField professorField = new JTextField();
		professorField.setBounds(150, 140, 200, 25);
		addFrame.add(professorField);

		JButton addButton = new JButton("Add Course");
		addButton.setBounds(150, 200, 100, 25);
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String courseNumber = courseNumberField.getText();
				String courseUnits = courseUnitsField.getText();
				String courseName = courseNameField.getText();
				String professor = professorField.getText();

				addFrame.dispose();
			}
		});
		addFrame.add(addButton);

		addFrame.setVisible(true);
	}

	private void removeCourse() {
        JFrame removeCourseFrame = new JFrame("Remove Course");
        removeCourseFrame.setSize(400, 300);
        removeCourseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        removeCourseFrame.setLayout(null);
        removeCourseFrame.setLocationRelativeTo(null);

        JLabel courseNumberLabel = new JLabel("Course Num:");
        courseNumberLabel.setBounds(50, 50, 100, 25);
        removeCourseFrame.add(courseNumberLabel);

        JTextField courseNumberField = new JTextField();
        courseNumberField.setBounds(150, 50, 200, 25);
        removeCourseFrame.add(courseNumberField);

        JLabel courseUnitsLabel = new JLabel("Course Units:");
        courseUnitsLabel.setBounds(50, 80, 100, 25);
        removeCourseFrame.add(courseUnitsLabel);

        JTextField courseUnitsField = new JTextField();
        courseUnitsField.setBounds(150, 80, 200, 25);
        removeCourseFrame.add(courseUnitsField);

        JLabel courseNameLabel = new JLabel("Course Name:");
        courseNameLabel.setBounds(50, 110, 100, 25);
        removeCourseFrame.add(courseNameLabel);

        JTextField courseNameField = new JTextField();
        courseNameField.setBounds(150, 110, 200, 25);
        removeCourseFrame.add(courseNameField);

        JButton addButton = new JButton("Remove");
        addButton.setBounds(150, 200, 100, 25);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseNumber = courseNumberField.getText();
                String courseUnits = courseUnitsField.getText();
                String courseName = courseNameField.getText();
                removeCourseFrame.dispose();
            }
        });
        removeCourseFrame.add(addButton);

        removeCourseFrame.setVisible(true);
    }
	
	private void assignAdvisors() {
	    // Read in list of users from file
		  String lastName = JOptionPane.showInputDialog("Enter the first letter of the student's last name:");
	        if (lastName != null && lastName.length() > 0) {
	            char firstLetter = Character.toUpperCase(lastName.charAt(0));
	            String advisorA = "Advisor A";
	            String advisorB = "Advisor B"
;	            if (advisorA != null && firstLetter >= 'A' && firstLetter <= 'M') {
	                JOptionPane.showMessageDialog(null, advisorA, "Student Advisor", JOptionPane.INFORMATION_MESSAGE);
	            }else if(advisorB != null && firstLetter >= 'A' && firstLetter <= 'M') {
	                JOptionPane.showMessageDialog(null, advisorB, "Student Advisor", JOptionPane.INFORMATION_MESSAGE);

	            }
	        }
	    }
public static void main(String[] args) {
	new StudentPage();
}
	
}


