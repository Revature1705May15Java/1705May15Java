package com.rev.p6;

public interface even 
{

	public static void main(String[] args) 
	{
		boolean a = isEven(5);
		
		if(a)
		{
			System.out.println("even");
		}
		else
		{
			System.out.println("odd");
		}
		
		
		boolean b = isEven(8);
		
		if(b)
		{
			System.out.println("even");
		}
		else
		{
			System.out.println("odd");
		}
		
	}
	
	static boolean isEven(int num)
	{
		//stores value of divided by 2, truncates for odd numbers
		int test = num/2;
		
		//if the test number times 2 is equal to original number
		//then the number is even
		if(test*2 == num)
		{
			return true;
		}
		
		return false;
	}
}