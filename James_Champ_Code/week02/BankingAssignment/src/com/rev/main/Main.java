package com.rev.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.rev.pojos.Account;
import com.rev.pojos.AccountType;
import com.rev.pojos.User;
import com.rev.service.Service;
import com.rev.util.InputValidator;

// TODO: Add comments.
public class Main {
	private static final String BANK_NAME = "[Placeholder Bank Name]";
	
	private static final int MAX_LOGIN_ATTEMPTS = 3;
	private static final int MAX_NUMBER_OF_ACCOUNTS = 6;
	
	private static final int INVALID_SELECTION = -1;
	private static final int INITIAL_MENU_ITEMS = 3;
	private static final int USER_MENU_ITEMS = 3;
	private static final int ACCOUNT_MENU_ITEMS = 6;
	private static final int ACCOUNT_TYPE_MENU_ITEMS = 4;
	
	private static Scanner scan;
	private static Service service;
	
	/**
	 * Main entry point for this program.
	 * 
	 * @param args	Command line arguments.
	 */
	public static void main(String[] args) {
		run();
	}

	/**
	 * Begins the banking program. Opens the Scanner,
	 * creates a new Service object, prints a welcome
	 * message to the user, and displays the initial
	 * menu.
	 */
	private static void run() {
		scan = new Scanner(System.in);
		service = new Service();
		
		System.out.println("\tWelcome to " + BANK_NAME + "'s portal.\n");
		displayInitialMenu();
	}
	
	// TODO: Rename and add comments.
	private static void displayInitialMenu() {
		switch(printInitialOptions()) {
			case 1:
				login();
				break;
			case 2:
				signUp();
				break;
			case 3:
				exitProgram();
				break;
		}
	}
	
	/**
	 * Displays the initial menu and prompts the user
	 * for a selection. Once a valid selection is made,
	 * the value of the selection is returned.
	 * 
	 * @return	The user's menu item selection.
	 */
	private static int printInitialOptions() {
		int result;
		String line;
		
		System.out.println("\tWhat would you like to do?\n");

		do {
			System.out.println("\t1. Log in to existing account.");
			System.out.println("\t2. Become a member.");
			System.out.println("\t3. Exit program.\n");
			
			System.out.print("\tMake a selection [1 - " + INITIAL_MENU_ITEMS + "]: ");
			
			line = scan.nextLine().trim();
			System.out.println();
			
			try {
				result = Integer.parseInt(line);
				
				if(!validateMenuSelection(result, INITIAL_MENU_ITEMS)) {
					result = INVALID_SELECTION;
					printErrorMessage(INITIAL_MENU_ITEMS);
				}
			}
			catch(NumberFormatException e) {
				result = INVALID_SELECTION;
				printErrorMessage(INITIAL_MENU_ITEMS);
			}
		} while(result == INVALID_SELECTION);
		
		return result;
	}
	
	/**
	 * Logs a user into the banking system, allowing them
	 * to access and modify their accounts.
	 * <p>
	 * This method gets an email from the user. If the email is
	 * valid and matches that of an existing user, the user is then
	 * prompted for a password. If the password is correct, the user
	 * will have access to their accounts.
	 * </p>
	 * <p>
	 * If the password is incorrectly entered three times, the program
	 * will end. This is to simulate a user being locked out of a 
	 * banking system for some amount of time after too many 
	 * unsuccessful login attempts.
	 * </p>
	 */
	private static void login() {
		String email;
		String password;
		
		email = promptForEmail();
		
		if(service.isEmailUnique(email)) {
			System.out.println("\tYou are not a member of " + BANK_NAME + ".\n");
			displayInitialMenu();
		}
		else {
			User user = service.getUser(email);
			int count = MAX_LOGIN_ATTEMPTS;
			boolean isPasswordCorrect = false;
			
			do {
				count--; 
				
				System.out.print("\tEnter your password: ");
				password = scan.nextLine().trim();
				System.out.println();
				
				if(password.equals(user.getPassword())) {
					isPasswordCorrect = true;
				}
				else {
					System.out.println("\tIncorrect password.");
					System.out.print("\t" + count);
					
					if(count != 1){
						System.out.println(" attempts remaining.\n");
					}
					else {
						System.out.println(" attempt remaing.\n");
					}
				}
				
			} while(count > 0 && !isPasswordCorrect);
			
			if(isPasswordCorrect) {
				displayUserMenu(user);
			}
			else {
				System.out.println("\tMaximum login attempts reached.\n");
				exitProgram();
			}
		}
	}
	
