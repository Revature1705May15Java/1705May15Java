/*
 * Q19. Create an ArrayList and insert integers 1 through 10. Display the ArrayList.
 *      Add all the even numbers up and display the result. Add all the odd numbers up 
 *      and display the result. Remove the prime numbers from the ArrayList and print
 *      out the remaining ArrayList.
 */

import java.awt.List;
import java.util.ArrayList;

public class UsingArrayList {
	public static void main(String[] args) {
		int num = 10; // this number controls the size of the array, adding up to this number from 1.
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 1; i <= num; i++) list.add(i);
		
		int total = 0, totalOdd = 0;
		for(int i = 0; i < list.size(); i++) {
			if((list.get(i)%2) == 0) total += list.get(i);
			else totalOdd += list.get(i);
		}
		System.out.println("All even numbers sum is: " + total);
		System.out.println("All odd numbers sum is: " + totalOdd);	
		
		list = removePrime(list);
		System.out.println(list.toString());
	}
	
	public static ArrayList<Integer> removePrime(ArrayList<Integer> num) {
		for(int k = 0; k < num.size(); k++){
			for(int i = 2; i < num.get(k); i++) {
				if(num.get(k) % i == 0){
					num.remove(k);
					k = 0;
				}
			}
		
			if(num.get(k) == 1 || num.get(k) == 2) num.remove(k);
		}
		return num;
	}
}
