package lambdaPractice;

public class Maths 
{
	public static void main(String[] args)
	{
		Maths m = new Maths(); 
		
		MathOperation addition = (int a, int b)-> a + b; 
		MathOperation subtraction = (int a, int b)-> a - b; 
		
		int sum = m.operate(addition, 3, 3); 
		System.out.println(sum); 
	}
	private int operate(MathOperation op, int a, int b)
	{
		return op.operation(a, b); 
	}
}

interface MathOperation
{
	int operation(int a, int b); 
}