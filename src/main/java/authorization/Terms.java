package authorization;

import java.text.ParseException;
import java.util.NoSuchElementException;

import menu.Voting;

public class Terms {
	
	
	public static void termsAndConditions() throws NoSuchElementException, InterruptedException, ParseException {
		Voting voting = new Voting();
		System.out.println("\n\n\n\n\t\t\tAs a voter of the Electronic Voting System, you agree not to:\r\n" + 
				"\r\n" + 
				"  1. Systematically retrieve data or other content from the Electronic Voting System to create \n  or compile, directly or indirectly, a collection, compilation, database, or directory\n  without written permission from us. \r\n" + 
				"  2. Trick, defraud, or mislead us and other voters, especially in any attempt to learn sensitive\n  information such as results. \r\n" + 
				"  3. Make improper use of our support services or submit false reports of abuse or misconduct. \r\n" + 
				"  4. Attempt to impersonate another person or use the name of another person.\r\n" + 
				"  5. Use any information obtained from the Electronic Voting System in order to harass, abuse, or\n  harm another person. \r\n" + 
				"  6. Harass, annoy, intimidate, or threaten any of our employees or agents engaged in providing\n  any portion of  the Electronic Voting System to you. \r\n" + 
				"\r\n" + 
				" 		\tDo you agree to the terms and conditions? Press Enter to accept...");
		
		pressEnter();
		voting.accessToVote();
		
		
	}
	
	private static void pressEnter()
	 { 
	        try
	        {
	            System.in.read();
	        }  
	        catch(Exception e)
	        {}  
	 }

}
