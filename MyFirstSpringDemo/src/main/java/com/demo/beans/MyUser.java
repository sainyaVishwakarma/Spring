package com.demo.beans;

public class MyUser {
	private int uid;
	private String uname,email;
	public MyUser() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("in default constructor");
	}
	public MyUser(int uid, String uname, String email) {
		
		super();
		System.out.println("in parameterized constructor");
		this.uid = uid;
		this.uname = uname;
		this.email = email;
	}
	public int getUid() {
		System.out.println("in uid getter method");
		return uid;
	}
	public void setUid(int uid) {
		System.out.println("in uid setter method");
		this.uid = uid;
	}
	public String getUname() {
		System.out.println("in uname getter method");
		return uname;
	}
	public void setUname(String uname) {
		System.out.println("in uname setter method");
		this.uname = uname;
	}
	public String getEmail() {
		System.out.println("in email getter method");
		return email;
	}
	public void setEmail(String email) {
		System.out.println("in email setter method");
		this.email = email;
	}
	@Override
	public String toString() {
		return "MyUser [uid=" + uid + ", uname=" + uname + ", email=" + email + "]";
	}
	
	
}
