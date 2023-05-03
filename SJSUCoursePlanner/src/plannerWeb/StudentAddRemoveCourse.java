package plannerWeb;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import courseplanner.*;

class StudentAddCourse extends JFrame implements ActionListener{
	JComboBox<String> addStudentCourseBox;
	JButton addCourseConfirmBtn;
	JButton addCourseCancelBtn;
	JTextField addCourseNameField;
	JLabel addCourseTitleLabel;
	JLabel addCourseNameLabel;
	UserInterface frame;

	public StudentAddCourse(UserInterface in) {
		frame = in;
		this.setLayout(null);
		this.setSize(1400, 800);

		addStudentCourseBox = new JComboBox<String>();
		addStudentCourseBox.setVisible(true);

		this.add(addStudentCourseBox);

		addCourseConfirmBtn = new JButton("Confirm");
		addCourseConfirmBtn.setBounds(210, 200, 90, 25);
		addCourseConfirmBtn.addActionListener(this);
		this.add(addCourseConfirmBtn);

		addCourseCancelBtn = new JButton("Cancel");
		addCourseCancelBtn.setBounds(100, 200, 90, 25);
		addCourseCancelBtn.addActionListener(this);
		this.add(addCourseCancelBtn);

		addCourseNameField = new JTextField();
		addCourseNameField.setBounds(100, 80, 200, 25);
		this.add(addCourseNameField);

		addCourseNameLabel = new JLabel("Name: ");
		addCourseNameLabel.setBounds(50, 80, 100, 25);
		this.add(addCourseNameLabel);

		addCourseTitleLabel = new JLabel("Add Course");
		addCourseTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		addCourseTitleLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		addCourseTitleLabel.setBounds(100, 30, 150, 25);
		addCourseTitleLabel.setBackground(Color.WHITE);
		addCourseTitleLabel.setOpaque(true);
		this.add(addCourseTitleLabel);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addCourseConfirmBtn) {
			if (frame.control.getCourse((String) addCourseNameField.getText()) != null) {
				JOptionPane.showMessageDialog(this, "Course of that name already exists.");
			} else {
				if (((String) addStudentCourseBox.getSelectedItem()).equals("N/a")) {
					frame.control.addCourse((String) addCourseNameField.getText());
					JOptionPane.showMessageDialog(this, "Successfully added course.");
				} else {
					frame.control.addCourse((String) addCourseNameField.getText(),
							(String) addStudentCourseBox.getSelectedItem());
					JOptionPane.showMessageDialog(this, "Successfully added course.");
					Student student = (Student) frame.control.system
							.getUser((String) addStudentCourseBox.getSelectedItem());
					student.addCourse(frame.control.getCourse((String) addCourseNameField.getText()));
				}

				addCourseNameField.setText("");
				addStudentCourseBox.setSelectedIndex(0);
				frame.pageTransition(frame.studentPage);
			}

		} else if (e.getSource() == addCourseCancelBtn) {
			addCourseNameField.setText("");
			addStudentCourseBox.setSelectedIndex(0);
			frame.pageTransition(frame.studentPage);
			frame.pageTransition(frame.studentPage);
		}

	}

	public void updateStudentAddCourseScreen() {
		ArrayList<User> users = frame.control.getUserList();
		ArrayList<String> professors = new ArrayList<String>();

		professors.add("N/a");

		for (int i = 0; i < users.size(); i++) {
			if (users.get(i) instanceof Student) {
				professors.add(users.get(i).getId());
			}
		}

		String[] studentBox = new String[professors.size()];
		studentBox = professors.toArray(studentBox);

		addStudentCourseBox = new JComboBox<String>(studentBox);
		addStudentCourseBox.setBounds(170, 130, 130, 25);
		this.add(addStudentCourseBox);

//		ImageIcon image3 = new ImageIcon("images/Administration.jpeg");
//
//		JLabel image = new JLabel(image3);
//		image.setBounds(0, 0, 1000, 500);
//		this.add(image);
	}

}

class StudentRemoveCourse extends JFrame implements ActionListener {

	JComboBox<String> removeCourseBox;
	JButton removeCourseConfirmBtn;
	JButton removeCourseCancelBtn;
	JLabel removeCourseTitleLabel;
	JLabel removeCourseNameLabel;
	UserInterface frame;

	public StudentRemoveCourse(UserInterface in) {
		frame = in;
		this.setLayout(null);
		this.setPreferredSize(new Dimension(1000, 500));

		removeCourseBox = new JComboBox<String>();

		removeCourseConfirmBtn = new JButton("Confirm");
		removeCourseConfirmBtn.setBounds(210, 200, 90, 25);
		removeCourseConfirmBtn.addActionListener(this);
		this.add(removeCourseConfirmBtn);

		removeCourseCancelBtn = new JButton("Cancel");
		removeCourseCancelBtn.setBounds(100, 200, 90, 25);
		removeCourseCancelBtn.addActionListener(this);
		this.add(removeCourseCancelBtn);

		removeCourseTitleLabel = new JLabel("Remove Course");
		removeCourseTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		removeCourseTitleLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		removeCourseTitleLabel.setBounds(100, 30, 200, 25);
		this.add(removeCourseTitleLabel);

		removeCourseNameLabel = new JLabel("Course:");
		removeCourseNameLabel.setBounds(100, 110, 100, 25);
		this.add(removeCourseNameLabel);
	}

	public void updateStudentRemoveCourseScreen() {
		ArrayList<Course> courses = frame.control.getAllCourses();
		ArrayList<String> coursesNames = new ArrayList<String>();

		// coursesNames.add("Select a Course");

		/*
		 * for (int i = 0; i < courses.size(); i++) {
		 * coursesNames.add(courses.get(i).getName()); }
		 */

		String[] coursesBox = new String[coursesNames.size()];
		coursesBox = coursesNames.toArray(coursesBox);

		removeCourseBox = new JComboBox<String>(coursesBox);
		removeCourseBox.setBounds(150, 110, 150, 25);
		this.add(removeCourseBox);

		ImageIcon image3 = new ImageIcon("images/Administration.jpeg");

		JLabel image = new JLabel(image3);
		image.setBounds(0, 0, 1000, 500);
		this.add(image);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == removeCourseConfirmBtn) {
			if (removeCourseBox.getItemCount() == 0) {
				JOptionPane.showMessageDialog(this, "Failed: There are no course to remove");
			} else {
				frame.control.removeCourse((String) removeCourseBox.getSelectedItem());
				JOptionPane.showMessageDialog(this, "Successfully removed course.");
			}

		}
		removeCourseBox.setSelectedIndex(0);
		frame.pageTransition(frame.studentPage);
	}

}
