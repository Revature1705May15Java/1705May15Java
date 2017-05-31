package com.ex.pojo;

public class Order 
{
	int id;
	Customer c;
	double total;
	public Order() 
	{
		super();
	}
	public Order(int id, Customer c, double total) {
		super();
		this.id = id;
		this.c = c;
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getC() {
		return c;
	}
	public void setC(Customer c) {
		this.c = c;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", c=" + c.getId()+ ", total=" + total + "]";
	}
	
	
}