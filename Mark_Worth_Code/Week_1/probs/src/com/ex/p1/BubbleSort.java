package com.ex.p1;

public class BubbleSort {
	
	
	public int[] bubbleSort(int[] unsortedarray){
		boolean nosort=true;
		for(int i=0;i<unsortedarray.length-1;i++){
			int firstnum=unsortedarray[i];
			int secondnum=unsortedarray[i+1];
			if(firstnum>secondnum){
				unsortedarray[i]=(int)secondnum;
				unsortedarray[i+1]=(int)firstnum;
				nosort=false;
			}
			if(i==unsortedarray.length-2&&nosort==false){
				bubbleSort(unsortedarray);
			}
		}
		
		return unsortedarray;
	}
}