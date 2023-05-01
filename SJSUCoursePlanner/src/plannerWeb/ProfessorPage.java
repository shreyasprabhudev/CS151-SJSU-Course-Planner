package plannerWeb;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ProfessorPage extends JFrame implements ActionListener{

	JComboBox<String> profOptBox;
	JLabel major;
	JButton profConfirmBtn;
	JButton profLogoutBtn;

	public ProfessorPage() {
		this.setSize(1400, 800);
		this.setLayout(null);
		this.setTitle("Majors");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String[] profOptions = { "Add Syllabus", "Add Required Text", "View Courses"};

		profOptBox = new JComboBox<String>(profOptions);
		profOptBox.setBounds(100, 220, 200, 25);
		this.add(profOptBox);

		profConfirmBtn = new JButton("Confirm");
		profConfirmBtn.addActionListener(this);
		profConfirmBtn.setBounds(210, 350, 90, 25);
		this.add(profConfirmBtn);

		profLogoutBtn = new JButton("Logout");
		profLogoutBtn.addActionListener(this);
		profLogoutBtn.setBounds(100, 350, 90, 25);
		this.add(profLogoutBtn);


		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == profConfirmBtn) {
			if (((String) profOptBox.getSelectedItem()).equals("Add Syllabus")) {

			} else if (((String) profOptBox.getSelectedItem()).equals("Add Required Text")) {

			} else if(((String) profOptBox.getSelectedItem()).equals("View Courses")) {
				
			}

		}
		if(e.getSource() == profLogoutBtn) {
			this.removeAll();
			selectUserTypeScreen();
		}

	}
	
	public static void main(String[] args) {
		new ProfessorPage();
	}

}
