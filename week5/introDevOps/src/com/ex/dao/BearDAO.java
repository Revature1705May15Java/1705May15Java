package com.ex.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.pojos.Bear;
import com.ex.pojos.Cave;
import com.ex.pojos.HoneyPot;
import com.ex.util.ConnectionUtil;

public class BearDAO {
	//pass in bear object storing no dependencies
	public void createBear(Bear b,HoneyPot hp,Cave c){
		Session session = ConnectionUtil.getSession();
		
		
		Transaction tx = session.beginTransaction();
		b.setDwelling(c);
		b.setHoneyPot(hp);
		
		int hp_id=(Integer) session.save(b.getHoneyPot());
		System.out.println("generated honey pot"+hp_id);
		session.save(b);
		tx.commit();
		session.close();
		
//		Bear child = new Bear();
//		child.setHeight(2.5);
//		
//		session.save(child);
		
		
		
	}
	
	
}