package com.ex.p2;

import java.util.Scanner;

public class Fibonacci {

	public static long fibonacci(int primeFib){
		if(primeFib <=1) return primeFib;
		else return fibonacci(primeFib-1) + fibonacci(primeFib-2);
	}
	
	
	public static void main(String args[]) {
		System.out.println("Enter count of Fibonacci");
		Scanner scan = new Scanner(System.in);
		Fibonacci fib = new Fibonacci();
		int primeFib = scan.nextInt();
		for (int i = 0; i < primeFib; i++){
			System.out.printf("Fibonacci number of %d is: %d\n", i, (fib.fibonacci(i)));

		}
		scan.close();
		
	}
	
}