package atmdbank;

import java.io.IOException;
import java.util.Scanner;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserLogin extends JFrame{
	
	private GreetingScreen greeting ;
	private UserScreen userScreenClass = new UserScreen();
	
	private JPanel panel;
	private JLabel login;
	private Image image;
	private JLabel holdImage;
	private JLabel IDLabel;
	private JTextField textID;
	private JLabel PassLabel;
	private JPasswordField textPass;
	private JButton admitButton;
	private JButton returnButton;
	
	UserLogin(){
		
		setTitle("User Login Screen");
		setSize(500,500);
		setLocation(400,400);
		
		getContentPane().setBackground(Color.CYAN);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		login = new JLabel("User Login");
		
		holdImage = new JLabel();
		image = new ImageIcon(UserLogin.class.getResource("/User.png")).getImage();
		holdImage.setIcon(new ImageIcon(image));
		
		IDLabel = new JLabel("Enter ID");
		textID = new JTextField(15);
		
		PassLabel = new JLabel("Enter Password");
		textPass = new JPasswordField(15);
		
		admitButton = new JButton("ADMIT");
		admitButton.addActionListener(new AdmitListener());
		
		admitButton.setBackground(Color.BLACK);
		admitButton.setForeground(Color.GREEN);
		admitButton.setFont(new Font("Times New Roman",Font.HANGING_BASELINE,15));
		
		returnButton = new JButton("RETURN");
		returnButton.addActionListener(new ReturnListener());
		
		returnButton.setBackground(Color.BLACK);
		returnButton.setForeground(Color.GREEN);
		returnButton.setFont(new Font("Times New Roman",Font.HANGING_BASELINE,15));
		
		
		panel.setLayout(new GridLayout(4,2));
		
		panel.add(login);
		panel.add(holdImage);
		panel.add(IDLabel);
		panel.add(textID);
		panel.add(PassLabel);
		panel.add(textPass);
		panel.add(admitButton);
		panel.add(returnButton);
		
		add(panel);
		setLayout(new FlowLayout());
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	
	private class AdmitListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			
			try {
				
				File byRead = new File("UserDTO.txt");
				Scanner reader = new Scanner(byRead);
				

				while(reader.hasNextLine()) {
					
				String satir = reader.nextLine();
					
				String [] tokens = satir.split(",");
						
				int ID = Integer.parseInt(tokens[2]);
				int Pass = Integer.parseInt(tokens[3]);
				
				String TextFieldID = textID.getText();
				String TextFieldPass = textPass.getText();
				
				int IDField = Integer.parseInt(TextFieldID);
				int PassField = Integer.parseInt(TextFieldPass);
						
				if((ID == IDField) && (Pass == PassField)) {
								
					ImageIcon img = new ImageIcon(UserLogin.class.getResource("/OkEmoji.png"));
					
					JOptionPane.showMessageDialog(null,"Successful","Congratulations!",JOptionPane.INFORMATION_MESSAGE,img);
					
					setVisible(false);
					
					String name = tokens[0];
					String surname = tokens[1];
					
					float balance = Float.valueOf(tokens[4]);
					int IBAN = Integer.parseInt(tokens[5]);
							
							
					UserDTO user = new UserDTO(name,surname,ID,Pass,balance,IBAN);
					
					userScreenClass.userScreen(user);
								
					break;
					}
					else if((ID != IDField) && (Pass != PassField)) {
						
						ImageIcon icon = new ImageIcon(UserLogin.class.getResource("/XEmoji.png"));
						JOptionPane.showMessageDialog(null, "Unssucessful","Sorry",JOptionPane.INFORMATION_MESSAGE,icon);
						
						setVisible(false);
		
					}
			
					
				}
				reader.close();
			}
			catch(IOException t) {
				
				t.printStackTrace();
			}
		}
	}
	private class ReturnListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			setVisible(false);
			new GreetingScreen();
		}
	}
}
		






