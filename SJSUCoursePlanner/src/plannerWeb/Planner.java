package plannerWeb;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import java.awt.Font;
import java.awt.Image;

public class Planner {

	public static void main(String[] args) {
		homePage();
	}

	public static void homePage() {
		JFrame jFrame = new JFrame();
		jFrame.setSize(1400, 800);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setResizable(false);
		jFrame.getContentPane().setBackground(Color.GRAY);
		jFrame.setTitle("SJSU Course Planner");

		JLabel homePageTitle = new JLabel();
		homePageTitle.setText("<html><center>Welcome to SJSU Course Planner Information Center!</center></html>");
		homePageTitle.setBounds(0, 100, jFrame.getWidth(), 80);
		homePageTitle.setFont(new Font("Palatino", Font.BOLD, 50));
		homePageTitle.setVerticalAlignment(JLabel.CENTER);
		homePageTitle.setHorizontalAlignment(JLabel.CENTER);

		JButton signUpButton = new JButton("Sign Up");
		int buttonWidth = 200;
		int buttonHeight = 50;
		int buttonX = (jFrame.getWidth() - buttonWidth) / 2 + 120; // adjusted buttonX value
		int buttonY = jFrame.getHeight() * 3 / 4 - buttonHeight / 2;
		signUpButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);

		ImageIcon imageIcon = new ImageIcon("./homeicon/sjsu1.jpeg");
		Image image = imageIcon.getImage();

		// Create a new ImageIcon from the original image
		ImageIcon originalImageIcon = new ImageIcon(image);

		// Set the icon of the label to the original image
		JLabel imageLabel = new JLabel();
		imageLabel.setIcon(originalImageIcon);

		// Calculate the space between the home page title and the sign-up boundary
		int space = signUpButton.getY() - (homePageTitle.getY() + homePageTitle.getHeight());

		// Set the bounds of the label to center it in the remaining space
		int x = (jFrame.getWidth() - originalImageIcon.getIconWidth()) / 2;
		int y = homePageTitle.getY() + homePageTitle.getHeight() + space / 2 - originalImageIcon.getIconHeight() / 2;
		imageLabel.setBounds(x, y, originalImageIcon.getIconWidth(), originalImageIcon.getIconHeight());

