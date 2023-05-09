package plannerWeb;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String[] advisorOptions = getUsernames(Planner.getUsers());

		advisorOptionsBox = new JComboBox<String>(advisorOptions);
		advisorOptionsBox.setBounds(100, 220, 200, 25);
		this.add(advisorOptionsBox);

		advisorOptionConfirmBtn = new JButton("Confirm");
		advisorOptionConfirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(String username : advisorOptions){
					if(((String) advisorOptionsBox.getSelectedItem() == username)){
						dispose();
						new StudentPage(username, true, adminUsername);
					}
				}
				
			}
		});
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
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				Planner.homepage();
			}
		});
		advisorLogoutBtn.setBounds(1200, 20, 150, 30);
		add(advisorLogoutBtn);

		this.setVisible(true);
	}

	public static String[] getUsernames(ArrayList<String> users){
		ArrayList<String> usernames = new ArrayList<String>();
		for(int i = 0; i < users.size(); i++){
			String currentLine = users.get(i);
			String[] fields = currentLine.split(" ");
			String currentUsername = fields[0];
			if(currentUsername.substring(0, 2).equals("SS"))
				usernames.add(currentUsername);
		}

		String[] final_arr = new String[usernames.size()];
		for(int i = 0; i < usernames.size(); i++)
			final_arr[i] = usernames.get(i);
		return final_arr;
	}

	

	public static void main(String[] args) {
		Planner.readFile();
		new AdvisorPage(null);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
	}

}