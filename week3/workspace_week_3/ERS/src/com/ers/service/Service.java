package com.ers.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import com.ers.dao.ImplDao;
import com.ers.pojo.Request;
import com.ers.pojo.User;

public class Service {
	static ImplDao dao = new ImplDao();
	
	public ArrayList<Request> getAllOpenRequests(){
		ArrayList<Request> req = dao.getAllRequests();
		
		for(int i = 0; i < req.size(); i++){
			if(req.get(i).getDateClosed() != null) {
				req.remove(i);
				i--;
				continue;
			}
			if(!req.get(i).getType().equals(dao.getStateType(0))) {
				req.remove(i);
				i--;
			} else {
				User u = dao.getUser(req.get(i).getRequesterId());
				req.get(i).setEmpFn(u.getFn()); // Adding the user names to the req to simplify the front end displaying this
				req.get(i).setEmpLn(u.getLn()); // information in the data table.
			}
		}
		
		return req;
	}
	
	public ArrayList<Request> getAllClosedRequests(){
		ArrayList<Request> req = dao.getAllRequests();
		
		for(int i = 0; i < req.size(); i++){
			if(req.get(i).getDateClosed() == null) {
				req.remove(i);
				i--; // decrement because the arraylist is now 1 element shorter, this stops from skipping an element.
			} else {
				User u = dao.getUser(req.get(i).getRequesterId());
				req.get(i).setEmpFn(u.getFn()); // Adding the user names to the req to simplify the front end displaying this
				req.get(i).setEmpLn(u.getLn()); // information in the data table.
			}
		}
		
		return req;
	}
	
	public ArrayList<Request> getAllUserClosedRequests(User u){
		ArrayList<Request> req = dao.getAllRequests();
		
		for(int i = 0; i < req.size(); i++){
			if(req.get(i).getDateClosed() == null || req.get(i).getRequesterId() != u.getId()) {
				req.remove(i);
				i--; // decrement because the arraylist is now 1 element shorter, this stops from skipping an element.
			} 
		}
		
		return req;
	}
	
	public Request getRequestById(int id){
		Request req = dao.getRequestById(id);
		User u = dao.getUser(req.getRequesterId());
		
		req.setEmpFn(u.getFn()); // Adding the user names to the req to simplify the front end displaying this
		req.setEmpLn(u.getLn()); // information in the data table.
		return req;
	}
	
	public String getStateType(int i){
		return dao.getStateType(i);
	}
	
	public boolean deleteRequest(int id){
		return dao.deleteRequest(id);
	}
	
	public boolean updateRequestById(Request req, User u){
		Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
		if(u.getRank() > 0 && u.getId() != req.getRequesterId()) req.setDateClosed(timeNow);
		
		return dao.updateRequestById(req);
	}
	
	public User getUserInfo(String username) {
		User temp = new User();
		try {
			temp = dao.getUser(username);
			ArrayList<Request> req = temp.getRequests();
			
			
			for(int i = 0; i < req.size(); i++){  // adding the first and last name to the requests so the can be used 
				req.get(i).setEmpFn(temp.getFn());// on the front-end by the data table.
				req.get(i).setEmpLn(temp.getLn());
			}
			temp.setRequests(req);
			return temp;
		} catch (Exception e){
			return null;
		}
	}
	
	public User getUserInfo(int id) {
		User temp = new User();
		
		temp = dao.getUser(id);
		ArrayList<Request> req = temp.getRequests();
		
		
		for(int i = 0; i < req.size(); i++){  // adding the first and last name to the requests so the can be used 
			req.get(i).setEmpFn(temp.getFn());// on the front-end by the data table.
			req.get(i).setEmpLn(temp.getLn());
		}
		temp.setRequests(req);
		
		return temp;
	}
	
	public int addUser(String uname, String pw, String fn, String ln, int rank){
		return dao.addUser(uname, pw, fn, ln, rank);
	}
	
	public int addRequest(double amt, String purpose, int id){
		return dao.addRequest(amt, purpose, id);
	}
	
	public boolean editUser(User u){
		User temp = dao.getUser(u.getId());

		if(!temp.getUsername().equals(u.getUsername())){
			System.out.println("uname");
			dao.editUser("USERNAME", u.getUsername(), u);
		}
		if(!temp.getPassword().equals(u.getPassword())){
			System.out.println("pw");
			dao.editUser("PASSWORD", u.getPassword(), u);
		}
		
		if(!temp.getFn().equals(u.getFn())){
			System.out.println("fn");
			dao.editUser("FIRSTNAME", u.getFn(), u);
		}
		if(!temp.getLn().equals(u.getLn())){
			System.out.println("ln");
			dao.editUser("LASTNAME", u.getLn(), u);
		}
		
		return true;
	}
}
