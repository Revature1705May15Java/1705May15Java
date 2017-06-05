package primeNumbers;

import java.util.ArrayList;

public class primeNumbers {
	static int listSize = 100;
	private static ArrayList<Integer> primes = new ArrayList<Integer>();
	private static ArrayList<Integer> nums = new ArrayList<Integer>();
	
	public static void main(String[] args) {
//		Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
		setListSize(1);
		run();
	}
	
	public static void setListSize(int size) {
		listSize = size;
		
		for(int i = 0; i < listSize; i++){
			nums.add(i+1);  // stores 1 to listSize, i.e. if listSize is 100, adds numbers 1 through 100.
		}
	}
	
	public static ArrayList<Integer> run() {
		
		System.out.print("Prime Numbers from 1 to " + listSize + ": ");
		for(int i = 0; i < listSize; i++){
			isPrime(nums.get(i));
		}
		System.out.println("Returned '" + primes.size() + "' primes.");
		System.out.println(primes.isEmpty());
		return primes;
	}
	
	public static String isPrime(int num) {
		
		for(int i = 2; i < num; i++) {
			if(num % i == 0) return ""; 
		}
			
		if(num == 1) return ""; 
		primes.add(num);
		return new String(num + " ");
	}
}
