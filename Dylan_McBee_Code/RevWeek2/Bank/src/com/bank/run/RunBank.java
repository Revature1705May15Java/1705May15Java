package com.bank.run;

import java.util.Scanner;

import com.bank.pojos.User;
import com.bank.service.Service;

public class RunBank {

	static Scanner scan;
	static Service service = new Service();
	public static void main(String[] args) {
		run();
		
	}
	
	public static void run(){
		scan = new Scanner(System.in);
		int decision;
		boolean prompt = true;
		System.out.println("WELCOME TO DOGGO BANK"
				+"\n"
				+ " Are you already a member?");
		while(prompt){
			System.out.println("1: New Member");
			System.out.println("2: Returning Member");
			System.out.println("3: Terminate Program");
			decision = scan.nextInt();
			switch(decision){
			
			case 1:
				User newUser = joinBank();
				System.out.println(newUser);
				break;
			case 2:
				User currentUser = login();
				loggedIn(currentUser);
				break;
			case 3:
				prompt = false;
				break;
			
			}
		}
	}
	
	static User joinBank(){
		
		System.out.println("Please enter your first name");
		String fn = scan.nextLine();
		System.out.println("Please enter your last name");
		String ln = scan.nextLine();
		System.out.println("Please enter your password");
		String pw = scan.nextLine();
		System.out.println("Please enter your username or email address");
		String uName = scan.nextLine();
		
		return service.addUser(fn, ln, uName, pw);
	}
	
	static User login(){
		User u = new User();
		scan = new Scanner(System.in);
		System.out.println("Welcome back! Please login");
		System.out.println("Username:");
		String uName = scan.nextLine();
		if(service.checkUser(uName)){
			System.out.println("Hello " + uName + ", Please enter your password");
			String pw = scan.nextLine();
			if(service.checkPassword(uName, pw)){
				u = service.getUser(uName);
				String uFn = u.getFn();
				System.out.println("User verified! Welcome back " + uFn + "!" );
				return u;
			}
			else{
				System.out.println("Incorrect password, please try again");
				login();
			}
		}
		else{
			System.out.println("UserName does not exist, returning to first page.");
			run();
		}
		return null;
	}
	
	static void loggedIn(User u){
		System.out.println("What would you like to do today " + u.getFn() + "?");
	}

}
