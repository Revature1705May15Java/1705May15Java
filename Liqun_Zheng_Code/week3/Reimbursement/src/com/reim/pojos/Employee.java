package com.reim.pojos;

import java.util.ArrayList;

public class Employee {
	int employee_id;
	String fn, ln, pw, uname;
	int is_manager;
	ArrayList<Request> employee_request;
	
	public Employee(){}
	
	public Employee(int employee_id, String fn, String ln, String pw, String uname, int is_manager,
			ArrayList<Request> employee_request) {
		super();
		this.employee_id = employee_id;
		this.fn = fn;
		this.ln = ln;
		this.pw = pw;
		this.uname = uname;
		this.is_manager = is_manager;
		this.employee_request = employee_request;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getIs_manager() {
		return is_manager;
	}

	public void setIs_manager(int is_manager) {
		this.is_manager = is_manager;
	}

	public ArrayList<Request> getEmployee_request() {
		return employee_request;
	}

	public void setEmployee_request(ArrayList<Request> employee_request) {
		this.employee_request = employee_request;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", fn=" + fn + ", ln=" + ln + ", pw=" + pw + ", uname=" + uname
				+ ", is_manager=" + is_manager + ", employee_request=" + employee_request + "]\n";
	}
	
	
	
}
