package com.ex.pojos;

import java.sql.Date;

public class Order {
	int id;
	Date dateOrdered;
	Customer st;
	double total;
	
	
	
	public Order() {
	}


	public Order(Date dateOrdered, Customer st, double total) {
		super();
		this.dateOrdered = dateOrdered;
		this.st = st;
		this.total = total;
	}

	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDateOrdered() {
		return dateOrdered;
	}


	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}


	public Customer getSt() {
		return st;
	}


	public void setSt(Customer st) {
		this.st = st;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", dateOrdered=" + dateOrdered + ", st=" + st + ", total=" + total + "]\n";
	}
	
}