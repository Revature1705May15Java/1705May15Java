package com.ex.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ex.beans.Bear;
import com.ex.beans.Cave;

@Transactional
public class DaoImpl implements Dao 
{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	} 
	
	/* (non-Javadoc)
	 * @see com.ex.dao.DaoInterface#getBears()
	 */
	@SuppressWarnings("unchecked")
	public List<Bear> getBears()
	{
		Session s = sessionFactory.getCurrentSession();
		List<Bear> bears = new ArrayList<Bear>(); 
		bears = s.createQuery("from Bear").list(); 
		return bears;
	}
	
	/* (non-Javadoc)
	 * @see com.ex.dao.DaoInterface#getCaves()
	 */
	@SuppressWarnings("unchecked")
	public List<Cave> getCaves()
	{
		Session s = sessionFactory.getCurrentSession();
		List<Cave> caves = new ArrayList<Cave>(); 
		caves = s.createQuery("from Cave").list(); 
		return caves;
	}
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void makeBear(Bear b)
	{
		Session s = sessionFactory.getCurrentSession();
		s.saveOrUpdate(b.getCave());
		s.save(b); 
	}
}
