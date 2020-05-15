package logic;

import java.util.Scanner;

import menu.Voting;

public class Admin {
	
	//creating objects
	private Scanner scan = new Scanner(System.in);
	
	public void readPassword()  {//method to check password of admin
		
		System.out.println("Please enter the password");
		String pass = scan.nextLine();
		
			if(pass.equals("q1w2e3r4t5y6")) {
				adminMenu();
			}
			else {
				System.out.println("\n\n\n\n\n\n\nWrong password! Try again:");
				readPassword();
			}
	}
	
	public void adminMenu() {
		
		//creating objects by accessing classes to see results
		System.out.println("\n\n\n\n\n\nAdmin Hidden Menu: \nResults:");
		System.out.println("Voted for NYC: " + Voting.nycVotes );//see NYC votes
		System.out.println("Voted for LA: " + Voting.laVotes );//see LA votes
		scan.close();
		
	}


}
