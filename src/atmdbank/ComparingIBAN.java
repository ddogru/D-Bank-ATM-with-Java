package atmdbank;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ComparingIBAN {
	
	public void Transfering(int transferingAmount,int otherCustomerIBAN) throws IOException { 
			
		File read = new File("UserDTO.txt");
		Scanner reader = new Scanner(read);
			
		while(reader.hasNextLine()) {
				
			String line = reader.nextLine();
				
			String [] tokens = line.split(",");
				
			int IBAN = Integer.parseInt(tokens[5]);
						
			if(otherCustomerIBAN == IBAN) {
							
				String name = tokens[0];
				String surname = tokens[1];
				int ID = Integer.parseInt(tokens[2]);
				int Pass = Integer.parseInt(tokens[3]);
				float balance = Float.valueOf(tokens[4]);
							
							
				UserDTO user = new UserDTO(name,surname,ID,Pass,balance,IBAN);
						
				ComparingIBAN comparingIBANClass = new ComparingIBAN();
				comparingIBANClass.Update(user,transferingAmount);
				break;
			}
			else {
				
					
			}	
		}
		reader.close();
	}


	private void Update(Object o, int transferingAmount) throws IOException {
			
		ArrayList<UserDTO>userList = new ArrayList<UserDTO>();
			
		String oldLine = o.toString();
			
		String [] tokens = oldLine.split(",");		

		File read = new File("UserDTO.txt");
		Scanner reader = new Scanner(read);
			
		StringBuffer buffer = new StringBuffer();
			
		while(reader.hasNextLine()) {
			buffer.append(reader.nextLine()+System.lineSeparator());
		}
			
		String fileContents = buffer.toString();
			
		reader.close();
				
		String name = tokens[0];
		String surname = tokens[1];
		int ID = Integer.parseInt(tokens[2]);
		int Pass = Integer.parseInt(tokens[3]);
		int IBAN = Integer.parseInt(tokens[5]);
				
		float balance = Float.valueOf(tokens[4]);
					
		float total = balance + transferingAmount;
				
		userList.add(new UserDTO(name,surname,ID,Pass,total,IBAN));
				
				
		FileWriter fw = new FileWriter("UserDTO.txt");
					
		for(UserDTO e : userList) {
						
			String newLine = e.toString();
			fileContents = fileContents.replaceAll(oldLine, newLine);
			
		}
						
		fw.append(fileContents);
		fw.flush();
		fw.close();
			
		
	}
}





