//First window 
//Person has two option 
//To sign up to vote
//To log in to his account and see results
package authorization;

import java.text.ParseException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Welcome {
	
	//choose sign up or log in
	private static int choice = 0;
	
	public static void welcome() throws ParseException, InterruptedException {
		
		//creating objects
		Scanner scan = new Scanner(System.in);//reads person input
		Registration register = new Registration();
		Logging login = new Logging();
		
		System.out.println("Welcome to Electronic Voting System!");
		System.out.println("1. Sign up to vote \n2. Log in to your account");
		
		
		choice = scan.nextInt();
		if(choice == 1) { //if person input is 1 then sign up to vote
			register.signUp();
		}
		else if(choice == 2) {//if person input is 2 then log in to the account
			login.logIn();
		}
		else {//incorrect input. Start again
			System.out.println("Invalid input! Please try again");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("\n\n\n\n\n\n");
			welcome();//failed. start again welcome
		}
		
	}
}