	/**
	 * Signs a new user up as a member of the bank. Logs 
	 * the newly created user into the banking system on
	 * success.
	 * <p>
	 * This method first prompts a user for their email 
	 * address. If the given address is not already in the
	 * database, the user is then prompted for their first
	 * name, last name, and a password.
	 * </p>
	 * <p>
	 * If all of the user's input is valid, a new {@code User}
	 * object is created, and the user is added to the database.
	 * The user is then logged into the banking system.
	 * </p>
	 * <p>
	 * If the user enters an email that is already in the database,
	 * the user is taken back to the previous menu.
	 * </p>
	 */
	private static void signUp() {
		String email;
		String firstName;
		String lastName;
		String password;
				
		// Get email
		email = promptForEmail();
		
		
		if(service.isEmailUnique(email)) {	// Email is unique.
			// Get first name:
			do{
				System.out.print("\tEnter your first name: ");
				firstName = scan.nextLine().trim();
				System.out.println();
			} while(firstName.length() == 0);
			
			// Get last name:
			do{
				System.out.print("\tEnter your last name: ");
				lastName = scan.nextLine().trim();
				System.out.println();
			} while(lastName.length() == 0);
			
			// Get password:
			do{
				System.out.print("\tEnter your password: ");
				password = scan.nextLine().trim();
				System.out.println();
			} while(password.length() == 0);
			// TODO: Ensure password is strong before continuing.
	
			User user = service.addUser(firstName, lastName, password, email);
	
			System.out.println("\tYou have successfully became a member of " + BANK_NAME);
			
			displayUserMenu(user);
		}
		else {	// Email exists in the database.
			System.out.println("\tYou are already a member of " + BANK_NAME + ".\n");
			displayInitialMenu();
		}
	}
	
	// TODO: Comments
	private static void displayUserMenu(User user) {
		String line;
		int selection;
		
		System.out.println("\tWelcome, " + user.getFirstName() + 
							" " + user.getLastName() + ".\n");
		
		do {
			System.out.println("\tWhat would you like to do today?\n");
			
			System.out.println("\t1. Create a new account.");
			// TODO: Rename option to something more appropriate
			System.out.println("\t2. View account details.");
			System.out.println("\t3. Log out.");
			
			System.out.print("\n\tMake a selection [1 - " + USER_MENU_ITEMS + "]: ");
			line = scan.nextLine().trim();
			System.out.println();
			
			try {
				selection = Integer.parseInt(line);
			}
			catch(NumberFormatException e) {
				selection = INVALID_SELECTION;
				// TODO: Print error message.
			}
			
			// TODO: Print error message if selection is not valid.
		} while(!validateMenuSelection(selection, USER_MENU_ITEMS));
		
		switch(selection) {
			case 1:
				createNewAccount(user);
				break;
			case 2:
				viewAccountDetails(user);
				break;
			case 3:
				exitProgram();
				break;
		}
	}
	
	private static void createNewAccount(User user) {
		if(user.getAccounts().size() == MAX_NUMBER_OF_ACCOUNTS) {
			System.out.println("\tCannot create new account.");
			System.out.println("\tYou currently have the maximum allowable number of accounts.\n");
		}
		else {
			// TODO: Test this once database triggers are set.
			AccountType type = selectAccountType();
			
			if(type == null) {	// User cancelled account creation
				displayUserMenu(user);
			}
			else {
				// TODO: Pass new account to service.
				
				// TODO: After account is created, go to account details screen.
			}
		}
	}
	
