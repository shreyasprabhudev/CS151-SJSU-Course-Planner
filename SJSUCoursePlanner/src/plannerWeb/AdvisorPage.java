package plannerWeb;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import courseplanner.Controller;


public class AdvisorPage extends JFrame implements ActionListener{

	JComboBox<String> profOptBox;
	JLabel major;
	JButton advisorConfirmBtn;
	JButton advisorLogoutBtn;
	JLabel advisorWelcomeLabel;

	public AdvisorPage() {
		
		this.setSize(1400, 800);
		this.setLayout(null);
		
		String[] profOptions = {"View Student Planner"};

		profOptBox = new JComboBox<String>(profOptions);
		profOptBox.setBounds(100, 220, 200, 25);
		this.add(profOptBox);

		advisorConfirmBtn = new JButton("Confirm");
		advisorConfirmBtn.addActionListener(this);
		advisorConfirmBtn.setBounds(210, 350, 90, 25);
		this.add(advisorConfirmBtn);

		advisorLogoutBtn = new JButton("Logout");
		advisorLogoutBtn.addActionListener(this);
		advisorLogoutBtn.setBounds(100, 350, 90, 25);
		this.add(advisorLogoutBtn);

		advisorWelcomeLabel = new JLabel("Welcome Advisor");
		advisorWelcomeLabel.setHorizontalAlignment(JLabel.CENTER);
		advisorWelcomeLabel.setFont(new Font("Serif", Font.BOLD, 50));
		advisorWelcomeLabel.setBounds(90, 80, 400, 80);
		this.add(advisorWelcomeLabel);

		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == advisorConfirmBtn) {
			if (((String) profOptBox.getSelectedItem()).equals("Add Syllabus")) {

			} else if (((String) profOptBox.getSelectedItem()).equals("Add Required Text")) {

			} else if(((String) profOptBox.getSelectedItem()).equals("View Courses")) {
				
			}

		}
		if(e.getSource() == advisorLogoutBtn) {
			this.removeAll();
		}

	}
	


}
