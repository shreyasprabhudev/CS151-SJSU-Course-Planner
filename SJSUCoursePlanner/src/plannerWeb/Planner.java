package plannerWeb;

import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;

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

		userLabel = new JLabel("Email");
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
		button.addActionListener(new Planner());
		panel.add(button);

		success = new JLabel("");
		success.setBounds(frame.getWidth() / 2 - 150, frame.getHeight() / 2 + 275, 300, 40);
		success.setFont(new Font("Arial", Font.PLAIN, 25));
		success.setHorizontalAlignment(JLabel.CENTER);
		panel.add(success);

		frame.setVisible(true);

	}

	// button action is tied to this code
	@Override
	public void actionPerformed(ActionEvent e) {
		String user = userText.getText();
		String password = passwordText.getText();
		System.out.println(user + ", " + password);

		// Create a new JFrame object
		JFrame newFrame = new JFrame();
		newFrame.setTitle("Welcome");
		newFrame.setSize(500, 500);
		newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newFrame.getContentPane().setBackground(new Color(0xF5F5DC));

		// Display the new JFrame
		newFrame.setVisible(true);
	}

}
