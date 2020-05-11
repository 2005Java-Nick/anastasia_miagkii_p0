//Registration for a new person to vote

package authorization;

import java.text.ParseException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import file.SaveVoter;
import logic.AdminPassword;
import logic.VoterLogic;
import menu.Voting;
import voter.Voter;

public class Registration {
	
	public void signUp() throws ParseException, InterruptedException {
		
	Scanner scan = new Scanner(System.in); //user input
	
	//creating objects
	Voter voter = new Voter(); 
	VoterLogic logic = new VoterLogic();
	Voting vote = new Voting();
	SaveVoter saveFile = new SaveVoter();
	
	//asks for user full name
	System.out.println("Please enter your full name:");
	String fullName = scan.nextLine(); //saves input to full name
	voter.setFullName(fullName);
	
	//check if name contains space
		if(!(logic.hasSpace(fullName) )) {//if not:
			System.out.println("Sorry, you didn't put your full name \n\n\n\n\n\n\n\n ");
			TimeUnit.SECONDS.sleep(3);
			signUp();//failed, start again registration
		}
	
	
// check if name contains only letters (FUNCTION DOESN'T WORK!!!)	
//	if(!(logic.isLetters(fullName))) {
//		System.out.println("Sorry, your name should contain only letters. \n\n\n\n\n\n\n\n ");
//		TimeUnit.SECONDS.sleep(3);
//		authorize();
//	}
	
	
	//asks for voter to register ID
	System.out.println("Please enter your 5-digit ID number:");
	String id = scan.nextLine();
	voter.setId(id);
	if(!(logic.IdLength(id))) {
		System.out.println("Sorry, your ID should contain 5-digits. \n\n\n\n\n\n\n\n ");
		TimeUnit.SECONDS.sleep(3);
		Welcome.welcome();
	}
	
	//asks for voter for his date of birth
	System.out.println("Please enter date of birth (yyyy/MM/dd): ");
	String dateOfBirth = scan.nextLine();
	voter.setBirthDate(dateOfBirth);
	
	if(!(logic.CalculateAge(dateOfBirth))) {//calculates if person is at least 18 years old
		System.out.println("Sorry, You must be at least 18 years old to continue voting. \n\n\n\n\n\n\n\n");
		TimeUnit.SECONDS.sleep(3);
		Welcome.welcome();
		}
	
		if(logic.CalculateAge(dateOfBirth) && logic.IdLength(id) && logic.hasSpace(fullName)) {
			saveFile.storeUserData(fullName, id);
		}
		vote.accessToVote();//if nothing was failed then person can vote
	
		}
	}
	