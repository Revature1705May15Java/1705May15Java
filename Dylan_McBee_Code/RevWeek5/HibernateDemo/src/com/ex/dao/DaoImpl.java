package com.ex.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.pojos.Person;
import com.ex.util.ConnectionUtil;

public class DaoImpl implements DAO {

	@Override
	public void createPerson(Person p) {
		Session session = ConnectionUtil.getSession();

		try {
			Transaction tx = session.beginTransaction();
			session.save(p);
			tx.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public Person getPersonById(int id) {
		Session session = ConnectionUtil.getSession();
		Person p = null;

		try {
			p = (Person) session.get(Person.class, id);
			System.out.println(p);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return p;
	}

	@Override
	public List<Person> getAllPeople() {
		Session session = ConnectionUtil.getSession();

		List<Person> people = session.createCriteria(Person.class).list();
		System.out.println(people);
		session.close();

		return people;
	}
	public void updatePerson(int id){
		Session session = ConnectionUtil.getSession();
		
		try {
			Person p = getPersonById(id);
			Transaction tx = session.beginTransaction();
			session.update(p);
			tx.commit();
		} finally {
			session.close();
		}
	
	}
	public void deleteById(int id){
		Session session = ConnectionUtil.getSession();
		try{
			Transaction tx = session.beginTransaction();
			session.delete(new Person(id,null,null));
			tx.commit();
		}finally{
			session.close();
		}
	}



}