package atmdbank;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Image;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartingScreen extends JFrame {
	
	private JPanel panel;
	private JLabel iconPart1 ; 
	private JLabel iconPart2 ;
	private JLabel iconPart3 ;
	private Image imagePart1 ;
	private Image imagePart2 ;
	private JLabel screenLabel;
	private Image panelImage;
	
	StartingScreen(){
		
		setTitle("Starting Screen");
		setSize(500,500);
		setLocation(400,400);
		
		panel = new JPanel();
		
		iconPart1 = new JLabel();
		iconPart2 = new JLabel();
		iconPart3 = new JLabel("ANK");
		
		imagePart1 = new ImageIcon(StartingScreen.class.getResource("/Letter-d-icon.png")).getImage();
		iconPart1.setIcon(new ImageIcon(imagePart1));
		imagePart2 = new ImageIcon(StartingScreen.class.getResource("/Letter-b-icon.png")).getImage();
		iconPart2.setIcon(new ImageIcon(imagePart2));
	
		
		JButton login = new JButton("LOGIN");
		login.addActionListener(new LoginListener());
		
		login.setBackground(Color.BLACK);
		login.setForeground(Color.MAGENTA);
		login.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		screenLabel = new JLabel();
		panelImage = new ImageIcon(StartingScreen.class.getResource("/Bank.png")).getImage();
		screenLabel.setIcon(new ImageIcon(panelImage));
		
		panel.add(iconPart1);
		panel.add(iconPart2);
		panel.add(iconPart3);
		panel.add(login);
		
		add(panel);
		
		getContentPane().setBackground(Color.BLACK);
		getContentPane().add(screenLabel);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	private class LoginListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e ) {
			
			setVisible(false);
			new GreetingScreen();
		}
	}
	
	public static void main(String [] args) {
		
		new StartingScreen();
	}
}
	
	



