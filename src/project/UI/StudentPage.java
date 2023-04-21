package project.UI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import plannerWeb.*;

public class StudentPage extends JFrame implements ActionListener {
	JComboBox<String> majorBox;
	JLabel major;
	JLabel studentWelcomeLabel;
	JButton confirmBtn;

	JMenuItem compSci;
	JMenuItem elecEng;
	JMenuItem aeroEng;
	JMenuItem softEng;
	JMenuItem bioEng;
	JMenuItem chemEng;
	JMenuItem compEng;
	JMenuItem mechEng;
	JMenuItem intEng;
	JMenuItem indEng;
	JMenuItem civilEng;
	JMenuItem math;
	JMenuItem physics;
	JMenuItem bio;
	JMenuItem art;
	JMenuItem soc;
	JMenuItem pubHealth;
	JMenuItem chem;

	StudentPage() {

		this.setSize(1400, 800);
		this.setLayout(null);
		this.setTitle("Majors");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String[] majors = { "Computer Science", "Software Engineering", "Electrical Engineering",
				"Aerospace Engineering", "Biomedical Engineering", "Mechanical Engineering", "Industrial Engineering",
				"Civil Engineering", "Interdisciplinary Engineering", "Mathematics", "Physics", "Biology",
				"Chemistry" };
		majorBox = new JComboBox<>(majors);
		majorBox.setBounds(100, 220, 200, 25);
		this.add(majorBox);

		confirmBtn = new JButton("Confirm");
		confirmBtn.addActionListener(this);
		confirmBtn.setBounds(150, 350, 90, 25);
		this.add(confirmBtn);

		studentWelcomeLabel = new JLabel("Welcome Student");
		studentWelcomeLabel.setHorizontalAlignment(JLabel.CENTER);
		studentWelcomeLabel.setFont(new Font("Serif", Font.BOLD, 50));
		studentWelcomeLabel.setBounds(90, 80, 400, 80);
		this.add(studentWelcomeLabel);

		major = new JLabel("Select Major");
		major.setBounds(100, 170, 220, 50);
		major.setFont(new Font("Serif", Font.PLAIN, 20));
		this.add(major);

		/*
		 * 
		 * compSci = new JMenuItem("Computer Science"); elecEng = new
		 * JMenuItem("Electrical Engineering"); elecEng.add aeroEng = new
		 * JMenuItem("Aerospace Engineering"); softEng = new
		 * JMenuItem("Software Engineering"); bioEng = new
		 * JMenuItem("Biomedical Engineering"); chemEng = new
		 * JMenuItem("Chemcial Engineering"); compEng = new
		 * JMenuItem("Computer Engineering"); mechEng = new
		 * JMenuItem("Mechanical Engineering"); intEng = new
		 * JMenuItem("Interdisciplinary Engineering"); indEng = new
		 * JMenuItem("Industrial Engineering"); civilEng = new
		 * JMenuItem("Civil Engineering"); math = new JMenuItem("Mathematics"); physics
		 * = new JMenuItem("Physics"); bio = new JMenuItem("Biology"); art = new
		 * JMenuItem("Art"); soc = new JMenuItem("Sociology"); pubHealth = new
		 * JMenuItem("Public Health"); chem = new JMenuItem("Chemistry");
		 * 
		 * majorMenu.add(compSci); majorMenu.add(elecEng); majorMenu.add(aeroEng);
		 * majorMenu.add(softEng); majorMenu.add(bioEng); majorMenu.add(chemEng);
		 * majorMenu.add(compEng); majorMenu.add(mechEng); majorMenu.add(intEng);
		 * majorMenu.add(indEng); majorMenu.add(civilEng); majorMenu.add(math);
		 * majorMenu.add(physics); majorMenu.add(bio); majorMenu.add(art);
		 * majorMenu.add(soc); majorMenu.add(pubHealth);
		 * 
		 * compSci.addActionListener(() -> JOptionPane.showMessageDialog(compSci,
		 * "Computer Science selected"));
		 * 
		 * menuBar.add(majorMenu); this.setJMenuBar(menuBar);
		 */
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == confirmBtn)
		{
			if((String) majorBox.getSelectedItem() == "Computer Science") {
				
			}
			if((String) majorBox.getSelectedItem() == "Software Engineering") {
				
			}
			if((String) majorBox.getSelectedItem() == "Electrical Engineering") {
				
			}if((String) majorBox.getSelectedItem() == "Aerospace Engineering") {
				
			}if((String) majorBox.getSelectedItem() == "Biomedical Engineering") {
				
			}if((String) majorBox.getSelectedItem() == "Mechanical Engineering") {
				
			}if((String) majorBox.getSelectedItem() == "Industrial Engineering") {
				
			}if((String) majorBox.getSelectedItem() == "Civil Engineering") {
				
			}if((String) majorBox.getSelectedItem() == "Interdisciplinary Engineering") {
				
			}if((String) majorBox.getSelectedItem() == "Mathematics") {
				
			}if((String) majorBox.getSelectedItem() == "Physics") {
				
			}
			if((String) majorBox.getSelectedItem() == "Biology") {
				
			}if((String) majorBox.getSelectedItem() == "Chemistry") {
				
			}
		}else {
			
		}
		
		
		
	}

	public static void main(String[] args) {
		new StudentPage();
	}

}
