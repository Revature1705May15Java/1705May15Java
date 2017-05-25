package pojos;

import java.sql.Date;

public class Order 
{
	int id; 
	Customer cust; 
	double total; 
	Date dateOrdered;
	
	public Order(Customer cust, double total, Date dateOrdered) {
		super();
		this.cust = cust;
		this.total = total;
		this.dateOrdered = dateOrdered;
	}

	public Order() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", cust=" + cust + ", total=" + total + ", dateOrdered=" + dateOrdered + "]";
	}

}
