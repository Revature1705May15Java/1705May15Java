package com.revature.dao;

import org.hibernate.Session;

import com.revature.model.User;
import com.revature.util.HibernateUtil;

public class UserDaoHibernate implements UserDao{
	
	private static UserDaoHibernate dao;
	
	private UserDaoHibernate(){}
	
	public static UserDaoHibernate getUserDao(){
		if(dao == null) return dao =  new UserDaoHibernate();
		return dao;
	}
	
	
	
	@Override
	public void update(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		session.saveOrUpdate(user);
		
		session.getTransaction().commit();
		
	}

	public static void main(String[] args) {
		User user = new User(1,"nonsense","1234",null,null);
		
		UserDaoHibernate dao = new UserDaoHibernate();
		
		dao.update(user);
	}
}
