package com.exercises;

import java.util.ArrayList;

public class Q8 {

	public static void main(String[] args) {
		System.out.println("works");
		ArrayList<String> names=new ArrayList<String>();
		ArrayList<String> palindromes=new ArrayList<String>();
		names.add("karan");
		names.add("madam");
		names.add("tom");
		names.add("civic");
		names.add("radar");
		names.add("sexes");
		names.add("jimmy");
		names.add("kayak");
		names.add("john");
		names.add("refer");
		names.add("billy");
		names.add("did");
		
		for(String name:names){
			int namesize=name.length();
			String reversename=new String();
			for(int i=0;i<name.length();i++){
				String appending=Character.toString(name.charAt(namesize-(i+1)));
				reversename=reversename.concat(appending);
			}
			if(reversename.equals(name)){
				palindromes.add(name);
			}
		}
		for(String palindrome:palindromes){
			System.out.println(palindrome);
		}
		
	}

}