		JButton logInButton = new JButton("Log In");
		buttonX = buttonX - buttonWidth - 50;
		logInButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);

		signUpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String firstName = JOptionPane.showInputDialog(jFrame, "Please enter your first name:");
				String lastName = JOptionPane.showInputDialog(jFrame, "Please enter your last name:");
				String email = JOptionPane.showInputDialog(jFrame, "Please enter your email:");
				String password = JOptionPane.showInputDialog(jFrame, "Please enter your password:");

				// generate username
				char firstLetter = firstName.charAt(0);
				char secondLetter = lastName.charAt(0);
				Random rand = new Random();
				int randomNum = rand.nextInt(9000) + 1000; // generate a random number between 1000 and 9999
				String username = String.format("%s%s-%d", Character.toUpperCase(firstLetter),
						Character.toUpperCase(secondLetter), randomNum);

				String d = "FirstName: " + new String(firstName);
				d += "; LastName: " + new String(lastName);
				d += "; Email: " + new String(email);
				d += "; Username: " + username;
				d += "; Password: " + new String(password) + ";";

				try {
					checkPasswordRequirements(password);
					FileWriter fileW = new FileWriter("userData.txt", true);
					BufferedWriter bufferW = new BufferedWriter(fileW);
					bufferW.write(d);
					bufferW.newLine();

					bufferW.close();
					fileW.close();
					JOptionPane.showMessageDialog(jFrame, String.format("Your username is: %s", username));
				} catch (PasswordException pe) {
					JOptionPane.showMessageDialog(jFrame, pe.getMessage());
				} catch (IOException ex) {
					System.out.println(ex);
				}
			}
		});

		// login button operations
		logInButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = JOptionPane.showInputDialog(jFrame, "Please enter your username:");
				String password = JOptionPane.showInputDialog(jFrame, "Please enter your password:");

				boolean isUserRegistered = false;

				try (BufferedReader br = new BufferedReader(new FileReader("userData.txt"))) {
					String line;
					while ((line = br.readLine()) != null) {
						// deleating all blank space & spliting
						String[] userData = line.replaceAll(" ", "").split(";");
						for (int i = 0; i < userData.length; i++) {
							System.out.println(userData[i]);
						}
						String storedUsername = userData[3].substring(9);
						String storedPassword = userData[4].substring(9);
						System.out.println(storedUsername.length() + " " + username.length() + " " + password.length()
								+ " " + storedPassword.length());
						if (storedUsername.equals(username) && storedPassword.equals(password)) {
							isUserRegistered = true;
							String firstName = userData[0].substring(10);
							String lastName = userData[1].substring(9);
							// Load the user's profile on the screen
							JFrame userProfileFrame = new JFrame();

							userProfileFrame.setSize(1400, 800);
							userProfileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							userProfileFrame.setResizable(false);
							userProfileFrame.getContentPane().setBackground(Color.GRAY);
							userProfileFrame.setTitle(String.format("%s's Profile", firstName));

							JLabel userProfileTitle = new JLabel();
							userProfileTitle.setText(String.format(
									"<html><center>Welcome, %s!<br>You are successfully logged in.</center></html>",
									firstName));
							userProfileTitle.setBounds(400, 80, 600, 80);
							userProfileTitle.setFont(new Font("Palatino", Font.BOLD, 30));
							userProfileTitle.setHorizontalAlignment(JLabel.CENTER);

							JLabel firstNameLabel = new JLabel("First Name:");
							firstNameLabel.setBounds(300, 250, 150, 30);
							firstNameLabel.setFont(new Font("Palatino", Font.BOLD, 25));

							JLabel firstNameValue = new JLabel(firstName);
							firstNameValue.setBounds(500, 250, 150, 30);
							firstNameValue.setFont(new Font("Palatino", Font.BOLD, 25));

							JLabel lastNameLabel = new JLabel("Last Name:");
							lastNameLabel.setBounds(300, 300, 150, 30);
							lastNameLabel.setFont(new Font("Palatino", Font.BOLD, 25));

							JLabel lastNameValue = new JLabel(lastName);
							lastNameValue.setBounds(500, 300, 150, 30);
							lastNameValue.setFont(new Font("Palatino", Font.BOLD, 25));

							JLabel usernameLabel = new JLabel("Username:");
							usernameLabel.setBounds(300, 350, 150, 30);
							usernameLabel.setFont(new Font("Palatino", Font.BOLD, 25));

							JLabel usernameValue = new JLabel(username);
							usernameValue.setBounds(500, 350, 150, 30);
							usernameValue.setFont(new Font("Palatino", Font.BOLD, 25));

							userProfileFrame.add(userProfileTitle);
							userProfileFrame.add(firstNameLabel);
							userProfileFrame.add(firstNameValue);
							userProfileFrame.add(lastNameLabel);
							userProfileFrame.add(lastNameValue);
							userProfileFrame.add(usernameLabel);
							userProfileFrame.add(usernameValue);
							userProfileFrame.setLayout(null);
							userProfileFrame.setVisible(true);

							// Stop searching for the user
							break;
						}
					}

					if (!isUserRegistered) {
						JOptionPane.showMessageDialog(jFrame, "Incorrect username or password.");
					}
				} catch (IOException ex) {
					System.out.println(ex);
				}
			}
		});
		jFrame.add(homePageTitle);
		jFrame.setLayout(null);
		jFrame.setLocationRelativeTo(null);
		jFrame.add(imageLabel);
		jFrame.add(signUpButton);
		jFrame.add(logInButton);
		jFrame.setVisible(true);
	}

	public static void checkPasswordRequirements(String password) throws PasswordException {
		boolean hasUpperCase = false;
		boolean hasLowerCase = false;
		boolean hasSpecialChar = false;
		boolean hasNumber = false;

		for (char c : password.toCharArray()) {
			if (Character.isUpperCase(c)) {
				hasUpperCase = true;
			} else if (Character.isLowerCase(c)) {
				hasLowerCase = true;
			} else if (Character.isDigit(c)) {
				hasNumber = true;
			} else if (!Character.isLetterOrDigit(c)) {
				hasSpecialChar = true;
			}
		}
		if (!hasUpperCase) {
			throw new UpperCaseCharacterMissing();
		} else if (!hasLowerCase) {
			throw new LowerCaseCharacterMissing();
		} else if (!hasSpecialChar) {
			throw new SpecialCharacterMissing();
		} else if (!hasNumber) {
			throw new NumberCharacterMissing();
		} else if (password.length() < 8) {
			throw new Minimum8CharactersRequired();
		}
	}
}