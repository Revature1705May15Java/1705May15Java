package com.ex.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ex.pojos.Person;
import com.ex.util.ConnectionUtil;

public class DaoImpl implements DAO{

	
	
	@Override
	public void createPerson(Person p) {
		Session session= ConnectionUtil.getSession();
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
		Session session= ConnectionUtil.getSession();
		Person p = null;
		try{
			p=(Person) session.get(Person.class, id);
			System.out.println(p);
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return p;
	}

	@Override
	public List<Person> getAllPersons() {
		Session session = ConnectionUtil.getSession();
		try{
			Criteria criteria = session.createCriteria(Person.class);
			List<Person> people=criteria.list();
			session.close();
			return people;
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void update(Person p) {
		Session session = ConnectionUtil.getSession();
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

	@Override
	public void deleteById(int id) {
		Session session = ConnectionUtil.getSession();
		try{
			Transaction tx = session.beginTransaction();
			session.delete(new Person(id,null,null));
			tx.commit();
		}finally{
			session.close();
		}
	}

	@Override
	public void specialSelect() {
		Session session = ConnectionUtil.getSession();
		try{
			Criteria criteria = session.createCriteria(Person.class)
					.add(
							Restrictions.and(
									Restrictions.ilike("first_name", "Mark"),
									Restrictions.isNotNull("last_name")
									)
						);
			List<Person> people=criteria.list();
			for(Person person:people){
				System.out.println(person.getFirstname());
			}
			session.close();
		}catch(HibernateException e){
			e.printStackTrace();
		}
	}

}