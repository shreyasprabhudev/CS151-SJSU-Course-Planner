package plannerWeb;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AdvisorPage extends JFrame implements ActionListener {

	JComboBox<String> advisorOptionsBox;
	JButton advisorOptionConfirmBtn;
	JButton advisorLogoutBtn;
	JLabel advisorWelcomeLabel;

	public AdvisorPage(String adminUsername) {
		this.setSize(1400, 800);
		this.setLayout(null);
		this.setTitle("Advisor Page");
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

		String[] advisorOptions = getUsernames(Planner.getUsers());

		advisorOptionsBox = new JComboBox<String>(advisorOptions);
		advisorOptionsBox.setBounds(600, 300, 250, 60);
		((JLabel)advisorOptionsBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		advisorOptionsBox.setFont(new Font("Arial", Font.PLAIN, 20));
		this.add(advisorOptionsBox);

		advisorOptionConfirmBtn = new JButton("Confirm");
		advisorOptionConfirmBtn.setBounds(650, 375, 150, 40);
		advisorOptionConfirmBtn.setFont(new Font("Arial", Font.PLAIN, 20));
		advisorOptionConfirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (String username : advisorOptions) {
					if (((String) advisorOptionsBox.getSelectedItem() == username)) {
						new StudentPage(username, true, adminUsername);
						dispose();
					}
				}

			}
		});
		this.add(advisorOptionConfirmBtn);

		advisorWelcomeLabel = new JLabel("Welcome Advisor!");
		advisorWelcomeLabel.setHorizontalAlignment(JLabel.CENTER);
		advisorWelcomeLabel.setFont(new Font("Serif", Font.BOLD, 50));
		advisorWelcomeLabel.setBounds(515, 80, 400, 80);
		this.add(advisorWelcomeLabel);

		// new added section for log out
		advisorLogoutBtn = new JButton("Logout");
		advisorLogoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Planner.homepage();
				dispose();
			}
		});
		advisorLogoutBtn.setBounds(1225, 30, 150, 40);
		advisorLogoutBtn.setFont(new Font("Arial", Font.PLAIN, 20));
		add(advisorLogoutBtn);

		// create a new JLabel to hold the image
		JLabel advLogoutLabel = new JLabel();

		// load the image from a file (replace "image.jpg" with the name of your image
		// file)
		ImageIcon imageAdvLogoutIcon = new ImageIcon("SJSUCoursePlanner/homeicon/adv.png");

		// set the icon of the JLabel to the loaded image
		advLogoutLabel.setIcon(imageAdvLogoutIcon);

		// set the size and position of the JLabel to center it in the JFrame
		advLogoutLabel.setBounds(1130, 310, 300, 280);

		// add the JLabel to the JFrame
		this.add(advLogoutLabel);

		this.setVisible(true);
	}

	public static String[] getUsernames(ArrayList<String> users) {
		ArrayList<String> usernames = new ArrayList<String>();
		for (int i = 0; i < users.size(); i++) {
			String currentLine = users.get(i);
			String[] fields = currentLine.split(" ");
			String currentUsername = fields[0];
			if (currentUsername.substring(0, 2).equals("SS"))
				usernames.add(currentUsername);
		}

		String[] final_arr = new String[usernames.size()];
		for (int i = 0; i < usernames.size(); i++)
			final_arr[i] = usernames.get(i);
		return final_arr;
	}

	public static void main(String[] args) {
		Planner.readFile();
		new AdvisorPage("SA-1111");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
	}

}