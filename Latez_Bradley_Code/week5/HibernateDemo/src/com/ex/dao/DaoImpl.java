package com.ex.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ex.pojos.Person;
import com.ex.util.ConnectionFactory;

public class DaoImpl implements DAO {

	@Override
	public void createPerson(Person p) {
		// TODO Auto-generated method stub
		Session session = ConnectionFactory.getSession();
		try{
			Transaction tx = session.beginTransaction();
			session.save(p);
			tx.commit();
			
		}
		finally{
			session.close();
		}
		
		
	}

	@Override
	public Person getPersonById(int id) {
		Session session = ConnectionFactory.getSession();
		Person p = null;
		try{
			p = (Person)session.get(Person.class, id);
			System.out.println("Is this your guy? "+p);
			
			
		}catch(HibernateException e){
			e.printStackTrace();
			
		}
		
		return p;
	}

	@Override
	public List<Person> getAll() {
		Session session = ConnectionFactory.getSession();
		Criteria criteria = session.createCriteria(Person.class);
		List<Person> people = criteria.list();
		session.close();
		
		return people;
		
	}
	
	public void update(Person p){
		Session session = ConnectionFactory.getSession();
		
		try{
			Transaction tx = session.beginTransaction();
			
			session.update(p);
			
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public void deleteById(int id){
		Session session = ConnectionFactory.getSession();
		try{
			Transaction tx = session.beginTransaction();
			session.delete(new Person(id, null,null));
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}
	}
	
	public void getPersonByName(String name){
		
		
		Session session = ConnectionFactory.getSession();
		Query q = session.createQuery("FROM Person WHERE FIRST_NAME=:fn");
		q.setParameter("fn", name);
		List list = q.list();
			System.out.println(q.list().get(0));

		
	}

	@Override
	public Person getPersonByIdC(int id) {
		Session session = ConnectionFactory.getSession();
		Criteria cr = session.createCriteria(Person.class);
		cr.add(Restrictions.eq("fn","Mary"));
		List results = cr.list();
		System.out.println(results.toString());
		return (Person)results.get(0);
	}

}
