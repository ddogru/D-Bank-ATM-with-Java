package atmdbank;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
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


public class AdminAddDelete extends JFrame{

	private String adminName;
	private String adminSurname;
	private int adminID;
	private int adminPass;
	
	public void adminAddDelete(Object o){
		
		setTitle("Admin ADD Screen");
		setSize(500,550);
		setLocation(400,400);
	
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		
		JTextField textName = new JTextField("Name",10);
		JTextField textSurname = new JTextField("Surname",10);
		JTextField textID = new JTextField("ID",10);
		JTextField textPass = new JTextField("Password",10);
		
		JTable table = new JTable();
		
		Object [] columns = {"Name","Surname","ID","Password"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		
				
		JScrollPane sp = new JScrollPane(table);
		
		JButton btnAdd = new JButton("ADD"); 
		
		btnAdd.setBackground(Color.BLACK);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Times New Roman",Font.BOLD,15));
		

        Object[] row = new Object[4];
        
        btnAdd.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent b) {
             
                row[0] = textName.getText();
                row[1] = textSurname.getText();
                row[2] = textID.getText();
                row[3] = textPass.getText();
                
                model.addRow(row);
                
                try {
                	
                	 ArrayList <AdminDTO> adminList = new ArrayList<AdminDTO>();
                     BufferedWriter writer = new BufferedWriter(new FileWriter("AdminDTO.txt",true));
             		
             		adminName = String.valueOf(row[0]);
             		
             		adminSurname = String.valueOf(row[1]);
   
             		adminID = Integer.parseInt((String) row[2]);
             		
             		adminPass = Integer.parseInt((String) row[3]);
             			
             		adminList.add(new AdminDTO(adminName,adminSurname,adminID,adminPass));
             			
             		for(AdminDTO e : adminList) {
             				
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
        btnDelete.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Times New Roman",Font.BOLD,15));
        
        btnDelete.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent b) {
        		
        		int i = table.getSelectedRow();
        		
        		if(i >= 0) {
        			model.removeRow(i);
        			
        			try {
        				
        				File file1 = new File("AdminDTO.txt");
        				Scanner reader = new Scanner(file1);
        				
        				File file2 = new File("tempUserDTO.txt");
        				FileWriter fw = new FileWriter(file2);
        				BufferedWriter bw = new BufferedWriter(fw);
        				
        				while(reader.hasNextLine()) {
        					
        					String satir = reader.nextLine();
        					
        					String [] tokens = satir.split(",");
        					
        					int ID = Integer.parseInt(tokens[2]);
        					
        					String name = tokens[0];
        					String surname = tokens[1];
        					int pass = Integer.parseInt(tokens[3]);
        						
        					if(ID == adminID) {
        						continue;
        					}
        					else {
        						bw.write(name+","+surname+","+ID+","+pass+"\n");
        						
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
        			
        			ImageIcon image = new ImageIcon(AdminAddDelete.class.getResource("/error.png"));
					
					JOptionPane.showMessageDialog(null," You cannot delete! ","Unsuccessful",JOptionPane.INFORMATION_MESSAGE,image);
        		}
        	}
        });
        
        JButton btnFinish = new JButton("Finish and Return");
        
        btnFinish.setBackground(Color.BLACK);
        btnFinish.setForeground(Color.WHITE);
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
	
		panel.add(btnAdd);
		panel.add(btnDelete);
		panel.add(btnFinish);
	
		
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	
}

