package com.crud.model;

public class User {
	
	private int id;
	private String name;
	private String email;
	private String addr;
	public User(int id, String name, String email, String addr) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.addr = addr;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

}
