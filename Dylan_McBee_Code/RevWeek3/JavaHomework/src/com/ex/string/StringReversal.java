package com.ex.string;

public class StringReversal {
	public static void main(String[] args) {
		String reverse = "reverse";
		for (int i = 0; i < reverse.length(); i++) {
		    reverse = reverse.substring(1, reverse.length() - i)
		        + reverse.substring(0, 1)
		        + reverse.substring(reverse.length() - i, reverse.length());
		 }
		 System.out.println(reverse);
	}
	
}