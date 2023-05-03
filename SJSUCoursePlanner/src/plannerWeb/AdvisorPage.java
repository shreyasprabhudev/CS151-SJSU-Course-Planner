package plannerWeb;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class AdvisorPage extends JFrame implements ActionListener{

	JComboBox<String> profOptBox;
	JLabel major;
	JButton advisorConfirmBtn;
	JButton advisorLogoutBtn;

	public AdvisorPage() {
		this.setSize(1400, 800);
		this.setLayout(null);
		this.setTitle("Majors");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
	
	public static void main(String[] args) {
		new AdvisorPage();
	}

}
