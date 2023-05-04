package plannerWeb;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

<<<<<<< HEAD

public class AdvisorPage extends JFrame implements ActionListener{

	JComboBox<String> profOptBox;
	JLabel major;
	JButton advisorConfirmBtn;
	JButton advisorLogoutBtn;
=======
public class AdvisorPage extends JFrame implements ActionListener {

	JComboBox<String> advisorOptionsBox;
	JButton advisorOptionConfirmBtn;
	JButton advisorLogoutBtn;
	JLabel advisorWelcomeLabel;
>>>>>>> a9f4ebab79e5abfaf833844ad77174cf7586829f

	public AdvisorPage() {
		this.setSize(1400, 800);
		this.setLayout(null);
<<<<<<< HEAD
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

=======
		this.setTitle("Advisor Page");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String[] advisorOptions = { "View User", "View Course Planner" };

		advisorOptionsBox = new JComboBox<String>(advisorOptions);
		advisorOptionsBox.setBounds(100, 220, 200, 25);
		this.add(advisorOptionsBox);

		advisorOptionConfirmBtn = new JButton("Confirm");
		advisorOptionConfirmBtn.addActionListener(this);
		advisorOptionConfirmBtn.setBounds(210, 350, 90, 25);
		this.add(advisorOptionConfirmBtn);

		advisorWelcomeLabel = new JLabel("Welcome Advisor");
		advisorWelcomeLabel.setHorizontalAlignment(JLabel.CENTER);
		advisorWelcomeLabel.setFont(new Font("Serif", Font.BOLD, 50));
		advisorWelcomeLabel.setBounds(90, 80, 400, 80);
		this.add(advisorWelcomeLabel);

		// new added section for log out
		advisorLogoutBtn = new JButton("Logout");
		advisorLogoutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				Planner.selectUserTypeScreen();
			}
		});
		advisorLogoutBtn.setBounds(1200, 20, 150, 30);
		add(advisorLogoutBtn);

		this.setVisible(true);
>>>>>>> a9f4ebab79e5abfaf833844ad77174cf7586829f
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
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
	
=======
		if (e.getSource() == advisorOptionConfirmBtn) {
			if (((String) advisorOptionsBox.getSelectedItem()).equals("Add User")) {

			} else if (((String) advisorOptionsBox.getSelectedItem()).equals("Remove User")) {

			} else if (((String) advisorOptionsBox.getSelectedItem()).equals("View Student Planner")) {

			}

		} else {

		}
	}

>>>>>>> a9f4ebab79e5abfaf833844ad77174cf7586829f
	public static void main(String[] args) {
		new AdvisorPage();
	}

}
