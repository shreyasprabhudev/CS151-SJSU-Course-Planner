package plannerWeb;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import courseplanner.*;

public class LoginPage2 extends JFrame implements ActionListener{
	JLabel homePageTitle;
	JButton signUpButton;
	JButton logInButton;
	UserInterface frame;

	public LoginPage2(UserInterface in) {
		frame = in;
		this.setSize(1400, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.GRAY);
		this.setTitle("SJSU Course Planner");

		homePageTitle = new JLabel();
		homePageTitle.setText("<html><center>Welcome to SJSU Course Planner Information Center!</center></html>");
		homePageTitle.setBounds(0, 100, this.getWidth(), 80);
		homePageTitle.setFont(new Font("Palatino", Font.BOLD, 50));
		homePageTitle.setVerticalAlignment(JLabel.CENTER);
		homePageTitle.setHorizontalAlignment(JLabel.CENTER);

		signUpButton = new JButton("Sign Up");
		int buttonWidth = 200;
		int buttonHeight = 50;
		int buttonX = (this.getWidth() - buttonWidth) / 2 + 120; // adjusted buttonX value
		int buttonY = this.getHeight() * 3 / 4 - buttonHeight / 2;
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
		int x = (this.getWidth() - originalImageIcon.getIconWidth()) / 2;
		int y = homePageTitle.getY() + homePageTitle.getHeight() + space / 2 - originalImageIcon.getIconHeight() / 2;
		imageLabel.setBounds(x, y, originalImageIcon.getIconWidth(), originalImageIcon.getIconHeight());

		JButton logInButton = new JButton("Log In");
		buttonX = buttonX - buttonWidth - 50;
		logInButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);

		signUpButton.addActionListener(this);

		// login button operations
		logInButton.addActionListener(this);

		this.add(homePageTitle);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.add(imageLabel);
		this.add(signUpButton);
		this.add(logInButton);
		this.setVisible(true);

	}



	private void pageTransition(JScrollPane before, JScrollPane after) {
		after.setVisible(true);
		frame.frame.add(after);
		before.setVisible(false);
		frame.frame.remove(before);
		frame.frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == logInButton) {
			String pwd = "";
			for (int i = 0; i < loginPwdField.getPassword().length; i++) {
				pwd += loginPwdField.getPassword()[i];
			}

			// Successful Login
			if (frame.control.loginUser(loginIdField.getText(), pwd)) {
				User user = frame.control.getCurrentUser();
				String fName = user.getFirstName();
				String lName = user.getLastName();

				if (user instanceof Admin) {
					frame.adminOptionScroll.adminWelcomeLabel.setText("Welcome, " + fName + " " + lName);
					pageTransition(frame.loginPage, frame.adminPage);

				} else if (user instanceof Professor) {
					frame.professorOptionScroll.profWelcomeLabel.setText("Welcome, " + fName + " " + lName);
					pageTransition(frame.loginScroll, frame.professorOptionScroll);

				} else if (user instanceof Student) {
					frame.studentPage.studentWelcomeLabel.setText("Welcome, " + fName + " " + lName);
					pageTransition(frame.loginScroll, frame.studentOptionScroll);
				}

				//frame.loginPage.statusLabel.setVisible(false);
				frame.loginPage.loginIdField.setText("");
				frame.loginPage.loginPwdField.setText("");

				frame.frame.pack();

				// Failed Login
			} else {
				//frame.loginPage.statusLabel.setVisible(true);
			}
		}
		
		
	}
}
