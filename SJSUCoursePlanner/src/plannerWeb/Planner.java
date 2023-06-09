package plannerWeb;

import java.awt.Color;

import javax.lang.model.util.ElementScanner14;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.awt.Font;
import java.awt.Image;

public class Planner {
	private static ArrayList<String> users = new ArrayList<>();
	private static JFrame frame;
	private static JPanel panel;
	private static String role;

	public static void main(String[] args) {
		homepage();
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
	}

	public static void homepage() {
		JLabel homePageTitle;
		JButton signUpButton;
		JButton logInButton;

		frame = new JFrame();
		panel = new JPanel();

		readFile();

		frame.setSize(1400, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setTitle("SJSU Course Planner");
		frame.add(panel);

		panel.setLayout(null);
		panel.setBackground(Color.GRAY);

		homePageTitle = new JLabel();
		homePageTitle.setText("<html><center>Welcome to SJSU Course Planner Information Center!</center></html>");
		homePageTitle.setBounds(0, 100, frame.getWidth(), 80);
		homePageTitle.setFont(new Font("Palatino", Font.BOLD, 50));
		homePageTitle.setVerticalAlignment(JLabel.CENTER);
		homePageTitle.setHorizontalAlignment(JLabel.CENTER);

		signUpButton = new JButton("Sign Up");
		int buttonWidth = 200;
		int buttonHeight = 50;
		int buttonX = (frame.getWidth() - buttonWidth) / 2 + 120; // adjusted buttonX value
		int buttonY = frame.getHeight() * 3 / 4 - buttonHeight / 2;
		signUpButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);

		ImageIcon imageIcon = new ImageIcon("SJSUCoursePlanner/homeicon/sjsu1.jpeg");
		Image image = imageIcon.getImage();

		// Create a new ImageIcon from the original image
		ImageIcon originalImageIcon = new ImageIcon(image);

		// Set the icon of the label to the original image
		JLabel imageLabel = new JLabel();
		imageLabel.setIcon(originalImageIcon);

		// Calculate the space between the home page title and the sign-up boundary
		int space = signUpButton.getY() - (homePageTitle.getY() + homePageTitle.getHeight());

		// Set the bounds of the label to center it in the remaining space
		int x = (frame.getWidth() - originalImageIcon.getIconWidth()) / 2;
		int y = homePageTitle.getY() + homePageTitle.getHeight() + space / 2 - originalImageIcon.getIconHeight() / 2;
		imageLabel.setBounds(x, y, originalImageIcon.getIconWidth(), originalImageIcon.getIconHeight());

		logInButton = new JButton("Log In");
		buttonX = buttonX - buttonWidth - 50;
		logInButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);

		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.updateUI();
				selectUserTypeScreen(false);
			}
		});

		// login button operations
		logInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.updateUI();
				selectUserTypeScreen(true);
			}
		});

		panel.add(homePageTitle);
		panel.setLayout(null);
		panel.add(imageLabel);
		panel.add(signUpButton);
		panel.add(logInButton);
		frame.setVisible(true);
	}

	public static void selectUserTypeScreen(boolean isLoggingIn) {
		JLabel pageTitle;
		JButton studentButton;
		JButton adminButton;
		JButton advisorButton;

		pageTitle = new JLabel();
		if (isLoggingIn)
			pageTitle.setText("Welcome Back!");
		else
			pageTitle.setText("Welcome to the SJSU Planner!");
		pageTitle.setBounds(0, 100, frame.getWidth(), 80);
		pageTitle.setFont(new Font("Palatino", Font.BOLD, 50));
		pageTitle.setVerticalAlignment(JLabel.CENTER);
		pageTitle.setHorizontalAlignment(JLabel.CENTER);

		studentButton = new JButton("I'm a student");
		int sbuttonWidth = 200;
		int sbuttonHeight = 50;
		int sbuttonX = (frame.getWidth() - sbuttonWidth) / 2; // adjusted buttonX value
		int sbuttonY = frame.getHeight() * 3 / 4 - sbuttonHeight / 2 - 200;
		studentButton.setBounds(sbuttonX, sbuttonY, sbuttonWidth, sbuttonHeight);
		studentButton.setFont(new Font("Arial", Font.PLAIN, 25));
		studentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.updateUI();
				role = "Student";
				if (isLoggingIn)
					welcomeScreen();
				else
					registerScreen();
			}
		});

		adminButton = new JButton("I'm an admin");
		int pbuttonWidth = 200;
		int pbuttonHeight = 50;
		int pbuttonX = (frame.getWidth() - pbuttonWidth) / 2; // adjusted buttonX value
		int pbuttonY = frame.getHeight() * 3 / 4 - pbuttonHeight / 2 - 100;
		adminButton.setBounds(pbuttonX, pbuttonY, pbuttonWidth, pbuttonHeight);
		adminButton.setFont(new Font("Arial", Font.PLAIN, 25));
		adminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.updateUI();
				role = "Admin";
				if (isLoggingIn)
					welcomeScreen();
				else
					registerScreen();
			}
		});

		advisorButton = new JButton("I'm an advisor");
		int abuttonWidth = 200;
		int abuttonHeight = 50;
		int abuttonX = (frame.getWidth() - abuttonWidth) / 2; // adjusted buttonX value
		int abuttonY = frame.getHeight() * 3 / 4 - abuttonHeight / 2;
		advisorButton.setBounds(abuttonX, abuttonY, abuttonWidth, abuttonHeight);
		advisorButton.setFont(new Font("Arial", Font.PLAIN, 25));
		advisorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.updateUI();
				role = "Advisor";
				if (isLoggingIn)
					welcomeScreen();
				else
					registerScreen();
			}
		});

		createBackButton("homepage", true);

		panel.add(pageTitle);
		panel.add(studentButton);
		panel.add(adminButton);
		panel.add(advisorButton);
		frame.setVisible(true);
	}

	public static void welcomeScreen() {
		JButton loginButton;
		JButton signUpButton;
		JLabel pageTitle;
		JLabel userLabel;
		JTextField userText;
		JLabel passwordLabel;
		JPasswordField passwordText;

		frame.setTitle(role + " Login Screen");

		pageTitle = new JLabel();
		pageTitle.setText(role + " Login Screen");
		pageTitle.setBounds(0, 100, frame.getWidth(), 80);
		pageTitle.setFont(new Font("Palatino", Font.BOLD, 50));
		pageTitle.setVerticalAlignment(JLabel.CENTER);
		pageTitle.setHorizontalAlignment(JLabel.CENTER);

		int buttonWidth = 200;
		int buttonHeight = 50;
		int buttonX = (frame.getWidth() - buttonWidth) / 2 + 120; // adjusted buttonX value
		int buttonY = frame.getHeight() * 3 / 4 - buttonHeight / 2;

		userLabel = new JLabel("Username");
		userLabel.setBounds(frame.getWidth() / 2 - 150, frame.getHeight() / 2 - 100, 300, 40);
		userLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		userLabel.setHorizontalAlignment(JLabel.CENTER);

		userText = new JTextField(20);
		userText.setBounds(frame.getWidth() / 2 - 150, frame.getHeight() / 2 - 25, 300, 40);
		userText.setFont(new Font("Arial", Font.PLAIN, 25));
		userText.setHorizontalAlignment(JTextField.CENTER);

		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(frame.getWidth() / 2 - 150, frame.getHeight() / 2 + 50, 300, 40);
		passwordLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		passwordLabel.setHorizontalAlignment(JLabel.CENTER);

		passwordText = new JPasswordField();
		passwordText.setBounds(frame.getWidth() / 2 - 150, frame.getHeight() / 2 + 125, 300, 40);
		passwordText.setFont(new Font("Arial", Font.PLAIN, 25));
		passwordText.setHorizontalAlignment(JTextField.CENTER);

		loginButton = new JButton("Login");
		buttonX = buttonX - buttonWidth + 80;
		loginButton.setBounds(buttonX, buttonY + 40, buttonWidth, buttonHeight);
		loginButton.setFont(new Font("Arial", Font.PLAIN, 25));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String username = userText.getText();
				String password = passwordText.getText();

				String output = checkUser(username, password);
				if (output.equals("Valid user")) {
					frame.removeAll();
					frame.dispose();

					String[] fields = getUser(username, password).split(" ");

					if (username.substring(0, 2).equals("SS"))
						new StudentPage(username, false, null);
					else if (username.substring(0, 2).equals("UA"))
						new AdminPage(username);
					else if (username.substring(0, 2).equals("SA"))
						new AdvisorPage(username);
				} else if (output.equals("User does not exist")) {
					JOptionPane.showMessageDialog(frame,
							new Exception("This is not a valid username! Please sign up first!"), "Error Logging In!",
							JOptionPane.ERROR_MESSAGE);
					panel.removeAll();
					panel.updateUI();
					welcomeScreen();
				} else if (output.equals("Wrong password")) {
					JOptionPane.showMessageDialog(frame, new PasswordException("Username and password do not match!"),
							"Password Error!", JOptionPane.ERROR_MESSAGE);
					panel.removeAll();
					panel.updateUI();
					welcomeScreen();
				}
			}
		});

		createBackButton("selectRole", true);

		panel.add(loginButton);
		panel.add(userText);
		panel.add(passwordLabel);
		panel.add(userLabel);
		panel.add(passwordText);
		panel.add(pageTitle);

		frame.setVisible(true);
	}

	public static void createBackButton(String screen, boolean isLoggingIn) {
		JButton backButton = new JButton("<");
		backButton.setBounds(25, 25, 75, 50);
		backButton.setFont(new Font("Arial", Font.PLAIN, 25));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.updateUI();
				if (screen.equals("selectRole"))
					if (isLoggingIn)
						selectUserTypeScreen(true);
					else
						selectUserTypeScreen(false);
				else if (screen.equals("homepage"))
					homepage();
			}
		});
		panel.add(backButton);
	}

	public static void registerScreen() {
		JLabel firstNameLabel;
		JTextField firstNameText;
		JLabel lastNameLabel;
		JTextField lastNameText;
		JLabel emailLabel;
		JTextField emailText;
		JLabel passwordLabel;
		JPasswordField passwordText;
		JButton button;
		JLabel pageTitle;

		pageTitle = new JLabel(role + " Sign Up");
		pageTitle.setBounds(0, 100, frame.getWidth(), 80);
		pageTitle.setFont(new Font("Palatino", Font.BOLD, 50));
		pageTitle.setVerticalAlignment(JLabel.CENTER);
		pageTitle.setHorizontalAlignment(JLabel.CENTER);
		panel.add(pageTitle);

		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(frame.getWidth() / 2 - 250, frame.getHeight() / 2 - 100, 300, 40);
		firstNameLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		firstNameLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(firstNameLabel);

		firstNameText = new JTextField(20);
		firstNameText.setBounds(frame.getWidth() / 2, frame.getHeight() / 2 - 100, 300, 40);
		firstNameText.setFont(new Font("Arial", Font.PLAIN, 25));
		firstNameText.setHorizontalAlignment(JTextField.CENTER);
		panel.add(firstNameText);

		lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setBounds(frame.getWidth() / 2 - 250, frame.getHeight() / 2 - 40, 300, 40);
		lastNameLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lastNameLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lastNameLabel);

		lastNameText = new JTextField(20);
		lastNameText.setBounds(frame.getWidth() / 2, frame.getHeight() / 2 - 40, 300, 40);
		lastNameText.setFont(new Font("Arial", Font.PLAIN, 25));
		lastNameText.setHorizontalAlignment(JTextField.CENTER);
		panel.add(lastNameText);

		emailLabel = new JLabel("Email");
		emailLabel.setBounds(frame.getWidth() / 2 - 250, frame.getHeight() / 2 + 20, 300, 40);
		emailLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		emailLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(emailLabel);

		emailText = new JTextField(20);
		emailText.setBounds(frame.getWidth() / 2, frame.getHeight() / 2 + 20, 300, 40);
		emailText.setFont(new Font("Arial", Font.PLAIN, 25));
		emailText.setHorizontalAlignment(JTextField.CENTER);
		panel.add(emailText);

		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(frame.getWidth() / 2 - 250, frame.getHeight() / 2 + 80, 300, 40);
		passwordLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		passwordLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(passwordLabel);

		passwordText = new JPasswordField();
		passwordText.setBounds(frame.getWidth() / 2, frame.getHeight() / 2 + 80, 300, 40);
		passwordText.setFont(new Font("Arial", Font.PLAIN, 25));
		passwordText.setHorizontalAlignment(JTextField.CENTER);
		panel.add(passwordText);

		button = new JButton("Sign Up");
		button.setBounds(frame.getWidth() / 2 - 100, frame.getHeight() / 2 + 200, 200, 40);
		button.setFont(new Font("Arial", Font.PLAIN, 25));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = passwordText.getText();
				String username = createUsername(role, firstNameText.getText(), lastNameText.getText());
				try {
					validatePassword(password);
					panel.removeAll();
					panel.updateUI();
					frame.dispose();

					writeFile(username, password, firstNameText.getText(), lastNameText.getText(), emailText.getText());

					if (username.substring(0, 2).equals("SS")) {
						createStudentFile(username);
						new StudentPage(username, false, null);
					} else if (username.substring(0, 2).equals("UA"))
						new AdminPage(username);
					else if (username.substring(0, 2).equals("SA"))
						new AdvisorPage(username);

					frame = null;
				} catch (PasswordException p) {
					JOptionPane.showMessageDialog(frame, p, "Password Error!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		panel.add(button);

		createBackButton("selectRole", false);

		frame.setVisible(true);
	}

	public static void readFile() {
		try {
			File file = new File("SJSUCoursePlanner/userData.txt");
			Scanner myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				users.add(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void writeFile(String username, String password, String firstName, String lastName, String email) {
		try {
			File file = new File("SJSUCoursePlanner/userData.txt");
			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		try {
			FileWriter writer = new FileWriter("SJSUCoursePlanner/userData.txt", true);
			writer.write(username + " " + encryptPassword(password) + " " + firstName + " " + lastName + " " + email);
			writer.write(System.getProperty("line.separator"));
			writer.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static String encryptPassword(String password){
		String new_password = "";
		Queue<String> queue = new LinkedList<>();

		for(int i = 0; i < password.length(); i++)
			queue.add(password.substring(i, i+1));

		Set<Integer> positions = Stream.of(0, 1, 3, 4, 6, 7, 8, 10, 12, 14, 15, 17, 19, 21, 23, 24, 27, 29, 33, 36, 38, 42, 47).collect(Collectors.toSet());
		String randomString = UUID.randomUUID().toString().replaceAll("-", "");
		
		for(int i = 0; i < 50; i++){
			if(positions.contains(i))
				try{
					new_password += randomString.substring(i, i + 1);
				}
				catch(Exception e){
					System.out.println("failed in adding from queue");
				}
			else{
				try{
					new_password += queue.remove();
				}
				catch(Exception e){
					System.out.println("failed in adding from queue");
				}
			}
				
		}

		return new_password;
	}

	public static String decryptPassword(String entered_password, String stored_password){
		Set<Integer> positions = Stream.of(0, 1, 3, 4, 6, 7, 8, 10, 12, 14, 15, 17, 19, 21, 23, 24, 27, 29, 33, 36, 38, 42, 47).collect(Collectors.toSet());
		Queue<String> queue = new LinkedList<>();

		for(int i = 0; i < entered_password.length(); i++)
			queue.add(entered_password.substring(i, i+1));

		String password = "";
		for(int i = 0; i < 50; i++){
			if(!positions.contains(i)){
				try{
					if(stored_password.substring(i, i+1).equals(queue.peek())){
						password += queue.remove();
					}
				}
				catch(Exception e){
					System.out.println("failed to add to password");
				}
			}
		}
		return password;
	}

	public static void createStudentFile(String username) {
		try {
			File file = new File("SJSUCoursePlanner/StudentCourses/" + username + ".txt");
			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static String createUsername(String role, String firstName, String lastName) {
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

	public static String checkUser(String username, String password) {
		boolean userExists = false;
		boolean wrongPassword = false;

		for (int i = 0; i < users.size(); i++) {
			String currentLine = users.get(i);
			String[] fields = currentLine.split(" ");
			String currentUsername = fields[0];
			String currentPassword = fields[1];
			currentPassword = decryptPassword(password, currentPassword);

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
		for (int i = 0; i < users.size(); i++) {
			String currentLine = users.get(i);
			String[] fields = currentLine.split(" ");
			String currentUsername = fields[0];

			if (username.equals(currentUsername))
				return currentLine;
		}
		return null;
	}

	public static void validatePassword(String password) throws LowerCaseCharacterMissing, UpperCaseCharacterMissing,
			SpecialCharacterMissing, NumberCharacterMissing, Minimum8CharactersRequired {
		boolean containsUpper = false;
		boolean containsLower = false;
		boolean containsSpecial = false;
		boolean containsNumber = false;

		String specialCharacters = "!#$%&'()*+,-./:;<=>?@[]^_`";

		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if (Character.isUpperCase(c))
				containsUpper = true;
			else if (Character.isLowerCase(c))
				containsLower = true;
			else if (Character.isDigit(c))
				containsNumber = true;
			else if (specialCharacters.contains(password.substring(i, i + 1)))
				containsSpecial = true;
		}

		if (!containsUpper)
			throw new UpperCaseCharacterMissing();
		else if (!containsLower)
			throw new LowerCaseCharacterMissing();
		else if (!containsSpecial)
			throw new SpecialCharacterMissing();
		else if (!containsNumber)
			throw new NumberCharacterMissing();
		else if (password.length() < 8)
			throw new Minimum8CharactersRequired();
	}

	public static ArrayList<String> getUsers() {
		return users;
	}

}
