package atmdbank;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;


public class UserScreen  extends JFrame{
	
	private GreetingScreen greeting;
	private ExitScreen exit;
	
	private JPanel panel ;
	private JPanel subPanel;

	private JLabel option;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	
	private JRadioButton rb1;
	private JRadioButton rb2;
	private JRadioButton rb3;
	private JRadioButton rb4;
	private JRadioButton rb5;
	private JRadioButton rb6;
	private JRadioButton rb7;
	private JRadioButton rb8;
	private JRadioButton rb9;
	private JRadioButton rb10;
	
	public void userScreen(Object o) {
		
		setTitle("User Screen");
		setSize(500,500);
		setLocation(400,400);
		
		getContentPane().setBackground(Color.CYAN);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		subPanel = new JPanel(new GridLayout(4,1));
		
		String satir = o.toString();
		String [] tokens = satir.split(",");
		
		panel.setBorder(BorderFactory.createTitledBorder("Welcome to the DBank"+" "+tokens[0].toUpperCase()
				+"  "+tokens[1].toUpperCase()));
		
		 
		option = new JLabel("Please Select An Option To Continue");
		
		button1 = new JButton("1) CASH WITHDRAW");
		button1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				try {
					DrawingCash drawingCashClass=new DrawingCash();
					drawingCashClass.drawingCash(o);
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		button1.setBackground(Color.BLACK);
		button1.setForeground(Color.BLUE);
		button1.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		button2 = new JButton("2) TRANSFER MONEY");
		button2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
				try {
					TransferMoney transferMoneyClass = new TransferMoney();
					transferMoneyClass.transferMoney(o);
				}
				catch(IOException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		
		button2.setBackground(Color.BLACK);
		button2.setForeground(Color.BLUE);
		button2.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		button3 = new JButton("3) CASH DEPOSIT");
		button3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				try {
					
					DepositMoney depositMoneyClass = new DepositMoney();
					depositMoneyClass.depositMoney(o);
				}
				catch(IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		

		button3.setBackground(Color.BLACK);
		button3.setForeground(Color.BLUE);
		button3.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		button4 = new JButton(" 4) CHECK STATEMENTS");
		button4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
				UserDetail userDetailClass = new UserDetail();
				try {
					userDetailClass.userDetail(o);
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		
		button4.setBackground(Color.BLACK);
		button4.setForeground(Color.BLUE);
		button4.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		button5 = new JButton(" 5) RETURN");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
				int i = JOptionPane.showConfirmDialog(null, "If you approve you'll be directed to the Greeting Screen.",
						"Are you sure to end this operation?",
						JOptionPane.YES_NO_OPTION);
				
				
				if(i == JOptionPane.YES_OPTION) {
				
					new GreetingScreen();
				}
				else if(i == JOptionPane.NO_OPTION) {
					setVisible(true);
				}
				
				
			}
		});
		
		button5.setBackground(Color.BLACK);
		button5.setForeground(Color.ORANGE);
		button5.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		button6 = new JButton("EXIT");
		button6.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
				int i = JOptionPane.showConfirmDialog(null, "Are you sure to exit? ",
						" EXIT",JOptionPane.YES_NO_OPTION);			
				
				if(i == JOptionPane.YES_OPTION) {
					
					ExitScreen exitScreenClass=new ExitScreen();
					exitScreenClass.setVisible(true);
				}
				else if(i == JOptionPane.NO_OPTION) {
					setVisible(true);
				}
			}
		});
		
		button6.setBackground(Color.BLACK);
		button6.setForeground(Color.GREEN);
		button6.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		subPanel.add(option);
		subPanel.add(button1);
		subPanel.add(button2);
		subPanel.add(button3);
		subPanel.add(button4);
		subPanel.add(button5);
		subPanel.add(button6);
		
		panel.add(subPanel);
		
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("ShortCuts");
		menu.setMnemonic(KeyEvent.VK_S);
		
		JMenu submenu = new JMenu("Operations");
		submenu.setMnemonic(KeyEvent.VK_O);
		
		JMenuItem item1 = new JMenuItem("Cash Withdraw");
		item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.ALT_MASK));
		
		JMenuItem item2 = new JMenuItem("Transfer Money");
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,ActionEvent.ALT_MASK));
		
		JMenuItem item3 = new JMenuItem("Cash Deposit");
		item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.ALT_MASK));
		
		JMenuItem item4 = new JMenuItem("Check Statements");
		item4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.ALT_MASK));
	
		JMenuItem item5 = new JMenuItem("Return");
		item5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.ALT_MASK));
		
		JMenuItem item6 = new JMenuItem("Exit");
		item6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.ALT_MASK));
		
		item1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				try {
					DrawingCash drawingCashClass = new DrawingCash();
					drawingCashClass.drawingCash(o);
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		item2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
				try {
					TransferMoney transferMoneyClass = new TransferMoney();
					transferMoneyClass.transferMoney(o);
				}
				catch(IOException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		
		item3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				try {
					
					DepositMoney depositMoneyClass = new DepositMoney();
					depositMoneyClass.depositMoney(o);
				}
				catch(IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		item4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
		
				try {
					UserDetail userDetailClass = new UserDetail();
					userDetailClass.userDetail(o);
				} catch (IOException e1) {
						
					e1.printStackTrace();
				}
				
			}
		});
		
		item5.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
				int i = JOptionPane.showConfirmDialog(null, "If you approve you'll be directed to the Greeting Screen.",
						"Are you sure to end this operation?",
						JOptionPane.YES_NO_OPTION);
				
				
				if(i == JOptionPane.YES_OPTION) {
					
					new GreetingScreen();
				}
				else if(i == JOptionPane.NO_OPTION) {
					setVisible(true);
				}
			}
		});
		
		item6.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
				int i = JOptionPane.showConfirmDialog(null, "Are you sure to exit?",
						"EXIT",JOptionPane.YES_NO_OPTION);
				
				
				if(i == JOptionPane.YES_OPTION) {
					
					new ExitScreen();
				}
				else if(i == JOptionPane.NO_OPTION) {
					setVisible(true);
				}
				
				
			}
		});
		
		submenu.add(item1);
		submenu.add(item2);
		submenu.add(item3);
		submenu.add(item4);
		submenu.add(item5);
		submenu.add(item6);
		
		menu.add(submenu);
		bar.add(menu);
		
		JMenu menu2 = new JMenu("Background");
		menu2.setMnemonic(KeyEvent.VK_B);
		
		JMenu submenu2 = new JMenu("Colors");
		submenu2.setMnemonic(KeyEvent.VK_C);
		
		rb1 = new JRadioButton("White");
		rb1.addActionListener(new RadioButtonListener());
		
		rb2 = new JRadioButton("Black");
		rb2.addActionListener(new RadioButtonListener());
		
		rb3 = new JRadioButton("Magenta");
		rb3.addActionListener(new RadioButtonListener());
		
		rb4 = new JRadioButton("Green");
		rb4.addActionListener(new RadioButtonListener());
		
		rb5 = new JRadioButton("Pink");
		rb5.addActionListener(new RadioButtonListener());
		
		rb6 = new JRadioButton("Yellow");
		rb6.addActionListener(new RadioButtonListener());
		
		rb7 = new JRadioButton("Red");
		rb7.addActionListener(new RadioButtonListener());
		
		rb8 = new JRadioButton("Blue");
		rb8.addActionListener(new RadioButtonListener());
		
		rb9 = new JRadioButton("Gray");
		rb9.addActionListener(new RadioButtonListener());
		
		rb10 = new JRadioButton("Original color");
		rb10.addActionListener(new RadioButtonListener());
		
		
		submenu2.add(rb1);
		submenu2.add(rb2);
		submenu2.add(rb3);
		submenu2.add(rb4);
		submenu2.add(rb5);
		submenu2.add(rb6);
		submenu2.add(rb7);
		submenu2.add(rb8);
		submenu2.add(rb9);
		submenu2.add(rb10);
		
		menu2.add(submenu2);
		bar.add(menu2);
		
		setJMenuBar(bar);
		add(panel);
		setLayout(new FlowLayout());
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}
	private class RadioButtonListener implements ActionListener{
		
		
		public void actionPerformed(ActionEvent e) {
			
			if(rb1.isSelected()) {
				
				getContentPane().setBackground(Color.WHITE);
			}
			else if(rb2.isSelected()) {
				
				getContentPane().setBackground(Color.BLACK);
			}
			else if(rb3.isSelected()) {
				
				getContentPane().setBackground(Color.MAGENTA);
			}
			else if(rb4.isSelected()) {
				
				getContentPane().setBackground(Color.GREEN);
			}
			else if(rb5.isSelected()) {
				
				getContentPane().setBackground(Color.PINK);
			}
			else if(rb6.isSelected()) {
				
				getContentPane().setBackground(Color.YELLOW);
			}
			else if(rb7.isSelected()) {
				
				getContentPane().setBackground(Color.RED);
			}
			else if(rb8.isSelected()) {
				
				getContentPane().setBackground(Color.BLUE);
			}
			else if(rb9.isSelected()) {
				
				getContentPane().setBackground(Color.GRAY);
			}
			else if(rb10.isSelected()) {
				
				getContentPane().setBackground(Color.CYAN);
				
			}
		}
		
	}
}



