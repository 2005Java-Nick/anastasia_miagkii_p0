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
		
		System.out.println("\t\t\t________________________________________________________");
		System.out.println("\n\t\t\t\t  Welcome to Electronic Voting System! ");
		System.out.println("\t\t\t\t__________________________________________\n");
		System.out.println("\t1. Sign up to vote \n\t2. Log in to your account (Only for those who have already voted!)");
		System.out.println("\nPlease choose one of the above:");
		
		
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
