package com.ex.service;

import java.util.ArrayList;
import java.util.Collections;

import com.ex.dao.DAO;
import com.ex.dao.IoDAO;
import com.ex.exceptions.IllegalCharacterException;
import com.ex.exceptions.InvalidEmailException;
import com.ex.exceptions.NonUniqueEmailException;
import com.ex.pojos.Student;
import com.ex.utilities.InputValidator;

public class StudentService {
	/**
	 * Data access object used to persist data in this project.
	 */
	private static DAO dao;
	/**
	 * The current ID number used for new students. ID numbers are not
	 * reused.
	 */
	private static int currentId;
	/**
	 * A list of all students.
	 */
	private static ArrayList<Student> studentList;
	
	/**
	 * Creates a new {@code StudentService} object. Instantiates a 
	 * new DAO object, populates a list of all students, and finds
	 * the next usable ID number for new students.
	 */
	public StudentService() {
		dao = new IoDAO();
		studentList = dao.getAllStudents();
		currentId = getCurrentIdNumber();
	}
	
	/**
	 * Returns the next usable ID number for new students.
	 * 
	 * @return	The next ID number that can be assigned to a new
	 * 			student.
	 */
	private int getCurrentIdNumber() {
		if(studentList.size() == 0) { 
			return 1;
		}
		else {
			int result = 0;
			
			for(Student s : studentList) {
				if(s.getId() > result) {
					result = s.getId();
				}
			}
			
			return ++result;
		}
	}
		
	/**
	 * Creates and adds a new student to the list of all students.
	 * 
	 * @param firstName		The new student's first name.
	 * @param lastName		The new student's last name.
	 * @param email			The new student's email address.
	 * @return				The newly created {@code Student} object. {@code Student} may 
	 * 						be null if something goes wrong.
	 * @throws NonUniqueEmailException	Thrown when an existing student has the same email address
	 * 									as the given email address.
	 * @throws InvalidEmailException	Thrown when the given email address is not properly formatted.
	 */
	public Student addStudent(String firstName, String lastName, String email) throws 	NonUniqueEmailException,
																						InvalidEmailException,
																						IllegalCharacterException {
		Student result = null;
		boolean isValid = InputValidator.validateEmail(email);
		
		if(InputValidator.validateName(firstName) || InputValidator.validateName(lastName)) {
			throw new IllegalCharacterException("Student's name cannot contain '" +
												IoDAO.DELIMITER + "'.");
		}
		if(isValid) {
			if(isEmailUnique(email)) {
				result = new Student(currentId++, firstName, lastName, email);
				studentList.add(result);
			}
			else {
				throw new NonUniqueEmailException("A student with the given email already exists.");
			}
		}
		else {
			throw new InvalidEmailException("Given email improperly formatted.");
		}
		
		return result;
	}
	
	/**
	 * Deletes the student with the given ID number from the list of
	 * all students. Returns {@code true} if the student was successfully
	 * removed.
	 * 
	 * @param id	The ID number of the student that is to be removed.
	 * @return		{@code true} if the student was successfully removed, and
	 * 				{@code false} if a student with the given ID number does
	 * 				not exist in the list of all students.
	 */
	public boolean removeStudent(int id) {
		for(Student student : studentList) {
			if(student.getId() == id) {
				studentList.remove(student);
				
				return true;
			}
		}
		
		// TODO: Consider throwing StudentNotFoundException
		return false;
	}
	
	/**
	 * Returns a list of all student objects. Specifically, creates a new
	 * {@code ArrayList} and fills it with copies of each {@code Student} stored
	 * in the list of all students.
	 * 
	 * @return	An {@code ArrayList} of all {@code Student} objects. 
	 */
	public ArrayList<Student> getAllStudents() {
		ArrayList<Student> results = new ArrayList<Student>();
		
		for(Student student : studentList) {
			results.add(student.makeCopy());
		}
			
		return results;
	}
	
	/**
	 * Returns a copy of the {@code Student} object that has the 
	 * given ID number.
	 * 
	 * @param id	The ID number of a student.
	 * @return		A {@code Student} object that has the given ID number.
	 * 				Object will be null if no student with the given ID
	 * 				number exists.
	 */
	public Student getStudentById(int id) {
		for(Student student : studentList) {
			if(student.getId() == id) {
				Student copy = student.makeCopy();
				return copy;
			}
		}
		
		// TODO: Consider throwing a StudentNotFoundException.
		return null;
	}
	
	/**
	 * Replaces an existing {@code Student} with the given, updated {@code Student} object.
	 * If the given {@code Student} has an ID number that does not match an existing
	 * student's, the list of all students will remain unchanged and this method will return
	 * a null {@code Student}.
	 * <br>
	 * If a student is ever added to the list of all students by this method, the list is 
	 * sorted before this method returns.
	 * 
	 * @param updatedStudent	The new {@code Student} that will replace an existing student.
	 * @return					The updated {@code Student} object, or a null student if no
	 * 							existing student shares an ID number with the given student.
	 * @throws InvalidEmailException	Thrown when the given student has an improperly formed
	 * 									email address.
	 * @throws NonUniqueEmailException	Thrown when the given student has shares an email address
	 * 									with another existing student.
	 */
	public Student updateStudent(Student updatedStudent) throws InvalidEmailException,
																NonUniqueEmailException,
																IllegalCharacterException {
		if(InputValidator.validateName(updatedStudent.getFirstName())
			|| InputValidator.validateName(updatedStudent.getLastName())) {
			throw new IllegalCharacterException("Student's name cannot contain '" +
												IoDAO.DELIMITER + "'.");
		}
		if(!InputValidator.validateEmail(updatedStudent.getEmail())) {
			throw new InvalidEmailException("Improperly formatted email address.");
		}

		int id = updatedStudent.getId();
		
		for(Student student : studentList) {
			if(id == student.getId()) {
				Student temp = student;
				studentList.remove(student);
				
				if(!isEmailUnique(updatedStudent.getEmail())) {
					studentList.add(temp);
					throw new NonUniqueEmailException("A student with the given email already exists");
				}
				else {
					studentList.add(updatedStudent);
				}
				
				Collections.sort(studentList);
				
				return updatedStudent;
			}
		}
		
		return null;
	}
	
	// TODO: Add comments to this method.
	public Student getStudentByEmail(String email) {
		Student result = null;
		
		for(int i = 0; i < studentList.size() && result == null; i++) {
			if(email.equals(studentList.get(i).getEmail())) {
				result = studentList.get(i);
			}
		}
		
		return result;
	}
	
	/**
	 * Removes each student from the data.txt which contains all students.
	 * All students stored in {@code studentList} are then written to said
	 * text file.
	 */
	public void writeAllStudentsToFile() {
		dao.removeAllStudents();
		
		for(Student s : studentList) {
			dao.addStudent(s);
		}
	}
	
	/**
	 * This method checks whether or not an existing student has the given
	 * email address.
	 * 
	 * @param email	The given email address.
	 * @return	{@code true} if an existing student has the given email address, 
	 * 			otherwise {@code false}.
	 */
	private boolean isEmailUnique(String email) {
		boolean isUnique = true;
		
		for(int i = 0; i < studentList.size() && isUnique; i++) {
			if(studentList.get(i).getEmail().equals(email)) {
				isUnique = false;
			}
		}
		
		return isUnique;
	}
}