package com.bank.run;

import java.util.ArrayList;
import java.util.Scanner;

import com.bank.pojos.User;
import com.bank.service.Service;
import com.bank.pojos.Account;
import com.bank.pojos.AccountType;

public class RunBank {
	static Scanner scan;
	static Service service = new Service();
	static User currentuser=new User();
	static ArrayList<AccountType> accounttypes= new ArrayList<AccountType>();
	public static ArrayList<Integer> currentuseraccounts=new ArrayList<Integer>();
	public static void main(String[] args) {
//		service.findAccounts(100);
//		service.changeUsername("test@gmail.com","test");
//		System.out.println("changed the name");
//		System.out.println(user);
//		System.out.println("Welcome "+user.getFn());
		accounttypes=service.getAccountTypes();
		startMenu();
	}
	
	static User JoinBank(){
		
//		scan = new Scanner(System.in);
		System.out.println("Please enter your first name");
		String fn = scan.nextLine();
		System.out.println("Please enter your last name");
		String ln = scan.nextLine();
		System.out.println("Please enter your password");
		String pw=scan.nextLine();
		System.out.println("Please enter your username or email address");
		String uname=scan.nextLine();
		if(service.findUser(uname)!=null){
			return service.addUser(fn,ln,pw,uname);
		}else{
			System.out.println("That username is taken, please try again");
			JoinBank();
		}
		return null;
	}
	static void logIntoAccount(){
		try{
			System.out.println("\nPlease enter your username or email address.");
			String uname=scan.nextLine();
			currentuser=service.findUser(uname);
//			System.out.println(currentuser.getFn()+" "+currentuser.getLn()+" "+currentuser.getId()+" "+currentuser.getUname()+" "+currentuser.getPw());
			if(currentuser!=null){
				currentuseraccounts=service.findAccounts(currentuser.getId());
				System.out.println("Please enter your password to log in.");
				String pw = scan.nextLine();
				boolean correctpw =service.checkPassword(pw, uname);
				if(correctpw){
					selectAccount();
				}else{
					System.out.println("Incorrect password, please try again");
					logIntoAccount();
				}
			}else{
				System.out.println("User was not found. Please try again or check your login information.");
				logIntoAccount();
			}
		}catch(NullPointerException e){
			System.out.println("There was a problem with your request, please try again.");
			e.printStackTrace();
			startMenu();
		}
		
			
	}
	static void selectAccount(){
		String acctmenu=new String();
		Integer selectedaccount = null;
		if(currentuseraccounts!=null){
			for(int i=0;i<currentuseraccounts.size()+1;i++){
				if(i<currentuseraccounts.size()){
				acctmenu=acctmenu+"["+(i+1)+"]: "+currentuseraccounts.get(i)+"\n";
				}else{
					acctmenu=acctmenu+"["+(i+1)+"]: "+"Create a new account";
				}
			}
			System.out.println("Logged in as "+currentuser.getFn()+" "+currentuser.getLn()
					+"\nWhich account would you like to view?\n"+acctmenu);
			String currentaccount=scan.nextLine();
			try{
				selectedaccount=Integer.parseInt(currentaccount);
				
			}catch(NumberFormatException e){
				System.out.println("Invalid input, please enter a valid number.");
				selectAccount();
			}
			if(1<=selectedaccount&&selectedaccount<=currentuseraccounts.size()){
				accountMenu(currentuseraccounts.get(selectedaccount-1));
				
			}else if(selectedaccount==currentuseraccounts.size()+1){
				createAccount();
			}else{
				System.out.println("That account number is not valid, please enter a new account number.");
				selectAccount();
			}
		}else{
			System.out.println("You don't currently have any accounts, would you like to create one?\n"
					+ "[1]: Yes\n"
					+ "[2]: No (Log out)");
			
			String optionstr=scan.nextLine();
			int option=0;
			try{
				option=(int)Integer.parseInt(optionstr);
				if(option==1){
					createAccount();
				}else{
					startMenu();
				}
			}catch(NumberFormatException e){
				System.out.println("Invalid input, please enter a valid number");
				selectAccount();
			}
			
		}
	}
	public static void createAccount(){
		AccountType option1=accounttypes.get(0);
		AccountType option2=accounttypes.get(1);
		AccountType option3=accounttypes.get(2);
		if(currentuseraccounts==null){
			System.out.println("Which kind of account would you like to make today?\n"
					+ "[1]: "+option1.getName()+"\n"
					+ "[2]: "+option2.getName()+"\n"
					+ "[3]: "+option3.getName());
			String optionstr=scan.nextLine();
			Integer option = null;
			try{
				option=Integer.parseInt(optionstr);
				if(option>0&&option<4){
					addAccount(option,currentuser.getId());
					System.out.println("Your account has been made.");
					startMenu();
				}
			}catch(NumberFormatException e){
				System.out.println("Invalid input, please enter a valid number");
				createAccount();
			}
		}
		if(currentuseraccounts.size()<6){
			System.out.println("Which kind of account would you like to make today?\n"
					+ "[1]: "+option1.getName()+"\n"
					+ "[2]: "+option2.getName()+"\n"
					+ "[3]: "+option3.getName());
			String optionstr=scan.nextLine();
			Integer option = null;
			try{
				option=Integer.parseInt(optionstr);
				if(option>0&&option<4){
					addAccount(option,currentuser.getId());
					System.out.println("Your account has been made.");
					startMenu();
				}
			}catch(NumberFormatException e){
				System.out.println("Invalid input, please enter a valid number");
				createAccount();
			}
		}else{
			System.out.println("You can only make six accounts.");
			selectAccount();
		}
			
	}
	public static void addAccount(int accounttype,int userid){
		service.newAccount(accounttype,userid);
	}
	public static void accountMenu(int accountid){
		System.out.println("What would you like to do today?\n"
				+"[1]: Make a withdrawal\n"
				+"[2]: Make a deposit\n"
				+"[3]: Check account balance\n"
				+"[4]: Close account\n"
				+"[5]: Return to account selection\n"
				+"[6]: Log out");
		String optionstr=scan.nextLine();
		Integer option = null;
		try{
			option=Integer.parseInt(optionstr);
			if(0<option&&option<7){
				changeAccount(option,accountid);
			}
		}catch(NumberFormatException e){
			System.out.println("Invalid input, please enter a valid number");
			accountMenu(accountid);
		}
	}
	public static void changeAccount(int option, int accountid) {
		double balance =service.getAccountBalance(accountid);
		System.out.println(option);
		switch(option){
		case(1):
			withdrawMoney(balance,accountid);
			break;
		case(2):
			depositMoney(balance,accountid);
			break;
		case(3):
			System.out.println("Your current account balance is $"+service.getAccountBalance(accountid));
			accountMenu(accountid);
			break;
		case(4):
			service.closeAccount(""+accountid);
			accountMenu(accountid);
			break;
		case(5):
			selectAccount();
			break;
		case(6):
			System.out.println("Thank you for banking with THE BANK.");
			startMenu();
		}
	}
	public static void withdrawMoney(double balance,int accountid){
		if(balance==0){
			System.out.println("Your funds are too low to make a withdrawal, please select another option.");
			accountMenu(accountid);
		}
		System.out.println("Current balance is $"+balance+", how much would you like to withdraw?");
		String strout=scan.nextLine();
		try{
			double withdrawalamount=Double.parseDouble(strout);
			if(withdrawalamount<=0){
				System.out.println("Invalid withdrawal amount, please enter a valid amount to withdraw.");
				withdrawMoney(balance,accountid);
			}else if(withdrawalamount<=balance){
				service.changeAccountBalance(""+(withdrawalamount*-1),""+accountid);
				System.out.println("Withdrawal complete, new balance is "+service.getAccountBalance(accountid));
				accountMenu(accountid);
			}else{
				System.out.println("Insufficient funds. Please try a different amount.");
				withdrawMoney(balance,accountid);
			}
			
		}catch(NumberFormatException e){
			System.out.println("Invalid input, please enter a number");
			withdrawMoney(balance,accountid);
		}
	}
	public static void depositMoney(double balance, int accountid){
		System.out.println("Current balance is $"+balance+", how much would you like to deposit?");
		String strin=scan.nextLine();
		try{
			double depositamount=Double.parseDouble(strin);
			if(depositamount<=0){
				System.out.println("Invalid deposit amount, please enter a valid amount to deposit.");
				depositMoney(balance,accountid);				
			}else{
				service.changeAccountBalance(""+depositamount,""+accountid);
				System.out.println("Deposit complete, new balance is "+service.getAccountBalance(accountid));
				accountMenu(accountid);
			}			
		}catch(NumberFormatException e){
			System.out.println("Invalid input, please enter a number");
			withdrawMoney(balance,accountid);
		}
		
	}
	
	static void startMenu(){
		scan=new Scanner(System.in);
		System.out.println("Welcome to THE BANK.\nAre you already a member?\n\n[1]: Yes\n[2]: No");
		
		try{
			String input=scan.nextLine();
			int selection=Integer.parseInt(input);
			if(selection==1){
				logIntoAccount();
			}else if(selection==2){
				currentuser=JoinBank();
				if(currentuser!=null){
				selectAccount();
				}else{
				startMenu();
				}
			}else{
				System.out.println("Invalid menu selection, please try again");
				startMenu();
			}
		}catch(NumberFormatException e){
			System.out.println("Invalid input, please enter a number on the menu.");
			startMenu();
		}
	}
}