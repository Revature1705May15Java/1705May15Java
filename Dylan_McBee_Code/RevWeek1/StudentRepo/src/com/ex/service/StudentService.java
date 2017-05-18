package com.ex.service;

import java.util.ArrayList;

import com.ex.dao.DAO;
import com.ex.dao.IoDAO;
import com.ex.pojos.Student;

public class StudentService {
	DAO dao = new IoDAO();
	public Student getStudentById(int id) {
		ArrayList<Student> s = dao.getAllStudents();
		for(Student student: s ){
			if(id==student.getId()){
				System.out.println(student.toString());
				return student;
			}
			
			
		}
		return null;
	}
	public Student addStudent(String fn, String ln, String email){
		return null;
	}
	/* - create student object taking in only 3 params
	 *  - fn, ln, email
	 *  service layer aka business logic layer handles the functionality of
	 *  getting the most recently used ID and assigning the new student the next value
	 *  - must also only accept unique email address
	 */
	
	public ArrayList<Student> getAllStudents(){
		return dao.getAllStudents();
	}
}