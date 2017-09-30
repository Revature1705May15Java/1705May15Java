package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.User;
import com.revature.repository.UserDao;

public class Main {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		
		UserDao userDao = (UserDao)appContext.getBean("userRepository");

		userDao.insert(new User(1,"james","12345"));
		//System.out.println(userDao.selectByUsername(new User(1,"peter","1234")));
	}
}
