import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Q20. Create a notepad file called Data.txt and enter the following: 
		Mickey:Mouse:35:Arizona
		Hulk:Hogan:50:Virginia
		Roger:Rabbit:22:California
		Wonder:Woman:18:Montana

Write a program that would read from the file and print it out to the screen in the following format:

		Name: Mickey Mouse
		Age: 35 years
		State: Arizona State

 */
public class FileIO {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new FileReader("src/file.txt"));) {
			while(br.ready()){
				String temp = br.readLine();
				String temp2[] = temp.split(":");
				
				for(int i = 0; i < temp2.length; i++) {
					System.out.print(temp2[i] + " ");
				}
				System.out.println();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
}
