//Registration for a new person to vote

package authorization;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import database.VoterDAOPostgres;
import logic.VoterLogic;
import menu.Voting;
import voter.Voter;

public class Registration {
	
	private Scanner scan = new Scanner(System.in); //user input
	private static Logger log = Logger.getRootLogger();
	
	public void signUp() throws ParseException, InterruptedException {
		
	
	
	//creating objects
	Voter voter = new Voter(); 
	VoterLogic logic = new VoterLogic();
	Voting vote = new Voting();
	
	System.out.println("Please enter your full name:");
	String fullName = scan.nextLine(); //saves input to full name
	String passportChoice;
	//VoterDAO voterDao = new VoterDAO();
	
	//check if name contains space
		if(!(logic.hasSpace(fullName) )) {//if not:
			System.out.println("Sorry, you didn't put your full name \n\n\n\n\n\n\n\n ");
			TimeUnit.SECONDS.sleep(3);
			signUp();//failed, start again registration
		}
		
	voter.setFullName(fullName);
	
	//Voter v = VoterDAO.getVoter(fullName);
		
	System.out.println("Are you citizen of United States?");
	passportChoice = scan.nextLine();
		if(!(logic.isCitizen(passportChoice))){
			System.out.println("Sorry, only citizens of Unites States can vote. Bye!");
			TimeUnit.SECONDS.sleep(3);
			Welcome.welcome();
		}
	
	//asks for voter to register ID
	System.out.println("Please enter your passport number:");
	String passNumber = scan.nextLine();
	voter.setPassportNumber(passNumber);
	
	
	
	if(!(logic.passportLength(passNumber))) {
		System.out.println("Sorry, The passport number must begin with 5 and be 9 numbers long. Please, start over. \n\n\n\n\n\n\n\n ");
		TimeUnit.SECONDS.sleep(5);
		signUp();
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
	
		if(logic.CalculateAge(dateOfBirth) && logic.passportLength(passNumber) && logic.hasSpace(fullName)) {
				//vote.accessToVote();//if nothing was failed then person can vote
				Terms.termsAndConditions();
			log.info("New voter!");
			}
	
		}
	}
	