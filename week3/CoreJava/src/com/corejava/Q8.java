package com.corejava;

import java.util.ArrayList;

public class Q8 {
/*
Write a program that stores the following strings
 in an ArrayList and saves all the palindromes 
 in another ArrayList.
�karan�, �madam�, �tom�, �civic�, �radar�, 
�sexes�, �jimmy�, �kayak�, �john�,  �refer�, 
�billy�, �did�
 */
	public static boolean isPalindrome(String str){
		boolean isPal=true;
		int halfway=Math.floorDiv(str.length(), 2);
		for(int i=0;i<halfway;i++){
			if(str.charAt(i)!=str.charAt(str.length()-i-1)){
				isPal=false;
			}
		}
		return isPal;
	}
	public static void main(String[] args) {
		ArrayList<String> strings=new ArrayList<String>();
		String string1="karan";
		strings.add(string1); 
		String string2="madam";
		strings.add(string2);
		String string3="tom";
		strings.add(string3);
		String string4="civic";
		strings.add(string4);
		String string5="radar";
		strings.add(string5); 
		String string6="sexes";
		strings.add(string6); 
		String string7="jimmy";
		strings.add(string7); 
		String string8="kayak";
		strings.add(string8); 
		String string9="john";
		strings.add(string9);  
		String string10="refer";
		strings.add(string10); 
		String string11="billy";
		strings.add(string11); 
		String string12="did";
		strings.add(string12);
		ArrayList<String> pals=new ArrayList<String>();
		for(String str:strings){
			if(isPalindrome(str)){
				pals.add(str);
			}
		}
		for(String pal:pals){
			System.out.println(pal);
		}
	}

}