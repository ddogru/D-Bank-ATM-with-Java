package atmdbank;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DepositMoney extends JFrame {
		
	private static JPanel depositPanel;
	private static JPanel depositSubPanel;
	
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
	
	public void depositMoney(Object o) throws IOException {
		
		JFrame jf=new JFrame();
			
		setTitle("Deposit Screen");
		setSize(500,500);
		setLocation(400,400);
		
		userList = new ArrayList<UserDTO>();
		
		oldLine = o.toString();
		
		tokens = oldLine.split(",");
		
		File read = new File("UserDTO.txt");
		reader = new Scanner(read);
		
		
		depositPanel = new JPanel();
		depositPanel.setBackground(Color.CYAN);
	
		depositPanel.setBorder(BorderFactory.createTitledBorder("Your Current Balance is " +tokens[4]+ " Please select an option"));
		
		depositSubPanel = new JPanel(new GridLayout(9,1));
		
				
			
		tenLirasButton = new JButton("10 TL");
		tenLirasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cash=10;
				Loading(cash,jf);
				
			}
		});
		
		tenLirasButton.setBackground(Color.BLACK);
		tenLirasButton.setForeground(Color.YELLOW);
		tenLirasButton.setFont(new Font("Times New Roman",Font.BOLD,15));
			
		twentyLirasButton = new JButton("20 TL");
		twentyLirasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cash=20;
				Loading(cash,jf);
				
			}
		});
		
		twentyLirasButton.setBackground(Color.BLACK);
		twentyLirasButton.setForeground(Color.YELLOW);
		twentyLirasButton.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		thirtyLirasButton = new JButton("30 TL");
		thirtyLirasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cash=30;
				Loading(cash,jf);
				
			}
		});
		
		thirtyLirasButton.setBackground(Color.BLACK);
		thirtyLirasButton.setForeground(Color.YELLOW);
		thirtyLirasButton.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		fiftyLirasButton = new JButton("50 TL");
		fiftyLirasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cash=50;
				Loading(cash,jf);
				
			}
		});
		
		fiftyLirasButton.setBackground(Color.BLACK);
		fiftyLirasButton.setForeground(Color.YELLOW);
		fiftyLirasButton.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		oneHundredLirasButton = new JButton("100 TL");
		oneHundredLirasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cash=100;
				Loading(cash,jf);
				
			}
		});
	
		oneHundredLirasButton.setBackground(Color.BLACK);
		oneHundredLirasButton.setForeground(Color.YELLOW);
		oneHundredLirasButton.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		twoHundredFiftyLirasButton = new JButton("250 TL");
		twoHundredFiftyLirasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cash=250;
				Loading(cash,jf);
				
			}
		});
		
		twoHundredFiftyLirasButton.setBackground(Color.BLACK);
		twoHundredFiftyLirasButton.setForeground(Color.YELLOW);
		twoHundredFiftyLirasButton.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		oneThousandLirasButton = new JButton("1000 TL");
		oneThousandLirasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cash=1000;
				Loading(cash,jf);
				
			}
		});
		
		oneThousandLirasButton.setBackground(Color.BLACK);
		oneThousandLirasButton.setForeground(Color.YELLOW);
		oneThousandLirasButton.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		otherAmountButton = new JButton("OTHER AMOUNT");
		otherAmountButton.addActionListener(new OtherAmountListener());
		
		otherAmountButton.setBackground(Color.BLACK);
		otherAmountButton.setForeground(Color.YELLOW);
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
		returnButton.setForeground(Color.YELLOW);
		returnButton.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		depositSubPanel.add(tenLirasButton);
		depositSubPanel.add(twentyLirasButton);
		depositSubPanel.add(thirtyLirasButton);
		depositSubPanel.add(fiftyLirasButton);
		depositSubPanel.add(oneHundredLirasButton);
		depositSubPanel.add(twoHundredFiftyLirasButton);
		depositSubPanel.add(oneThousandLirasButton);
		depositSubPanel.add(otherAmountButton);
		depositSubPanel.add(returnButton);
		
		depositPanel.add(depositSubPanel);
		
		add(depositPanel);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			approveB.setForeground(Color.YELLOW);
			approveB.setFont(new Font("Times New Roman",Font.BOLD,15));
			
			JButton cancelB = new JButton("CANCEL");
			
			cancelB.setBackground(Color.BLACK);
			cancelB.setForeground(Color.YELLOW);
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
					JLabel contents=new JLabel(fileContents);
					jf.getContentPane().add(contents);
					
					
					reader.close();
						
					String name = tokens[0];
					String surname = tokens[1];
					int ID = Integer.parseInt(tokens[2]);
					int Pass = Integer.parseInt(tokens[3]);
					int IBAN = Integer.parseInt(tokens[5]);
						
					float balance = Float.valueOf(tokens[4]);
					
					
					String amount = text.getText();
					
					float drawingAmount = Float.valueOf(amount);
						
						if(drawingAmount %10 == 0) {
							
							float total = balance + drawingAmount;
				
							userList.add(new UserDTO(name,surname,ID,Pass,total,IBAN));
							
						
							try {
								
								FileWriter fw = new FileWriter("UserDTO.txt");
								
								ImageIcon icon = new ImageIcon(DepositMoney.class.getResource("/Dollar.png"));
								JOptionPane.showMessageDialog(null,"Successful","Your operation is done",JOptionPane.INFORMATION_MESSAGE,icon);
								
								for(UserDTO c : userList) {
										
									String newLine = c.toString();
									fileContents = fileContents.replaceAll(oldLine, newLine);
									
									String [] tokensForNewLine = newLine.split(",");
								
									depositPanel.setBorder(BorderFactory.createTitledBorder(" Your current balance is "+tokensForNewLine[4]));	
									
									float newCurrentBalance = Float.valueOf(tokensForNewLine[4]);
									
									UserDTO newUser = new UserDTO(name,surname,ID,Pass,newCurrentBalance,IBAN);
									
									setVisible(false);
									
									DepositMoney depositMoneyClass = new DepositMoney();
									depositMoneyClass.depositMoney(newUser);
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
							JLabel multipliesTen=new JLabel("Please enter multiples of 10!");
							jf.getContentPane().add(multipliesTen);
							
							ImageIcon image = new ImageIcon(DepositMoney.class.getResource("/error.png"));
							
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
							
							DepositMoney depositMoneyClass = new DepositMoney();
							try {
								depositMoneyClass.depositMoney(sendUser);
							} catch (IOException e1) {
								
								e1.printStackTrace();
							}
							
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
	
	public static void Loading(int cash, JFrame jf) {
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

		float total = balance + cash;
		
		userList.add(new UserDTO(name,surname,ID,Pass,total,IBAN));
	
		try {
			FileWriter fw = new FileWriter("UserDTO.txt");
		
			ImageIcon icon = new ImageIcon(DepositMoney.class.getResource("/Dollar.png"));
			JOptionPane.showMessageDialog(null,"Successful","Your operation is done",JOptionPane.INFORMATION_MESSAGE,icon);
			jf.setVisible(false);
		
			for(UserDTO e : userList) {
				
				String newLine = e.toString();
				fileContents = fileContents.replaceAll(oldLine, newLine);
				
			
				String [] tokensForNewLine = newLine.split(",");
		
				depositPanel.setBorder(BorderFactory.createTitledBorder(" Your current balance is "+tokensForNewLine[4]));	
			
				float newCurrentBalance = Float.valueOf(tokensForNewLine[4]);
			
				UserDTO newUser = new UserDTO(name,surname,ID,Pass,newCurrentBalance,IBAN);
			
				jf.setVisible(false);
			
				DepositMoney depositMoneyClass = new DepositMoney();
				depositMoneyClass.depositMoney(newUser);
			}
			fw.append(fileContents);
			fw.flush();
			fw.close();
		
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}