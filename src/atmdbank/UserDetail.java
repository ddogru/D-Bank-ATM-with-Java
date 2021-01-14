package atmdbank;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserDetail extends JFrame {
	
	private UserScreen userScreenClass = new UserScreen();
	
	private JPanel panel;
	private JButton button;
	
	public void userDetail(Object o) throws IOException {
		
		setTitle("User Detail Screen");
		setSize(500,500);
		setLocation(400,400);
		
		panel = new JPanel();
		panel.setBackground(Color.CYAN);
		
		String userInfo = o.toString();
		
		String [] tokens = userInfo.split(",");
		
		String name = tokens[0];
		String surname = tokens[1];
		String ID = tokens[2];
		String pass = tokens[3];
		String balance = tokens[4];
		String IBAN = tokens[5];
		
		
		
		String [][]data = { {name,surname,ID,pass,balance,IBAN}};
		String [] columns = {"Name","Surname","ID","Password","Balance","IBAN"};
		
		JTable table = new JTable(data,columns);
		table.setBounds(400, 400, 500, 500);
		
		JScrollPane sp=new JScrollPane(table); 
		
		button = new JButton("Finish to Look");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				userScreenClass.userScreen(o);
				
			}
			
		});
		
		button.setBackground(Color.YELLOW);
		button.setForeground(Color.RED);
		button.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,15));
		
		panel.add(sp);
		panel.add(button);
		
		add(panel);
	
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
}

