package atmdbank;

import java.awt.GridLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TransferMoney extends JFrame {

	private ComparingIBAN comparingIBANClass = new ComparingIBAN();
	private UserDTO newUser;

	private JPanel transferPanel;
	private JPanel transferSubPanel;
	
	private JButton firstButton;
	private JButton secondButton;
	private JButton thirdButton;
	private JButton returnButton;
	
	private ArrayList<UserDTO>userList;
	private Scanner reader;
	private String oldLine;
	private String[] tokens;
	
	
	private String name;
	private String surname;
	private int ID;
	private int Pass;
	private float balance;
	private int IBAN;
	
	public void transferMoney(Object o) throws IOException {
		
		setTitle("Transfer Money Screen");
		setSize(500,500);
		setLocation(400,400);
		
		userList = new ArrayList<UserDTO>();
		
		oldLine = o.toString();
		
		tokens = oldLine.split(",");
		
		File read = new File("UserDTO.txt");
		reader = new Scanner(read);
		
		name = tokens[0];
		surname = tokens[1];
		ID = Integer.parseInt(tokens[2]);
		Pass = Integer.parseInt(tokens[3]);
		balance = Float.valueOf(tokens[4]);
		IBAN = Integer.parseInt(tokens[5]);
		
		
		transferPanel = new JPanel();
	
		transferPanel.setBackground(Color.CYAN);
		
		transferPanel.setBorder(BorderFactory.createTitledBorder("Your Current Balance is " +tokens[4]+ " Please select an option"));
		
		transferSubPanel = new JPanel(new GridLayout(4,1));
		
		
		firstButton = new JButton("1) DBank To DBank");
		firstButton.addActionListener(new FirstButtonListener());
		
		firstButton.setBackground(Color.BLACK);
		firstButton.setForeground(Color.MAGENTA);
		firstButton.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		secondButton = new JButton("2) DBank To Other Bank");
		secondButton.addActionListener(new SecondButtonListener());
		
		secondButton.setBackground(Color.BLACK);
		secondButton.setForeground(Color.MAGENTA);
		secondButton.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		thirdButton = new JButton("3) DBank To Foreign Bank");	
		thirdButton.addActionListener(new ThirdButtonListener());
		
		thirdButton.setBackground(Color.BLACK);
		thirdButton.setForeground(Color.MAGENTA);
		thirdButton.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		returnButton = new JButton("RETURN");
		returnButton.addActionListener(new ReturnListener());
		
		returnButton.setBackground(Color.BLACK);
		returnButton.setForeground(Color.PINK);
		returnButton.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		transferSubPanel.add(firstButton);
		transferSubPanel.add(secondButton);
		transferSubPanel.add(thirdButton);
		transferSubPanel.add(returnButton);
		
		transferPanel.add(transferSubPanel);
		
		add(transferPanel);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	private class FirstButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent b) {
			
			setVisible(false);
			
			JFrame jf = new JFrame();
			
			jf.setTitle("First Button Screen");
			jf.setSize(500,500);
			jf.setLocation(400,400);
			
			jf.getContentPane().setBackground(Color.CYAN);
			
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(3,2));
			
			JLabel labelIBAN = new JLabel("Please enter other customer's IBAN");
			JTextField textIBAN = new JTextField(15);
			
			JLabel labelTransferingAmount = new JLabel("Please enter amount");
			JTextField textAmount = new JTextField(15);
			
			JButton admit = new JButton("ADMIT");
			
			admit.setBackground(Color.BLACK);
			admit.setForeground(Color.MAGENTA);
			admit.setFont(new Font("Times New Roman",Font.BOLD,15));
			
			admit.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent b) {
					
					jf.setVisible(false);
					
					String forIBAN = textIBAN.getText();
					String  forAmount= textAmount.getText();
					
					int otherCustomerIBAN = Integer.parseInt(forIBAN);
					int transferingAmount = Integer.parseInt(forAmount);
					
					
					StringBuffer buffer = new StringBuffer();
					
					while(reader.hasNextLine()) {
						buffer.append(reader.nextLine()+System.lineSeparator());
					}
					
					String fileContents = buffer.toString();
					
					reader.close();
					
					
					if(balance>=transferingAmount) {
						
						if(transferingAmount %10 == 0) {
								
							float total = balance - transferingAmount;
					
							userList.add(new UserDTO(name,surname,ID,Pass,total,IBAN));
							
							try {

								FileWriter fw = new FileWriter("UserDTO.txt");
								
								ImageIcon icon = new ImageIcon(TransferMoney.class.getResource("/Dollar.png"));
								JOptionPane.showMessageDialog(null,"Successful","Your operation is done",JOptionPane.INFORMATION_MESSAGE,icon);
								
									
								for(UserDTO e : userList) {
											
									String newLine = e.toString();
									fileContents = fileContents.replaceAll(oldLine, newLine);
									
									String [] tokensForNewLine = newLine.split(",");
									
									transferPanel.setBorder(BorderFactory.createTitledBorder(" Your current balance is "+tokensForNewLine[4]));	
									
									float newCurrentBalance = Float.valueOf(tokensForNewLine[4]);
									
									newUser = new UserDTO(name,surname,ID,Pass,newCurrentBalance,IBAN);
									
									setVisible(false);
									
								}
									
								fw.append(fileContents);
								fw.flush();
								fw.close();
									
								comparingIBANClass.Transfering(transferingAmount, otherCustomerIBAN);
								
								TransferMoney transferMoneyClass = new TransferMoney();
								transferMoneyClass.transferMoney(newUser);
							
							}
							catch(IOException e) {
								e.printStackTrace();
							}
								
						}
							
						else {
								
							ImageIcon image = new ImageIcon(TransferMoney.class.getResource("/error.png"));
								
							JOptionPane.showMessageDialog(null,"Unsuccessful ","Please enter multiples of 10!",JOptionPane.INFORMATION_MESSAGE,image);
								
							setVisible(false);
								
							String [] tokens = oldLine.split(",");
								
							String sendName = tokens[0];
							String sendSurname = tokens[1];
							int sendID = Integer.parseInt(tokens[2]);
							int sendPass = Integer.parseInt(tokens[3]);
							float sendBalance = Float.valueOf(tokens[4]);
							int sendIBAN = Integer.parseInt(tokens[5]);
								
							UserDTO sendUser = new UserDTO(sendName,sendSurname,sendID,sendPass,sendBalance,sendIBAN);
								
							UserScreen userScreenClass = new UserScreen();
							userScreenClass.userScreen(sendUser);
								
						}
					}
						
					else {
							
						ImageIcon image = new ImageIcon(TransferMoney.class.getResource("/error.png"));
							
						JOptionPane.showMessageDialog(null,"Unsuccessful ","Cannot withdraw this amount!",JOptionPane.INFORMATION_MESSAGE,image);
										
						setVisible(false);
							
						String [] tokens = oldLine.split(",");
							
						String sendName = tokens[0];
						String sendSurname = tokens[1];
						int sendID = Integer.parseInt(tokens[2]);
						int sendPass = Integer.parseInt(tokens[3]);
						float sendBalance = Float.valueOf(tokens[4]);
						int sendIBAN = Integer.parseInt(tokens[5]);
							
						UserDTO sendUser = new UserDTO(sendName,sendSurname,sendID,sendPass,sendBalance,sendIBAN);
							
						UserScreen userScreenClass = new UserScreen();
						userScreenClass.userScreen(sendUser);
					}
			
				}
			});
			JButton cancel = new JButton("CANCEL");
			
			cancel.setBackground(Color.BLACK);
			cancel.setForeground(Color.MAGENTA);
			cancel.setFont(new Font("Times New Roman",Font.BOLD,15));
			
			cancel.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					jf.setVisible(false);
					
					String [] tokens = oldLine.split(",");
					
					String sendName = tokens[0];
					String sendSurname = tokens[1];
					int sendID = Integer.parseInt(tokens[2]);
					int sendPass = Integer.parseInt(tokens[3]);
					float sendBalance = Float.valueOf(tokens[4]);
					int sendIBAN = Integer.parseInt(tokens[5]);
					
					UserDTO sendUser = new UserDTO(sendName,sendSurname,sendID,sendPass,sendBalance,sendIBAN);
					
					UserScreen userScreenClass = new UserScreen();
					userScreenClass.userScreen(sendUser);
				}
			});
			
			panel.add(labelIBAN);
			panel.add(textIBAN);
			panel.add(labelTransferingAmount);
			panel.add(textAmount);
			panel.add(admit);
			panel.add(cancel);
			
			jf.add(panel);
			jf.setLayout(new FlowLayout());
			
			jf.setVisible(true);
			jf.setResizable(false);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	
	}
	private class SecondButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent b) {
			
			setVisible(false);
			
			JFrame jf = new JFrame();
			
			jf.setTitle("Second Button Screen");
			jf.setSize(500,500);
			jf.setLocation(400,400);
			
			jf.getContentPane().setBackground(Color.CYAN);
			
			JPanel borderPanel = new JPanel();
			borderPanel.setBorder(BorderFactory.createTitledBorder("10 TL will be charged during this operation"));
			borderPanel.setBackground(Color.WHITE);
			
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(3,2));
			
			JLabel labelIBAN = new JLabel("Please enter other customer's IBAN");
			JTextField textIBAN = new JTextField(15);
			
			JLabel labelTransferingAmount = new JLabel("Please enter amount");
			JTextField textAmount = new JTextField(15);
			
			JButton admit = new JButton("ADMIT");
			
			admit.setBackground(Color.BLACK);
			admit.setForeground(Color.MAGENTA);
			admit.setFont(new Font("Times New Roman",Font.BOLD,15));
			
			admit.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent b) {
					
					jf.setVisible(false);
					
					String  forAmount= textAmount.getText();
					int transferingAmount = Integer.parseInt(forAmount);
					
					
					StringBuffer buffer = new StringBuffer();
					
					while(reader.hasNextLine()) {
						buffer.append(reader.nextLine()+System.lineSeparator());
					}
					
					String fileContents = buffer.toString();
					
					reader.close();
					
					
					if(balance>=(transferingAmount+10)) {
						
						if(transferingAmount %10 == 0) {
								
							float total = balance - (transferingAmount+10);
					
							userList.add(new UserDTO(name,surname,ID,Pass,total,IBAN));
							
							try {

								FileWriter fw = new FileWriter("UserDTO.txt");
								
								ImageIcon icon = new ImageIcon(TransferMoney.class.getResource("/Dollar.png"));
								JOptionPane.showMessageDialog(null,"Successful","Your operation is done",JOptionPane.INFORMATION_MESSAGE,icon);
								
									
								for(UserDTO e : userList) {
											
									String newLine = e.toString();
									fileContents = fileContents.replaceAll(oldLine, newLine);
									
									String [] tokensForNewLine = newLine.split(",");
									
									transferPanel.setBorder(BorderFactory.createTitledBorder(" Your current balance is "+tokensForNewLine[4]));	
									
									float newCurrentBalance = Float.valueOf(tokensForNewLine[4]);
									
									newUser = new UserDTO(name,surname,ID,Pass,newCurrentBalance,IBAN);
									
									setVisible(false);
									
								}
									
								fw.append(fileContents);
								fw.flush();
								fw.close();
								
								TransferMoney transferMoneyClass = new TransferMoney();
								transferMoneyClass.transferMoney(newUser);
							
							}
							catch(IOException e) {
								e.printStackTrace();
							}
								
						}
							
						else {
								
							ImageIcon image = new ImageIcon(TransferMoney.class.getResource("/error.png"));
								
							JOptionPane.showMessageDialog(null,"Unsuccessful ","Please enter multiples of 10!",JOptionPane.INFORMATION_MESSAGE,image);
								
							setVisible(false);
								
							String [] tokens = oldLine.split(",");
								
							String sendName = tokens[0];
							String sendSurname = tokens[1];
							int sendID = Integer.parseInt(tokens[2]);
							int sendPass = Integer.parseInt(tokens[3]);
							float sendBalance = Float.valueOf(tokens[4]);
							int sendIBAN = Integer.parseInt(tokens[5]);
								
							UserDTO sendUser = new UserDTO(sendName,sendSurname,sendID,sendPass,sendBalance,sendIBAN);
								
							UserScreen userScreenClass = new UserScreen();
							userScreenClass.userScreen(sendUser);
								
						}
					}
						
					else {
							
						ImageIcon image = new ImageIcon(TransferMoney.class.getResource("/error.png"));
							
						JOptionPane.showMessageDialog(null,"Unsuccessful ","Cannot withdraw this amount!",JOptionPane.INFORMATION_MESSAGE,image);
										
						setVisible(false);
							
						String [] tokens = oldLine.split(",");
							
						String sendName = tokens[0];
						String sendSurname = tokens[1];
						int sendID = Integer.parseInt(tokens[2]);
						int sendPass = Integer.parseInt(tokens[3]);
						float sendBalance = Float.valueOf(tokens[4]);
						int sendIBAN = Integer.parseInt(tokens[5]);
							
						UserDTO sendUser = new UserDTO(sendName,sendSurname,sendID,sendPass,sendBalance,sendIBAN);
							
						UserScreen userScreenClass = new UserScreen();
						userScreenClass.userScreen(sendUser);
					}
			
				}
			});
			JButton cancel = new JButton("CANCEL");
			
			cancel.setBackground(Color.BLACK);
			cancel.setForeground(Color.MAGENTA);
			cancel.setFont(new Font("Times New Roman",Font.BOLD,15));
			
			cancel.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					jf.setVisible(false);
					
					String [] tokens = oldLine.split(",");
					
					String sendName = tokens[0];
					String sendSurname = tokens[1];
					int sendID = Integer.parseInt(tokens[2]);
					int sendPass = Integer.parseInt(tokens[3]);
					float sendBalance = Float.valueOf(tokens[4]);
					int sendIBAN = Integer.parseInt(tokens[5]);
					
					UserDTO sendUser = new UserDTO(sendName,sendSurname,sendID,sendPass,sendBalance,sendIBAN);
					
					UserScreen userScreenClass = new UserScreen();
					userScreenClass.userScreen(sendUser);
				}
			});
			
			panel.add(labelIBAN);
			panel.add(textIBAN);
			panel.add(labelTransferingAmount);
			panel.add(textAmount);
			panel.add(admit);
			panel.add(cancel);
			
			borderPanel.add(panel);
			
			jf.add(borderPanel);
			jf.setLayout(new FlowLayout());
			
			jf.setVisible(true);
			jf.setResizable(false);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	
			
	}
	private class ThirdButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent b) {
			
			setVisible(false);
			
			JFrame jf = new JFrame();
			
			jf.setTitle("Third Button Screen");
			jf.setSize(500,500);
			jf.setLocation(400,400);
			
			jf.getContentPane().setBackground(Color.CYAN);
			
			JPanel borderPanel = new JPanel();
			borderPanel.setBorder(BorderFactory.createTitledBorder("50 TL will be charged during this operation"));
			borderPanel.setBackground(Color.WHITE);
			
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(3,2));
			
			JLabel labelIBAN = new JLabel("Please enter other customer's IBAN");
			JTextField textIBAN = new JTextField(15);
			
			JLabel labelTransferingAmount = new JLabel("Please enter amount");
			JTextField textAmount = new JTextField(15);
			
			JButton admit = new JButton("ADMIT");
			
			admit.setBackground(Color.BLACK);
			admit.setForeground(Color.MAGENTA);
			admit.setFont(new Font("Times New Roman",Font.BOLD,15));
			
			admit.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent b) {
					
					jf.setVisible(false);
					
					String  forAmount= textAmount.getText();
					int transferingAmount = Integer.parseInt(forAmount);//////
					
					
					StringBuffer buffer = new StringBuffer();
					
					while(reader.hasNextLine()) {
						buffer.append(reader.nextLine()+System.lineSeparator());
					}
					
					String fileContents = buffer.toString();
					
					reader.close();
					
					
					if(balance>=(transferingAmount+50)) {
						
						if(transferingAmount %10 == 0) {
								
							float total = balance - (transferingAmount+50);
					
							userList.add(new UserDTO(name,surname,ID,Pass,total,IBAN));
							
							try {

								FileWriter fw = new FileWriter("UserDTO.txt");
								
								ImageIcon icon = new ImageIcon(TransferMoney.class.getResource("/Dollar.png"));
								JOptionPane.showMessageDialog(null,"Successful","Your operation is done",JOptionPane.INFORMATION_MESSAGE,icon);
								
									
								for(UserDTO e : userList) {
											
									String newLine = e.toString();
									fileContents = fileContents.replaceAll(oldLine, newLine);
									
									String [] tokensForNewLine = newLine.split(",");
									
									transferPanel.setBorder(BorderFactory.createTitledBorder(" Your current balance is "+tokensForNewLine[4]));	
									
									float newCurrentBalance = Float.valueOf(tokensForNewLine[4]);
									
									newUser = new UserDTO(name,surname,ID,Pass,newCurrentBalance,IBAN);
									
									setVisible(false);
									
								}
									
								fw.append(fileContents);
								fw.flush();
								fw.close();
								
								TransferMoney transferMoneyClass = new TransferMoney();
								transferMoneyClass.transferMoney(newUser);
							
							}
							catch(IOException e) {
								e.printStackTrace();
							}
								
						}
							
						else {
							
							ImageIcon image = new ImageIcon(TransferMoney.class.getResource("/error.png"));
								
							JOptionPane.showMessageDialog(null,"Unsuccessful ","Please enter multiples of 10!",JOptionPane.INFORMATION_MESSAGE,image);
								
							setVisible(false);
								
							String [] tokens = oldLine.split(",");
								
							String sendName = tokens[0];
							String sendSurname = tokens[1];
							int sendID = Integer.parseInt(tokens[2]);
							int sendPass = Integer.parseInt(tokens[3]);
							float sendBalance = Float.valueOf(tokens[4]);
							int sendIBAN = Integer.parseInt(tokens[5]);
								
							UserDTO sendUser = new UserDTO(sendName,sendSurname,sendID,sendPass,sendBalance,sendIBAN);
								
							UserScreen userScreenClass = new UserScreen();
							userScreenClass.userScreen(sendUser);
								
						}
					}
						
					else {
						
						ImageIcon image = new ImageIcon(TransferMoney.class.getResource("/error.png"));
							
						JOptionPane.showMessageDialog(null,"Unsuccessful ","Cannot withdraw this amount!",JOptionPane.INFORMATION_MESSAGE,image);
										
						setVisible(false);
							
						String [] tokens = oldLine.split(",");
							
						String sendName = tokens[0];
						String sendSurname = tokens[1];
						int sendID = Integer.parseInt(tokens[2]);
						int sendPass = Integer.parseInt(tokens[3]);
						float sendBalance = Float.valueOf(tokens[4]);
						int sendIBAN = Integer.parseInt(tokens[5]);
							
						UserDTO sendUser = new UserDTO(sendName,sendSurname,sendID,sendPass,sendBalance,sendIBAN);
							
						UserScreen userScreenClass = new UserScreen();
						userScreenClass.userScreen(sendUser);
					}
			
				}
			});
			JButton cancel = new JButton("CANCEL");
			
			cancel.setBackground(Color.BLACK);
			cancel.setForeground(Color.MAGENTA);
			cancel.setFont(new Font("Times New Roman",Font.BOLD,15));
			
			cancel.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					jf.setVisible(false);
					
					String [] tokens = oldLine.split(",");
					
					String sendName = tokens[0];
					String sendSurname = tokens[1];
					int sendID = Integer.parseInt(tokens[2]);
					int sendPass = Integer.parseInt(tokens[3]);
					float sendBalance = Float.valueOf(tokens[4]);
					int sendIBAN = Integer.parseInt(tokens[5]);
					
					UserDTO sendUser = new UserDTO(sendName,sendSurname,sendID,sendPass,sendBalance,sendIBAN);
					
					UserScreen userScreenClass = new UserScreen();
					userScreenClass.userScreen(sendUser);
				}
			});
			
			panel.add(labelIBAN);
			panel.add(textIBAN);
			panel.add(labelTransferingAmount);
			panel.add(textAmount);
			panel.add(admit);
			panel.add(cancel);
			
			borderPanel.add(panel);
			
			jf.add(borderPanel);
			jf.setLayout(new FlowLayout());
			
			jf.setVisible(true);
			jf.setResizable(false);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	
			
	}
	private class ReturnListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {

			setVisible(false);
			
			String [] tokens = oldLine.split(",");
			
			String sendName = tokens[0];
			String sendSurname = tokens[1];
			int sendID = Integer.parseInt(tokens[2]);
			int sendPass = Integer.parseInt(tokens[3]);
			float sendBalance = Float.valueOf(tokens[4]);
			int sendIBAN = Integer.parseInt(tokens[5]);
			
			UserDTO sendUser = new UserDTO(sendName,sendSurname,sendID,sendPass,sendBalance,sendIBAN);
			
			UserScreen userScreenClass = new UserScreen();
			userScreenClass.userScreen(sendUser);
			
		}
	}
		
}


