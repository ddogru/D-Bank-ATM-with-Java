package atmdbank;

import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class UserList extends AbstractTableModel {
    private Vector data;
    private Vector columns;
    private String [] columnNames = {"NAME","SURNAME","ID","PASSWORD","BALANCE","IBAN"};
    
    public UserList() {
            String line;
            data = new Vector();
            columns = new Vector();
            try {
                    FileReader fr = new FileReader("UserDTO.txt");
                    BufferedReader br = new BufferedReader((fr));
                    
                    StringTokenizer st1 = new StringTokenizer(br.readLine(), " ,");
                    
                    while (st1.hasMoreTokens())
                            columns.addElement(st1.nextToken());
                    while ((line = br.readLine()) != null) {
                            StringTokenizer st2 = new StringTokenizer(line, " ,");
                            while (st2.hasMoreTokens())
                                    data.addElement(st2.nextToken());
                    }
                    br.close();
            } catch (Exception e) {
                    e.printStackTrace();
            }
    }
    
    public String getColumnName(int column) {
    	
		return columnNames[column];
	}
    
    public int getRowCount() {
            return data.size() / getColumnCount();
    }

    public int getColumnCount() {
            return 6;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
            return (String) data.elementAt((rowIndex * getColumnCount())
                            + columnIndex);
    }
    public void userList(Object o){
    	
    	JFrame frame = new JFrame();
    	frame.setTitle("User List Screen");
    	frame.setSize(500,500);
        frame.setLocation(400,400);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
    	
    	 UserList model = new UserList();
    	 
         JTable table = new JTable();
         table.setBounds(400,400, 500, 500);
         table.setModel(model);
         
         JScrollPane scrollpane = new JScrollPane(table);
         
         JButton btnFinish = new JButton("Finish and Return");
 		 btnFinish.addActionListener(new ActionListener() {
 			
 			public void actionPerformed(ActionEvent e) {
 				
 				frame.setVisible(false);
 				
 				AdminScreen adminScreenClass = new AdminScreen();
 				adminScreenClass.adminScreen(o);
 				
 			}
 			
 		});
         
 		 btnFinish.setBackground(Color.MAGENTA);
 		 btnFinish.setForeground(Color.BLACK);
         btnFinish.setFont(new Font("Times New Roman",Font.PLAIN,15));
         panel.add(scrollpane);
         panel.add(btnFinish);
         
         frame.add(panel);
         
         frame.setVisible(true);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setResizable(false);
         
    }
}