package atmdbank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DrawingCash extends JFrame{
	
	
	private static JPanel drawingPanel;
	private JPanel drawingSubPanel;
	
	private JButton tenLirasButton;
	private JButton twentyLirasButton;
	private JButton thirtyLirasButton;
	private JButton fiftyLirasButton;
	private JButton oneHundredLirasButton;
	private JButton twoHundredFiftyLirasButton;
	private JButton oneThousandLirasButton;
	private JButton otherAmountButton;
	private JButton returnButton;
	
	private static ArrayList<UserDTO>userList ;
	private static Scanner reader;
	private static String oldLine;
	private static String[] tokens;
	
	
	public void drawingCash(Object o) throws IOException {
		
		JFrame jf=new JFrame();
		setTitle("Drawing Screen");
		setSize(500,500);
		setLocation(400,400);
		
		userList = new ArrayList<UserDTO>();
		
		oldLine = o.toString();
		
		tokens = oldLine.split(",");
		
		File read = new File("UserDTO.txt");
		reader = new Scanner(read);
		
		
		drawingPanel = new JPanel();
		
		drawingPanel.setBackground(Color.CYAN);
	
		drawingPanel.setBorder(BorderFactory.createTitledBorder("Your Current Balance is " +tokens[4]+ " Please select an option"));
		
		drawingSubPanel = new JPanel(new GridLayout(9,1));
		
		
		tenLirasButton = new JButton("10 TL");
		tenLirasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cash=10;
				Drawing(cash,jf);
			}
		});
		
		tenLirasButton.setBackground(Color.BLACK);
		tenLirasButton.setForeground(Color.RED);
		tenLirasButton.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		twentyLirasButton = new JButton("20 TL");
		twentyLirasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cash=20;
				Drawing(cash,jf);
			}
		});
		
		twentyLirasButton.setBackground(Color.BLACK);
		twentyLirasButton.setForeground(Color.RED);
		twentyLirasButton.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		thirtyLirasButton = new JButton("30 TL");
		thirtyLirasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cash=30;
				Drawing(cash,jf);
			}
		});
		
		thirtyLirasButton.setBackground(Color.BLACK);
		thirtyLirasButton.setForeground(Color.RED);
		thirtyLirasButton.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		fiftyLirasButton = new JButton("50 TL");
		fiftyLirasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cash=50;
				Drawing(cash,jf);
			}
		});
		
		fiftyLirasButton.setBackground(Color.BLACK);
		fiftyLirasButton.setForeground(Color.RED);
		fiftyLirasButton.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		oneHundredLirasButton = new JButton("100 TL");
		oneHundredLirasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cash=100;
				Drawing(cash,jf);
			}
		});
		
		oneHundredLirasButton.setBackground(Color.BLACK);
		oneHundredLirasButton.setForeground(Color.RED);
		oneHundredLirasButton.setFont(new Font("Times New Roman",Font.BOLD,15));
	
		twoHundredFiftyLirasButton = new JButton("250 TL");
		twoHundredFiftyLirasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cash=250;
				Drawing(cash,jf);
			}
		});
		
		twoHundredFiftyLirasButton.setBackground(Color.BLACK);
		twoHundredFiftyLirasButton.setForeground(Color.RED);
		twoHundredFiftyLirasButton.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		oneThousandLirasButton = new JButton("1000 TL");
		oneThousandLirasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cash=1000;
				Drawing(cash,jf);
			}
		}); 
		
		oneThousandLirasButton.setBackground(Color.BLACK);
		oneThousandLirasButton.setForeground(Color.RED);
		oneThousandLirasButton.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		otherAmountButton = new JButton("OTHER AMOUNT");
		otherAmountButton.addActionListener(new OtherAmountListener()); 
		
		otherAmountButton.setBackground(Color.BLACK);
		otherAmountButton.setForeground(Color.RED);
		otherAmountButton.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		returnButton = new JButton("RETURN");
		returnButton.addActionListener(new ActionListener() {
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
		});
		
		returnButton.setBackground(Color.BLACK);
		returnButton.setForeground(Color.RED);
		returnButton.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		
		drawingSubPanel.add(tenLirasButton);
		drawingSubPanel.add(twentyLirasButton);
		drawingSubPanel.add(thirtyLirasButton);
		drawingSubPanel.add(fiftyLirasButton);
		drawingSubPanel.add(oneHundredLirasButton);
		drawingSubPanel.add(twoHundredFiftyLirasButton);
		drawingSubPanel.add(oneThousandLirasButton);
		drawingSubPanel.add(otherAmountButton);
		drawingSubPanel.add(returnButton);
		
		drawingPanel.add(drawingSubPanel);
		
		add(drawingPanel);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void Drawing(int cash,JFrame jf) {
		
		StringBuffer buffer = new StringBuffer();
		
		while(reader.hasNextLine()) {
			buffer.append(reader.nextLine()+System.lineSeparator());
		}
		
		String fileContents = buffer.toString();
		
		reader.close();
			
		String name = tokens[0];
		String surname = tokens[1];
		int ID = Integer.parseInt(tokens[2]);
		int Pass = Integer.parseInt(tokens[3]);
		int IBAN = Integer.parseInt(tokens[5]);
			
		float balance = Float.valueOf(tokens[4]);
		
		if(balance >= cash) {
			
			float total = balance - cash;
			
			userList.add(new UserDTO(name,surname,ID,Pass,total,IBAN));
			
			try {
				FileWriter fw = new FileWriter("UserDTO.txt");
				 
				
				ImageIcon icon = new ImageIcon(DrawingCash.class.getResource("/Dollar.png"));
				JOptionPane.showMessageDialog(null,"Successful","Your operation is done",JOptionPane.INFORMATION_MESSAGE,icon);
				
				for(UserDTO e : userList) {
						
					String newLine = e.toString();
					fileContents = fileContents.replaceAll(oldLine, newLine);
					
					String [] tokensForNewLine = newLine.split(",");
				
					drawingPanel.setBorder(BorderFactory.createTitledBorder(" Your current balance is "+tokensForNewLine[4]));	
					
					float newCurrentBalance = Float.valueOf(tokensForNewLine[4]);
					
					UserDTO newUser = new UserDTO(name,surname,ID,Pass,newCurrentBalance,IBAN);
					
					jf.setVisible(false);
					
					DrawingCash drawingCashClass = new DrawingCash();
					drawingCashClass.drawingCash(newUser);
				}
				fw.append(fileContents);
				fw.flush();
				fw.close();
				
				
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		else {
			
			ImageIcon image = new ImageIcon(DrawingCash.class.getResource("/error.png"));
			
			JOptionPane.showMessageDialog(null,"Unsuccessful ","Cannot withdraw this amount!",JOptionPane.INFORMATION_MESSAGE,image);
			
			drawingPanel.setBorder(BorderFactory.createTitledBorder("You don't have this amount of money!"));
			
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
	}
	
	private class OtherAmountListener implements ActionListener{
		
		public void actionPerformed(ActionEvent b) {
			
			setVisible(false);
			
			JFrame jf = new JFrame();
			
			jf.setTitle("Other Amount Screen");
			jf.setSize(500,500);
			jf.setLocation(400,400);
			
			jf.getContentPane().setBackground(Color.CYAN);
			
			JPanel panel = new JPanel(new GridLayout(2,1));
			
			JLabel label = new JLabel("How much money you want to withdraw?");
			
			JTextField text = new JTextField(10);
			
			JButton approveB = new JButton("APPROVE");
			
			approveB.setBackground(Color.BLACK);
			approveB.setForeground(Color.RED);
			approveB.setFont(new Font("Times New Roman",Font.BOLD,15));
			
			JButton cancelB = new JButton("CANCEL");
			
			cancelB.setBackground(Color.BLACK);
			cancelB.setForeground(Color.RED);
			cancelB.setFont(new Font("Times New Roman",Font.BOLD,15));
			
			panel.add(label);
			panel.add(text);
			panel.add(approveB);
			panel.add(cancelB);
			
			approveB.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
				
					jf.setVisible(false);
					
					StringBuffer buffer = new StringBuffer();
					
					while(reader.hasNextLine()) {
						buffer.append(reader.nextLine()+System.lineSeparator());
					}
					
					String fileContents = buffer.toString();
					
					reader.close();
						
					String name = tokens[0];
					String surname = tokens[1];
					int ID = Integer.parseInt(tokens[2]);
					int Pass = Integer.parseInt(tokens[3]);
					int IBAN = Integer.parseInt(tokens[5]);
						
					float balance = Float.valueOf(tokens[4]);
					
					
					String amount = text.getText();
					
					float drawingAmount = Float.valueOf(amount);
					
					if(balance>drawingAmount) {
						
						if(drawingAmount %10 == 0) {
							
							float total = balance - drawingAmount;
				
							userList.add(new UserDTO(name,surname,ID,Pass,total,IBAN));
							
						
							try {
								
								FileWriter fw = new FileWriter("UserDTO.txt");
								
								ImageIcon icon = new ImageIcon(DrawingCash.class.getResource("/Dollar.png"));
								JOptionPane.showMessageDialog(null,"Successful","Your operation is done",JOptionPane.INFORMATION_MESSAGE,icon);
								
								for(UserDTO c : userList) {
										
									String newLine = c.toString();
									fileContents = fileContents.replaceAll(oldLine, newLine);
									
									String [] tokensForNewLine = newLine.split(",");
								
									drawingPanel.setBorder(BorderFactory.createTitledBorder(" Your current balance is "+tokensForNewLine[4]));	
									
									float newCurrentBalance = Float.valueOf(tokensForNewLine[4]);
									
									UserDTO newUser = new UserDTO(name,surname,ID,Pass,newCurrentBalance,IBAN);
									
									setVisible(false);
									
									DrawingCash drawingCashClass = new DrawingCash();
									drawingCashClass.drawingCash(newUser);
								}
										
								fw.append(fileContents);
								fw.flush();
								fw.close();
							}
							catch(IOException c) {
								c.printStackTrace();
							}
						}
							
						else {
							System.out.println("Please enter multiples of 10!");
							
							ImageIcon image = new ImageIcon(DrawingCash.class.getResource("/error.png"));
							
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
						
						ImageIcon image = new ImageIcon(DrawingCash.class.getResource("/error.png"));
						
						JOptionPane.showMessageDialog(null,"Unsuccessful ","Cannot withdraw this amount!",JOptionPane.INFORMATION_MESSAGE,image);
						
						drawingPanel.setBorder(BorderFactory.createTitledBorder("You don't have this amount of money!"));
						
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
			
			cancelB.addActionListener(new ActionListener() {
				
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
			
			jf.add(panel);
			jf.setLayout(new FlowLayout());
			jf.setVisible(true);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.setResizable(false);
		}
	}
 }