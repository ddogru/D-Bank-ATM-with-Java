package atmdbank;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class GreetingScreen extends JFrame {
	
	GreetingScreen() {
		
		setTitle("Greeting Screen");
		setSize(500,500);
		setLocation(400,400);
		
		
		JPanel panel = new JPanel(new GridLayout(5,1));
		
		JLabel greeting = new JLabel("Welcome To The DBank");
		
		JLabel choice = new JLabel("Please Select An Option");
		
		JButton userButton =  new JButton("User Login");
		userButton.addActionListener(new UserListener());
		
		panel.setBackground(Color.WHITE);
		
		userButton.setFont(new Font("Times New Roman",Font.BOLD,15));
		userButton.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				
				userButton.setBackground(Color.DARK_GRAY);
				userButton.setForeground(Color.RED);
				
			}
			public void mouseExited(MouseEvent e) {
				
				userButton.setBackground(Color.RED);
				userButton.setForeground(Color.BLACK);
			}
			public void mousePressed(MouseEvent e) {
				
				userButton.setBackground(Color.DARK_GRAY);
				userButton.setForeground(Color.CYAN);
			}
		});
		
		JButton adminButton = new JButton("Admin Login");
		adminButton.addActionListener(new AdminListener());
		
		adminButton.setFont(new Font("Times New Roman",Font.BOLD,15));
		adminButton.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				
				adminButton.setBackground(Color.DARK_GRAY);
				adminButton.setForeground(Color.MAGENTA);	
				
				
			}
			public void mouseExited(MouseEvent e) {
				
				adminButton.setBackground(Color.GREEN);
				adminButton.setForeground(Color.ORANGE);
			}
			public void mousePressed(MouseEvent e) {
				
				adminButton.setBackground(Color.DARK_GRAY);
				adminButton.setForeground(Color.BLUE);
			}
		
		});
		
		
		JButton exitButton = new JButton("EXIT");
		exitButton.addActionListener(new ExitListener());
		
		exitButton.setFont(new Font("Times New Roman",Font.ITALIC,15));
		exitButton.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				
				exitButton.setBackground(Color.DARK_GRAY);
				exitButton.setForeground(Color.WHITE);
			}
			public void mouseExited(MouseEvent e) {
				
				exitButton.setBackground(Color.ORANGE);
				exitButton.setForeground(Color.YELLOW);
				
			}
			public void mousePressed(MouseEvent e) {
				
				exitButton.setBackground(Color.DARK_GRAY);
				exitButton.setForeground(Color.GREEN);
			}
		});
		
		getContentPane().setBackground(Color.CYAN);
		
		
		panel.add(greeting);
		panel.add(choice);
		panel.add(userButton);
		panel.add(adminButton);
		panel.add(exitButton);
		
		add(panel);

		setLayout(new FlowLayout());
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	private class UserListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			setVisible(false);
			
			UserLogin userLoginClass = new UserLogin();
			userLoginClass.setVisible(true);
		}
	}
	
	private class AdminListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			setVisible(false);
			
			AdminLogin adminLoginClass = new AdminLogin();
			adminLoginClass.setVisible(true);
		}
	}
	private class ExitListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			setVisible(false);
			
			int i = JOptionPane.showConfirmDialog(null, "Are you sure to exit?",
					"EXIT",JOptionPane.YES_NO_OPTION);
			
			if(i == 0) {
			
				ExitScreen exitScreenClass=new ExitScreen();
				exitScreenClass.setVisible(true);
			}
			else if(i == 1) {
				setVisible(true);
			}
		}
	}

}
	

