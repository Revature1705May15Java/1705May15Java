package com.ex.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.ex.pojos.Student;

public class IoDAO implements DAO{
	
	static String filename = "src/com/ex/datasource/data.txt"; // data source location

	@Override
	public Student addStudent(Student s) {		
		int id = s.getId();
		String fName = s.getFirstName();
		String lName = s.getLastName();
		String email = s.getEmail();
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));){// true param enables append capability 
			bw.write("" + id + ":" + fName + ":" + lName + ":" + email +"\n");
			return s;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	
		
	}

	@Override
	public boolean removeStudent(Student s) {

		return false;
	}

	@Override
	public ArrayList<Student> getAllStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		
			try {
				BufferedReader br = new BufferedReader(new FileReader(filename));
				String line = null; // current line - placeholder
				
				while((line = br.readLine())!=null){
					String[] curr = line.split(":");
					
					Student temp = new Student();
					temp.setId(Integer.parseInt(curr[0]));
					temp.setFirstName(curr[1]);
					temp.setLastName(curr[2]);
					temp.setEmail(curr[3]);
					
					students.add(temp);
					System.out.println(temp);
					
					
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		finally{
		
			
		}
		
		
		
		
		return students;
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student updateStudent(Student updatedStudent) {
		// TODO Auto-generated method stub
		return null;
	}

}
