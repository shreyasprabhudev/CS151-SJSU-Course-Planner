package plannerWeb;

import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.lang.model.util.ElementScanner14;
import javax.swing.*;

public class Planner implements ActionListener {

	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton button;
	private static JLabel success;
	private static JLabel pageTitle;

	public static void main(String[] args) {

		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setTitle("SJSU COURSE PLANNER");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1400, 800);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.add(panel);

		panel.setLayout(null);

		pageTitle = new JLabel("Welcome to SJSU Course Planner");
		pageTitle.setBounds(frame.getHeight() / 2 - 75, 150, 800, 40);
		pageTitle.setFont(new Font("Arial", Font.PLAIN, 35));
		pageTitle.setHorizontalAlignment(JLabel.CENTER);
		panel.add(pageTitle);

		userLabel = new JLabel("SJSU ID Number");
		userLabel.setBounds(frame.getWidth() / 2 - 150, frame.getHeight() / 2 - 100, 300, 40);
		userLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		userLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(frame.getWidth() / 2 - 150, frame.getHeight() / 2 - 25, 300, 40);
		userText.setFont(new Font("Arial", Font.PLAIN, 25));
		userText.setHorizontalAlignment(JTextField.CENTER);
		panel.add(userText);

		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(frame.getWidth() / 2 - 150, frame.getHeight() / 2 + 50, 300, 40);
		passwordLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		passwordLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(passwordLabel);

		passwordText = new JPasswordField();
		passwordText.setBounds(frame.getWidth() / 2 - 150, frame.getHeight() / 2 + 125, 300, 40);
		passwordText.setFont(new Font("Arial", Font.PLAIN, 25));
		passwordText.setHorizontalAlignment(JTextField.CENTER);
		panel.add(passwordText);

		button = new JButton("Login");
		button.setBounds(frame.getWidth() / 2 - 100, frame.getHeight() / 2 + 200, 200, 40);
		button.setFont(new Font("Arial", Font.PLAIN, 25));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = userText.getText();
				String password = passwordText.getText();
				System.out.println(user + ", " + password);

				frame.setVisible(false);
				frame.dispose();

