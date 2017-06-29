package com.ex.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.pojos.Bear;
import com.ex.pojos.Cave;
import com.ex.pojos.HoneyPot;
import com.ex.util.ConnectionFactory;

public class BearDAO {
	
	public void createBear(Bear b, HoneyPot hp, Cave c){
		Session session = ConnectionFactory.getSession();
		
		Transaction tx = session.beginTransaction();
		b.setDwelling(c);
		int hp_id = (Integer) session.save(b.getHoneyPot());
		System.out.println("Generated Honeypot: "+hp_id);
		session.save(b);
		tx.commit();
		session.close();
		
		
		
	}
	
	public Bear getOrload(int id){
		Session session = ConnectionFactory.getSession();
		Bear bearGet = (Bear) session.get(Bear.class, id);
		System.out.println(bearGet.getClass()+ ": getBear");
		return bearGet;
		
	}
	

}
