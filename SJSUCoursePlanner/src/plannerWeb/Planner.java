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
import java.util.Random;
import java.util.Scanner;
import java.awt.Font;
import java.awt.Image;

public class Planner {
	private static ArrayList<String> users = new ArrayList<>();
	private static JFrame frame = new JFrame();
	private static JPanel panel = new JPanel();

	public static void main(String[] args) {
		readFile();
		selectUserTypeScreen();
	}

	public static void selectUserTypeScreen(){
		JLabel pageTitle;
		JButton studentButton;
		JButton professorButton;
		JButton advisorButton;

		frame.setTitle("SJSU Course Planner");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1400, 800);
		frame.setResizable(false);
		frame.add(panel);

		panel.setLayout(null);
		panel.setBackground(Color.GRAY);

		pageTitle = new JLabel();
		pageTitle.setText("Welcome to SJSU Course Planner Information Center!");
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
				welcomeScreen("Student");
			}
		});

		professorButton = new JButton("I'm a professor");
		int pbuttonWidth = 200;
		int pbuttonHeight = 50;
		int pbuttonX = (frame.getWidth() - pbuttonWidth) / 2; // adjusted buttonX value
		int pbuttonY = frame.getHeight() * 3 / 4 - pbuttonHeight / 2 - 100;
		professorButton.setBounds(pbuttonX, pbuttonY, pbuttonWidth, pbuttonHeight);
		professorButton.setFont(new Font("Arial", Font.PLAIN, 25));
		professorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.updateUI();
				welcomeScreen("Professor");
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
				welcomeScreen("Advisor");
			}
		});

		panel.add(pageTitle);
		panel.add(studentButton);
		panel.add(professorButton);
		panel.add(advisorButton);
		frame.setVisible(true);
	}

	public static void welcomeScreen(String role){
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

		signUpButton = new JButton("Sign Up");
		int buttonWidth = 200;
		int buttonHeight = 50;
		int buttonX = (frame.getWidth() - buttonWidth) / 2 + 120; // adjusted buttonX value
		int buttonY = frame.getHeight() * 3 / 4 - buttonHeight / 2;
		signUpButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
		signUpButton.setFont(new Font("Arial", Font.PLAIN, 25));
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.updateUI();
				registerScreen(role);
			}
		});

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
		buttonX = buttonX - buttonWidth - 50;
		loginButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
		loginButton.setFont(new Font("Arial", Font.PLAIN, 25));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String username = userText.getText();
				String password = passwordText.getText();

				String output = checkUser(username, password);
				if(output.equals("Valid user")){
					frame.removeAll();
					frame.setVisible(false);

					String[] fields = getUser(username, password).split(" ");

					if(username.substring(0,2).equals("SS"))
						new StudentPage();
					else if(username.substring(0,2).equals("UP"))
						new ProfessorPage();
					// successfulLoginScreen(username, fields[2], fields[3], fields[4]);
				}
				else if(output.equals("User does not exist")){
					JOptionPane.showMessageDialog(frame, new Exception("This is not a valid username! Please sign up first!"), "Error Loggin In!", JOptionPane.ERROR_MESSAGE);
					panel.removeAll();
					panel.updateUI();
					welcomeScreen(role);
				}
				else if(output.equals("Wrong password")){
					JOptionPane.showMessageDialog(frame, new PasswordException("Username and password do not match!"), "Password Error!", JOptionPane.ERROR_MESSAGE);
					panel.removeAll();
					panel.updateUI();
					welcomeScreen(role);
				}
			}
		});

		createBackButton();

		panel.add(loginButton);
		panel.add(userText);
		panel.add(passwordLabel);
		panel.add(userLabel);
		panel.add(passwordText);
		panel.add(signUpButton);
		panel.add(pageTitle);

		frame.setVisible(true);
	}

	public static void createBackButton(){
		JButton backButton = new JButton("<");
		backButton.setBounds(25, 25, 100, 50);
		backButton.setFont(new Font("Arial", Font.PLAIN, 25));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.updateUI();
				selectUserTypeScreen();
			}
		});
		panel.add(backButton);
	}

	public static void registerScreen(String role){
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

		pageTitle = new JLabel("Sign Up");
		pageTitle.setBounds(frame.getHeight() / 2 - 75, 150, 800, 40);
		pageTitle.setFont(new Font("Arial", Font.PLAIN, 35));
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
				try{
					validatePassword(password);
					panel.removeAll();
					panel.updateUI();

					writeFile(username, password, firstNameText.getText(), lastNameText.getText(), emailText.getText());
					successScreen(username);
				}
				catch(PasswordException p){
					JOptionPane.showMessageDialog(frame, p, "Password Error!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		panel.add(button);

		frame.setVisible(true);
	}

	public static void loginScreen(){
		JLabel userLabel;
		JTextField userText;
		JLabel pageTitle;
		JLabel passwordLabel;
		JPasswordField passwordText;
		JButton button;

		pageTitle = new JLabel("Login");
		pageTitle.setBounds(frame.getHeight() / 2 - 100, 150, 800, 40);
		pageTitle.setFont(new Font("Arial", Font.PLAIN, 35));
		pageTitle.setHorizontalAlignment(JLabel.CENTER);
		panel.add(pageTitle);

		userLabel = new JLabel("Username");
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

				String username = userText.getText();
				String password = passwordText.getText();

				String output = checkUser(username, password);
				if(output.equals("Valid user")){
					panel.removeAll();
					panel.updateUI();

					String[] fields = getUser(username, password).split(" ");

					successfulLoginScreen(username, fields[2], fields[3], fields[4]);
				}
				else if(output.equals("User does not exist")){
					JOptionPane.showMessageDialog(frame, new Exception("This is not a valid username! Please sign up first!"), "Error Loggin In!", JOptionPane.ERROR_MESSAGE);
				}
				else if(output.equals("Wrong password")){
					JOptionPane.showMessageDialog(frame, new PasswordException("Username and password do not match!"), "Password Error!", JOptionPane.ERROR_MESSAGE);
				}
		
			}
		});
		panel.add(button);

		frame.setVisible(true);

	}

	public static void readFile(){
		try{
			File file = new File("userData.txt");
			Scanner myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
			  String data = myReader.nextLine();
			  users.add(data);
			}
			myReader.close();
		} 
		catch(FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void writeFile(String username, String password, String firstName, String lastName, String email){
		try{
			File file = new File("userData.txt");
			if (file.createNewFile()) {
			  System.out.println("File created: " + file.getName());
			} 
			else {
			  System.out.println("File already exists.");
			}
		} 
		catch(IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		try{
			FileWriter writer = new FileWriter("userData.txt", true);
			writer.write(username + " " + password + " " + firstName + " " + lastName + " " + email);
			writer.write(System.getProperty( "line.separator" ));
			writer.close();
			System.out.println("Successfully wrote to the file.");
		} 
		catch(IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static String createUsername(String role, String firstName, String lastName){
		String output = "";
		if(role.equals("Student"))
			output += "SS";
		else if(role.equals("Professor"))
			output += "UP";
		else if(role.equals("Advisor"))
			output += "UA";
		output += "-";

		Random random = new Random();
		output += random.nextInt((9999 - 100) + 1) + 10;

		return output;
	}

	public static String checkUser(String username, String password){
		boolean userExists = false;
		boolean wrongPassword = false;

		for(int i = 0; i < users.size(); i++){
			String currentLine = users.get(i);
			String[] fields = currentLine.split(" ");
			String currentUsername = fields[0];
			String currentPassword = fields[1];

			if(username.equals(currentUsername))
				userExists = true;
			if(username.equals(currentUsername) && !password.equals(currentPassword))
				wrongPassword = true;
		}

		if(!userExists)
			return "User does not exist";
		else if(wrongPassword)
			return "Wrong password";
		else
			return "Valid user";
	}

	public static String getUser(String username, String password){
		for(int i = 0; i < users.size(); i++){
			String currentLine = users.get(i);
			String[] fields = currentLine.split(" ");
			String currentUsername = fields[0];

			if(username.equals(currentUsername))
				return currentLine;
		}
		return null;
	}

	public static void validatePassword(String password) throws LowerCaseCharacterMissing, UpperCaseCharacterMissing, SpecialCharacterMissing, NumberCharacterMissing, Minimum8CharactersRequired{
		boolean containsUpper = false;
		boolean containsLower = false;
		boolean containsSpecial = false;
		boolean containsNumber = false;
	
		String specialCharacters = "!#$%&'()*+,-./:;<=>?@[]^_`";
	
		for(int i = 0;i < password.length(); i++){
			char c = password.charAt(i);
			if(Character.isUpperCase(c))
				containsUpper = true;
			else if (Character.isLowerCase(c))
				containsLower = true;
			else if (Character.isDigit(c))
				containsNumber = true;
			else if(specialCharacters.contains(password.substring(i,i+1)))
				containsSpecial = true;
		}
	
		if(!containsUpper)
			throw new UpperCaseCharacterMissing();
		else if(!containsLower)
			throw new LowerCaseCharacterMissing();
		else if(!containsSpecial)
			throw new SpecialCharacterMissing();
		else if(!containsNumber)
			throw new NumberCharacterMissing();
		else if(password.length() < 8)
			throw new Minimum8CharactersRequired();	
	}

	public static void successScreen(String username){
		JLabel pageTitle;
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();

		frame.setTitle("Success!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1400, 800);
		frame.setResizable(false);
		frame.add(panel);

		pageTitle = new JLabel("Success! Welcome " + username + "!");
		pageTitle.setBounds(frame.getWidth() / 2 - 400, frame.getHeight() / 2 - 75, 800, 40);
		pageTitle.setFont(new Font("Arial", Font.PLAIN, 35));
		pageTitle.setHorizontalAlignment(JLabel.CENTER);
		panel.add(pageTitle);

		frame.setVisible(true);

	}

	public static void successfulLoginScreen(String username, String firstName, String lastName, String email){
		JLabel pageTitle;
		JLabel usernameLabel;
		JLabel firstNameLabel;
		JLabel lastNameLabel;
		JLabel emailLabel;
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();

		frame.setTitle("Success!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1400, 800);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.add(panel);

		panel.setLayout(null);

		pageTitle = new JLabel("Success! Welcome back " + username + "!");
		pageTitle.setBounds(frame.getWidth() / 2 - 400, frame.getHeight() / 2 - 225, 800, 40);
		pageTitle.setFont(new Font("Arial", Font.PLAIN, 35));
		pageTitle.setHorizontalAlignment(JLabel.CENTER);
		panel.add(pageTitle);

		usernameLabel = new JLabel("Username: " + username);
		usernameLabel.setBounds(frame.getWidth() / 2 - 150, frame.getHeight() / 2  - 125, 300, 40);
		usernameLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		usernameLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(usernameLabel);

		firstNameLabel = new JLabel("First Name: " + firstName);
		firstNameLabel.setBounds(frame.getWidth() / 2 - 150, frame.getHeight() / 2 - 50, 300, 40);
		firstNameLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		firstNameLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(firstNameLabel);

		lastNameLabel = new JLabel("Last Name: " + lastName);
		lastNameLabel.setBounds(frame.getWidth() / 2 - 150, frame.getHeight() / 2 + 25, 300, 40);
		lastNameLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lastNameLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lastNameLabel);

		emailLabel = new JLabel("Email: " + email);
		emailLabel.setBounds(frame.getWidth() / 2 - 150, frame.getHeight() / 2 + 100, 300, 40);
		emailLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		emailLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(emailLabel);

		frame.setVisible(true);

	}
}

class PasswordException extends Exception{
	public PasswordException(String s){
		super(s);
	}
}

class UpperCaseCharacterMissing extends PasswordException {
	public UpperCaseCharacterMissing(){
		super("Password is missing an upper case character!");
	}
}

class LowerCaseCharacterMissing extends PasswordException {
	public LowerCaseCharacterMissing(){
		super("Password is missing a lower case character!");
	}
}

class SpecialCharacterMissing extends PasswordException {
	public SpecialCharacterMissing(){
		super("Password is missing a special character!");
	}
}

class NumberCharacterMissing extends PasswordException {
	public NumberCharacterMissing(){
		super("Password is missing a number character!");
	}
}

class Minimum8CharactersRequired extends PasswordException {
	public Minimum8CharactersRequired(){
		super("Password requires a minimum of 8 characters!");
	}
}

