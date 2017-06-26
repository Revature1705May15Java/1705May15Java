package com.springers.pojos;

import java.util.ArrayList;

@Entity
@Table(name = "BANKUSERS")
public class User {
	
	@Id
    @Column(name = "empId")
    @SequenceGenerator(name = "BANKUSERID_SEQ", sequenceName = "BANKUSERID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BANKUSERID_SEQ")
	int id;
	
	@Column(name = "empRank", nullable = false)
	int rank;
	
	@Column(name = "firstname", length=100, nullable = false)
	String fn;
	
	@Column(name = "lastname", length=100, nullable = false)
	String ln;
	
	@Column(name = "username", length=50, nullable = false)
	String username;
	
	@Column(name = "password", length=50, nullable = false)
	String password;
	
	// In this instance, easier to map these in the dao layer with HQL
	ArrayList<Request> Requests;
	
	public User() {}
	
	public User(int id, String fn, String ln, String username, String password, ArrayList<Request> requestIds) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.username = username;
		this.password = password;
		this.Requests = requestIds;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", rank=" + rank + ", fn=" + fn + ", ln=" + ln + ", username=" + username
				+ ", password=" + password + ", Requests=" + Requests + "]";
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Request> getRequests() {
		return Requests;
	}

	public void setRequests(ArrayList<Request> Requests) {
		this.Requests = Requests;
	}
}
