package plannerWeb;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AdminPage extends JFrame implements ActionListener {

	JComboBox<String> adminOptionsBox;
	JButton adminOptionConfirmBtn;
	JButton adminLogoutBtn;
	JLabel adminWelcomeLabel;
	UserInterface frame;

	public AdminPage(UserInterface in) {
		frame = in;
		this.setSize(1400, 800);
		this.setLayout(null);
		this.setTitle("Majors");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String[] adminOptions = { "Add User", "Remove User", "Add Course", "Remove Course", "Add Required Information",
				"View Course Planner" };

		adminOptionsBox = new JComboBox<String>(adminOptions);
		adminOptionsBox.setBounds(100, 220, 200, 25);
		this.add(adminOptionsBox);

		adminOptionConfirmBtn = new JButton("Confirm");
		adminOptionConfirmBtn.addActionListener(this);
		adminOptionConfirmBtn.setBounds(210, 350, 90, 25);
		this.add(adminOptionConfirmBtn);

		adminLogoutBtn = new JButton("Logout");
		adminLogoutBtn.addActionListener(this);
		adminLogoutBtn.setBounds(100, 350, 90, 25);
		this.add(adminLogoutBtn);

		adminWelcomeLabel = new JLabel("Welcome Admin");
		adminWelcomeLabel.setHorizontalAlignment(JLabel.CENTER);
		adminWelcomeLabel.setFont(new Font("Serif", Font.BOLD, 50));
		adminWelcomeLabel.setBounds(90, 80, 400, 80);
		this.add(adminWelcomeLabel);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == adminOptionConfirmBtn) {
			if (((String) adminOptionsBox.getSelectedItem()).equals("Add User")) {

			} else if (((String) adminOptionsBox.getSelectedItem()).equals("Remove User")) {

			} else if (((String) adminOptionsBox.getSelectedItem()).equals("Add Course")) {

			} else if (((String) adminOptionsBox.getSelectedItem()).equals("Remove Course")) {

			} else if (((String) adminOptionsBox.getSelectedItem()).equals("Add Required Information")) {

			} else if (((String) adminOptionsBox.getSelectedItem()).equals("View Student Planner")) {

			}

		}
		if (e.getSource() == adminLogoutBtn) {
			this.setVisible(false);
			this.dispose();
			Planner.selectUserTypeScreen();
		}
	}

}
