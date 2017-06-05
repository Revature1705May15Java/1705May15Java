/*
 * Q5. Write a substring method that accepts a string str and an integer idx and 
 * returns the substring contained between 0 and idx-1 inclusive.  Do NOT use any 
 * of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.
 */
public class Substring {
	public static void main(String[] args) {
		String str = "Hello World!";
		int index = 7, startPoint = 2;
		
		String mySubstring = subString(str, index);
		System.out.println("Substring of '" + str + "' and index = " + index + " is:        " + mySubstring);
		
		mySubstring = subString(str, startPoint, index);
		System.out.println("\nSubstring of '" + str + "' and index = " + startPoint + " and " + index + " is:  " + mySubstring);
		
	}
	
	static String subString(String str, int i) {
		String temp = "";
		for(int x = 0; x < i; x++){
			temp += str.charAt(x);
		}
		return temp;
	}
	static String subString(String str, int start, int end) {
		String temp = "";
		for(int x = start; x < end; x++){
			temp += str.charAt(x);
		}
		return temp;
	}
}
