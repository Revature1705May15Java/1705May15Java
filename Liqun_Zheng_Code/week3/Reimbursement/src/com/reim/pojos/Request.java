package com.reim.pojos;

import java.sql.Date;

public class Request {
	private int request_id, requester_id, resolver_id;
	private String note, purpose;
	private State_type state;
	private Date opened, closed;
	private double amount;
	private String requester_name;
	
	public Request(){}
	public Request(int request_id, int requester_id, int resolver_id, String note, String purpose, State_type state,
			Date opened, Date closed, double amount) {
		super();
		this.request_id = request_id;
		this.requester_id = requester_id;
		this.resolver_id = resolver_id;
		this.note = note;
		this.purpose = purpose;
		this.state = state;
		this.opened = opened;
		this.closed = closed;
		this.amount = amount;
	}
	
	public Request(int request_id, int requester_id, int resolver_id, String note, String purpose, State_type state,
			Date opened, Date closed, double amount, String requester_name) {
		super();
		this.request_id = request_id;
		this.requester_id = requester_id;
		this.resolver_id = resolver_id;
		this.note = note;
		this.purpose = purpose;
		this.state = state;
		this.opened = opened;
		this.closed = closed;
		this.amount = amount;
		this.requester_name = requester_name;
	}
	
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	public int getRequester_id() {
		return requester_id;
	}
	public void setRequester_id(int requester_id) {
		this.requester_id = requester_id;
	}
	public int getResolver_id() {
		return resolver_id;
	}
	public void setResolver_id(int resolver_id) {
		this.resolver_id = resolver_id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public State_type getState() {
		return state;
	}
	public void setState(State_type state) {
		this.state = state;
	}
	public Date getOpened() {
		return opened;
	}
	public void setOpened(Date opened) {
		this.opened = opened;
	}
	public Date getClosed() {
		return closed;
	}
	public void setClosed(Date closed) {
		this.closed = closed;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getRequester_name() {
		return requester_name;
	}
	public void setRequester_name(String requester_name) {
		this.requester_name = requester_name;
	}
	@Override
	public String toString() {
		return "Request [request_id=" + request_id + ", requester_id=" + requester_id + ", resolver_id=" + resolver_id
				+ ", note=" + note + ", purpose=" + purpose + ", state=" + state + ", opened=" + opened + ", closed="
				+ closed + ", amount=" + amount + ", requester_name=" + requester_name + "]\n";
	}
	
	

	
	
	
}