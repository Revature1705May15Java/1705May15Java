package com.corejava;

/*
Create a notepad file called Data.txt and 
   enter the following: 
Mickey:Mouse:35:Arizona
Hulk:Hogan:50:Virginia
Roger:Rabbit:22:California
Wonder:Woman:18:Montana

Write a program that would read from the file 
  and print it out to the screen in the following format:

Name: Mickey Mouse
Age: 35 years
State: Arizona State
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q20 {
	static int num=3;
	static String filename="src/com/CoreJava/data.txt";//data source
	
	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new FileReader(filename));){
			String line=null;//current line - placeholder
			
			while((line=br.readLine())!=null){
				String[] curr = line.split(":");
				String string1="Name: ";
				String string2="Age: ";
				String string3="State: ";
				System.out.println(string1+curr[0]);
				System.out.println(string2+curr[1]);
				System.out.println(string3+curr[2]+"\n");
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
}
