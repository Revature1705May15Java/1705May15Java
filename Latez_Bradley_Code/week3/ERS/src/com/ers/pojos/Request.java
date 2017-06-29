package com.ers.pojos;

import java.sql.Date;

public class Request {
	int stateid,requestid,requesterid,resolverid;
	double amount;
	Date open,closed;
	String purpose, note;
	
	
	
	public Request() {
		super();
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Request [stateid=" + stateid + ", amount=" + amount + ", requestid=" + requestid + ", requesterid="
				+ requesterid + ", resolverid=" + resolverid + ", open=" + open + ", closed=" + closed + ", purpose="
				+ purpose + ", note=" + note + "]";
	}





	public Request(int stateid, double amount, int requestid, int requesterid, int resolverid, Date open, Date closed,
			String purpose, String note) {
		super();
		this.stateid = stateid;
		this.amount = amount;
		this.requestid = requestid;
		this.requesterid = requesterid;
		this.resolverid = resolverid;
		this.open = open;
		this.closed = closed;
		this.purpose = purpose;
		this.note = note;
	}





	public Request(double amount, int requesterid, String purpose) {
		super();
		this.amount = amount;
		this.requesterid = requesterid;
		this.purpose = purpose;
	}



	public int getStateid() {
		return stateid;
	}
	public void setStateid(int stateid) {
		this.stateid = stateid;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double d) {
		this.amount = d;
	}
	public int getRequestid() {
		return requestid;
	}
	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}
	public int getRequesterid() {
		return requesterid;
	}
	public void setRequesterid(int requesterid) {
		this.requesterid = requesterid;
	}
	public int getResolverid() {
		return resolverid;
	}
	public void setResolverid(int resolverid) {
		this.resolverid = resolverid;
	}
	public Date getOpen() {
		return open;
	}
	public void setOpen(Date open) {
		this.open = open;
	}
	public Date getClosed() {
		return closed;
	}
	public void setClosed(Date closed) {
		this.closed = closed;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

}
