//Voting menu. Gives opportunity to vote
package menu;

import java.text.ParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import authorization.CloseVoting;
import database.VoterDAOPostgres;
import voter.Voter;


public class Voting {
	
	public static int nycVotes;
	public static int laVotes;
	

	VoterDAOPostgres voterDao = new VoterDAOPostgres();
	private int choice = 0;//voter choice
	private Scanner scan = new Scanner(System.in);
	
	
	public void accessToVote() throws InterruptedException, ParseException,NoSuchElementException { 
		
		CloseVoting close = new CloseVoting();
		Voter v = new Voter();
		
		
		// PlayerDAO playerDao = new PlayerDAOPostgres();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\tHello, " + v.getFullName() + "! Your vote is very important to us. ");
		System.out.println("\n Please select one of the following:");
		System.out.println("\n\t1. New York City");
		System.out.println("\t2. Los Angeles");
		System.out.println("\nYour choice: ");
		
		choice = scan.nextInt();
		
		if(choice == 1) {//if voter inputs 1 then nyc gets +1 votes
			nycVotes++;
			System.out.println("Your vote for New York City submitted! Thank you ");
			v.setVote("New York City");
		}
		else if(choice == 2) {//if voter inputs 1 then la gets +1 votes
			laVotes++;
			System.out.println("Your vote for Los Angeles submitted! Thank you");
			v.setVote("Los Angeles");
		}
		else {//if voter inputs invalid number
			System.out.println("Invalid input! Please try again");
			TimeUnit.SECONDS.sleep(3);
			accessToVote();//failed.start again voting
		}
		
		voterDao.registerVoter(v);
		
		close.close();//close and start again from welcome
		
		
	}
	
	

}
