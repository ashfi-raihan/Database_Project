package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import GUI.HomePage;

public class ProjectDetails implements ActionListener{

	JPanel topPanel, middlePanel, bottomPanel;
	JButton backButton;
	Font f40 = new Font("Serif", Font.BOLD, 40);
	Font f38 = new Font("Goudy Old Style", Font.BOLD, 38);
	JFrame frame;
	JLabel label, label2, label3, label4, label5, label6, label7, label8, label9;
	

	public ProjectDetails() {
		
		label = new JLabel("Project Details");
		label.setForeground(Color.magenta);
		label.setBounds(185, 15, 500, 90);
		label.setFont(new Font("Jokerman", Font.BOLD, 50));
		
		label2 = new JLabel("Project Title - ");
		label2.setForeground(Color.yellow);
		label2.setFont(f40);
		label2.setBounds(50, 45, 650, 50);
		
		label3 = new JLabel("Supershop Management System");
		label3.setForeground(Color.blue);
		label3.setFont(f38);
		label3.setBounds(90, 90, 660, 50);
		
		label4 = new JLabel("Project Idea - ");
		label4.setForeground(Color.yellow);
		label4.setFont(f40);
		label4.setBounds(50, 350, 650, 50);
		
		label5 = new JLabel("The main intention of our project is to show");
		label5.setForeground(Color.blue);
		label5.setFont(f38);
		label5.setBounds(90, 400, 660, 50);
		
		label6 = new JLabel("all the management system of a Supershop.");
		label6.setForeground(Color.blue);
		label6.setFont(f38);
		label6.setBounds(50, 450, 700, 50);
        
      //Back button
      	backButton = new JButton("<Back");
      	backButton.setBounds(630, 3, 100, 30);
      	backButton.setBackground(new Color(0x50AB60));
      	backButton.setForeground(Color.white);
      	backButton.setFocusable(false);
      	backButton.addActionListener(this);
        
        topPanel = new JPanel();
		topPanel.setBounds(0, 0, 750, 100);
		topPanel.add(label);
		topPanel.setLayout(null);
		topPanel.setBackground(Color.cyan);
		
		middlePanel = new JPanel();
		middlePanel.setBounds(0, 100, 750, 575);
		middlePanel.setLayout(null);
		middlePanel.setBackground(Color.gray);
		middlePanel.add(label2);
		middlePanel.add(label3);
		middlePanel.add(label4);
		middlePanel.add(label5);
		middlePanel.add(label6);
		
		
		
		bottomPanel = new JPanel();
		bottomPanel.setLayout(null);
		bottomPanel.setBounds(0, 675, 750, 75);
		bottomPanel.setBackground(Color.cyan);
		bottomPanel.add(backButton);
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750, 750);
		frame.setTitle("Project Details Page");
		frame.setLocation(400, 50);
		frame.setLayout(null);
		frame.add(topPanel);
		frame.add(middlePanel);
		frame.add(bottomPanel);
		frame.setResizable(false);
		frame.setVisible(true);
	}
        
        @Override
        public void actionPerformed(ActionEvent e){
    		
    		if (e.getSource() == backButton){
    			new HomePage();
    			frame.dispose();
    		}
    	}
	

}
