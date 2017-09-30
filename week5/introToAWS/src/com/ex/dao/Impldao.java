package com.ex.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ex.pojos.Person;
import com.ex.util.ConnectionUtil;

public class Impldao implements dao{

	@Override
	public void deletePerson(Person p) {
		Session session = ConnectionUtil.getSession();
		
		try{
			Transaction ta = session.beginTransaction();
			session.delete(p);
			ta.commit();
		} 
		finally {
			session.close();
		}
	}
	
	public void deletePersonById(int id) {
		Session session = ConnectionUtil.getSession();
		
		try{
			Transaction ta = session.beginTransaction();
			session.delete(new Person(id, null, null));
			ta.commit();
		} 
		finally {
			session.close();
		}
	}
	
	@Override
	public void updatePerson(Person p) {
		Session session = ConnectionUtil.getSession();
		
		try{
			Transaction ta = session.beginTransaction();
			session.update(p);
			ta.commit();
		} 
		finally {
			session.close();
		}
	}
	
	@Override
	public void createPerson(Person p) {
		Session session = ConnectionUtil.getSession();
		
		try{
			Transaction ta = session.beginTransaction();
			session.save(p);
			ta.commit();
		} 
		finally {
			session.close();
		}
	}

	@Override
	public Person getPersonById(int id) {
		
		Session session = ConnectionUtil.getSession();
		Person p = null;
		
		try{
			p = (Person) session.get(Person.class, id);
			
			System.out.println(p.toString());
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
		return p;
	}
	
	@Override
	public List<Person> getAllPeople() {
		List<Person> people = null;
		Session session = ConnectionUtil.getSession();
		Person p = null;
		
		try{
			Criteria criteria = session.createCriteria(Person.class).add(Restrictions.eq("ln", "Raion"));
			people = criteria.list();
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
		return people;
	}
	
	
	
	
	
	public void deleteInHQL(Person p){
		Session session = ConnectionUtil.getSession();
		Transaction ta = session.beginTransaction();
		
		try {
		  String hql = "delete from Person where p_id = :pid";
		  Query query = session.createQuery(hql); // CLASS NAME, NOT TABLE NAME!
		  query.setInteger("pid", p.getId());
		  
		  System.out.println(query.executeUpdate());

		  ta.commit();
		} catch (Throwable t) {
		  ta.rollback();
		  throw t;
		} finally{
			session.close();
		}
	}

}
