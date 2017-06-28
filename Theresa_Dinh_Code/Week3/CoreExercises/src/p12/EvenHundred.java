package p12;

public class EvenHundred 
{
	public static void main(String[] args)
	{
		int[] array = new int[100]; 
		
		// fills array from 1-100
		for(int i = 0; i < 100; i++)
		{
			array[i] = i+1; 
		}
		
		// prints all the ints that are even 
		for(int i : array)
		{
			if (i % 2 == 0)
				System.out.print(i + " "); 
		}
	}
}