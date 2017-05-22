package com.rev.classes;

public class LocalInner {
	private int data = 50;
	
	void display() {
		class Local {
			void message() {
				System.out.println("In inner class method. Data is " + data);
			}
		}
		
		// inside outer class method display()
		Local l = new Local();
		l.message();
	}
	
	public static void main(String[] args) {
		LocalInner outer = new LocalInner();
		outer.display();
	}
}