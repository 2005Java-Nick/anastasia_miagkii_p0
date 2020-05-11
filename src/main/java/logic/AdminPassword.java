package logic;

import java.util.Scanner;

import menu.AdminMenu;

public class AdminPassword {
	
	//creating objects
	private Scanner scanner = new Scanner(System.in);
	AdminMenu admin = new AdminMenu();
	
	public void readPassword() {//method to check password of admin
		
		System.out.println("Please enter the password");
		String pass = scanner.nextLine();
		
		if(pass.equals("q1w2e3r4t5y6")) {
			System.out.println("works!");
			admin.adminMenu();
		}
		else {
			System.out.println("\n\n\n\n\n\n\nWrong password! Try again:");
			readPassword();
		}
	}

	
	
}
