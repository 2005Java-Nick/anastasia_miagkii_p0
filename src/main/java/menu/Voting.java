//Voting menu. Gives opportunity to vote
package menu;

import java.text.ParseException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import authorization.CloseVoting;

public class Voting {
	
	public int nycVotes;
	public int laVotes;
	private int choice = 0;//voter choice
	private Scanner scan = new Scanner(System.in);
	
	
	public void accessToVote() throws InterruptedException, ParseException { 
		
		CloseVoting close = new CloseVoting();
		
		System.out.println("\n\n\n\n\n\n\n\n\nWelcome to vote! ");
		System.out.println("Your vote is very important to us. Please select one of the following:");
		System.out.println("1. New York City");
		System.out.println("2. Los Angeles");
		choice = scan.nextInt();
		
		if(choice == 1) {//if voter inputs 1 then nyc gets +1 votes
			nycVotes++;
		}
		else if(choice == 2) {//if voter inputs 1 then la gets +1 votes
			laVotes++;
		}
		else {//if voter inputs invalid number
			System.out.println("Invalid input! Please try again");
			TimeUnit.SECONDS.sleep(3);
			accessToVote();//failed.start again voting
		}
		
		
		close.close();//close and start again from welcome
		
		
	}
	
	

}
