package com.ex.thread;

public class MyRunnable implements Runnable {
	StringBuilder sb = new StringBuilder("runnable");
	
	@Override
	public void run(){
		for(int i = 0; i <10; i++){
			System.out.println(sb.append(i));
		}
	}
	
}