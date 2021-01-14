package atmdbank;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserAddDelete extends JFrame{

	private String userName;
	private String userSurname;
	private int userID;
	private int userPass;
	private float userBalance;
	private int userIBAN ;
	
	public void userAddDelete(Object o){
		
		setTitle("User ADD Screen");
		setSize(550,550);
		setLocation(400,400);
	
		JPanel panel = new JPanel();
		
		panel.setBackground(Color.CYAN);
		
		JTextField textName = new JTextField("Name",10);
		JTextField textSurname = new JTextField("Surname",10);
		JTextField textID = new JTextField("ID",10);
		JTextField textPass = new JTextField("Password",10);
		JTextField textBalance = new JTextField("Balance",10);
		JTextField textIBAN = new JTextField("IBAN",10);
		
		JTable table = new JTable();
		
		Object [] columns = {"Name","Surname","ID","Password","Balance","IBAN"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		
				
		JScrollPane sp = new JScrollPane(table);
		
		JButton btnAdd = new JButton("Add");
		
		btnAdd.setBackground(Color.BLACK);
		btnAdd.setForeground(Color.GREEN);
		btnAdd.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		 
        Object[] row = new Object[6];
        
        btnAdd.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent b) {
             
                row[0] = textName.getText();
                row[1] = textSurname.getText();
                row[2] = textID.getText();
                row[3] = textPass.getText();
                row[4] = textBalance.getText();
                row[5] = textIBAN.getText();
                
                model.addRow(row);
                
                try {
                	
                	 ArrayList <UserDTO> userList = new ArrayList<UserDTO>();
                     BufferedWriter writer = new BufferedWriter(new FileWriter("UserDTO.txt",true));
             		
             		userName = String.valueOf(row[0]);
             		userSurname = String.valueOf(row[1]);
            
             		userID = Integer.parseInt((String) row[2]);
             		
             		userPass = Integer.parseInt((String) row[3]);
             		
             		userBalance = Float.valueOf((String) row[4]);
             		
             		userIBAN = Integer.parseInt((String) row[5]);
             			
             			
             		userList.add(new UserDTO(userName,userSurname,userID,userPass,userBalance,userIBAN));
             		
             		for(UserDTO e : userList) {
             				
             			writer.append(e.toString());
             			writer.newLine();
             		}
             			
             		writer.close();	
                }
                catch(IOException e) {
                	e.printStackTrace();
                }
               
            }
        });
        
        JButton btnDelete = new JButton("DELETE");
        
        btnDelete.setBackground(Color.BLACK);
        btnDelete.setForeground(Color.GREEN);
        btnAdd.setFont(new Font("Times New Roman",Font.BOLD,15));
        
        btnDelete.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent b) {
        		
        		int i = table.getSelectedRow();
        		
        		if(i >= 0) {
        			model.removeRow(i);
        			
        			try {
        				
        				File file1 = new File("UserDTO.txt");
        				Scanner reader = new Scanner(file1);
        				
        				File file2 = new File("tempUserDTO.txt");
        				FileWriter fw = new FileWriter(file2);
        				BufferedWriter bw = new BufferedWriter(fw);
        				
        				while(reader.hasNextLine()) {
        					
        					String line = reader.nextLine();
        					
        					String [] tokens = line.split(",");
        					
        					int ID = Integer.parseInt(tokens[2]);
        					
        					String name = tokens[0];
        					String surname = tokens[1];
        					int pass = Integer.parseInt(tokens[3]);
        					float balance = Float.valueOf(tokens[4]);
        					int IBAN = Integer.parseInt(tokens[5]);
        						
        					if(ID == userID) {
        						continue;
        					}
        					else {
        						bw.write(name+","+surname+","+ID+","+pass+","+balance+","+IBAN+"\n");
        						
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
        		else {
        			
        			ImageIcon image = new ImageIcon(UserAddDelete.class.getResource("/error.png"));
					
					JOptionPane.showMessageDialog(null," You cannot delete! ","Unsuccessful",JOptionPane.INFORMATION_MESSAGE,image);
        		}
        	}
        });
        
    	JButton btnFinish = new JButton("Finish and Return");
    	
    	 btnFinish.setBackground(Color.BLACK);
         btnFinish.setForeground(Color.GREEN);
         btnFinish.setFont(new Font("Times New Roman",Font.BOLD,15));
         
    	
		btnFinish.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
				AdminScreen adminScreenClass = new AdminScreen();
				adminScreenClass.adminScreen(o);
				
			}
			
		});
		
        
		panel.add(sp);
		panel.add(textName);
		panel.add(textSurname);
		panel.add(textID);
		panel.add(textPass);
		panel.add(textBalance);
		panel.add(textIBAN);
	
		panel.add(btnAdd);
		panel.add(btnDelete);
		panel.add(btnFinish);
	
		
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	
}

