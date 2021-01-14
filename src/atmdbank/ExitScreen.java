package atmdbank;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Image;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExitScreen extends JFrame {
	
	ExitScreen(){
		
		setTitle("Exit Screen");
		setSize(500,500);
		setLocation(400,400);
			
		JPanel panel = new JPanel();
		
		panel.setBackground(Color.ORANGE);
			
		JLabel exitLabel = new JLabel("Thank you for choosing DBank");
		exitLabel.setFont(new Font("Times New Roman",Font.BOLD,21));
			
		JLabel holdExit = new JLabel();
		Image img = new ImageIcon(ExitScreen.class.getResource("/ExitPage.png")).getImage();
		holdExit.setIcon(new ImageIcon(img));
			
		JButton goodBye = new JButton("GOOD BYE");
		goodBye.addActionListener(new GoodByeListener());
		
		goodBye.setBackground(Color.BLACK);
		goodBye.setForeground(Color.GREEN);
		goodBye.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		panel.add(exitLabel);
		panel.add(holdExit);
		panel.add(goodBye);
			
		add(panel);
			
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
	}
	
	private class GoodByeListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			
			System.exit(0);
			
		}
		
		
	}

}

