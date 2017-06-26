package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.UserDaoHibernate;
import com.revature.model.User;

public class UploadImageController {

	public static String uploadImage(HttpServletRequest request){
		User loggedUser = new User(1, "hello", "hi",null,null);
		
		//if this is null? Redirect the user to login
		
		if(request.getMethod().equals("GET")){
			return "profile.jsp";
		}
		
		//Whatever is here, is post
		System.out.println(request.getParameter("blob"));
		
		loggedUser.setImage(request.getParameter("blob").getBytes());
		UserDaoHibernate.getUserDao().update(loggedUser);
		
		request.getSession().setAttribute("loggedUser", loggedUser);
		request.getSession().setAttribute("blob", new String(loggedUser.getImage()));
		
		return "profile.jsp";

	}
	
}