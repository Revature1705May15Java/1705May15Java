package com.rev.nested;

public class LocalInner {
	
	private int data = 50;
	
	void display(){
		System.out.println("in display");
		class Local{
			void message(){
				System.out.println("in inner class method. data is " + 50);
			}
		}
		
		// inside outer class method display()
//		Local l = new Local();
//		l.message();
	}
	
	
	public static void main(String[] args) {
		LocalInner outer = new LocalInner();
		outer.display();
	}

}