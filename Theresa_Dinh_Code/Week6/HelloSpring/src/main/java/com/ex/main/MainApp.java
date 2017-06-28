package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.SpringBeans;

public class MainApp 
{
	
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		SpringBeans obj = (SpringBeans)context.getBean("helloworld"); 
		obj.getMessage();
	}
}