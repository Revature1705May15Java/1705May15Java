package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.HelloWorld;
import com.ex.beans.Note;

public class MainApp {
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		HelloWorld obj = (HelloWorld) context.getBean("HelloWorld");
		obj.getMessage();
		
		Note obj2 = (Note) context.getBean("Note");
		
		obj2.getNote();
		obj2.setNote("Changed!");
		obj2.getNote();
		
		
	}
}
