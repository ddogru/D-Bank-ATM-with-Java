package atmdbank;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;


import java.awt.Color;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserDelete extends JFrame {

	private JPanel panel;
	private JLabel label;
	private JTextField textID;
	private JButton approveB;
	private JButton cancelB;
	
	private String adminInfo;
	
	public void userDelete(Object o) {
		
		adminInfo = o.toString();
		
		setTitle("User Delete Screen");
		setSize(500,500);
		setLocation(400,400);
		
		getContentPane().setBackground(Color.CYAN);
		
		panel = new JPanel();
		
		label = new JLabel("Please enter an user ID");
		textID = new JTextField(10);
		
		approveB = new JButton("APPROVE");
		approveB.addActionListener(new ApproveListener());
		
		approveB.setBackground(Color.BLACK);
		approveB.setForeground(Color.ORANGE);
		
		approveB.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				
				approveB.setBackground(Color.GREEN);
				approveB.setForeground(Color.DARK_GRAY);
			}
			public void mousePressed(MouseEvent e) {
				
				approveB.setBackground(Color.MAGENTA);
				approveB.setForeground(Color.RED);
			}
			
		});
		
		cancelB = new JButton("CANCEL");
		cancelB.addActionListener(new CancelListener());
		
		cancelB.setBackground(Color.BLACK);
		cancelB.setForeground(Color.ORANGE);
		
		panel.add(label);
		panel.add(textID);
		panel.add(approveB);
		panel.add(cancelB);
		
		add(panel);
		
		setLayout(new FlowLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	private class ApproveListener implements ActionListener{
		
		public void actionPerformed(ActionEvent b) {
			

			int i = JOptionPane.showConfirmDialog(null, "Are you sure to delete?",
					"Delete Operation",JOptionPane.YES_NO_OPTION);
			
			if(i == JOptionPane.YES_OPTION) {
				
				try {
					
					String takenID =  textID.getText();
					
					int deletedID = Integer.parseInt(takenID);
				
					File file1 = new File("UserDTO.txt");
					Scanner reader = new Scanner(file1);
					
					File file2 = new File("tempUserDTO.txt");
					FileWriter fw = new FileWriter(file2);
					BufferedWriter bw = new BufferedWriter(fw);
					
					while(reader.hasNextLine()) {
						
						String satir = reader.nextLine();
						
						String [] tokens = satir.split(",");
						
						int ID= Integer.parseInt(tokens[2]);
						
						String name = tokens[0];
						String surname = tokens[1];
						int pass = Integer.parseInt(tokens[3]);
						float balance = Float.valueOf(tokens[4]);
						int IBAN = Integer.parseInt(tokens[5]);
							
						if(ID == deletedID) {
							
							ImageIcon img = new ImageIcon(UserDelete.class.getResource("/success.png"));
							
							JOptionPane.showMessageDialog(null, "Deleting Successful","Success",JOptionPane.INFORMATION_MESSAGE,img);
							
							continue;
						}
						else {
							
							bw.write(name+","+surname+","+ID+","+pass+","+balance+","+IBAN+"\n");
							
							setVisible(false);
							
							AdminScreen adminScreenClass = new AdminScreen();
							adminScreenClass.adminScreen(adminInfo);
						}
					}
					bw.close();
					reader.close();
					
					file1.delete();
					file2.renameTo(file1);
					
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			
			}
			else if(i == JOptionPane.NO_OPTION) {
				
				setVisible(false);
				
				AdminScreen adminScreenClass = new AdminScreen();
				adminScreenClass.adminScreen(adminInfo);
			}
			
			
		}
	}
	private class CancelListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			setVisible(false);
			
			AdminScreen adminScreenClass = new AdminScreen();
			
			adminScreenClass.adminScreen(adminInfo);
		}
	}

}
