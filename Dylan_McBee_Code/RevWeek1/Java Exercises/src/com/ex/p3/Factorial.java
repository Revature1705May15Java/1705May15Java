package com.ex.p3;

import java.util.Scanner;

class Calculation {

}

public class Factorial {

	public static int fact(int n) {
		int result;

		if (n == 1)
			return 1;

		result = fact(n - 1) * n;
		return result;
	}

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter integer to calculate");
		

		int a = fact(scan.nextInt());
		System.out.println("The factorial of the number is : " + a);
	}

}