	private static AccountType selectAccountType() {
		int selection;
		String line;
		
		do {
			System.out.println("\tWhat type of account would you like to create?\n");
			System.out.println("\t1. Checking");
			System.out.println("\t2. Savings");
			System.out.println("\t3. Credit");
			System.out.println("\t4. Cancel account creation");
			
			System.out.print("\n\tMake a selection [1 - " + ACCOUNT_TYPE_MENU_ITEMS + "]: ");
			line = scan.nextLine().trim();
			System.out.println();
			
			try {
				selection = Integer.parseInt(line);
			}
			catch(NumberFormatException e) {
				selection = INVALID_SELECTION;
				// TODO: Print error message
			}
			
			// TODO: Print error message if not selection is not valid.
		} while(!validateMenuSelection(selection, ACCOUNT_TYPE_MENU_ITEMS));
		
		AccountType type;
		
		switch(selection) {
			case AccountType.CHECKING:
				type = new AccountType(AccountType.CHECKING);
				break;
			case AccountType.SAVINGS:
				type = new AccountType(AccountType.SAVINGS);
				break;
			case AccountType.CREDIT:
				type = new AccountType(AccountType.CREDIT);
				break;
			default:
				return null;
		}
		
		return type;
	}

	
	private static void viewAccountDetails(User user) {
		int selection = selectAccount(user);
		
		if(selection == 0) { // User has no accounts
			displayUserMenu(user);
		}
		else if(selection > user.getAccounts().size()) { // User has cancelled view account details
			displayUserMenu(user);
		}
		else {
			displayAccountActions(user, user.getAccounts().get(--selection));
		}
	}
	
	// TODO: Test this method
	private static int selectAccount(User user) {
		ArrayList<Account> accounts = user.getAccounts();
		int selection;
		
		if(accounts.size() == 0) {
			System.out.println("\tYou currently have no open accounts.\n");
			selection = 0;
		}
		else {
			String line;
			
			do {
				System.out.println("\tWhich account would you like to view?\n");
				System.out.printf("\t%13s%17s%18s%n", "Type", "Balance", "Acct. Number");
				System.out.println("\t     -------------------------------------------");
				
				for (int i = 1; i <= user.getAccounts().size(); i++) {
					Account a = accounts.get(i - 1);
					// TODO: See what adding a dollar sign would look like
					System.out.printf("\t%d.%11s%17.2f%18d%n", i, a.getType().getName(), a.getBalance(),
							a.getAccountId());
				} 
				
				System.out.println("\n\t" + (accounts.size() + 1) + ". Cancel view account.");
				
				System.out.print("\n\tMake a selection [1 - " + (accounts.size() + 1) + "]: ");
				line = scan.nextLine();
				System.out.println();
				
				try {
					selection = Integer.parseInt(line);
				}
				catch(NumberFormatException e) {
					selection = INVALID_SELECTION;
					// TODO: Print error message
				}
				
				// TODO: Print error message if selection is out of range
			} while(!validateMenuSelection(selection, accounts.size() + 1));
		}
		
		return selection;
	}
	
	private static void displayAccountActions(User user, Account account) {
		String line;
		int selection;
		
		do {
			System.out.println(account.toString() + "\n\n");
			
			System.out.println("\tAccount actions:\n");
			
			System.out.println("\t1. Deposit funds");
			System.out.println("\t2. Withdraw funds");
			System.out.println("\t3. Transfer funds");
			System.out.println("\t4. Add account holder");
			System.out.println("\t5. Close account");
			System.out.println("\t6. Back");
			
			System.out.print("\n\tMake a selection [1 - " + ACCOUNT_MENU_ITEMS + "]: ");
			line = scan.nextLine().trim();
			System.out.println();
			
			try {
				selection = Integer.parseInt(line);
			}
			catch(NumberFormatException e) {
				selection = INVALID_SELECTION;
				// TODO: Print error message
			}
			
			// TODO: Print error message if selection is out of range
		} while(!validateMenuSelection(selection, ACCOUNT_MENU_ITEMS));
		
		switch(selection) {
			case 1:
				depositFunds(user, account);
				break;
			case 2:
				withdrawFunds(user, account);
				break;
			case 3:
				transferFunds(user, account);
				break;
			case 4:
				addAccountHolder(user, account);
				break;
			case 5:
				closeAccount(user, account);
				break;
			case 6:
				displayUserMenu(user);
				break;
		}
	}
	
