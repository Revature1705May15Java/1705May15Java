package com.ers.pojos;

import java.sql.Date;

public class Request {
	int stateid,requestid,requesterid,resolverid;
	double amt;
	Date reqdate,resdate;
	String purpose,note,name;
	
	public int getStateid() {
		return stateid;
	}
	public void setStateid(int stateid) {
		this.stateid = stateid;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
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
	public Date getReqdate() {
		return reqdate;
	}
	public void setReqdate(Date reqdate) {
		this.reqdate = reqdate;
	}
	public Date getResdate() {
		return resdate;
	}
	public void setResdate(Date resdate) {
		this.resdate = resdate;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Request(int amt, String purpose, int requesterid) {
		super();
		this.amt = amt;
		this.requesterid = requesterid;
		this.purpose = purpose;
	}
	public Request(){
		
	}
	
}
