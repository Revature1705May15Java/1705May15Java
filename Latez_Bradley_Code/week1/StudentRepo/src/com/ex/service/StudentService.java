package com.ex.service;

import java.util.ArrayList;

import com.ex.dao.DAO;
import com.ex.dao.IoDAO;
import com.ex.pojos.Student;

public class StudentService {
	
	DAO dao = new IoDAO();		
	
	public Student addStudent(String fn, String ln, String email){return null;}
	/* create student object taking in only 3 params:
	 * - fn, ln, email
	 * service layer aka business logic layer handles the functionality of
	 * getting the most recently used ID and assigning the new student the next value
	 * - must also only accept unique email address
	 * 
	 */
	

}
