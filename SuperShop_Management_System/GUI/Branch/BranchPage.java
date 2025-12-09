package GUI.Branch;

import Entity.*;
import EntityList.*;
import GUI.*;
import File.BranchIO.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class BranchPage extends JFrame  implements ActionListener{
	Font font30B = new Font("Segoe UI",Font.BOLD,30);
	Font font20 = new Font("Segoe UI",Font.PLAIN,20);
	Font font20B = new Font("Segoe UI",Font.BOLD,20);
	Font font15 = new Font("Segoe UI",Font.PLAIN,15);
	
	
	JTextField name,id,location,totalEmployees;
	JTextArea textArea;
	JScrollPane jsp;
	JPanel topPanel,leftPanel,rightPanel,bottomPanel; 
	JButton deleteBtn,addBtn,backButton,homeButton,searchBtn,updateBtn,clear;
	
	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	
	JComboBox comboBox;
	
	public BranchPage(){
		
		super("Branch Page");
		this.setSize(1000,700);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.branches = branches;
		
		
		//=========================TOP PANEL===========================
		topPanel = new JPanel();
		topPanel.setBounds(0,0,1000,80); //x,y,w,h
		topPanel.setLayout(null);
		
		//------------------Welcome-------------------
		JLabel title = new JLabel("Welcome to Branch Management Page");
		title.setBounds(200,15,700,50); //x,y,w,h
		title.setFont(font30B);
		topPanel.add(title);
		
		this.add(topPanel);
		
		
		//=========================LEFT PANEL===========================
		leftPanel = new JPanel();
		leftPanel.setBounds(0,80,600,550);
		leftPanel.setLayout(null);
		leftPanel.setBackground(new Color(153,153,255));
		
		
		int vPos = 110;
		int gap=70;
		int lblsize=150;
		int txtfieldsize=300;
		//---------------------Name---------------------
		JLabel nameLabel = new JLabel("Branch Name");
		nameLabel.setBounds(60,vPos,lblsize,30); //x,y,w,h
		nameLabel.setFont(font20);
		leftPanel.add(nameLabel);
		
		//Name TextField
		name = new JTextField();
		name.setBounds(220,vPos,txtfieldsize,30); //x,y,w,h
		name.setFont(font20);
		leftPanel.add(name);
		
		vPos+=gap;
		//--------------------Id------------------------
		JLabel idLabel = new JLabel("Branch ID");
		idLabel.setBounds(60,vPos,lblsize,30); //x,y,w,h
		idLabel.setFont(font20);
		leftPanel.add(idLabel);

		id = new JTextField();
		id.setBounds(220,vPos,txtfieldsize,30); //x,y,w,h
		id.setFont(font20);
		leftPanel.add(id);
		
		vPos+=gap;
		//-----------------------Location-------------------
		JLabel locationLabel = new JLabel("Branch Location");
		locationLabel.setBounds(60,vPos,lblsize,30); //x,y,w,h
		locationLabel.setFont(font20);
		leftPanel.add(locationLabel);

		location = new JTextField();
		location.setBounds(220,vPos,txtfieldsize,30); //x,y,w,h
		location.setFont(font20);
		leftPanel.add(location);
		
		vPos+=gap;
		//-------------------Total Employees------------------
		JLabel totalEmployeesLabel = new JLabel("Total Employees");
		totalEmployeesLabel.setBounds(60,vPos,lblsize,30); //x,y,w,h
		totalEmployeesLabel.setFont(font20);
		leftPanel.add(totalEmployeesLabel);

		totalEmployees = new JTextField();
		totalEmployees.setBounds(220,vPos,txtfieldsize,30); //x,y,w,h
		totalEmployees.setFont(font20);
		leftPanel.add(totalEmployees);
		
		
		//------------------ Buttons ------------------------
		int btnhpos =20;
		int btnhgap =130;
		int btnvpos =440;
		
		//Add Button
		addBtn = new JButton("Add");
		addBtn.setBounds(btnhpos,btnvpos,100,30); //x,y,w,h
		addBtn.setFont(font20);
		addBtn.setBackground(new Color(87,70,229));
		addBtn.setForeground(Color.WHITE);
		addBtn.setCursor(cursor);
		addBtn.addActionListener(this);
		leftPanel.add(addBtn);
		
		btnhpos += btnhgap;
		
		//Delete Button
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(btnhpos,btnvpos,120,30); //x,y,w,h
		deleteBtn.setFont(font20);
		deleteBtn.setBackground(Color.RED);
		deleteBtn.setForeground(Color.WHITE);
		deleteBtn.setCursor(cursor);
		deleteBtn.addActionListener(this);
		leftPanel.add(deleteBtn);
		
		btnhpos += btnhgap;
		
		//Update Button
		updateBtn = new JButton("Update");
		updateBtn.setBounds(btnhpos+10,btnvpos,100,30); //x,y,w,h
		updateBtn.setFont(font20);
		updateBtn.setBackground(new Color(87,70,229));
		updateBtn.setForeground(Color.WHITE);
		updateBtn.setCursor(cursor);
		updateBtn.addActionListener(this);
		leftPanel.add(updateBtn);
		
		btnhpos += btnhgap;
		
		//Search Button
		searchBtn = new JButton("Search");
		searchBtn.setBounds(btnhpos,btnvpos,120,30); //x,y,w,h
		searchBtn.setFont(font20);
		searchBtn.setBackground(Color.RED);
		searchBtn.setForeground(Color.WHITE);
		searchBtn.setCursor(cursor);
		searchBtn.addActionListener(this);
		leftPanel.add(searchBtn);
		
		
		//Clear Button
		clear = new JButton("Clear");
		clear.setBounds(370,370,90,30); //x,y,w,h
		clear.setFont(font20);
		clear.setBackground(Color.RED);
		clear.setForeground(Color.WHITE);
		clear.setCursor(cursor);
		clear.addActionListener(this);
		leftPanel.add(clear);
		
		btnhpos += btnhgap;
		
		this.add(leftPanel);
		//=========================RIGHT PANEL===========================
		rightPanel = new JPanel();
		rightPanel.setBounds(600,80,400,550);
		rightPanel.setLayout(null);
		rightPanel.setBackground(new Color(102,178,255));
		
		//------------------Text Area -------------------

		textArea = new JTextArea();
		textArea.setFont(font15);
		
		JScrollPane jsp = new JScrollPane(textArea);
		jsp.setBounds(13, 13, 360, 525);
		rightPanel.add(jsp);
		BranchFileIO.loadAllBranch(branches);
		updateTextArea();
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
      	backButton.addActionListener(this);
      	bottomPanel.add(backButton);
		
      	 		//Home Button
      	homeButton = new JButton("<Home");
      	homeButton.setBounds(900,10,100, 30);
      	homeButton.setBackground(new Color(0x50AB60));
      	homeButton.setForeground(Color.black);
      	homeButton.setFocusable(false);
      	homeButton.setFont(font15);
		homeButton.setCursor(cursor);
      	homeButton.addActionListener(this);
		bottomPanel.add(homeButton);
		
		this.add(bottomPanel);
		
		this.setVisible(true);
	}
	
	BranchList branches = new BranchList();
		
	@Override
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == addBtn){
			try{
				Branch b = new Branch(name.getText(),id.getText(),location.getText(),
								Integer.parseInt(totalEmployees.getText()));
								
				branches.insert(b);
				BranchFileIO.addBranch(b);
				updateTextArea();
			}
			catch(NumberFormatException er){
				JOptionPane.showMessageDialog(this, "Invalid input! Enter Age & Salary in number format", "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch(Exception er){
				JOptionPane.showMessageDialog(this, "Invalid input! Enter ID in number format", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(e.getSource() == deleteBtn){
			Branch b = branches.getById(id.getText());
			if(b != null){
				branches.removeById(id.getText());
				updateTextArea();
				JOptionPane.showMessageDialog(this,"Branch Deleted");
			}
			else{
				JOptionPane.showMessageDialog(this,"Branch Not Found", "Warning",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(e.getSource() == updateBtn){
			try{
				Branch tempB = new Branch(name.getText(),id.getText(),location.getText(),
								Integer.parseInt(totalEmployees.getText()));
				Branch b = branches.getById(id.getText());
				branches.removeById(id.getText());
				if(b != null){
					b = tempB;
					branches.insert(tempB);
					updateTextArea();
					JOptionPane.showMessageDialog(this,"Information Updated");
				}
				else{
					JOptionPane.showMessageDialog(this,"Employee Not Found", "Warning",JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(NumberFormatException er){
				JOptionPane.showMessageDialog(this, "Invalid input! Enter Age & Salary in number format", "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch(Exception er){
				JOptionPane.showMessageDialog(this, "Invalid input! Enter ID in number format", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(e.getSource() == searchBtn){
			Branch b = branches.getById(id.getText());
			if(b != null){
				JOptionPane.showMessageDialog(this,b.getBranchAsString());
			}
			else{
				JOptionPane.showMessageDialog(this,"Branch Not Found", "Warning",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() == clear){
			
			name.setText("");
			id.setText("");
			location.setText("");
			totalEmployees.setText("");
		}
		if(e.getSource() == backButton){
			new HomePage();
			this.dispose();	
		}
		if(e.getSource() == homeButton){
			new HomePage();
			this.dispose();	
		}
	}

	public void updateTextArea(){
		textArea.setText(branches.getAllBranchAsString());
	}


}
