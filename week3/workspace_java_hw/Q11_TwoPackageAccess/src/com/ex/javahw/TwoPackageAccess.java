/*
 * Q11. Write a program that would access two float-variables from 
 *      a class that exists in another package. Note, you will need
 *      to create two packages to demonstrate the solution.
 */
package com.ex.javahw;

import com.ex.secondPackage.SecondPackageClass;

public class TwoPackageAccess {
	public static void main(String[] args) {
		SecondPackageClass longName = new SecondPackageClass();
		
		System.out.println("The two float values in my class in another package are "
						+ longName.num + " and " + longName.num2);
		
	}
}
