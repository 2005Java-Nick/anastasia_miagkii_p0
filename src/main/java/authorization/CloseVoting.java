//Closing method that is close voting for a person
//and starts voting for a new person

package authorization;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class CloseVoting {
	
	public void close() throws InterruptedException, ParseException {
	
		System.out.println("Thank you! Bye-bye!");	
		TimeUnit.SECONDS.sleep(3); //holds screen for 3 seconds
		System.out.println("\n\n\n\n\n\n\n\n");
		Welcome.welcome(); //starts voting for a new person
	}

}
