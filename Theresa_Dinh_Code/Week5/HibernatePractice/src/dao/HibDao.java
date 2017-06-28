package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Person;
import util.ConnectionUtil;

public class HibDao implements Dao
{

	public void createPerson(Person p)
	{
		Session session = ConnectionUtil.getSession();
		
		try
		{
			Transaction t = session.beginTransaction(); 
			session.save(p); 
			t.commit();
		}
		finally
		{
			session.close();
		}
	}

	public Person getPersonById(int id) 
	{
		Session session = ConnectionUtil.getSession(); 
		Person p = null; 
		
		try
		{
			p = (Person)session.get(Person.class, id); 
			System.out.println(p);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return p;
	}

	@SuppressWarnings("unchecked")
	public List<Person> getPeople()
	{
		Session session = ConnectionUtil.getSession();
		List<Person> list = null; 
		
		try
		{
//			Criteria criteria = session.createCriteria(Person.class); 
//			list = criteria.list(); 
			
			list = session.createQuery("from pojos.Person").list(); 
			return list; 
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace(); 
		}
		finally
		{
			session.close();
		}
		return list; 
	}
	
	public void updatePerson(Person p)
	{
		Session session = ConnectionUtil.getSession(); 
		
		try
		{
			Transaction t = session.beginTransaction(); 
			
			session.update(p);
			t.commit(); 
		}
		finally
		{
			session.close();
		}
	}
	
	public void deletePerson(int id)
	{
		Session session = ConnectionUtil.getSession(); 
		
		try
		{
			Transaction t = session.beginTransaction(); 
			
			session.delete(new Person(id, null, null));
			t.commit(); 
		}
		finally
		{
			session.close();
		}
	}
}