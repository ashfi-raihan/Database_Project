package GUI.Sell;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Entity.*;
import EntityList.*;
import File.ProductIO.*;
import GUI.*;

public class SellPage extends JFrame implements ActionListener {
    Font font30B = new Font("Segoe UI",Font.BOLD,30);
	Font font20 = new Font("Segoe UI",Font.PLAIN,20);
	Font font15 = new Font("Segoe UI",Font.PLAIN,15);
	
	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	
	JPanel topPanel,leftPanel,rightPanel,bottomPanel;
	JButton backButton,homeButton,buyBtn;
	JTextArea itemsTextArea, soldTextArea;
	JScrollPane itemsJsp,soldJsp;
	

    JTextField productId;
	
	SellList products = new SellList();
	//ProductList productList = new ProductList();
   

    public SellPage() {
        super("Sell Page");
		this.setSize(1000,700);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.products=products;
		
		//=========================TOP PANEL===========================
		topPanel = new JPanel();
		topPanel.setBounds(0,0,1000,80); //x,y,w,h
		topPanel.setLayout(null);
		//topPanel.setBackground(Color.cyan);
		
		//------------------Welcome-------------------
		JLabel title = new JLabel("Welcome to Our Shop");
		title.setBounds(200,15,700,50); //x,y,w,h
		title.setFont(font30B);
		topPanel.add(title);
		
		this.add(topPanel);
		
		//=========================LEFT PANEL===========================
		leftPanel = new JPanel();
		leftPanel.setBounds(0,80,500,550);
		leftPanel.setLayout(null);
		leftPanel.setBackground(new Color(102,178,255));
		
		itemsTextArea = new JTextArea();
		itemsTextArea.setFont(font20);
		itemsTextArea.setEditable(false);
		
		itemsJsp = new JScrollPane(itemsTextArea);
		itemsJsp.setBounds(25,50,450,470);
		leftPanel.add(itemsJsp);
		
		ProductFileIO.loadProductForSell(products);
		itemsTextArea.setText(products.getAllSellProductAsString());
		
		this.add(leftPanel);
		//=========================RIGHT PANEL===========================
		rightPanel = new JPanel();
		rightPanel.setBounds(500,80,500,550);
		rightPanel.setLayout(null);
		rightPanel.setBackground(new Color(153,153,255));
		
		
		//--------------------------- ID ------------------------------
		
		int vpose = 30;
		// Branch ID Label
        JLabel productIdLabel = new JLabel("Enter Product ID");
        productIdLabel.setBounds(vpose, 30, 150, 30); // x,y,w,h
        productIdLabel.setFont(font20);
        rightPanel.add(productIdLabel);

        // Branch ID TextField
        productId = new JTextField();
        productId.setBounds(vpose+160, 30, 200, 30); // x,y,w,h
        productId.setFont(font15);
        rightPanel.add(productId);
		// Buy Button
		buyBtn = new JButton("Buy");
		buyBtn.setBounds(vpose+370, 30, 60, 30);
		buyBtn.setCursor(cursor);
		buyBtn.setBackground(Color.orange);
		buyBtn.setFocusable(false);
		buyBtn.addActionListener(this);
		rightPanel.add(buyBtn);
		
		
		soldTextArea = new JTextArea();
		soldTextArea.setFont(font15);
		soldTextArea.setEditable(false);
		
		soldTextArea.setText("=============================================\n"+
								"\t"+"Welcome to Groceteria"+"\n"+
				   "============================================"+"\n\n\n");
		
		soldJsp = new JScrollPane(soldTextArea);
		soldJsp.setBounds(60,80,360,460);
		rightPanel.add(soldJsp);
        
		
		this.add(rightPanel);
		//=========================BOTTOM PANEL===========================
		bottomPanel = new JPanel();
		bottomPanel.setBounds(0,620,1000,80);
		bottomPanel.setLayout(null);
		//bottomPanel.setBackground(Color.cyan);
		
		//Back Button
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
      	homeButton = new JButton("Procced->");
      	homeButton.setBounds(880,10,110, 30);
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
	
	double bill = 0;
	
	public void actionPerformed(ActionEvent e){
		
		if (e.getSource() == backButton){
			new CustomerLoginPage();
			this.dispose();
		}
		if (e.getSource() == homeButton) {
  			new Payment(bill);
  			this.dispose();
		}	
		if(e.getSource() == buyBtn){
			Product p = products.getByProductId(productId.getText());
			soldTextArea.setText(soldTextArea.getText() + p.getSellProductAsString());
			productId.setText("");
			bill += p.getProductPrice();
			System.out.println(bill);
		}
	}
	
}