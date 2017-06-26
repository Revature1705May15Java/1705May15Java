package com.springers.pojos;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;

@Entity
@Table(name = "REQUESTS")
public class Request {
	
	@Id
    @Column(name = "RequestId")
    @SequenceGenerator(name = "REQUESTID_SEQ", sequenceName = "REQUESTID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REQUESTID_SEQ")
	int id;
	
	 @Column(name = "REQUESTER_ID", nullable = false)
	int requesterId;
	 
	@Column(name = "ADMIN_ID", nullable = false)
	int adminId;
	
	@Column(name = "BALANCE", nullable = false)
	double balance;
	
	@Column(name = "PURPOSE", length=200, nullable = false)
	String purpose;
	
	@Column(name = "ADMIN_NOTE", length=100)
	String adminNote;
	
	@Column(name = "STATUS", length=100, nullable = false)
	String type;
	
	
	String empFn, empLn;

	Date dateOpened, dateClosed;
	
	public String getAdminNote() {
		return adminNote;
	}

	public void setAdminNote(String adminNote) {
		this.adminNote = adminNote;
	}

	public String getPurpose() {
		return purpose;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", requesterId=" + requesterId + ", adminId=" + adminId + ", balance=" + balance
				+ ", purpose=" + purpose + ", adminNote=" + adminNote + ", type=" + type + ", dateOpened=" + dateOpened
				+ ", dateClosed=" + dateClosed + "]";
	}

	public String getEmpFn() {
		return empFn;
	}

	public void setEmpFn(String empFn) {
		this.empFn = empFn;
	}

	public String getEmpLn() {
		return empLn;
	}

	public void setEmpLn(String empLn) {
		this.empLn = empLn;
	}
	
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	public Request(){}
	
	public Request(int requesterId, double balance, String type, Date dateOpened) {
		super();
		this.requesterId = requesterId;
		this.balance = balance;
		this.type = type;
		this.dateOpened = dateOpened;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRequesterId() {
		return requesterId;
	}

	public void setRequesterId(int requesterId) {
		this.requesterId = requesterId;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(Date dateOpened) {
		this.dateOpened = dateOpened;
	}

	public Date getDateClosed() {
		return dateClosed;
	}

	public void setDateClosed(Date dateClosed) {
		this.dateClosed = dateClosed;
	}

}
