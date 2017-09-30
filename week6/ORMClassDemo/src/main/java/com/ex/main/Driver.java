package com.ex.main;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.Bear;
import com.ex.beans.Cave;
import com.ex.dao.Dao;

public class Driver {
	public static void main(String[] args) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		//Create a bean that deals with interfaces
		Dao dao = (Dao) ac.getBean("myDao");
		
		Cave c = new Cave("My Chicken Cave");
		Bear b = new Bear(150, "Darrin", c);

		dao.makeBear(b);
		
		List<Bear> list = dao.getBears();
		
		System.out.println(list.get(0).toString());
		
	}
}
