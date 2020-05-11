package menu;

public class AdminMenu {

		public void adminMenu() {
			
			//creating objects by accessing classes to see results
			Voting results = new Voting();
			
			System.out.println("\n\n\n\n\n\nAdmin Hidden Menu: \nResults:");
			System.out.println("Voted for NYC: " + results.nycVotes );//see NYC votes
			System.out.println("Voted for LA: " + results.laVotes );//see LA votes
			
		}
}
