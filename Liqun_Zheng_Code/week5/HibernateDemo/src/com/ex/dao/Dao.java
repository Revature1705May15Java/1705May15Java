package com.ex.dao;

import java.util.ArrayList;

import com.ex.pojos.Person;

public interface Dao {
	
	void createPerson(Person p);
	Person getPersonById(int id);
	ArrayList<Person> getPersons();
	public void updatePersons(Person p);
	public void deletePersons(int id);
	public Person getPersonByID(int id);
	Person getPersonByLname();
}