	private static void depositFunds(User user, Account account) {
		// Determine amount
		
		// Call service.deposit(account, amount);
		
		// Go back to account menu
	}
	
	private static void withdrawFunds(User user, Account account) {
		// Determine amount
		
		// Call service.withdraw(account, amount);
		
		// Go back to account menu
	}
	
	private static void transferFunds(User user, Account account) {
		// Determine amount
		
		// Determine recipient account id
		
		// Call service.transfer(account, toAccount, amount);
		
		// Go back to account menu
	}
	
	private static void addAccountHolder(User user, Account account) {
		// Determine new account holder's id (This seems somewhat unrealistic...)
		
		// Call service.addAccountHolder(account, newAccountHolder);
		
		// Go back to account menu
	}
	
	private static void closeAccount(User user, Account account) {
		// Prompt for confirmation
		String line;
		int selection;
		
		do {
			System.out.println("\tAre you sure that you want to close this account?\n");
			
			System.out.println("\t1. Yes");
			System.out.println("\t2. Cancel");
			
			System.out.print("\n\tMake a selection [1 - 2]: ");
			line = scan.nextLine().trim();
			System.out.println();
			
			try {
				selection = Integer.parseInt(line);
			}
			catch(NumberFormatException e) {
				selection = INVALID_SELECTION;
				// TODO: Print error message.
			}
			
			// TODO: Print error message if out of range.
		} while(!validateMenuSelection(selection, 2));
		
		if(selection == 1) {
			// TODO: Call service.closeAccount(account);
			
			// Go back to user menu
		}
		else {
			displayAccountActions(user, account);
		}		
	}
	
	/**
	 * Prompts the user for an email address, and returns the
	 * address if it is properly formed. While the input is
	 * not properly formed, the user will be prompted for an
	 * email.
	 * 
	 * @return	The user's email address.
	 */
	private static String promptForEmail() {
		String email;
		boolean isValidInput = false;
				
		do {
			System.out.print("\tEnter your email address: ");
			email = scan.nextLine().trim();
			System.out.println();
			
			if(InputValidator.validateEmail(email)) {
				isValidInput = true;
			}
			else {
				System.out.println("\tYour email address was improperly formed.\n");
			}
		} while(!isValidInput);
		
		return email;
	}
	
	/**
	 * Used to end this program. Closes the Scanner and prints a message 
	 * that bids the user adieu.
	 */
	private static void exitProgram() {
		scan.close();
		
		System.out.println("\tThanks for visiting " + BANK_NAME + ".");
		System.out.println("\tHave a great day!\n");
		
		System.out.println("\nProgram terminated...");
	}
	
	/**
	 * Determines whether a user's menu item selection is within range.
	 * 
	 * @param input				The number that the user entered.
	 * @param totalSelections	The total number of menu items in the current menu.
	 * @return					{@code true} if the user's selection is valid, {@code false}
	 * 							otherwise.
	 */
	private static boolean validateMenuSelection(int input, int totalSelections) {
		return input >= 1 || input <= totalSelections;
	}
	
	/**
	 * Prints an error message when a user attempts to choose a menu item that
	 * is out of range.
	 * 
	 * @param totalSelections	The total number of selections in the current
	 * 							menu.
	 */
	private static void printErrorMessage(int totalSelections) {
		System.out.println("\n\tInvalid selection.\n" +
						 	"\tPlease enter a whole number between 1 and " +
							totalSelections + ".\n");
	}
}
