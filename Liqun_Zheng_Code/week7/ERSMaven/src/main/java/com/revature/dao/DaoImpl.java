package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.beans.State_type;



@Transactional
public class DaoImpl implements Dao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//find requests by an employee id
	@Override
	public ArrayList<Request> findReqByEmpId(int emp_id) {
		Session s = sessionFactory.getCurrentSession();
		 ArrayList<Request> requests = new ArrayList<Request>();
		 Criteria cri = s.createCriteria(Request.class).add(Restrictions.like("employee_id", emp_id));
		requests = (ArrayList<Request>) cri.list();
		return requests;

	}
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public int addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		Session s = sessionFactory.getCurrentSession();
		s.saveOrUpdate(emp.getEmployee_request()); 
		s.save(emp);
		return 0;
	}
	@Override
	public Employee findEmpByUname(String uname) {
		Session s = sessionFactory.getCurrentSession();
		 Employee emp = new Employee();
		 Criteria cri = s.createCriteria(Employee.class).add(Restrictions.like("uname", uname));
		 emp = (Employee) cri.list().get(0);
		return emp;
	}
	@Override
	public int updateEmployee(int empId, String fname, String lname, String uname, String pw) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ArrayList<Employee> getAllEmployee(int isEmployee) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Request getRequest(int requestId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Request> getAllRequests() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Request addRequest(Employee u, String purpose, double amount) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Request appDenReq(Employee emp, int r_id, State_type state, String note) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public State_type findTypeById(int type_id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public State_type findState(String state) {
		// TODO Auto-generated method stub
		return null;
	}


}