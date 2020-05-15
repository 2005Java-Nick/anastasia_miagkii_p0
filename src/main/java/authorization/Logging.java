//Logging to voter's account to see his/her result
//Also, check whether or not is it administrator


package authorization;

import java.text.ParseException;
import java.util.Scanner;

import logic.Admin;
import logic.VoterLogic;

public class Logging {
	
		private Scanner scan = new Scanner(System.in);
		
		private String passportNum;
		

	public void logIn() throws ParseException, InterruptedException {
		
		//creating objects
		VoterLogic logic = new VoterLogic();
		Admin admin = new Admin();
		
		
		System.out.println("Please enter your passport number:");
		passportNum = scan.nextLine();
		
				if(logic.checkAdmin(passportNum)) { //if input = admin
					admin.readPassword(); //opens function to check password
					}
				else {
					System.out.println("Your passport number is " + passportNum);
				}
	
			}
	}

	
