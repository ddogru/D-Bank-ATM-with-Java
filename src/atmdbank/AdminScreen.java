package atmdbank;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

public class AdminScreen extends JFrame {
	
	private GreetingScreen greeting;
	private UserAddDelete userAddDeleteClass = new UserAddDelete();
	UserList userListClass = new UserList();
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
	private JButton button7;
	
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
		
		
	public void adminScreen(Object o) {
			
		setTitle("Admin Screen");
		setSize(500,500);
		setLocation(400,400);
		
		getContentPane().setBackground(Color.CYAN);	
			
		panel = new JPanel();
		
		panel.setBackground(Color.WHITE);
			
		subPanel = new JPanel(new GridLayout(4,2));
			
		String satir = o.toString();
		String [] tokens = satir.split(",");
			
		panel.setBorder(BorderFactory.createTitledBorder("Welcome to the DBank"+" "+tokens[0].toUpperCase()
				+"  "+tokens[1].toUpperCase()));
			
			 
		option = new JLabel("Please Select An Option To Continue");
			
		button1 = new JButton("1) User Add");
		
		button1.setBackground(Color.BLACK);
		button1.setForeground(Color.ORANGE);
		button1.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		button1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
					
				setVisible(false);
				
				userAddDeleteClass.userAddDelete(o);
				
			}
		});
			
			button2 = new JButton("2) User List");
			
			
			button2.setBackground(Color.BLACK);
			button2.setForeground(Color.ORANGE);
			button2.setFont(new Font("Times New Roman",Font.BOLD,15));
			
			button2.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					UserList userListClass = new UserList();
					userListClass.userList(o);
					
				}
			});
			
			button3 = new JButton(" 3) Admin Add");
			
			button3.setBackground(Color.BLACK);
			button3.setForeground(Color.ORANGE);
			button3.setFont(new Font("Times New Roman",Font.BOLD,15));
			
			button3.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					
					AdminAddDelete adminAddDeleteClass = new AdminAddDelete();
					adminAddDeleteClass.adminAddDelete(o);
				}
			});
			
			button4 = new JButton(" 4) User Delete");
			
			button4.setBackground(Color.BLACK);
			button4.setForeground(Color.ORANGE);
			button4.setFont(new Font("Times New Roman",Font.BOLD,15));
			
			button4.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					
					UserDelete userDeleteClass = new UserDelete();
					userDeleteClass.userDelete(o);
					
				}
			});
			
			button5 = new JButton(" 5) Admin Delete");
			
			button5.setBackground(Color.BLACK);
			button5.setForeground(Color.ORANGE);
			button5.setFont(new Font("Times New Roman",Font.BOLD,15));
			
			button5.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					
					AdminDelete adminDeleteClass = new AdminDelete();
					adminDeleteClass.adminDelete(o);
				}
			});
			
			button6 = new JButton("RETURN");
			
			button6.setBackground(Color.BLACK);
			button6.setForeground(Color.MAGENTA);
			button6.setFont(new Font("Times New Roman",Font.BOLD,15));
			
			button6.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					
					int i = JOptionPane.showConfirmDialog(null, "If you approve you'll be directed to the Greeting Screen.",
							"Are you sure to end this operation?",
							JOptionPane.YES_NO_OPTION);
					
					
					if(i == 0) {
						
						new GreetingScreen();
					}
					else if(i == 1) {
						setVisible(true);
					}
					
					
				}
			});
			
			button7 = new JButton("EXIT");
			
			button7.setBackground(Color.BLACK);
			button7.setForeground(Color.CYAN);
			button7.setFont(new Font("Times New Roman",Font.BOLD,15));
			
			button7.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					
					int i = JOptionPane.showConfirmDialog(null, "Are you sure to exit? ",
							" EXIT",JOptionPane.YES_NO_OPTION);			
					
					if(i == 0) {
						
						new ExitScreen();
					}
					else if(i == 1) {
						setVisible(true);
					}
				}
			});
			
			subPanel.add(option);
			subPanel.add(button1);
			subPanel.add(button2);
			subPanel.add(button3);
			subPanel.add(button4);
			subPanel.add(button5);
			subPanel.add(button6);
			subPanel.add(button7);
			
			panel.add(subPanel);
			
			JMenuBar bar = new JMenuBar();
			JMenu menu = new JMenu("ShortCuts");
			menu.setMnemonic(KeyEvent.VK_S);
			
			JMenu submenu = new JMenu("Operations");
			submenu.setMnemonic(KeyEvent.VK_O);
			
			JMenuItem item1 = new JMenuItem("User Add and Delete");
			item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.ALT_MASK));
			
			JMenuItem item2 = new JMenuItem("User List");
			item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.ALT_MASK));
			
			JMenuItem item3 = new JMenuItem("Admin Add and Delete");
			item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.ALT_MASK));
			
			JMenuItem item4 = new JMenuItem("User Delete");
			item4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.ALT_MASK));
			
			JMenuItem item5 = new JMenuItem("Admin Delete");
			item5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.ALT_MASK));
			
			JMenuItem item6 = new JMenuItem("Return");
			item6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.ALT_MASK));
			
			JMenuItem item7 = new JMenuItem("Exit");
			item7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.ALT_MASK));
			
			item1.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
							
					userAddDeleteClass.userAddDelete(o);
				}
			});
			
			item2.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					
					userListClass.userList(o);
					
				}
			});
			
			item3.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					
					AdminAddDelete adminAddDeleteClass = new AdminAddDelete();
					adminAddDeleteClass.adminAddDelete(o);
				}
			});
			
			item4.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					
					UserDelete userDeleteClass = new UserDelete();
					userDeleteClass.userDelete(o);
				}
			});
			
			item5.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					
					AdminDelete adminDeleteClass = new AdminDelete();
					adminDeleteClass.adminDelete(o);
				}
			});
			
			item6.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					
					int i = JOptionPane.showConfirmDialog(null, "If you approve you'll be directed to the Greeting Screen.",
							"Are you sure to end this operation?",
							JOptionPane.YES_NO_OPTION);
					
					
					if(i == 0) {
						
						new GreetingScreen();
					}
					else if(i == 1) {
						setVisible(true);
					}
					
					
				}
			});
			
			item7.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					
					int i = JOptionPane.showConfirmDialog(null, "Are you sure to exit?",
							"EXIT",JOptionPane.YES_NO_OPTION);
					
					
					if(i == 0) {
						
						new ExitScreen();
					}
					else if(i == 1) {
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
			submenu.add(item7);
			
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



