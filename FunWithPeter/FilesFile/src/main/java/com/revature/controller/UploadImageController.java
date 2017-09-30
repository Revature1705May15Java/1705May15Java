package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.UserDaoHibernate;
import com.revature.model.User;

public class UploadImageController {
	public static String uploadImage(HttpServletRequest request){
		
		User loggedUser = new User(1,"Lei","Raion",null,null);
		
		// if this is null, redirect the user to the login.
		if(request.getMethod().equals("GET")){
			System.out.println("\n\nGet??");
			return "profile.jsp";
		}
		
		//Whatever gets here is POST
		loggedUser.setImage(request.getParameter("blob").getBytes()); //transforming the string into an array of bytes.
		UserDaoHibernate.getUserDao().update(loggedUser);
		request.getSession().setAttribute("loggedUser", loggedUser);
		
		request.getSession().setAttribute("blob", new String(loggedUser.getImage())); //created a new string from a byte array.

		return "profile.jsp";
	}
}
