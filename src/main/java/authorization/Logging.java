//Logging to voter's account to see his/her result
//Also, check whether or not is it administrator


package authorization;

import java.text.ParseException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import file.ReadFile;
import logic.AdminPassword;
import logic.VoterLogic;
import menu.AdminMenu;
import voter.Voter;

public class Logging {
	
	private Scanner scan = new Scanner(System.in);
	private String id;
	
	public void logIn() throws ParseException, InterruptedException {
		
		//creating objects
		VoterLogic logic = new VoterLogic();
		AdminMenu admin = new AdminMenu();
		AdminPassword pass = new AdminPassword();
		Voter voter = new Voter();
		ReadFile read = new ReadFile();
		
		
		System.out.println("Please enter your 5-digit ID number:");
		id = scan.nextLine();
		
		if(logic.checkAdmin(id)) { //if input = admin
			pass.readPassword(); //opens function to check password
		}
		else {
			if(!(logic.IdLength(id))) { //if id is not 5-digit number, show error and start again
				System.out.println("ERROR! Invalid ID number!");
				TimeUnit.SECONDS.sleep(3);//holds screen for 3 secs
				System.out.println("\n\n\n\n\n\n\n\n");//clear screen
				Welcome.welcome(); //failed, start again
			}
		
				else {
					String fullName = voter.getFullName();
					String id = voter.getId();
					read.confirmLogin(fullName, id);
				}
			}
		}

	}
