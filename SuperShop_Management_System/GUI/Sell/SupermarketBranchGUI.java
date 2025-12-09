//package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SupermarketBranchGUI extends JFrame implements ActionListener {
    Font font30B = new Font("Segoe UI",Font.BOLD,30);
	Font font20P = new Font("Segoe UI",Font.PLAIN,20);
	Font font15P = new Font("Segoe UI",Font.PLAIN,15);
	
	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	
	JPanel topPanel,leftPanel,rightPanel,bottomPanel;
	JButton backButton,homeButton,saveBtn;
	

    JTextField branchIdField, branchNameField, locationField, totalEmployeesField;
   

    public SupermarketBranchGUI() {
        super("Branch Page");
		this.setSize(1000,700);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//=========================TOP PANEL===========================
		topPanel = new JPanel();
		topPanel.setBounds(0,0,1000,80); //x,y,w,h
		topPanel.setLayout(null);
		//topPanel.setBackground(Color.cyan);
		
		//------------------Welcome-------------------
		JLabel title = new JLabel("Welcome to Employee Management Page");
		title.setBounds(200,15,700,50); //x,y,w,h
		title.setFont(font30B);
		topPanel.add(title);
		
		this.add(topPanel);
		
		//=========================LEFT PANEL===========================
		leftPanel = new JPanel();
		leftPanel.setBounds(0,80,400,540);
		leftPanel.setLayout(null);
		leftPanel.setBackground(new Color(102,178,255));
		
		
		
		
		this.add(leftPanel);
		//=========================RIGHT PANEL===========================
		rightPanel = new JPanel();
		rightPanel.setBounds(400,80,600,540);
		rightPanel.setLayout(null);
		rightPanel.setBackground(new Color(153,153,255));
		
		 // Branch ID Label
        JLabel branchIdLabel = new JLabel("Branch ID");
        branchIdLabel.setBounds(10, 60, 150, 30); // x,y,w,h
        branchIdLabel.setFont(font20);
        this.add(branchIdLabel);

        // Branch ID TextField
        branchIdField = new JTextField();
        branchIdField.setBounds(170, 60, 200, 30); // x,y,w,h
        branchIdField.setFont(font20);
        this.add(branchIdField);

        // Branch Name Label
        JLabel branchNameLabel = new JLabel("Branch Name");
        branchNameLabel.setBounds(10, 100, 150, 30); // x,y,w,h
        branchNameLabel.setFont(font20);
        this.add(branchNameLabel);

        // Branch Name TextField
        branchNameField = new JTextField();
        branchNameField.setBounds(170, 100, 200, 30); // x,y,w,h
        branchNameField.setFont(font20);
        this.add(branchNameField);

        // Location Label
        JLabel locationLabel = new JLabel("Location");
        locationLabel.setBounds(10, 140, 150, 30); // x,y,w,h
        locationLabel.setFont(font20);
        this.add(locationLabel);

        // Location TextField
        locationField = new JTextField();
        locationField.setBounds(170, 140, 200, 30); // x,y,w,h
        locationField.setFont(font20);
        this.add(locationField);

        // Total Employees Label
        JLabel totalEmployeesLabel = new JLabel("Total Employees");
        totalEmployeesLabel.setBounds(10, 180, 150, 30); // x,y,w,h
        totalEmployeesLabel.setFont(font20);
        this.add(totalEmployeesLabel);

        // Total Employees TextField
        totalEmployeesField = new JTextField();
        totalEmployeesField.setBounds(170, 180, 200, 30); // x,y,w,h
        totalEmployeesField.setFont(font20);
        this.add(totalEmployeesField);

        // Save Button
        saveBtn = new JButton("Save");
        saveBtn.setBounds(170, 220, 200, 30); // x,y,w,h
        saveBtn.setFont(font20);
        saveBtn.addActionListener(this);
        this.add(saveBtn);
		
		this.add(rightPanel);
		//=========================BOTTOM PANEL===========================
		bottomPanel = new JPanel();
		bottomPanel.setBounds(0,620,1000,80);
		bottomPanel.setLayout(null);
		//bottomPanel.setBackground(Color.cyan);
		
		backButton = new JButton("<Back");
      	backButton.setBounds(0,10,100, 30);
      	backButton.setBackground(new Color(0x50AB60));
      	backButton.setForeground(Color.black);
      	backButton.setFocusable(false);
		backButton.setCursor(cursor);
      	backButton.setFont(font15);
      	//backButton.addActionListener(this);
      	bottomPanel.add(backButton);
		
      	 		//Home Button
      	homeButton = new JButton("<Home");
      	homeButton.setBounds(900,10,100, 30);
      	homeButton.setBackground(new Color(0x50AB60));
      	homeButton.setForeground(Color.black);
      	homeButton.setFocusable(false);
      	homeButton.setFont(font15);
		homeButton.setCursor(cursor);
      	//homeButton.addActionListener(this);
		bottomPanel.add(homeButton);
		
		this.add(bottomPanel);
		
		this.setVisible(true);
	/*
        // Welcome Title
        JLabel title = new JLabel("Supermarket Branch Management System");
        title.setBounds(100, 10, 500, 40); // x,y,w,h
        title.setFont(titleFont);
        this.add(title);

        // Branch ID Label
        JLabel branchIdLabel = new JLabel("Branch ID");
        branchIdLabel.setBounds(10, 60, 150, 30); // x,y,w,h
        branchIdLabel.setFont(font20);
        this.add(branchIdLabel);

        // Branch ID TextField
        branchIdField = new JTextField();
        branchIdField.setBounds(170, 60, 200, 30); // x,y,w,h
        branchIdField.setFont(font20);
        this.add(branchIdField);

        // Branch Name Label
        JLabel branchNameLabel = new JLabel("Branch Name");
        branchNameLabel.setBounds(10, 100, 150, 30); // x,y,w,h
        branchNameLabel.setFont(font20);
        this.add(branchNameLabel);

        // Branch Name TextField
        branchNameField = new JTextField();
        branchNameField.setBounds(170, 100, 200, 30); // x,y,w,h
        branchNameField.setFont(font20);
        this.add(branchNameField);

        // Location Label
        JLabel locationLabel = new JLabel("Location");
        locationLabel.setBounds(10, 140, 150, 30); // x,y,w,h
        locationLabel.setFont(font20);
        this.add(locationLabel);

        // Location TextField
        locationField = new JTextField();
        locationField.setBounds(170, 140, 200, 30); // x,y,w,h
        locationField.setFont(font20);
        this.add(locationField);

        // Total Employees Label
        JLabel totalEmployeesLabel = new JLabel("Total Employees");
        totalEmployeesLabel.setBounds(10, 180, 150, 30); // x,y,w,h
        totalEmployeesLabel.setFont(font20);
        this.add(totalEmployeesLabel);

        // Total Employees TextField
        totalEmployeesField = new JTextField();
        totalEmployeesField.setBounds(170, 180, 200, 30); // x,y,w,h
        totalEmployeesField.setFont(font20);
        this.add(totalEmployeesField);

        // Save Button
        saveBtn = new JButton("Save");
        saveBtn.setBounds(170, 220, 200, 30); // x,y,w,h
        saveBtn.setFont(font20);
        saveBtn.addActionListener(this);
        this.add(saveBtn);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveBtn) {
            System.out.println("Save Clicked");
            String branchId = branchIdField.getText();
            String branchName = branchNameField.getText();
            String location = locationField.getText();
            String totalEmployees = totalEmployeesField.getText();

            // Here you can add code to save the branch details
            // For now, just printing the input
            System.out.println("Branch ID: " + branchId);
            System.out.println("Branch Name: " + branchName);
            System.out.println("Location: " + location);
            System.out.println("Total Employees: " + totalEmployees);

            // Clearing the fields after processing
            branchIdField.setText("");
            branchNameField.setText("");
            locationField.setText("");
            totalEmployeesField.setText("");
        }
    }

    public static void main(String[] args) {
        // Creating an instance of the SupermarketBranchGUI class
        new SupermarketBranchGUI();
    }
	
	*/
}