				createScreen(user, password);
			}
		});
		panel.add(button);

		success = new JLabel("");
		success.setBounds(frame.getWidth() / 2 - 150, frame.getHeight() / 2 + 275, 300, 40);
		success.setFont(new Font("Arial", Font.PLAIN, 25));
		success.setHorizontalAlignment(JLabel.CENTER);
		panel.add(success);

		frame.setVisible(true);

	}

	public static String userValidation(String user, String password) {
		if (user.equals("000000000")) {
			return "Admin";
		} else if (user.length() == 9 && user.substring(0, 7).equals("0000000")) {
			return "Professor";
		} else if (user.length() == 9 && user.substring(0, 5).equals("00000")) {
			return "Advisor";
		} else {
			return "Student";
		}
	}

	private static void createScreen(String user, String password) {
		if (userValidation(user, password).equals("Student"))
			createStudentFrame();
		else if (userValidation(user, password).equals("Advisor"))
			createAdvisorFrame();
	}

	private static void createStudentFrame() {
		JFrame frame = new JFrame();
		frame.setSize(1400, 800);
		frame.setTitle("Welcome Student!");
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);

		String data[][] = { { "CS 146", "Data Structures and Algorithms", "3" },
				{ "CS 147", "Computer Architecture", "3" }, { "CS 149", "Operating Systems", "3" },
				{ "CS 151", "Object-Oriented Design", "3" }, { "CS 152", "Programming Paradigms", "3" },
				{ "CS 154", "Formal Languages and Computability", "3" },
				{ "CS 157A", "Introduction to Database Management Systems", "3" },
				{ "CS 160", "Software Engineering", "3" }, { "CS 166", "Information Security", "3" } };
		String column[] = { "Course ID", "Course Name", "Units" };

		JTable studentTable = new JTable(data, column);
		studentTable.setBounds(500, 500, 500, 500);
		studentTable.getTableHeader().setReorderingAllowed(false);
		studentTable.getTableHeader().setResizingAllowed(false);
		JScrollPane sp = new JScrollPane(studentTable);
		frame.add(sp);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		// Code for second page

		JFrame secondFrame = new JFrame();
		secondFrame.setSize(1400, 800);
		secondFrame.setTitle("Majors");
		secondFrame.setResizable(false);
		secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		JMenu majorMenu = new JMenu("Majors");

		JMenuItem compSci = new JMenuItem("Computer Science");
		JMenuItem elecEng = new JMenuItem("Electrical Engineering");
		JMenuItem aeroEng = new JMenuItem("Aerospace Engineering");
		JMenuItem softEng = new JMenuItem("Software Engineering");
		JMenuItem bioEng = new JMenuItem("Biomedical Engineering");
		JMenuItem chemEng = new JMenuItem("Chemcial Engineering");
		JMenuItem compEng = new JMenuItem("Computer Engineering");
		JMenuItem mechEng = new JMenuItem("Mechanical Engineering");
		JMenuItem intEng = new JMenuItem("Interdisciplinary Engineering");
		JMenuItem indEng = new JMenuItem("Industrial Engineering");
		JMenuItem civilEng = new JMenuItem("Civil Engineering");
		JMenuItem math = new JMenuItem("Mathematics");
		JMenuItem physics = new JMenuItem("Physics");
		JMenuItem bio = new JMenuItem("Biology");
		JMenuItem art = new JMenuItem("Art");
		JMenuItem soc = new JMenuItem("Sociology");
		JMenuItem pubHealth = new JMenuItem("Public Health");
		JMenuItem chem = new JMenuItem("Chemistry");

		majorMenu.add(compSci);
		majorMenu.add(elecEng);
		majorMenu.add(aeroEng);
		majorMenu.add(softEng);
		majorMenu.add(bioEng);
		majorMenu.add(chemEng);
		majorMenu.add(compEng);
		majorMenu.add(mechEng);
		majorMenu.add(intEng);
		majorMenu.add(indEng);
		majorMenu.add(civilEng);
		majorMenu.add(math);
		majorMenu.add(physics);
		majorMenu.add(bio);
		majorMenu.add(art);
		majorMenu.add(soc);
		majorMenu.add(pubHealth);

		menuBar.add(majorMenu);
		secondFrame.setJMenuBar(menuBar);
		secondFrame.setVisible(true);

		// Code for third Frame
		JFrame frame3 = new JFrame();

	}

	private static void createAdvisorFrame() {
		JFrame frame = new JFrame();
		JPanel advisorPanel = new JPanel();
		frame.setSize(1400, 800);
		frame.setTitle("Welcome Advisor!");
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.add(advisorPanel);
		advisorPanel.setLayout(null);

		JLabel searchStudentID = new JLabel("Enter Student ID Number");
		searchStudentID.setBounds(frame.getWidth() / 2 - 150, frame.getHeight() / 2 - 100, 300, 40);
		searchStudentID.setFont(new Font("Arial", Font.PLAIN, 25));
		searchStudentID.setHorizontalAlignment(JLabel.CENTER);
		advisorPanel.add(searchStudentID);

		JTextField searchStudentIDText = new JTextField(20);
		searchStudentIDText.setBounds(frame.getWidth() / 2 - 150, frame.getHeight() / 2 - 25, 300, 40);
		searchStudentIDText.setFont(new Font("Arial", Font.PLAIN, 25));
		searchStudentIDText.setHorizontalAlignment(JTextField.CENTER);
		advisorPanel.add(searchStudentIDText);

		JButton viewPlannerButton = new JButton("View Planner");
		viewPlannerButton.setBounds(frame.getWidth() / 2 - 100, frame.getHeight() / 2 + 50, 200, 40);
		viewPlannerButton.setFont(new Font("Arial", Font.PLAIN, 25));

		viewPlannerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
				createStudentFrame();
			}
		});
		advisorPanel.add(viewPlannerButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
	}

}