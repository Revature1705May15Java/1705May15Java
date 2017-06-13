package com.ex.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.pojos.Bear;
import com.ex.pojos.Cave;
import com.ex.pojos.HoneyPot;
import com.ex.util.ConnectionUtil;

public class BearDAO {
	public void createBearsDemo() {
		Session session = ConnectionUtil.getSession();
		
		Transaction tx = session.beginTransaction();
		
		//Roaming Bears looking for a place to hibernate! zzz
		Bear parent = new Bear("black1","Black Bear", 100.00,2000.00,new HoneyPot(100,100));
		
		int i = (Integer) session.save(parent.getHoneyPot());
		System.out.println(i + " Parent Bear's ----------HoneyPot Generated ID");
		
		//Bear has little Cub
		Bear child = new Bear("brown1","Brown Bear",25,500,new HoneyPot(30,30));
			//Add child to Parent Bear's bearCub Collection
			parent.getBearCubs().add(child);
			//Save Child's Honeypot
			session.save(child.getHoneyPot());
		
		//They found a Cave!
		Cave newHome = new Cave(600, 500);
		parent.setDwelling(newHome);
		child.setDwelling(newHome);
		
		session.save(newHome);
		session.save(parent);
		session.save(child);
		tx.commit();
		session.close();
		System.out.println("------TIME TO HIBERNATE---------");
		
	}



}
