package com.ex.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.List;


import com.ex.pojos.Person;
import com.ex.util.ConnectionUtil;

public class DaoImpl implements Dao {

	@Override
	public void createPerson(Person p) {
		// TODO Auto-generated method stub
		Session session = ConnectionUtil.getSession();
		try{
			Transaction tx = session.beginTransaction();
			session.save(p);
			tx.commit();
		}finally{
			session.close();
		}
	}

	@Override
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		Session session = ConnectionUtil.getSession();
		Person p = null;
		try{
			p = (Person) session.get(Person.class, id);
			System.out.println(p);
		}catch(HibernateException e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return p;
	}
	
	@Override
	public ArrayList<Person> getPersons() {
		// TODO Auto-generated method stub
		Session session = ConnectionUtil.getSession();
		ArrayList<Person> p = new ArrayList<Person>();
		try{
			Criteria criteria =  session.createCriteria(Person.class);
			
			p =(ArrayList<Person>) criteria.list();
			
			return p;
		}catch(HibernateException e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return p;
	}
	
	@Override
	public void updatePersons(Person p) {
		// TODO Auto-generated method stub
		Session session = ConnectionUtil.getSession();
		
		try{
			Transaction tx = session.beginTransaction();
			session.update(p);
			
			tx.commit();
			
		
		}catch(HibernateException e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
	}
	@Override
	public void deletePersons(int id) {
		// TODO Auto-generated method stub
		Session session = ConnectionUtil.getSession();
		
		try{
			Transaction tx = session.beginTransaction();
			session.delete(new Person(id, null, null));
			
			tx.commit();
			
		
		}catch(HibernateException e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
	}
	
	@Override
	public Person getPersonByID(int id){
		Person p = new Person();
		Session session = ConnectionUtil.getSession();
		Query query = session.createQuery("FROM Person WHERE P_ID =:id");
		query.setParameter("id", id);
		p =   (Person) query.list().get(0);
		
		return p;
	}

	public Person getPersonByLname(){
		Person p = new Person();
		Session session = ConnectionUtil.getSession();
		Criteria cri = session.createCriteria(Person.class).add(Restrictions.like("lastname", "bonds"));
		p = (Person) cri.list().get(0);
		return p;
	}
}